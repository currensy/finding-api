package com.reaf.design.ebay.api.finding.enums;

/**
 * Created by iabramov on 17/09/2015.
 */
public enum FindingApiParam {
    RESPONSE_DATA_FORMAT("RESPONSE-DATA-FORMAT"),OPERATION_NAME("OPERATION-NAME"),
    SECURITY_APPNAME("SECURITY-APPNAME"),GLOBAL_ID("GLOBAL-ID"),KEYWORDS("keywords"),
    PRODUCT_ID("productId"),TRACKING_ID("affiliate.trackingId"),NETWORK_ID("affiliate.networkId"),
    SERVICE_VERSION("SERVICE-VERSION");

    private String paramName;

    FindingApiParam(String s) {
        paramName=s;
    }

    public String getParamName() {
        return paramName;
    }
}
