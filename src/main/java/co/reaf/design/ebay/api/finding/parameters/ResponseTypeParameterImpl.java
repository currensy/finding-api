package co.reaf.design.ebay.api.finding.parameters;

import co.reaf.design.ebay.api.finding.enums.FindingApiResponseType;

/**
 * Created by iabramov on 17/09/2015.
 */
public class ResponseTypeParameterImpl implements Parameter<FindingApiResponseType> {

    private FindingApiResponseType  findingApiResponseType;

    @Override
    public void setParamValue(FindingApiResponseType value) {
        this.findingApiResponseType=value;
    }

    @Override
    public String getParamValue() {
        return findingApiResponseType.name();
    }
}
