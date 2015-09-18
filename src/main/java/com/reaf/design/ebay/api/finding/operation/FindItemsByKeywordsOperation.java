package com.reaf.design.ebay.api.finding.operation;

import com.reaf.design.ebay.api.finding.annotation.ApiCallParam;
import com.reaf.design.ebay.api.finding.enums.EbayFindingApiOperationName;
import com.reaf.design.ebay.api.finding.enums.FindingApiParam;
import com.reaf.design.ebay.api.finding.parameters.KeywordsParameterImpl;
import com.reaf.design.ebay.api.finding.parameters.OperationNameParameterImpl;

/**
 * Created by iabramov on 11/09/2015.
 */

public class FindItemsByKeywordsOperation implements FindingApiOperation {

    @ApiCallParam(FindingApiParam.OPERATION_NAME)
    private OperationNameParameterImpl operationName;

    @ApiCallParam(FindingApiParam.KEYWORDS)
    private KeywordsParameterImpl keywords;


    public FindItemsByKeywordsOperation(String keywords){
        OperationNameParameterImpl operationNameParameter = new OperationNameParameterImpl();
        operationNameParameter.setParamValue(EbayFindingApiOperationName.findItemsByKeywords);
        setOperationName(operationNameParameter);
        KeywordsParameterImpl keywordsParameter = new KeywordsParameterImpl();
        keywordsParameter.setParamValue(keywords);
        setKeywords(keywordsParameter);
    }

    private void setOperationName(OperationNameParameterImpl operationName){
        this.operationName=operationName;
    }

    private void setKeywords(KeywordsParameterImpl keywords){
        this.keywords=keywords;
    }

    @Override
    public String getOperationName() {
        return operationName.getParamValue();
    }

    @Override
    public String getOperationInputValue(){
        return keywords.getParamValue();
    }


}
