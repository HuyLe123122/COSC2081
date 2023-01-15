package Store;

import java.io.FileNotFoundException;
import java.io.*;
import java.util.Scanner;

public class UserAccount {
    String username;
    String password;
    public UserAccount(){}
    public UserAccount(String username,String password, String filename){
        this.username = username;
        this.password = password;
        writeToFile(filename);
    }
    public void createFile(String filename){
        try {
            File myFile = new File("src/Store/UserAccount.txt");
            if (!myFile.exists())
                myFile.createNewFile();
        }catch (IOException e){
            System.out.println("Error while creating FIle");
        }
    }
    public void writeToFile(String filename){
        try {
            FileWriter myWriter = new FileWriter("src/Store/UserAccount"+filename,true);
            myWriter.write("\n Username:"+username +"\t Password:" + password);
            myWriter.close();
        } catch (IOException e){
            System.out.println("Error while writing to file");

        };
    }
    public static void readFromFile(String filename){
        try{
            FileReader myReader = new FileReader("src/Store/UserAccount"+filename);
            int i;
            while ((i=myReader.read())!= -1)
                System.out.println((char)i);
        }catch (IOException e){
            System.out.println("Error While reading from file");
        }
    }


}
class Account{
    public Account() throws FileNotFoundException {
        char ch;
        String username = "", password = "";
        final String filename = "UserAccount.txt";
        Scanner input = new Scanner(System.in);
        UserAccount userAccount = new UserAccount();
        userAccount.createFile(filename);
        do {
            System.out.println("1.Register: ");
            System.out.println("2.Login: ");
            System.out.println("3.Admin login: ");
            System.out.println("0.Exit");
            System.out.println("Choose:");
            switch (ch = input.next().charAt(0)) {
                case '1':
                    input.nextLine();
                    System.out.println("Username: ");
                    username = input.nextLine();
                    System.out.println("Password: ");
                    password = input.nextLine();
                    userAccount = new UserAccount(username,password,filename);
                    System.out.println("Welcome to book Store");
                    break;
                case '2':
                    input.nextLine();
                    System.out.println("Username: ");
                    username = input.nextLine();
                    System.out.println("Password: ");
                    password = input.nextLine();
                    Scanner fileScan = new Scanner(new File("src/Store/UserAccountUserAccount.txt"));
                    boolean found = false;
                    while(fileScan.hasNextLine()) {
                        String Input = fileScan.nextLine();
                        String Username = Input.substring(0, Input.indexOf(""));
                        String Password = Input.substring(Input.indexOf("")+1);

                        if ((username.equals("hello")) && (password.equals("hello"))) {
                            found = true;
                            System.out.println("Logged in successfully");
                            System.out.println("Welcome to book Store");

                        }
                        if (!found) {
                            System.out.println("Invalid User");
                            Account account = new Account();
                            System.out.println(password);
                        }break;
                    }
                    break;
                case '3':
                    System.out.println("====================== A d m i n - L o g i n ======================");
                    input.nextLine();
                    System.out.println("Username: ");
                    username = input.nextLine();
                    System.out.println("Password: ");
                    password = input.nextLine();
                    if (username.equals("admin") && password.equals("admin12345")) {
                        System.out.println("------ Login Success! Welcome to admin! ------");
                        Admin.showMenu();
                        break;
                    } else {
                        Admin.adminFailedLoginMenu();
                        System.out.println("failed to login admin");
                        Account account = new Account();
                    }
                    break;
                    case '0':
                    break;
                default:
                    System.out.println("Wrong choice");
                    Account account =  new Account();
            }
            break;
        } while (ch != '0');
    }
}