package com.reaf.design.ebay.api.finding.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.reaf.design.ebay.api.finding.domain.response.Response;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by iabramov on 18/09/2015.
 */
public interface FindingApiParser {
    Response parse(JsonNode jsonNode) throws JsonProcessingException, InvocationTargetException, IllegalAccessException;
}
