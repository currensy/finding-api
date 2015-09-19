package co.reaf.design.ebay.api.finding.parameters;

/**
 * Created by iabramov on 18/09/2015.
 */
public class OperationInputValueParameterImpl implements Parameter<String>{

    private String inputValue;


    @Override
    public void setParamValue(String value) {
        inputValue=value;
    }

    @Override
    public String getParamValue() {
        return inputValue;
    }
}
