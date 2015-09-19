package co.reaf.design.ebay.api.finding.operation;

import co.reaf.design.ebay.api.finding.annotation.ApiCallParam;
import co.reaf.design.ebay.api.finding.enums.EbayFindingApiOperationName;
import co.reaf.design.ebay.api.finding.parameters.OperationInputValueParameterImpl;
import co.reaf.design.ebay.api.finding.parameters.OperationNameParameterImpl;
import co.reaf.design.ebay.api.finding.enums.FindingApiParam;

/**
 * Created by iabramov on 18/09/2015.
 */

public class FindItemsByCategory implements FindingApiOperation {

    @ApiCallParam(FindingApiParam.OPERATION_NAME)
    private OperationNameParameterImpl operationName;

    @ApiCallParam(FindingApiParam.CATEGORY_ID)
    private OperationInputValueParameterImpl categoryId;



    public FindItemsByCategory(String categoryId) {
        OperationNameParameterImpl operationNameParameter = new OperationNameParameterImpl();
        operationNameParameter.setParamValue(EbayFindingApiOperationName.findItemsByCategory);
        setOperationName(operationNameParameter);
        setOperationInputValue(categoryId);
    }

    private void setOperationName(OperationNameParameterImpl operationName){
        this.operationName=operationName;
    }

    @Override
    public void setOperationInputValue(Object operationInputValue) {
        OperationInputValueParameterImpl operationInputValueParameter = new OperationInputValueParameterImpl();
        operationInputValueParameter.setParamValue((String)operationInputValue);
        setCategoryId(operationInputValueParameter);
    }

    @Override
    public String getOperationName() {
        return operationName.getParamValue();
    }

    @Override
    public String getOperationInputValue() {
        return categoryId.getParamValue();
    }

    public void setCategoryId(OperationInputValueParameterImpl categoryId) {
        this.categoryId = categoryId;
    }
}
