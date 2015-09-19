package co.reaf.design.ebay.api.finding.parameters;

/**
 * Created by iabramov on 17/09/2015.
 */
public class NetworkIdParameterImpl implements Parameter<String>{

    private String networkId;

    @Override
    public void setParamValue(String value) {
        networkId=value;
    }

    @Override
    public String getParamValue() {
        return networkId;
    }
}
