package co.reaf.design.ebay.api.finding.parser;

import co.reaf.design.ebay.api.finding.domain.item.Item;
import co.reaf.design.ebay.api.finding.domain.response.FindingApiResponse;
import co.reaf.design.ebay.api.finding.domain.response.PaginationOutput;
import co.reaf.design.ebay.api.finding.domain.response.Response;
import co.reaf.design.ebay.api.finding.exception.FindingApiException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import co.reaf.design.ebay.api.finding.domain.item.ParsedItem;
import co.reaf.design.ebay.api.finding.domain.response.ParsedPaginationOutput;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by iabramov on 18/09/2015.
 */

public class FindingApiParserImpl implements FindingApiParser {

    private static final String SETTER_PREFIX = "set";
    private static final String COUNT = "@count";
    private static final String ITEM = "item";

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Response parse(JsonNode jsonNode) throws JsonProcessingException, InvocationTargetException, IllegalAccessException, FindingApiException {
        Response response = new Response();
        List parsedItems = new ArrayList();
        ParsedPaginationOutput parsedPaginationOutput = new ParsedPaginationOutput();
        FindingApiResponse[] findingApiResponse = objectMapper.treeToValue(jsonNode, FindingApiResponse[].class);
        for (int i = 0; i < findingApiResponse.length; i++) {

            if(findingApiResponse[i].getAck().get(0).equalsIgnoreCase("failure")) {

                throw new FindingApiException("Request failed");
            }
            response = (Response) originalArrayResponseToOwnResponse(findingApiResponse[i], response);

            List<JsonNode> searchResult = findingApiResponse[i].getSearchResult();
            for (JsonNode node : searchResult) {
                response.setCount(node.get(FindingApiParserImpl.COUNT).asText());
                JsonNode items = node.get(FindingApiParserImpl.ITEM);
                if(items==null) throw new FindingApiException("No Items Found");
                Item[] item = objectMapper.treeToValue(items, Item[].class);
                for (int j = 0; j < item.length; j++) {
                    ParsedItem parsedItem = new ParsedItem();
                    parsedItem = (ParsedItem) originalArrayResponseToOwnResponse(item[i], parsedItem);
                    parsedItems.add(parsedItem);
                    response.setItems(parsedItems);
                }
            }


            PaginationOutput paginationOutput = objectMapper.treeToValue(findingApiResponse[i].getPaginationOutput().get(0), PaginationOutput.class);
            parsedPaginationOutput = (ParsedPaginationOutput) originalArrayResponseToOwnResponse(paginationOutput, parsedPaginationOutput);
            response.setParsedPaginationOutput(parsedPaginationOutput);
        }

        return response;

    }

    private Object originalArrayResponseToOwnResponse(Object object, Object response) throws IllegalAccessException, InvocationTargetException {
        Field[] declaredFields = object.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            String declaredFieldName = declaredField.getName();
            if (declaredField.get(object)!=null){
            String formattedDeclaredFieldName = declaredFieldName.replaceFirst(declaredFieldName.substring(0, 1), declaredFieldName.substring(0, 1).toUpperCase());
            Method[] responseObjectDeclaredMethods = response.getClass().getDeclaredMethods();
            for (Method responseObjectDeclaredMethod : responseObjectDeclaredMethods) {
                if (responseObjectDeclaredMethod.getName().equals(FindingApiParserImpl.SETTER_PREFIX+formattedDeclaredFieldName)){
                    responseObjectDeclaredMethod.setAccessible(true);
                    responseObjectDeclaredMethod.invoke(response,((List)declaredField.get(object)).get(0));
                }
            }
            }

        }

        return response;
    }

}
