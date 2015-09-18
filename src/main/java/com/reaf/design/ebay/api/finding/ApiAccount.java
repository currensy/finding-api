package com.reaf.design.ebay.api.finding;


import com.reaf.design.ebay.api.finding.annotation.ApiCallParam;

import com.reaf.design.ebay.api.finding.enums.FindingApiParam;
import com.reaf.design.ebay.api.finding.parameters.AppIdParameterImpl;
import com.reaf.design.ebay.api.finding.parameters.Parameter;

public class ApiAccount {


    @ApiCallParam(FindingApiParam.SECURITY_APPNAME)
    private AppIdParameterImpl appId;



    public ApiAccount(String appId){
        setAppId(appId);
    }

    public AppIdParameterImpl getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        AppIdParameterImpl appIdParameter = new AppIdParameterImpl();
        appIdParameter.setParamValue(appId);
        this.appId=appIdParameter;

    }
}
