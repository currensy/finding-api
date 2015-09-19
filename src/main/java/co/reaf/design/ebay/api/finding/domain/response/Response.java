package co.reaf.design.ebay.api.finding.domain.response;

import co.reaf.design.ebay.api.finding.domain.item.ParsedItem;

import java.util.List;

/**
 * Created by iabramov on 18/09/2015.
 */
public class Response {

    private String ack;
    private String version;
    private String timestamp;
    private String count;
    private List<ParsedItem> items;
    private ParsedPaginationOutput parsedPaginationOutput;


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

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public List<ParsedItem> getItems() {
        return items;
    }

    public void setItems(List<ParsedItem> items) {
        this.items = items;
    }

    public ParsedPaginationOutput getParsedPaginationOutput() {
        return parsedPaginationOutput;
    }

    public void setParsedPaginationOutput(ParsedPaginationOutput parsedPaginationOutput) {
        this.parsedPaginationOutput = parsedPaginationOutput;
    }

    @Override
    public String toString() {
        return "Response{" +
                "ack='" + ack + '\'' +
                ", version='" + version + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", items=" + items +
                '}';
    }
}
