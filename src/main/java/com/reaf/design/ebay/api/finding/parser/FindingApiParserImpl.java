package com.reaf.design.ebay.api.finding.parser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reaf.design.ebay.api.finding.domain.FindingApiResponse;
import com.reaf.design.ebay.api.finding.domain.Item;
import com.reaf.design.ebay.api.finding.domain.ParsedItem;
import com.reaf.design.ebay.api.finding.domain.Response;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by iabramov on 18/09/2015.
 */
public class FindingApiParserImpl implements FindingApiParser {


    private ObjectMapper objectMapper = new ObjectMapper();

    public void parse(JsonNode jsonNode) throws JsonProcessingException, InvocationTargetException, IllegalAccessException {
        Response response = new Response();
        List parsedItems = new ArrayList();
        FindingApiResponse[] findingApiResponse = objectMapper.treeToValue(jsonNode, FindingApiResponse[].class);
        for (int i = 0; i < findingApiResponse.length; i++) {


            response = (Response) originalArrayResponseToOwnResponse(findingApiResponse[i], response);

            List<JsonNode> searchResult = findingApiResponse[i].getSearchResult();
            for (JsonNode node : searchResult) {
                node.get("@count");
                JsonNode items = node.get("item");
                Item[] item = objectMapper.treeToValue(items, Item[].class);
                for (int j = 0; j < item.length; j++) {
                    ParsedItem parsedItem = new ParsedItem();
                    parsedItem = (ParsedItem) originalArrayResponseToOwnResponse(item[i], parsedItem);
                    parsedItems.add(parsedItem);
                    response.setItems(parsedItems);
                }
            }
        }

        response.getItems();

    }

    private Object originalArrayResponseToOwnResponse(Object object, Object response) throws IllegalAccessException, InvocationTargetException {
        Field[] declaredFields = object.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            String declaredFieldName = declaredField.getName();
            Method declaredMethod = null;
            try {
                declaredMethod = response.getClass().getDeclaredMethod("set" + declaredFieldName.replaceFirst(declaredFieldName.substring(0, 1), declaredFieldName.substring(0,1).toUpperCase()), String.class);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            if(declaredMethod!=null){
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(response, ((List)declaredField.get(object)).get(0));
            }
        }

        return response;
    }

}
