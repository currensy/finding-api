package co.reaf.design.ebay.api.finding.domain.response;

/**
 * Created by iabramov on 19/09/2015.
 */

public class ParsedPaginationOutput {

    private String pageNumber;
    private String entriesPerPage;
    private String totalPages;
    private String totalEntries;

    public String getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getEntriesPerPage() {
        return entriesPerPage;
    }

    public void setEntriesPerPage(String entriesPerPage) {
        this.entriesPerPage = entriesPerPage;
    }

    public String getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(String totalPages) {
        this.totalPages = totalPages;
    }

    public String getTotalEntries() {
        return totalEntries;
    }

    public void setTotalEntries(String totalEntries) {
        this.totalEntries = totalEntries;
    }
}
