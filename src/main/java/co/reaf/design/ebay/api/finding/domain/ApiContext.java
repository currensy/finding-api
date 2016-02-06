package co.reaf.design.ebay.api.finding.domain;

import co.reaf.design.ebay.api.finding.annotation.ApiCallParam;
import co.reaf.design.ebay.api.finding.enums.*;
import co.reaf.design.ebay.api.finding.filters.ItemFilter;
import co.reaf.design.ebay.api.finding.operation.FindingApiOperation;
import co.reaf.design.ebay.api.finding.parameters.EbayGlobalIdParameterImpl;
import co.reaf.design.ebay.api.finding.parameters.EntriesPerPageParameterImpl;
import co.reaf.design.ebay.api.finding.parameters.ResponseTypeParameterImpl;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

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


    private ItemFilter itemFilter = new ItemFilter();


    public ApiContext() {
    }

    private ApiContext(Builder builder) {
        apiAccount=builder.apiAccount;
        partnerAccount=builder.partnerAccount;
        operation=builder.operation;
        responseType=builder.responseType;
        globalId=builder.globalId;
        entriesPerPage=builder.entriesPerPage;
    }


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

    public void setCondition(ItemCondition condition) {
        Map<String, String> filters = itemFilter.getFilters();
       filters.put("Condition",condition.getCondition());
    }

    public void setListingType(ListingType listingType) {
        Map<String, String> filters = itemFilter.getFilters();
        filters.put("ListingType",listingType.getListingType());
    }

    public void setAvailableToLocation(String availableToLocation) {
        Map<String, String> filters = itemFilter.getFilters();
        filters.put("AvailableTo",availableToLocation);
    }


    public static class Builder {

            private ApiAccount apiAccount;
            private PartnerAccount partnerAccount;
            private FindingApiOperation operation;
            private ResponseTypeParameterImpl responseType;
            private EbayGlobalIdParameterImpl globalId;
            private EntriesPerPageParameterImpl entriesPerPage;

            public Builder(ApiAccount apiAccount) {
                this.apiAccount = apiAccount;
            }


            public Builder partnerAccount(PartnerAccount partnerAccount) {
                this.partnerAccount = partnerAccount;
                return this;
            }

            public Builder operation(FindingApiOperation operation) {
                this.operation = operation;
                return this;
            }

            public Builder responseType(FindingApiResponseType responseType) {
                ResponseTypeParameterImpl responseTypeParameter = new ResponseTypeParameterImpl();
                responseTypeParameter.setParamValue(responseType);
                this.responseType = responseTypeParameter;
                return this;
            }

            public Builder globalId(EbayGlobalId globalId) {
                EbayGlobalIdParameterImpl ebayGlobalIdParameter = new EbayGlobalIdParameterImpl();
                ebayGlobalIdParameter.setParamValue(globalId);
                this.globalId = ebayGlobalIdParameter;
                return this;
            }

            public Builder entriesPerPage(String entriesPerPage) {
                EntriesPerPageParameterImpl entriesPerPageParameter = new EntriesPerPageParameterImpl();
                entriesPerPageParameter.setParamValue(entriesPerPage);
                this.entriesPerPage = entriesPerPageParameter;
                return this;
            }


            public ApiContext build() {
                return new ApiContext(this);
            }
        }


    }
