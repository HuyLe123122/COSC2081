package Store;

public class Validate {

    private StringBuilder error	= new StringBuilder();



    public void getError() {
        System.out.println(this.error);
    }

    public void setError(String error) {
        this.error.append(error).append("\n");
    }

    public boolean checkPrice(double value){
        boolean flag = (value > 0) && (value < 1000);
        if(flag == false){
            this.setError("Price: Price must in [0-1000]");
        }
        return flag;
    }

    public boolean checkName(String value){
        boolean flag	= value.matches("[A-z\\.\\s!]{2,100}");
        if(flag == false){
            this.setError("Name: Name must in form of[A-z\\.\\s!]{2,100}");
        }
        return flag;
    }

    public boolean checkID(String value){
        boolean flag	= value.matches("[A-z]{3}-[0-9]{3}");
        if(flag == false){
            this.setError("ID: ID must in form of [A-z]{3}-[0-9]{3}");
        }
        return flag;
    }

}
