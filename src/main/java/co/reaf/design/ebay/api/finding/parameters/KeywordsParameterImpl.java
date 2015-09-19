package co.reaf.design.ebay.api.finding.parameters;

/**
 * Created by iabramov on 17/09/2015.
 */
public class KeywordsParameterImpl implements Parameter<String>{

    private String keywords;

    @Override
    public void setParamValue(String value) {
        keywords=value;
    }

    @Override
    public String getParamValue() {
        return keywords;
    }
}
