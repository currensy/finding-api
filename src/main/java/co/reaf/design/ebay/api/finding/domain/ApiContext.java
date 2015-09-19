package co.reaf.design.ebay.api.finding.domain;

import co.reaf.design.ebay.api.finding.annotation.ApiCallParam;
import co.reaf.design.ebay.api.finding.enums.EbayGlobalId;
import co.reaf.design.ebay.api.finding.enums.FindingApiResponseType;
import co.reaf.design.ebay.api.finding.operation.FindingApiOperation;
import co.reaf.design.ebay.api.finding.parameters.EbayGlobalIdParameterImpl;
import co.reaf.design.ebay.api.finding.parameters.EntriesPerPageParameterImpl;
import co.reaf.design.ebay.api.finding.parameters.ResponseTypeParameterImpl;

import co.reaf.design.ebay.api.finding.enums.FindingApiParam;
import org.springframework.stereotype.Component;

/**
 * Created by iabramov on 11/09/2015.
 */

@Component
public class ApiContext {

    private ApiAccount apiAccount;
    private PartnerAccount partnerAccount;
    private FindingApiOperation operation;



    @ApiCallParam(FindingApiParam.RESPONSE_DATA_FORMAT)
    private ResponseTypeParameterImpl responseType;
    @ApiCallParam(FindingApiParam.GLOBAL_ID)
    private EbayGlobalIdParameterImpl globalId;
    @ApiCallParam(FindingApiParam.ENTRIES_PER_PAGE)
    private EntriesPerPageParameterImpl entriesPerPage;


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

    public void setGlobalId(EbayGlobalId globalId){
        EbayGlobalIdParameterImpl ebayGlobalIdParameter = new EbayGlobalIdParameterImpl();
        ebayGlobalIdParameter.setParamValue(globalId);
        this.globalId=ebayGlobalIdParameter;
    }

    public void setEntriesPerPage(String entriesPerPage){
        EntriesPerPageParameterImpl entriesPerPageParameter = new EntriesPerPageParameterImpl();
        entriesPerPageParameter.setParamValue(entriesPerPage);
        this.entriesPerPage=entriesPerPageParameter;
    }




}