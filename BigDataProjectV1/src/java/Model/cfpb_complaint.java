package Model;
public class cfpb_complaint {
  int  ProductID,SubproductID,IssueID,SubissueID,CompanyID;
  String SubmittedVia,ComplaintNarratives, Tags, DateSent,ConsentProvided, ComplaintID, DateReceived;

    public cfpb_complaint(String ComplaintID, int ProductID, int SubproductID, int IssueID, int SubissueID, int CompanyID, String SubmittedVia, String ComplaintNarratives, String Tags, String DateSent, String ConsentProvidedComplaintID, String DateReceived) {
        this.ComplaintID = ComplaintID;
        this.ProductID = ProductID;
        this.SubproductID = SubproductID;
        this.IssueID = IssueID;
        this.SubissueID = SubissueID;
        this.CompanyID = CompanyID;
        this.SubmittedVia = SubmittedVia;
        this.ComplaintNarratives = ComplaintNarratives;
        this.Tags = Tags;
        this.DateSent = DateSent;
        this.ConsentProvided = ConsentProvidedComplaintID;
        this.DateReceived = DateReceived;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public int getSubproductID() {
        return SubproductID;
    }

    public void setSubproductID(int SubproductID) {
        this.SubproductID = SubproductID;
    }

    public int getIssueID() {
        return IssueID;
    }

    public void setIssueID(int IssueID) {
        this.IssueID = IssueID;
    }

    public int getSubissueID() {
        return SubissueID;
    }

    public void setSubissueID(int SubissueID) {
        this.SubissueID = SubissueID;
    }

    public int getCompanyID() {
        return CompanyID;
    }

    public void setCompanyID(int CompanyID) {
        this.CompanyID = CompanyID;
    }

    public String getSubmittedVia() {
        return SubmittedVia;
    }

    public void setSubmittedVia(String SubmittedVia) {
        this.SubmittedVia = SubmittedVia;
    }

    public String getComplaintNarratives() {
        return ComplaintNarratives;
    }

    public void setComplaintNarratives(String ComplaintNarratives) {
        this.ComplaintNarratives = ComplaintNarratives;
    }

    public String getTags() {
        return Tags;
    }

    public void setTags(String Tags) {
        this.Tags = Tags;
    }

    public String getDateSent() {
        return DateSent;
    }

    public void setDateSent(String DateSent) {
        this.DateSent = DateSent;
    }

    public String getConsentProvided() {
        return ConsentProvided;
    }

    public void setConsentProvidedComplaintID(String ConsentProvidedComplaintID) {
        this.ConsentProvided = ConsentProvidedComplaintID;
    }

    public String getDateReceived() {
        return DateReceived;
    }

    public void setDateReceived(String DateReceived) {
        this.DateReceived = DateReceived;
    }
    
    public void setComplaintID(String com){
        this.setComplaintID(com);
    }
    
    public String getComplaintID(){
        return ComplaintID;
    }
  
}
