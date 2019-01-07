package Model;
public class company_response {
    int ResponseID,ComplaintID,CompanyID;
    String CompanyResponse,ResponseStatus,ConsumerDisputed,TimelyResponse;

    public int getResponseID() {
        return ResponseID;
    }

    public void setResponseID(int ResponseID) {
        this.ResponseID = ResponseID;
    }

    public int getComplaintID() {
        return ComplaintID;
    }

    public void setComplaintID(int ComplaintID) {
        this.ComplaintID = ComplaintID;
    }

    public int getCompanyID() {
        return CompanyID;
    }

    public void setCompanyID(int CompanyID) {
        this.CompanyID = CompanyID;
    }

    public String getCompanyResponse() {
        return CompanyResponse;
    }

    public void setCompanyResponse(String CompanyResponse) {
        this.CompanyResponse = CompanyResponse;
    }

    public String getResponseStatus() {
        return ResponseStatus;
    }

    public void setResponseStatus(String ResponseStatus) {
        this.ResponseStatus = ResponseStatus;
    }

    public String getConsumerDisputed() {
        return ConsumerDisputed;
    }

    public void setConsumerDisputed(String ConsumerDisputed) {
        this.ConsumerDisputed = ConsumerDisputed;
    }

    public String getTimelyResponse() {
        return TimelyResponse;
    }

    public void setTimelyResponse(String TimelyResponse) {
        this.TimelyResponse = TimelyResponse;
    }

    public company_response(int ResponseID, int ComplaintID, int CompanyID, String CompanyResponse, String ResponseStatus, String ConsumerDisputed, String TimelyResponse) {
        this.ResponseID = ResponseID;
        this.ComplaintID = ComplaintID;
        this.CompanyID = CompanyID;
        this.CompanyResponse = CompanyResponse;
        this.ResponseStatus = ResponseStatus;
        this.ConsumerDisputed = ConsumerDisputed;
        this.TimelyResponse = TimelyResponse;
    }
}
