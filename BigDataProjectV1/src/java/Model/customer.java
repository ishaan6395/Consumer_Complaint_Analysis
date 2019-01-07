package Model;

public class customer {
    int CustomerID;
    String CustomerName, Zip, AgeRange,IncomeRange;

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public String getZip() {
        return Zip;
    }

    public void setZip(String Zip) {
        this.Zip = Zip;
    }

    public String getAgeRange() {
        return AgeRange;
    }

    public void setAgeRange(String AgeRange) {
        this.AgeRange = AgeRange;
    }

    public String getIncomeRange() {
        return IncomeRange;
    }

    public void setIncomeRange(String IncomeRange) {
        this.IncomeRange = IncomeRange;
    }

    public customer(int CustomerID, String CustomerName, String Zip, String AgeRange, String IncomeRange) {
        this.CustomerID = CustomerID;
        this.CustomerName = CustomerName;
        this.Zip = Zip;
        this.AgeRange = AgeRange;
        this.IncomeRange = IncomeRange;
    }
}
