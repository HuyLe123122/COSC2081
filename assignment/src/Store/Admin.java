package Store;

import java.io.IOException;
import java.util.Scanner;

public class Admin {
    private static BookStore storeObj	= new BookStore();
    private static Client clientobj	= null;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int functionID	= 0;
        boolean flag	= true;

        do {
            Account account = new Account();
            showMenu();

            try {
                functionID		= sc.nextInt();
                sc.nextLine();

                switch (functionID) {
                    case 1: addBook(); 		break;
                    case 2: editBook(); 	break;
                    case 3: deleteBook(); 	break;
                    case 4: findBook(); 	break;
                    case 5: listBook("price", 0); 	break;	// price 0	price High - Low
                    case 6: listBook("price", 1); 	break;	// price 1	price Low - High
                    case 7: listBook("name", 1); 	break;	// name 1	name A-Z
                    case 8: listBook("name", 0); 	break;  // name 0	name Z-A
                    case 9: addName(); break;
                    case 10: editInfo(); break;
                    case 11:
                    default:
                        flag = false;
                        break;
                }
            } catch (Exception e) {
                Print("Error! Please try again!");
                flag	= true;
                sc.nextLine();
            }

        } while (flag == true);

        sc.close();
    }

    public static void showMenu(){
        Print(" BOOK STORE ");
        Print("1. ADD BOOK");		// x
        Print("2. EDIT BOOK");	// x
        Print("3. DELETE BOOK");	//
        Print("4. FIND BOOK");	// x
        Print("5. SORT (PRICE: HIGH > LOW)");
        Print("6. SORT (PRICE: LOW > HIGH)");
        Print("7. SORT (NAME: A > Z)");
        Print("8. SORT (NAME: Z > A)");
        Print("9. ADD CUSTOMER INFO");
        Print("10. EDIT CUSTOMER INFO");
        Print("11.EXIT");// x
        Print("Your choice [1-11]: ");
    }

    public static void addBook(){
        if(storeObj.checkFull() == false){
            Scanner sc = new Scanner(System.in);

            String bookName	= "";
            String bookID	= "";
            double bookPrice= 0;

            Print("ID: ");
            bookID		= sc.nextLine();

            Print("Name: ");
            bookName	= sc.nextLine();

            Print("Price: ");
            bookPrice	= sc.nextDouble();

            Validate validateObj	= new Validate();
            boolean flagID			= validateObj.checkID(bookID);
            boolean flagName		= validateObj.checkName(bookName);
            boolean flagPrice		= validateObj.checkPrice(bookPrice);

            if(flagID && flagName && flagPrice){
                Book bookObj	= new Book(bookID, bookName, bookPrice);
                storeObj.add(bookObj);
            }else{
                validateObj.getError();
            }


        }else{
            System.out.println("Store is full!");
        }
    }

    public static void Print(String content){
        System.out.println(content);
    }

    public static void deleteBook(){
        Scanner sc = new Scanner(System.in);

        String bookID	= "";

        Print("ID: ");
        bookID		= sc.nextLine();

        storeObj.delete(bookID);
    }

    public static void findBook(){
        Scanner sc = new Scanner(System.in);

        String bookID	= "";

        Print("ID: ");
        bookID		= sc.nextLine();

        storeObj.find(bookID);
    }

    public static void editBook(){
        Scanner sc = new Scanner(System.in);

        String bookName	= "";
        String bookID	= "";
        double bookPrice= 0;

        Print("ID: ");
        bookID		= sc.nextLine();

        Print("NAME: ");
        bookName	= sc.nextLine();

        Print("PRICE: ");
        bookPrice	= sc.nextDouble();

        storeObj.edit(bookID, bookName, bookPrice);
    }

    public static void listBook(String property, int type){
        if(property.equals("name") && type == 1) storeObj.sortNameAZ();
        if(property.equals("name") && type == 0) storeObj.sortNameZA();
        if(property.equals("price") && type == 1) storeObj.sortPriceAZ();
        if(property.equals("price") && type == 0) storeObj.sortPriceZA();
        storeObj.list();
    }
    public static void addName(){
        Scanner sc = new Scanner(System.in);
        String customerName		= "";
        String customerAddress		= "";
        Integer phoneNumber	= 0;

        Print("Name: ");
        customerName	= sc.nextLine();

        Print("Address: ");
        customerAddress	= sc.nextLine();

        Print("Phone Number: ");
        phoneNumber	= sc.nextInt();

        clientobj= new Client(customerName, customerAddress, phoneNumber);

    }
    public static void editInfo(){
        if (clientobj != null) {
            Scanner sc = new Scanner(System.in);

            String Name = "";
            String Address = "";
            Integer PhoneNumber = 0;

            Print("Name: ");
            Name = sc.nextLine();

            Print("Address: ");
            Address = sc.nextLine();

            Print("PRICE: ");
            PhoneNumber = sc.nextInt();
            clientobj.setCustomerName(Name);
            clientobj.setCustomerAddress(Address);
            clientobj.setPhoneNumber(PhoneNumber);

        }else{
            Print("Customer is not exist");
        }
    }

    public static void adminFailedLoginMenu() {
    }
}
