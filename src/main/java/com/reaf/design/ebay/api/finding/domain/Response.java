package com.reaf.design.ebay.api.finding.domain;

import java.util.List;

/**
 * Created by iabramov on 18/09/2015.
 */
public class Response {

    private String ack;
    private String version;
    private String timestamp;
    private List<ParsedItem> items;


    public String getAck() {
        return ack;
    }

    public void setAck(String ack) {
        this.ack = ack;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public List<ParsedItem> getItems() {
        return items;
    }

    public void setItems(List<ParsedItem> items) {
        this.items = items;
    }
}
