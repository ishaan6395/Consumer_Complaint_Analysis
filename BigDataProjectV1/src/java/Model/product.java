package Model;

public class product {
    int ProductID;
    String ProductName;

    public product(int ProductID, String ProductName) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }
    
}
