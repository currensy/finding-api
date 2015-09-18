package com.reaf.design.ebay.api.finding.parameters;

import com.reaf.design.ebay.api.finding.enums.EbayFindingApiOperationName;

/**
 * Created by iabramov on 17/09/2015.
 */
public class OperationNameParameterImpl implements Parameter<EbayFindingApiOperationName> {

    private EbayFindingApiOperationName operationName;

    @Override
    public void setParamValue(EbayFindingApiOperationName value) {
        operationName=value;
    }

    @Override
    public String getParamValue() {

        return operationName.name();
    }
}
