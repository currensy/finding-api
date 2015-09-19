package co.reaf.design.ebay.api.finding.domain;


import co.reaf.design.ebay.api.finding.annotation.ApiCallParam;
import co.reaf.design.ebay.api.finding.parameters.AppIdParameterImpl;

import co.reaf.design.ebay.api.finding.enums.FindingApiParam;

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
