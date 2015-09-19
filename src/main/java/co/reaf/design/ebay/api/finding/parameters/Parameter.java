package co.reaf.design.ebay.api.finding.parameters;

/**
 * Created by iabramov on 17/09/2015.
 */
public interface Parameter<T> {

    public void setParamValue(T value);
    public String getParamValue();
}
