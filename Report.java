package warehouse_management;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Report {
	private DateTimeFormatter formatter =
	        DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss a");
	
	public void savePurchaseHistory(Product product,
            int quantity) {

try {

FileWriter fw =
new FileWriter("PurchaseHistory.txt", true);

fw.write("\n====================================\n");

fw.write("Date : "
+ LocalDateTime.now().format(formatter)
+ "\n");

fw.write("Product ID : "
+ product.getProductId() + "\n");

fw.write("Product Name : "
+ product.getProductName() + "\n");

fw.write("Supplier : "
+ product.getSupplier() + "\n");

fw.write("Quantity Added : "
+ quantity + "\n");

fw.write("Purchase Price : ₹"
+ product.getPurchasePrice() + "\n");

fw.write("====================================\n");

fw.close();

}

catch(Exception e){

System.out.println(e.getMessage());

}

}
	
	public void saveSalesHistory(Product product,
            int quantity,
            double profit) {

try {

FileWriter fw =
new FileWriter("SalesHistory.txt", true);

fw.write("\n====================================\n");

fw.write("Date : "
+ LocalDateTime.now().format(formatter)
+ "\n");

fw.write("Product ID : "+ product.getProductId() + "\n");

fw.write("Product Name : "+ product.getProductName() + "\n");

fw.write("Quantity Sold : "+ quantity + "\n");

fw.write("Selling Price : ₹"+ product.getSellingPrice() + "\n");

fw.write("Profit : ₹"+ profit + "\n");

fw.write("====================================\n");

fw.close();

}

catch(Exception e){

System.out.println(e.getMessage());

}

}
	
	public void saveInventoryReport(ArrayList<Product> products) {

	    try {

	        FileWriter fw =
	                new FileWriter("InventoryReport.txt",true);

	        fw.write("========== INVENTORY REPORT ==========\n\n");

	        for(Product product : products){

	            fw.write(product.toString());

	            fw.write("\n-----------------------------\n");

	        }

	        fw.close();

	        System.out.println("Inventory Report Saved.");

	    }

	    catch(Exception e){

	        System.out.println(e.getMessage());

	    }

	}
	
	

}
