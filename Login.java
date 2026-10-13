package warehouse_management;



import java.util.Scanner;

public class Login {

    private final String USERNAME = "admin";
    private final String PASSWORD = "1234";

    public boolean login() {

        Scanner sc = new Scanner(System.in);

        int attempts = 3;

        while (attempts > 0) {

            System.out.println("\n========== ADMIN LOGIN ==========");

            System.out.print("Username : ");
            String username = sc.nextLine();

            System.out.print("Password : ");
            String password = sc.nextLine();

            if (username.equals(USERNAME) &&
                    password.equals(PASSWORD)) {

                System.out.println("\nLogin Successful!");
                return true;

            } else {

                attempts--;

                System.out.println("\nInvalid Username or Password.");

                if (attempts > 0) {

                    System.out.println("Attempts Left : " + attempts);

                }

            }

        }

        System.out.println("\nToo Many Invalid Attempts.");
        System.out.println("Access Denied.");
        
        return false;
        
    }
   
}