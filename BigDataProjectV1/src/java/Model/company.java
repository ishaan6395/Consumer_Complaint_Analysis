package Model;

public class company {
    int CompanyID;
    String CompanyName;

    public company(int CompanyID, String CompanyName) {
        this.CompanyID = CompanyID;
        this.CompanyName = CompanyName;
    }

    public int getCompanyID() {
        return CompanyID;
    }

    public void setCompanyID(int CompanyID) {
        this.CompanyID = CompanyID;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }
    
}
