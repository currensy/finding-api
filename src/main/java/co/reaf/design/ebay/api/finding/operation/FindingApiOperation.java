package co.reaf.design.ebay.api.finding.operation;

/**
 * Created by iabramov on 11/09/2015.
 */
public interface FindingApiOperation {


    void setOperationInputValue(Object operationInputValue);

    String getOperationName();

    String getOperationInputValue();
}
