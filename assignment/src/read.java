import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class read {
    public static void main(String[] args){
        read main = new read();
        main.readFile("Store/UserAccount.txt","Store/user.txt");
    }
    public void readFile(String fileName, String s){
        File file = new File(getClass().getResource(fileName).getPath());
        try{
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                System.out.println(scanner.nextLine());

            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}