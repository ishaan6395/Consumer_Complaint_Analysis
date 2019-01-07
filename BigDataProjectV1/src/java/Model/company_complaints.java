package Model;

public class company_complaints {
    int Complaints;
    String Company;

    public company_complaints(int Complaints, String Company) {
        this.Complaints = Complaints;
        this.Company = Company;
    }

    public int getComplaints() {
        return Complaints;
    }

    public void setComplaints(int Complaints) {
        this.Complaints = Complaints;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String Company) {
        this.Company = Company;
    }
    
    
}
