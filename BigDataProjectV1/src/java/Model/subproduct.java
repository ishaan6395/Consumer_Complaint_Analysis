package Model;
public class subproduct {
    int SubproductID,ProductID;
    String SubproductName;

    public int getSubproductID() {
        return SubproductID;
    }

    public void setSubproductID(int SubproductID) {
        this.SubproductID = SubproductID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public String getSubproductName() {
        return SubproductName;
    }

    public void setSubproductName(String SubproductName) {
        this.SubproductName = SubproductName;
    }

    public subproduct(int SubproductID, int ProductID, String SubproductName) {
        this.SubproductID = SubproductID;
        this.ProductID = ProductID;
        this.SubproductName = SubproductName;
    }
}
