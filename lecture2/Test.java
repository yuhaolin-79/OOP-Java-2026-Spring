import java.lang.String;
import java.io.FileWriter;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("hello.txt");
            String h = "Hello"; 
            String w = "World";
            fw.write(h+ " " + w); 
            fw.close ();
        }
        catch (IOException e) {
            System.out.println("Error writing to file:" + e);
        }
    }
}