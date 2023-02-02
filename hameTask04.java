import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 * 1.Сохранить в файл строку и загрузить из файла строку с выводом в консоль используя классы FileWriter и FileReader
 * 2.Загрузить из файла многострочный текст формата ФИО возраст и пол через пробелы. Разбить по строкам
 * и вывести в консоль в формате "Иванов И.И. 32 М"
 * 3.Загруженный и разбитый по строкам текст загрузить в подготовленные списки. Фамилии, имена, отчества,
 * возрас и пол в отдельных списках.
 * 4.Отсортировать по возрасту используя дополнительный список индексов.
 */
public class hameTask04 {
    public static void main(String[] args) {
        // 1 Задача
        try {

            FileWriter fileWriter = new FileWriter("bd.txt");
            fileWriter.append("Горшков Федор Валерьевич 28 М\n");
            fileWriter.append("Уголева Антонина Ефимовна 18 Ж\n");
            fileWriter.append("Новосельцева Алла Данииловна 22 Ж\n");
            fileWriter.append("Митасова Алена Лукьяновна 35 Ж\n");
            fileWriter.append("Раскатов Юрий Юлианович 38 М\n");
            fileWriter.append("Шумов Лев Тимофеевич 23 М\n");
            fileWriter.flush();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        // 2 задача
        try {
            String str = new String();
            FileReader fileReader = new FileReader("bd.txt");
            while (fileReader.ready()) str +=(char)fileReader.read();
            System.out.println(str);

            // 3 задача
            String[] arrStr = str.split("\n");
            ArrayList<String> lastName = new ArrayList<>();
            ArrayList<String> firstName = new ArrayList<>();
            ArrayList<String> patrName = new ArrayList<>();
            ArrayList<Integer> age = new ArrayList<>();
            ArrayList<Boolean> sex = new ArrayList<>();
            for (int i = 0; i < arrStr.length; i++) {
                String[] tmp = arrStr[i].split(" ");
                lastName.add(tmp[0]);
                firstName.add(tmp[1]);
                patrName.add(tmp[2]);
                age.add(Integer.parseInt(tmp[3]));
                sex.add(tmp[4].contains("Ж")? false: true);
            }
            // задача
            int[] id = new int[age.size()]; // массив индексов
            for (int i = 0; i < age.size(); i++) {
                 id[i] = i;
            }
            int [] arrTemp = new int[age.size()]; // временый массив для работы с возрастом
            for (int i = 0; i < age.size(); i++) {
                arrTemp[i] = age.get(i);
            }

            // Сортировка пузырком
            boolean isSorted = false;     // переменая для ослеживание проходов
            while (!isSorted) {            // пока массив не отсортирован
                isSorted = true;
                for (int i = 1; i < id.length; i++) {
                    if (arrTemp[i] < arrTemp[i - 1]) {

                        int tmp1 = arrTemp[i];
                        arrTemp[i] = arrTemp[i - 1];
                        arrTemp[i - 1] = tmp1;

                        int tmp2 = id[i];     // переставляем id
                        id[i] = id[i - 1];
                        id[i - 1] = tmp2;
                        isSorted = false;   // если есть перестонавка сбрасиваем обратно в false
                    }
                }
            }

            for (Integer item: id) {    // выводим
                System.out.printf("%s %s %s %d %s\n",lastName.get(item), firstName.get(item),patrName.get(item),age.get(item),sex.get(item));
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
