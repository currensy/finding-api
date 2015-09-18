package com.reaf.design.ebay.api.finding.operation;

import com.reaf.design.ebay.api.finding.enums.FindingApiParam;
import com.reaf.design.ebay.api.finding.parameters.OperationNameParameterImpl;
import org.apache.http.message.BasicNameValuePair;

/**
 * Created by iabramov on 11/09/2015.
 */
public interface FindingApiOperation {


    String getOperationName();

    String getOperationInputValue();
}
