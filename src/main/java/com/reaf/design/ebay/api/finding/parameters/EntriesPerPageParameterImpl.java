package com.reaf.design.ebay.api.finding.parameters;

/**
 * Created by iabramov on 18/09/2015.
 */
public class EntriesPerPageParameterImpl implements Parameter<String>{

    private String entriesPerPage;

    @Override
    public void setParamValue(String value) {
        entriesPerPage=value;
    }

    @Override
    public String getParamValue() {
        return entriesPerPage;
    }
}
