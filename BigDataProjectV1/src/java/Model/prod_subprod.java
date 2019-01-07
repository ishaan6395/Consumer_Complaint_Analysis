package Model;

public class prod_subprod {
    int ProdId,SubProdID;
    String ProdName,SubprodName;

    public prod_subprod(int ProdId, int SubProdID, String ProdName, String SubprodName) {
        this.ProdId = ProdId;
        this.SubProdID = SubProdID;
        this.ProdName = ProdName;
        this.SubprodName = SubprodName;
    }

    public int getProdId() {
        return ProdId;
    }

    public void setProdId(int ProdId) {
        this.ProdId = ProdId;
    }

    public int getSubProdID() {
        return SubProdID;
    }

    public void setSubProdID(int SubProdID) {
        this.SubProdID = SubProdID;
    }

    public String getProdName() {
        return ProdName;
    }

    public void setProdName(String ProdName) {
        this.ProdName = ProdName;
    }

    public String getSubprodName() {
        return SubprodName;
    }

    public void setSubprodName(String SubprodName) {
        this.SubprodName = SubprodName;
    }
    
}
