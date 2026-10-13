package warehouse_management;
import java.util.ArrayList;
import java.io.*;

public class Inventory {
	
	private void updateProductCounter() {

	    int max = 100;

	    for (Product product : productList) {

	        String id = product.getProductId();

	        if (id.startsWith("P")) {

	            int number = Integer.parseInt(id.substring(1));

	            if (number > max) {

	                max = number;

	            }

	        }

	    }

	    productCounter = max + 1;
	}
	
	private void updateSupplierCounter() {

	    int max = 100;

	    for (Supplier supplier : supplierList) {

	        String id = supplier.getSupplierId();

	        if (id.startsWith("S")) {

	            int number = Integer.parseInt(id.substring(1));

	            if (number > max) {

	                max = number;

	            }

	        }

	    }

	    supplierCounter = max + 1;
	}
	
	
	
	private ArrayList<Product> productList = new ArrayList<>();

	private ArrayList<Supplier> supplierList = new ArrayList<>();
	private int productCounter = 101;
	public String generateProductId() {

	    return "P" + productCounter++;

	}
	private int supplierCounter = 101;
	public String generateSupplierId() {

	    return "S" + supplierCounter++;

	}
	public void addSupplier(Supplier supplier) {

	    supplierList.add(supplier);
	    saveInventory();

	    System.out.println("Supplier Added Successfully.");

	}
	
	public void viewSuppliers() {

	    if (supplierList.isEmpty()) {

	        System.out.println("No Suppliers Available.");

	        return;

	    }

	    for (Supplier supplier : supplierList) {

	        System.out.println(supplier);

	        System.out.println("-------------------------");

	    }

	}
	
	public void addProduct(Product product) {

	    productList.add(product);
	    saveInventory();

	    System.out.println("Product Added Successfully.");

	}
	
	public void viewProducts() {

	    if (productList.isEmpty()) {

	        System.out.println("No Products Available.");

	        return;

	    }

	    for (Product product : productList) {

	        System.out.println(product);

	        System.out.println("---------------------------");

	    }

	}
	
	public Product searchProductById(String productId) {

	    for (Product product : productList) {

	        if (product.getProductId().equalsIgnoreCase(productId)) {

	            return product;

	        }

	    }

	    return null;

	}
	
	public Product searchProductByName(String productName) {

	    for (Product product : productList) {

	        if (product.getProductName().equalsIgnoreCase(productName)) {

	            return product;

	        }

	    }

	    return null;

	}
	
	public void searchByCategory(String category) {

	    boolean found = false;

	    for (Product product : productList) {

	        if (product.getCategory().equalsIgnoreCase(category)) {

	            System.out.println(product);

	            System.out.println("-----------------------");

	            found = true;

	        }

	    }

	    if (!found) {

	        System.out.println("No Products Found.");

	    }

	}
	
	public void updateProduct(String productId,
            String name,
            String category,
            String supplier,
            double purchasePrice,
            double sellingPrice,
            int quantity,
            int minimumStock) {

Product product = searchProductById(productId);

if (product == null) {

System.out.println("Product Not Found.");

return;

}

product.setProductName(name);
product.setCategory(category);
product.setSupplier(supplier);
product.setPurchasePrice(purchasePrice);
product.setSellingPrice(sellingPrice);
product.setQuantity(quantity);
product.setMinimumStock(minimumStock);
saveInventory();

System.out.println("Product Updated Successfully.");

}
	
	public void deleteProduct(String productId) {

	    Product product = searchProductById(productId);

	    if (product == null) {

	        System.out.println("Product Not Found.");

	        return;

	    }

	    productList.remove(product);
	    saveInventory();

	    System.out.println("Product Deleted Successfully.");

	}
	
	public Supplier searchSupplier(String supplierId) {

	    for (Supplier supplier : supplierList) {

	        if (supplier.getSupplierId().equalsIgnoreCase(supplierId)) {

	            return supplier;

	        }

	    }

	    return null;

	}
	
	public void deleteSupplier(String supplierId) {

	    Supplier supplier = searchSupplier(supplierId);

	    if (supplier == null) {

	        System.out.println("Supplier Not Found.");

	        return;

	    }

	    supplierList.remove(supplier);
	    saveInventory();

	    System.out.println("Supplier Deleted Successfully.");

	}
	
	//Incoming Stock

	
	public void incomingStock(String productId, int quantity) {

	    Product product = searchProductById(productId);

	    if (product == null) {

	        System.out.println("Product Not Found.");

	        return;

	    }

	    product.setQuantity(product.getQuantity() + quantity);
	    saveInventory();

	    System.out.println("Stock Updated Successfully.");
	}
	
	public void outgoingStock(String productId, int quantity) {

	    Product product = searchProductById(productId);

	    if (product == null) {

	        System.out.println("Product Not Found.");

	        return;

	    }

	    if (quantity > product.getQuantity()) {
	    	
	        System.out.println("Insufficient Stock.");

	        return;

	    }

	    product.setQuantity(product.getQuantity() - quantity);
	    saveInventory();
	    System.out.println("Stock Updated Successfully.");
	}
	
	//Calculate Profit
	public double calculateProfit(String productId, int quantitySold) {

	    Product product = searchProductById(productId);

	    if (product == null) {

	        return 0;

	    }

	    double profit = (product.getSellingPrice()
	            - product.getPurchasePrice())
	            * quantitySold;

	    return profit;

	}
	
	//warehouse value
	public double warehouseValue() {

	    double total = 0;

	    for (Product product : productList) {

	        total += product.getPurchasePrice()
	                * product.getQuantity();

	    }

	    return total;

	}
	
	//low stock alert
	public void lowStockAlert() {

	    boolean found = false;

	    for (Product product : productList) {

	        if (product.getQuantity()
	                <= product.getMinimumStock()) {

	            System.out.println(product);

	            System.out.println("Need To Order : "
	                    + (product.getMinimumStock()
	                    - product.getQuantity()));

	            System.out.println("----------------------");

	            found = true;

	        }

	    }

	    if (!found) {

	        System.out.println("No Low Stock Products.");

	    }

	}
	
	//dash
	public void dashboard() {

	    int totalProducts = productList.size();

	    int totalSuppliers = supplierList.size();

	    int totalQuantity = 0;

	    int lowStock = 0;

	    for (Product product : productList) {

	        totalQuantity += product.getQuantity();

	        if (product.getQuantity()
	                <= product.getMinimumStock()) {

	            lowStock++;

	        }

	    }

	    System.out.println("\n========== INVENTORY DASHBOARD ==========");

	    System.out.println("Total Products : " + totalProducts);

	    System.out.println("Total Suppliers : " + totalSuppliers);

	    System.out.println("Total Quantity : " + totalQuantity);

	    System.out.println("Low Stock Products : " + lowStock);

	    System.out.println("Warehouse Value : ₹" + warehouseValue());

	}
	
	public ArrayList<Product> getProductList() {

	    return productList;

	}
	public void saveInventory() {

	    try {

	        ObjectOutputStream out =
	                new ObjectOutputStream(
	                        new FileOutputStream("inventory.dat"));

	        out.writeObject(productList);
	        out.writeObject(supplierList);

	        out.close();

	    }

	    catch(Exception e) {
	        e.printStackTrace();
	    }

	    }

	@SuppressWarnings("unchecked")
	public void loadInventory() {

	    try {

	        ObjectInputStream in =
	                new ObjectInputStream(
	                        new FileInputStream("inventory.dat"));

	        productList = (ArrayList<Product>) in.readObject();

	        supplierList = (ArrayList<Supplier>) in.readObject();
	        updateProductCounter();
	        updateSupplierCounter();

	        in.close();

	    }

	    catch(Exception e) {
	        e.printStackTrace();
	    }

	}
}
