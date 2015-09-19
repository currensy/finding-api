package co.reaf.design.ebay.api.finding.operation;

import co.reaf.design.ebay.api.finding.annotation.ApiCallParam;
import co.reaf.design.ebay.api.finding.enums.EbayFindingApiOperationName;
import co.reaf.design.ebay.api.finding.parameters.KeywordsParameterImpl;
import co.reaf.design.ebay.api.finding.parameters.OperationNameParameterImpl;
import co.reaf.design.ebay.api.finding.enums.FindingApiParam;

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
        setOperationInputValue(keywords);
    }

    private void setOperationName(OperationNameParameterImpl operationName){
        this.operationName=operationName;
    }

    private void setKeywords(KeywordsParameterImpl keywords){
        this.keywords=keywords;
    }

    @Override
    public void setOperationInputValue(Object operationInputValue){
        KeywordsParameterImpl keywordsParameter = new KeywordsParameterImpl();
        keywordsParameter.setParamValue((String)operationInputValue);
        setKeywords(keywordsParameter);
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
