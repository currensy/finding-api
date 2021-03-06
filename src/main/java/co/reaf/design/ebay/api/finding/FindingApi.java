package co.reaf.design.ebay.api.finding;

import co.reaf.design.ebay.api.finding.annotation.ApiCallParam;
import co.reaf.design.ebay.api.finding.domain.ApiAccount;
import co.reaf.design.ebay.api.finding.domain.ApiContext;
import co.reaf.design.ebay.api.finding.domain.PartnerAccount;
import co.reaf.design.ebay.api.finding.domain.response.Response;
import co.reaf.design.ebay.api.finding.exception.FindingApiException;
import co.reaf.design.ebay.api.finding.executer.FindingApiRequestExecuterImpl;
import co.reaf.design.ebay.api.finding.filters.ItemFilter;
import co.reaf.design.ebay.api.finding.operation.FindingApiOperation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import co.reaf.design.ebay.api.finding.enums.FindingApiParam;
import co.reaf.design.ebay.api.finding.executer.RequestExecuter;
import co.reaf.design.ebay.api.finding.parameters.Parameter;
import co.reaf.design.ebay.api.finding.parser.FindingApiParserImpl;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by iabramov on 17/09/2015.
 */

@Component
public class FindingApi {

    private static final String PRODUCTION_ENDPOINT = "http://svcs.ebay.com/services/search/FindingService/v1";
    private static final String SERVICE_VERSION = "1.0.0";

    private ApiContext apiContext;

    private Map<String, String> paramsMap = new LinkedHashMap<>();


    RequestExecuter requestExecuter = new FindingApiRequestExecuterImpl();


    public FindingApi() {
    }

    public ApiContext getApiContext() {
        return apiContext;
    }

    public void setApiContext(ApiContext apiContext) {
        this.apiContext = apiContext;
    }

    public FindingApi(ApiContext apiContext) {
        this.apiContext=apiContext;

    }

    private String buildStringUrl() throws IllegalAccessException {
        flushMap();
        initParamMap();
        List<NameValuePair> qparams = new ArrayList();
        qparams.addAll(paramsMap.entrySet().stream().map(param -> new BasicNameValuePair(param.getKey(), param.getValue())).collect(Collectors.toList()));
        String stringUrl = FindingApi.PRODUCTION_ENDPOINT + "?" + URLEncodedUtils.format(qparams, "UTF-8").replace("%28", "(").replace("%29",")");
        System.out.println(stringUrl);
        return stringUrl;
    }

    public Response execOperation() throws IllegalAccessException, FindingApiException {
        String stringUrl = buildStringUrl();
        JsonNode findingApiResponseNode = (JsonNode) requestExecuter.exec(stringUrl, JsonNode.class);
        JsonNode responseByOperationNode = findingApiResponseNode.get(apiContext.getOperation().getOperationName()+"Response");
        FindingApiParserImpl findingApiParser = new FindingApiParserImpl();
        try {
            return findingApiParser.parse(responseByOperationNode);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void initParamMap() throws IllegalAccessException {

        paramsMap.put(FindingApiParam.SERVICE_VERSION.getParamName(), FindingApi.SERVICE_VERSION);

        if (apiContext==null){
            throw new RuntimeException("Please set ApiContext");
        }
        Field[] fields = apiContext.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.get(apiContext) instanceof ApiAccount){
                ApiAccount apiAccount = (ApiAccount) field.get(apiContext);
                Field[] apiAccountFields = apiAccount.getClass().getDeclaredFields();
                for (Field apiAccountField : apiAccountFields) {
                    populateMap(apiAccountField,apiAccount);
                }
            }

            if (field.get(apiContext) instanceof PartnerAccount){
                PartnerAccount partnerAccount = (PartnerAccount) field.get(apiContext);
                Field[] partnerAccountFields = partnerAccount.getClass().getDeclaredFields();
                for (Field partnerAccountField : partnerAccountFields) {
                    populateMap(partnerAccountField,partnerAccount);
                }
            }

            if (field.get(apiContext) instanceof FindingApiOperation){
                FindingApiOperation findingApiOperation = (FindingApiOperation) field.get(apiContext);
                Field[] findingApiOperationFields = findingApiOperation.getClass().getDeclaredFields();
                for (Field findingApiOperationField : findingApiOperationFields) {
                    populateMap(findingApiOperationField,apiContext.getOperation());
                }
            }

            if(field.get(apiContext) instanceof ItemFilter){
                ItemFilter itemFilter = (ItemFilter) field.get(apiContext);
                Map<String,String> filters = itemFilter.getFilters();
                int index = 0;
                for (Map.Entry<String, String> filterNameValueSet : filters.entrySet()) {
                    String name = filterNameValueSet.getKey();
                    String value = filterNameValueSet.getValue();
                    String paramName="itemFilter("+index+").name";
                    paramsMap.put(paramName, name);
                    String paramValue="itemFilter("+index+").value(0)";
                    paramsMap.put(paramValue,value);
                    index++;
                }
            }

            populateMap(field,apiContext);


        }




    }

    private void flushMap(){
        paramsMap.clear();
    }


    private void populateMap(Field field, Object obj) throws IllegalAccessException {
        field.setAccessible(true);
        if (field.isAnnotationPresent(ApiCallParam.class)) {
            ApiCallParam annotation = field.getAnnotation(ApiCallParam.class);
            FindingApiParam paramName = annotation.value();
            if(field.get(obj) instanceof Parameter) {
                Parameter param = (Parameter) field.get(obj);
                paramsMap.put(paramName.getParamName(),param.getParamValue());
            }

        }
    }


}
