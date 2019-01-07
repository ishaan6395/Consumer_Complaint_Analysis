package Model;
public class cfpb_merged {
    String ComplaintID,DateReceived,DateSent,ProductName,SubproductName,IssueName,SubissueName,
            CompanyName,SubmittedVia,ComplaintNarratives,Tags,ConsentProvided;

    public cfpb_merged(String ComplaintID, String DateReceived, String DateSent, String ProductName, String SubproductName, String IssueName, String SubissueName, String CompanyName, String SubmittedVia, String ComplaintNarratives, String Tags, String ConsentProvided) {
        this.ComplaintID = ComplaintID;
        this.DateReceived = DateReceived;
        this.DateSent = DateSent;
        this.ProductName = ProductName;
        this.SubproductName = SubproductName;
        this.IssueName = IssueName;
        this.SubissueName = SubissueName;
        this.CompanyName = CompanyName;
        this.SubmittedVia = SubmittedVia;
        this.ComplaintNarratives = ComplaintNarratives;
        this.Tags = Tags;
        this.ConsentProvided = ConsentProvided;
    }

    public String getComplaintID() {
        return ComplaintID;
    }

    public void setComplaintID(String ComplaintID) {
        this.ComplaintID = ComplaintID;
    }

    public String getDateReceived() {
        return DateReceived;
    }

    public void setDateReceived(String DateReceived) {
        this.DateReceived = DateReceived;
    }

    public String getDateSent() {
        return DateSent;
    }

    public void setDateSent(String DateSent) {
        this.DateSent = DateSent;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getSubproductName() {
        return SubproductName;
    }

    public void setSubproductName(String SubproductName) {
        this.SubproductName = SubproductName;
    }

    public String getIssueName() {
        return IssueName;
    }

    public void setIssueName(String IssueName) {
        this.IssueName = IssueName;
    }

    public String getSubissueName() {
        return SubissueName;
    }

    public void setSubissueName(String SubissueName) {
        this.SubissueName = SubissueName;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
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

    public String getConsentProvided() {
        return ConsentProvided;
    }

    public void setConsentProvided(String ConsentProvided) {
        this.ConsentProvided = ConsentProvided;
    }
    
}
