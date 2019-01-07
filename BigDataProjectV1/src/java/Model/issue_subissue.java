package Model;

public class issue_subissue {
    int SubissueID,IssueID;
    String SubissueName, IssueName;

    public issue_subissue(int SubissueID, int IssueID, String SubissueName, String IssueName) {
        this.SubissueID = SubissueID;
        this.IssueID = IssueID;
        this.SubissueName = SubissueName;
        this.IssueName = IssueName;
    }

    public int getSubissueID() {
        return SubissueID;
    }

    public void setSubissueID(int SubissueID) {
        this.SubissueID = SubissueID;
    }

    public int getIssueID() {
        return IssueID;
    }

    public void setIssueID(int IssueID) {
        this.IssueID = IssueID;
    }

    public String getSubissueName() {
        return SubissueName;
    }

    public void setSubissueName(String SubissueName) {
        this.SubissueName = SubissueName;
    }

    public String getIssueName() {
        return IssueName;
    }

    public void setIssueName(String IssueName) {
        this.IssueName = IssueName;
    }
    
}
