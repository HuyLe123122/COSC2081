package Store;


public class Client {

    private String customerName;
    private String customerAddress;
    private Integer phoneNumber;

    public Client(String customerName, String customerAddress, Integer phoneNumber){
        this.setCustomerName(this.customerName);
        this.setCustomerAddress(this.customerAddress);
        this.setPhoneNumber(this.phoneNumber);
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String CustomerName) {
        this.customerName = CustomerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public double getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void showInfo() {
        System.out.println("Customer Info: ");
        System.out.println("- Name \t\t:" + this.getCustomerName());
        System.out.println("- Address \t\t:" + this.getCustomerAddress());
        System.out.println("- Phone Number  \t:" + this.getPhoneNumber());
    }
}
