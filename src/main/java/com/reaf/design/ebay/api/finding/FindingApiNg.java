package com.reaf.design.ebay.api.finding;

import com.reaf.design.ebay.api.finding.annotation.ApiCallParam;
import com.reaf.design.ebay.api.finding.enums.FindingApiParam;
import com.reaf.design.ebay.api.finding.enums.FindingApiResponseType;
import com.reaf.design.ebay.api.finding.operation.FindingApiOperation;
import com.reaf.design.ebay.api.finding.parameters.OperationNameParameterImpl;
import com.reaf.design.ebay.api.finding.parameters.Parameter;
import com.reaf.design.ebay.api.finding.parameters.ResponseTypeParameterImpl;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by iabramov on 17/09/2015.
 */
public class FindingApiNg {

    private ApiContext apiContext;


    private static final String PRODUCTION_ENDPOINT = "http://svcs.ebay.com/services/search/FindingService/v1";
    private static final String SERVICE_VERSION = "1.0.0";

    private Map<String, String> paramsMap = new HashMap<>();


    public ApiContext getApiContext() {
        return apiContext;
    }

    public void setApiContext(ApiContext apiContext) {
        this.apiContext = apiContext;
    }

    public FindingApiNg(ApiContext apiContext) {
        this.apiContext=apiContext;

    }

    public void build() {
        flushMap();
        try {
            initParamMap();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        List<NameValuePair> qparams = new ArrayList();
        qparams.addAll(paramsMap.entrySet().stream().map(param -> new BasicNameValuePair(param.getKey(), param.getValue())).collect(Collectors.toList()));
        System.out.println(FindingApiNg.PRODUCTION_ENDPOINT + "?" + URLEncodedUtils.format(qparams, "UTF-8"));

    }

    private void initParamMap() throws IllegalAccessException {

        paramsMap.put(FindingApiParam.SERVICE_VERSION.getParamName(), FindingApiNg.SERVICE_VERSION);


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
