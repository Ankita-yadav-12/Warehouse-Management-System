package warehouse_management;

public class Main {
	public static void welcomeScreen() {


	        System.out.println("***************************************************");
	        System.out.println("*                                                 *");
	        System.out.println("*        WAREHOUSE MANAGEMENT SYSTEM              *");
	        System.out.println("*                                                 *");
	        System.out.println("*         Developed by CodeCrafters               *");
	        System.out.println("*                                                 *");
	        System.out.println("***************************************************");
	        System.out.println("*     Inventory Management Made Simple            *");
	        System.out.println("***************************************************");
	    }
	

	    public static void main(String[] args) {

	        welcomeScreen();

	        Login login = new Login();

	        if(login.login()) {

	            Menu menu = new Menu();

	            menu.getInventory().loadInventory();

	            menu.mainMenu();

	        }
	        else {

	            System.out.println("\nProgram Terminated.");

	        }

	    }

	}

