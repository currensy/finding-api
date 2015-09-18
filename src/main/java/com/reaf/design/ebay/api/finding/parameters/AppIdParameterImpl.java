package com.reaf.design.ebay.api.finding.parameters;

/**
 * Created by iabramov on 17/09/2015.
 */
public class AppIdParameterImpl implements Parameter<String>{

    private String appId;

    @Override
    public void setParamValue(String value) {
        appId=value;
    }

    @Override
    public String getParamValue() {
        return appId;
    }
}
