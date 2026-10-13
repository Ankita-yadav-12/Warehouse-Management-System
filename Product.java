package warehouse_management;
import java.io.Serializable;
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
	

    private String productId;
    private String productName;
    private String category;
    private String supplier;

    private double purchasePrice;
    private double sellingPrice;

    private int quantity;
    private int minimumStock;

    // Constructor
    public Product(String productId, String productName, String category,
                   String supplier, double purchasePrice,
                   double sellingPrice, int quantity,
                   int minimumStock) {

        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.supplier = supplier;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
        this.quantity = quantity;
        this.minimumStock = minimumStock;
    }

    // Getters

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public String getSupplier() {
        return supplier;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getMinimumStock() {
        return minimumStock;
    }

    // Setters

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setMinimumStock(int minimumStock) {
        this.minimumStock = minimumStock;
    }

    // Display Product

    @Override
    public String toString() {

        return "\nProduct ID : " + productId
                + "\nProduct Name : " + productName
                + "\nCategory : " + category
                + "\nSupplier : " + supplier
                + "\nPurchase Price : ₹" + purchasePrice
                + "\nSelling Price : ₹" + sellingPrice
                + "\nQuantity : " + quantity
                + "\nMinimum Stock : " + minimumStock;
    }

}