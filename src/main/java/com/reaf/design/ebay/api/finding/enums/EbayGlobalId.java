package com.reaf.design.ebay.api.finding.enums;

import com.reaf.design.ebay.api.finding.annotation.ApiCallParam;

/**
 * Created by iabramov on 11/09/2015.
 */
public enum EbayGlobalId {
    US("EBAY-US"),UK("EBAY-GB");

    private String globalId;

    EbayGlobalId(String globalId) {
        this.globalId=globalId;
    }

    public String getGlobalId(){
        return globalId;
    }
}
