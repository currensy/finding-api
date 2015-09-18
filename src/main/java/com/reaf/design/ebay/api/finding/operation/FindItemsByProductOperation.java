package com.reaf.design.ebay.api.finding.operation;

import com.reaf.design.ebay.api.finding.annotation.ApiCallParam;
import com.reaf.design.ebay.api.finding.enums.EbayFindingApiOperationName;
import com.reaf.design.ebay.api.finding.enums.FindingApiParam;
import com.reaf.design.ebay.api.finding.parameters.OperationNameParameterImpl;
import com.reaf.design.ebay.api.finding.parameters.ProductIdParameterImpl;

/**
 * Created by iabramov on 17/09/2015.
 */
public class FindItemsByProductOperation implements FindingApiOperation {

    @ApiCallParam(FindingApiParam.OPERATION_NAME)
    private OperationNameParameterImpl operationName;

    @ApiCallParam(FindingApiParam.PRODUCT_ID)
    private ProductIdParameterImpl productId;

    public FindItemsByProductOperation(String productId){
        OperationNameParameterImpl operationNameParameter = new OperationNameParameterImpl();
        operationNameParameter.setParamValue(EbayFindingApiOperationName.findItemsByProduct);
        setOperationName(operationNameParameter);
        ProductIdParameterImpl ProductIdParameter = new ProductIdParameterImpl();
        ProductIdParameter.setParamValue(productId);
        setProductId(ProductIdParameter);
    }

    private void setOperationName(OperationNameParameterImpl operationName){
        this.operationName=operationName;
    }

    private void setProductId(ProductIdParameterImpl productId){
        this.productId=productId;
    }

    @Override
    public String getOperationName() {
        return operationName.getParamValue();
    }

    @Override
    public String getOperationInputValue(){
        return productId.getParamValue();
    }

}