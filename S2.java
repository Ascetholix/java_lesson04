import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class S2 {
    public static void main(String[] args) {
        String text = "";
        FileReader reader = null;
        try {
            reader = new FileReader("bd.sql");
            while (reader.ready()){
                text += (char)reader.read();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(text);
    }
}
