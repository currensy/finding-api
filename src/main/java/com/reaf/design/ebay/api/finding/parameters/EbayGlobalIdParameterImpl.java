package com.reaf.design.ebay.api.finding.parameters;

import com.reaf.design.ebay.api.finding.enums.EbayGlobalId;

/**
 * Created by iabramov on 18/09/2015.
 */
public class EbayGlobalIdParameterImpl implements Parameter<EbayGlobalId>{

    private EbayGlobalId globalId;

    @Override
    public void setParamValue(EbayGlobalId value) {
        globalId=value;
    }

    @Override
    public String getParamValue() {
        return globalId.getGlobalId();
    }
}
