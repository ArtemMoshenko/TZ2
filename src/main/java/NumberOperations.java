import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NumberOperations {

    public static void main(String[] args) {
        String filename = "numbers.txt"; // Имя файла с числами

        try {
            List<Integer> numbers = readNumbersFromFile(filename);

            int min = _min(numbers);
            int max = _max(numbers);
            int sum = _sum(numbers);
            int mult = _mult(numbers);

            System.out.println("Минимальное: " + min);
            System.out.println("Максимальное: " + max);
            System.out.println("Сумма: " + sum);
            System.out.println("Произведение: " + mult);

        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    public static List<Integer> readNumbersFromFile(String filename) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            String[] parts = line.split(" ");
            for (String part : parts) {
                numbers.add(Integer.parseInt(part));
            }
        }
        return numbers;
    }

    public static int _min(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("Список чисел не может быть пустым");
        }
        int min = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) < min) {
                min = numbers.get(i);
            }
        }
        return min;
    }

    public static int _max(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("Список чисел не может быть пустым");
        }
        int max = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) > max) {
                max = numbers.get(i);
            }
        }
        return max;
    }

    public static int _sum(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("Список чисел не может быть пустым");
        }
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    public static int _mult(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("Список чисел не может быть пустым");
        }
        int mult = 1;
        for (int number : numbers) {
            mult *= number;
        }
        return mult;
    }
}