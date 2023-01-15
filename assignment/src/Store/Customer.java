package Store;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Customer {
    String customerName;
    String address;
    Integer phoneNumber;
    public Customer(){}
    public Customer(String customerName, String address, int phoneNumber, String filename){
        this.customerName = customerName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        writeToFile(filename);
    }
    public void createFile(String filename){
        try {
            File myFile = new File("src/Store/Customer.txt"+filename);
            if (!myFile.exists())
                myFile.createNewFile();
        }catch (IOException e){
            System.out.println("Error while creating FIle");
        }
    }
    public void writeToFile(String filename){
        try {
            FileWriter myWriter = new FileWriter("src/Store/Customer.txt"+filename,true);
            myWriter.write("\n Name:"+ customerName +"\t Address:" + address +"\t Phone Number:" + phoneNumber);
            myWriter.close();
        } catch (IOException e){
            System.out.println("Error while writing to file");

        };
    }
    public static void readFromFile(String filename){
        try{
            FileReader myReader = new FileReader("src/Store/Customer.txt"+filename);
            int i;
            while ((i=myReader.read())!= -1)
                System.out.print((char)i);
        }catch (IOException e){
            System.out.println("Error While reading from file");
        }
    }


}
class CustomerInfo {
    public static void main(String[] args) {
        char ch;
        String customerName, address;
        int phoneNumber;
        final String filename = "Customer.txt";
        Scanner input = new Scanner(System.in);
        Customer info = new Customer();
        info.createFile(filename);
        System.out.println("Welcome to Customer Information");
        do {
            System.out.println("1. Add Information");
            System.out.println("2.Edit Information");
            System.out.println("3.Show List of Information");
            System.out.println("0.Exit");
            System.out.println("Choose:");
            switch (ch = input.next().charAt(0)) {
                case '1':
                    input.nextLine();
                    System.out.println("Name");
                    customerName = input.nextLine();
                    System.out.println("Home Adress");
                    address = input.nextLine();
                    System.out.println("Phone Number");
                    phoneNumber = input.nextInt();
                    info = new Customer(customerName, address,phoneNumber,filename);
                    break;
                case '2':
                    System.out.println("current working on");
                    break;
                case '3':
                    System.out.println("List Customer");
                    info.readFromFile(filename);
                    System.out.println(("\nEnd of List Customer"));
                    break;
                case '0':
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        } while (ch != '0');
    }
}