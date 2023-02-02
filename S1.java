
import java.io.FileWriter;
import java.io.IOException;

public class S1 {
    public static void main(String[] args) {

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter("bd.sql");
            fileWriter.append("ПриветМир");
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
