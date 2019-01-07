package Model;

public class subissue {
    int SubissueID,IssueID;
    String SubissueName;

    public subissue(int SubissueID, int IssueID, String SubissueName) {
        this.SubissueID = SubissueID;
        this.IssueID = IssueID;
        this.SubissueName = SubissueName;
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
    
}
