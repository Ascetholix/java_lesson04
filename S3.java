import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class S3 {
    public static void main(String[] args) {

        String str = "";
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> alFamily = new ArrayList<>();
        ArrayList<String> alName = new ArrayList<>();
        ArrayList<String> alSname = new ArrayList<>();
        ArrayList<Integer> alAge = new ArrayList<>();
        ArrayList<Boolean> alSex = new ArrayList<>();

        try {
            FileReader reader = new FileReader("tx.txt");

            while (reader.ready()) str += (char)reader.read();

            String [] arrStr = str.split("\r\n");

            for (int i = 0; i < arrStr.length; i++) {
                String[] tmp = arrStr[i].split(" ");
                alFamily.add(tmp[0]);
                alName.add(tmp[1]);
                alSname.add(tmp[2]);
                alAge.add(Integer.parseInt(tmp[3]));
                alSex.add(tmp[4].contains("Ж")?false: true);
            }
            System.out.println(alFamily);
            System.out.println(alName);
            System.out.println(alSname);
            System.out.println(alAge);
            System.out.println(alSex);

//            for (String item: arrStr) System.out.println(item);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
//        System.out.println(str);
    }
}
