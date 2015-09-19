package co.reaf.design.ebay.api.finding.parameters;

/**
 * Created by iabramov on 17/09/2015.
 */
public class ProductIdParameterImpl implements Parameter<String>{

    private String productId;

    @Override
    public void setParamValue(String value) {
        productId=value;
    }

    @Override
    public String getParamValue() {
        return productId;
    }


}
