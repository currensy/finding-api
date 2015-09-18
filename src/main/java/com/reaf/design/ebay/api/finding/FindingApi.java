package com.reaf.design.ebay.api.finding;


import com.reaf.design.ebay.api.finding.enums.EbayGlobalId;
import com.reaf.design.ebay.api.finding.enums.FindingApiParam;
import com.reaf.design.ebay.api.finding.enums.FindingApiResponseType;
import com.reaf.design.ebay.api.finding.operation.FindingApiOperation;
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
 * Created by iabramov on 11/09/2015.
 */
public class FindingApi {

    public static final String PRODUCTION_ENDPOINT = "http://svcs.ebay.com/services/search/FindingService/v1";
    public static final String SERVICE_VERSION = "1.0.0";

    private ApiContext apiContext;

    // ApiAccount
    private String appName;
    private String trackingId;
    private int networkId;

    // ApiContext
    private FindingApiResponseType responseType;
    private EbayGlobalId globalId;
    private FindingApiOperation operation;
    private int entriesPerPage;

    
    public FindingApi init(ApiContext apiContext) {
        setApiContext(apiContext);
        return this;
    }

    private void bindUrlParameters(){



    }

    public ApiContext getApiContext() {
        return apiContext;
    }

    public void setApiContext(ApiContext apiContext) {
        this.apiContext = apiContext;
    }

    public FindingApi init(String appName, String trackingId, FindingApiOperation operation){
        setOperation(operation);
        setAppName(appName);
        setTrackingId(trackingId);
        setGlobalId(EbayGlobalId.US);
        setResponseType(FindingApiResponseType.JSON);
        setEntriesPerPage(10);
        setNetworkId(9);
        return this;
    }
    
    private Map<String,String> generateParamsMap() {
        Map<String, String> params = new HashMap();
        addToMapIfParamNotNull(params,"SECURITY-APPNAME", appName);
        addToMapIfParamNotNull(params, "RESPONSE-DATA-FORMAT", responseType.name());
        addToMapIfParamNotNull(params, "SERVICE-VERSION", FindingApi.SERVICE_VERSION);
        //addToMapIfParamNotNull(params, "OPERATION-NAME", operation.getOperationName().name());
        //addToMapIfParamNotNull(params, operation.getParamKey(), operation.getParamValue());
        addToMapIfParamNotNull(params, "affiliate.trackingId", trackingId);
        addToMapIfParamNotNull(params, "affiliate.networkId", String.valueOf(networkId));
        addToMapIfParamNotNull(params,"GLOBAL-ID",globalId.name());
        addToMapIfParamNotNull(params, "paginationInput.entriesPerPage", String.valueOf(entriesPerPage));


        return params;
    }
    
    private void addToMapIfParamNotNull(Map<String,String> map,String key,String val){
        if (val!=null) map.put(key,val);
    }


    public void build(){

        if(operation==null) {
            System.out.println("You need to specify operation");
            return;
        }
        
        List<NameValuePair> qparams = new ArrayList();
        Map<String, String> paramsMap = generateParamsMap();
        qparams.addAll(paramsMap.entrySet().stream().map(param -> new BasicNameValuePair(param.getKey(), param.getValue())).collect(Collectors.toList()));
        System.out.println(FindingApi.PRODUCTION_ENDPOINT + "?" + URLEncodedUtils.format(qparams, "UTF-8"));


    }



    private String getAppName() {
        return appName;
    }

    private void setAppName(String appName) {
        this.appName = appName;
    }

    public FindingApiResponseType getResponseType() {
        return responseType;
    }

    public FindingApi setResponseType(FindingApiResponseType responseType) {
        this.responseType = responseType;
        return this;
    }



    public EbayGlobalId getGlobalId() {
        return globalId;
    }

    public FindingApi setGlobalId(EbayGlobalId globalId) {
        this.globalId = globalId;
        return this;
    }

    public FindingApi setOperation(FindingApiOperation operation){
        if(operation!=null){
            this.operation=operation;
        }
        return this;
    }

    public int getEntriesPerPage() {
        return entriesPerPage;
    }

    public FindingApi setEntriesPerPage(int entriesPerPage) {
        this.entriesPerPage = entriesPerPage;
        return this;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public FindingApi setTrackingId(String trackingId) {
        this.trackingId = trackingId;
        return this;
    }

    public int getNetworkId() {
        return networkId;
    }

    public FindingApi setNetworkId(int networkId) {
        this.networkId = networkId;
        return this;
    }

    @Override
    public String toString() {
        return "FindingApi{" +
                "appName='" + appName + '\'' +
                ", responseType=" + responseType +
                ", operationName=" + operation +
                ", globalId=" + globalId +
                ", entriesPerPage=" + entriesPerPage +
                ", trackingId=" + trackingId +
                ", networkId=" + networkId +
                '}';
    }
}
