package com.reaf.design.ebay.api.finding;

import com.reaf.design.ebay.api.finding.annotation.ApiCallParam;

import com.reaf.design.ebay.api.finding.enums.EbayGlobalId;
import com.reaf.design.ebay.api.finding.enums.FindingApiParam;
import com.reaf.design.ebay.api.finding.enums.FindingApiResponseType;
import com.reaf.design.ebay.api.finding.operation.FindingApiOperation;
import com.reaf.design.ebay.api.finding.parameters.OperationNameParameterImpl;
import com.reaf.design.ebay.api.finding.parameters.Parameter;
import com.reaf.design.ebay.api.finding.parameters.ResponseTypeParameterImpl;

/**
 * Created by iabramov on 11/09/2015.
 */
public class ApiContext {

    private ApiAccount apiAccount;
    private PartnerAccount partnerAccount;
    private FindingApiOperation operation;



    @ApiCallParam(FindingApiParam.RESPONSE_DATA_FORMAT)
    private ResponseTypeParameterImpl responseType;
    //private EbayGlobalId globalId;
    //private int entriesPerPage;


    public ApiAccount getApiAccount() {
        return apiAccount;
    }

    public void setApiAccount(ApiAccount apiAccount) {
        this.apiAccount = apiAccount;
    }

    public PartnerAccount getPartnerAccount() {
        return partnerAccount;
    }

    public void setPartnerAccount(PartnerAccount partnerAccount) {
        this.partnerAccount = partnerAccount;
    }

    public void setOperation(FindingApiOperation operation){
        this.operation=operation;
    }

    public FindingApiOperation getOperation(){
        return operation;
    }


    public void setResponseType(FindingApiResponseType responseType) {
        ResponseTypeParameterImpl responseTypeParameter = new ResponseTypeParameterImpl();
        responseTypeParameter.setParamValue(responseType);
        this.responseType = responseTypeParameter;
    }




}
