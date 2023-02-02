import java.util.Arrays;

/**
 * Сортировка массива
 */
public class S4_sort {
    public static void main(String[] args) {

        int[] id = new int[] {28, 18, 22, 35, 38, 23}; // массив

        System.out.println(Arrays.toString(id));

        // сортировка пузырком

        boolean isSorted = false;     // переменая для ослеживание проходов
        while (!isSorted) {            // пока массив не отсортирован
            isSorted = true;
            for (int i = 1; i < id.length; i++) {
                if (id[i] < id[i - 1]) {
                    int tmp1 = id[i];
                    id[i] = id[i - 1];
                    id[i - 1] = tmp1;
                    isSorted = false;   // если есть перестонавка сбрасиваем обратно в false
                }
            }
        }
        System.out.println(Arrays.toString(id));
    }
}
