package Store;

import java.util.Scanner;
public class LoginAdmin extends UserAccount {
    Scanner sc = new Scanner(System.in);
    public LoginAdmin() {
        System.out.println("====================== A d m i n - L o g i n ======================");
        sc.nextLine();
        System.out.println("Username: ");
        username = sc.nextLine();
        System.out.println("Password: ");
        password = sc.nextLine();
        if (username.equals("admin") && password.equals("admin12345")) {
            System.out.println("------ Login Success! Welcome to admin! ------");
        } else {
            Admin.adminFailedLoginMenu();
        }
    }
}