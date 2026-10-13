package warehouse_management;
import java.util.Scanner;

public class Menu {
	public Inventory getInventory() {
	    return inventory;
	}
	 private Inventory inventory = new Inventory();
	    private Report report = new Report();
	    private Scanner sc = new Scanner(System.in);
	    public void mainMenu() {

	        int choice;

	        do {

	            System.out.println("\n==================================");
	            System.out.println("      WAREHOUSE MANAGEMENT");
	            System.out.println("==================================");
	            System.out.println("1. Inventory Dashboard");
	            System.out.println("2. Product Management");
	            System.out.println("3. Supplier Management");
	            System.out.println("4. Stock Management");
	            System.out.println("5. Reports");
	            System.out.println("6. Exit");
	            System.out.print("Enter Choice : ");

	            choice = Integer.parseInt(sc.nextLine());

	            switch(choice) {

	            case 1:

	                inventory.dashboard();

	                break;

	            case 2:

	                productMenu();

	                break;

	            case 3:

	                supplierMenu();

	                break;

	            case 4:

	                stockMenu();

	                break;

	            case 5:

	                reportMenu();

	                break;

	            case 6:

	                System.out.println("Thank You!");

	                break;

	            default:

	                System.out.println("Invalid Choice.");

	            }

	        }

	        while(choice != 6);

	    }
	    
	    public void productMenu() {

	        int choice;

	        do {

	            System.out.println("\n========== PRODUCT MENU ==========");

	            System.out.println("1. Add Product");
	            System.out.println("2. View Products");
	            System.out.println("3. Search Product");
	            System.out.println("4. Search By Category");
	            System.out.println("5. Update Product");
	            System.out.println("6. Delete Product");
	            System.out.println("7. Back");

	            System.out.print("Enter Choice : ");

	            choice = Integer.parseInt(sc.nextLine());

	            switch(choice) {

	            case 1:

	                addProduct();

	                break;

	            case 2:

	                inventory.viewProducts();

	                break;

	            case 3:

	                searchProduct();

	                break;

	            case 4:

	                searchCategory();

	                break;

	            case 5:

	                updateProduct();

	                break;

	            case 6:

	                deleteProduct();

	                break;

	            case 7:

	                break;

	            default:

	                System.out.println("Invalid Choice");

	            }

	        }

	        while(choice != 7);

	    }
	    
	    private void addProduct() {

	        String id = inventory.generateProductId();

	        System.out.print("Product Name : ");
	        String name = sc.nextLine();

	        System.out.print("Category : ");
	        String category = sc.nextLine();

	        System.out.print("Supplier : ");
	        String supplier = sc.nextLine();

	        System.out.print("Purchase Price : ");
	        double purchase = Double.parseDouble(sc.nextLine());

	        System.out.print("Selling Price : ");
	        double selling = Double.parseDouble(sc.nextLine());

	        System.out.print("Quantity : ");
	        int quantity = Integer.parseInt(sc.nextLine());

	        System.out.print("Minimum Stock : ");
	        int minimum = Integer.parseInt(sc.nextLine());

	        Product product = new Product(id,
	                name,
	                category,
	                supplier,
	                purchase,
	                selling,
	                quantity,
	                minimum);

	        inventory.addProduct(product);

	    }
	    
	    //search product
	    private void searchProduct() {

	        System.out.print("Enter Product ID : ");

	        String id = sc.nextLine();

	        Product product = inventory.searchProductById(id);

	        if(product == null) {

	            System.out.println("Product Not Found.");

	        }

	        else {

	            System.out.println(product);

	        }

	    }
	    
	    private void searchCategory() {

	        System.out.print("Enter Category : ");

	        String category = sc.nextLine();

	        inventory.searchByCategory(category);

	    }
	    
	    private void deleteProduct() {

	        System.out.print("Enter Product ID : ");

	        String id = sc.nextLine();

	        inventory.deleteProduct(id);

	    }
	    private void updateProduct() {

	        System.out.print("Enter Product ID : ");
	        String id = sc.nextLine();

	        Product product = inventory.searchProductById(id);

	        if(product == null) {
	            System.out.println("Product Not Found.");
	            return;
	        }

	        int choice;

	        do {

	            System.out.println("\n====== UPDATE PRODUCT ======");
	            System.out.println("1. Update Name");
	            System.out.println("2. Update Category");
	            System.out.println("3. Update Supplier");
	            System.out.println("4. Update Purchase Price");
	            System.out.println("5. Update Selling Price");
	            System.out.println("6. Update Quantity");
	            System.out.println("7. Update Minimum Stock");
	            System.out.println("8. Back");

	            System.out.print("Choice : ");
	            choice = Integer.parseInt(sc.nextLine());

	            switch(choice) {

	            case 1:
	                System.out.print("New Name : ");
	                product.setProductName(sc.nextLine());
	                break;

	            case 2:
	                System.out.print("New Category : ");
	                product.setCategory(sc.nextLine());
	                break;

	            case 3:
	                System.out.print("New Supplier : ");
	                product.setSupplier(sc.nextLine());
	                break;

	            case 4:
	                System.out.print("New Purchase Price : ");
	                product.setPurchasePrice(Double.parseDouble(sc.nextLine()));
	                break;

	            case 5:
	                System.out.print("New Selling Price : ");
	                product.setSellingPrice(Double.parseDouble(sc.nextLine()));
	                break;

	            case 6:
	                System.out.print("New Quantity : ");
	                product.setQuantity(Integer.parseInt(sc.nextLine()));
	                break;

	            case 7:
	                System.out.print("New Minimum Stock : ");
	                product.setMinimumStock(Integer.parseInt(sc.nextLine()));
	                break;

	            case 8:
	                break;

	            default:
	                System.out.println("Invalid Choice.");
	            }

	        } while(choice != 8);

	    }
	    
	   

	    public void supplierMenu() {

	        int choice;

	        do {

	            System.out.println("\n========== SUPPLIER MENU ==========");

	            System.out.println("1. Add Supplier");
	            System.out.println("2. View Suppliers");
	            System.out.println("3. Search Supplier");
	            System.out.println("4. Delete Supplier");
	            System.out.println("5. Back");

	            System.out.print("Enter Choice : ");

	            choice = Integer.parseInt(sc.nextLine());

	            switch(choice) {

	            case 1:

	                addSupplier();

	                break;

	            case 2:

	                inventory.viewSuppliers();

	                break;

	            case 3:

	                searchSupplier();

	                break;

	            case 4:

	                deleteSupplier();

	                break;

	            }

	        }

	        while(choice != 5);

	    }
	    
	    private void addSupplier() {

	        String id = inventory.generateSupplierId();

	        System.out.print("Supplier Name : ");

	        String name = sc.nextLine();

	        System.out.print("Phone : ");

	        String phone = sc.nextLine();

	        System.out.print("Email : ");

	        String email = sc.nextLine();

	        System.out.print("Address : ");

	        String address = sc.nextLine();

	        Supplier supplier = new Supplier(

	                id,

	                name,

	                phone,

	                email,

	                address);

	        inventory.addSupplier(supplier);

	    }
	    
	    private void searchSupplier() {

	        System.out.print("Supplier ID : ");

	        String id = sc.nextLine();

	        Supplier supplier = inventory.searchSupplier(id);

	        if(supplier == null)

	            System.out.println("Supplier Not Found.");

	        else

	            System.out.println(supplier);

	    }
	    
	    private void deleteSupplier() {

	        System.out.print("Supplier ID : ");

	        String id = sc.nextLine();

	        inventory.deleteSupplier(id);

	    }
	    
	    public void stockMenu() {

	        int choice;

	        do {

	            System.out.println("\n========== STOCK MENU ==========");

	            System.out.println("1. Incoming Stock");

	            System.out.println("2. Outgoing Stock");

	            System.out.println("3. Low Stock Alert");

	            System.out.println("4. Back");

	            System.out.print("Enter Choice : ");

	            choice = Integer.parseInt(sc.nextLine());

	            switch(choice) {

	            case 1:

	                incomingStock();

	                break;

	            case 2:

	                outgoingStock();

	                break;

	            case 3:

	                inventory.lowStockAlert();

	                break;

	            }

	        }

	        while(choice != 4);

	    }
	    
	    private void incomingStock() {

	        System.out.print("Product ID : ");

	        String id = sc.nextLine();

	        Product product = inventory.searchProductById(id);

	        if(product == null){

	            System.out.println("Product Not Found.");

	            return;

	        }

	        System.out.print("Quantity Added : ");

	        int quantity = Integer.parseInt(sc.nextLine());

	        inventory.incomingStock(id, quantity);

	        report.savePurchaseHistory(product, quantity);

	    }
	    
	    private void outgoingStock() {

	        System.out.print("Enter Product ID : ");
	        String id = sc.nextLine();

	        Product product = inventory.searchProductById(id);

	        if(product == null) {

	            System.out.println("Product Not Found.");
	            return;

	        }

	        System.out.print("Quantity Sold : ");
	        int quantity = Integer.parseInt(sc.nextLine());

	        if(quantity > product.getQuantity()) {

	            System.out.println("Insufficient Stock.");
	            return;

	        }

	        inventory.outgoingStock(id, quantity);

	        double profit = inventory.calculateProfit(id, quantity);

	        report.saveSalesHistory(product, quantity, profit);

	        System.out.println("Estimated Profit : ₹" + profit);

	    }
	    
	    
	    public void reportMenu() {

	        int choice;

	        do {

	            System.out.println("\n========== REPORT MENU ==========");

	            System.out.println("1. Save Inventory Report");
	            System.out.println("2. Back");

	            System.out.print("Enter Choice : ");

	            choice = Integer.parseInt(sc.nextLine());

	            switch(choice) {

	            case 1:

	                report.saveInventoryReport(inventory.getProductList());

	                break;

	            case 2:

	                break;

	            default:

	                System.out.println("Invalid Choice.");

	            }

	        }

	        while(choice != 2);

	    }
	    }
	    
	    



