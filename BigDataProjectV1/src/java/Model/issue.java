package Model;

public class issue {
    int IssueID;
    String IssueName;

    public issue(int IssueID, String IssueName) {
        this.IssueID = IssueID;
        this.IssueName = IssueName;
    }

    public int getIssueID() {
        return IssueID;
    }

    public void setIssueID(int IssueID) {
        this.IssueID = IssueID;
    }

    public String getIssueName() {
        return IssueName;
    }

    public void setIssueName(String IssueName) {
        this.IssueName = IssueName;
    }
}
