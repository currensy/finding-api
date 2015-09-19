package com.reaf.design.ebay.api.finding.domain.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

/**
 * Created by iabramov on 18/09/2015.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class FindingApiResponse {

    private List<String> ack;
    private List<String> version;
    private List<String> timestamp;
    private List<JsonNode> searchResult;
    private List<JsonNode> paginationOutput;

    public List<String> getAck() {
        return ack;
    }

    public void setAck(List<String> ack) {
        this.ack = ack;
    }

    public List<String> getVersion() {
        return version;
    }

    public void setVersion(List<String> version) {
        this.version = version;
    }

    public List<String> getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(List<String> timestamp) {
        this.timestamp = timestamp;
    }

    public List<JsonNode> getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(List<JsonNode> searchResult) {
        this.searchResult = searchResult;
    }

    public List<JsonNode> getPaginationOutput() {
        return paginationOutput;
    }

    public void setPaginationOutput(List<JsonNode> paginationOutput) {
        this.paginationOutput = paginationOutput;
    }
}
