import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class NumberOperationsTest {

    @Test
    void testMin() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 4, 2, 3));
        assertEquals(1, NumberOperations._min(numbers));
    }

    @Test
    void testMax() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 4, 2, 3));
        assertEquals(4, NumberOperations._max(numbers));
    }

    @Test
    void testSum() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 4, 2, 3));
        assertEquals(10, NumberOperations._sum(numbers));
    }

    @Test
    void testMult() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 4, 2, 3));
        assertEquals(24, NumberOperations._mult(numbers));
    }

    @Test
    void testEmptyList() {
        List<Integer> numbers = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> NumberOperations._min(numbers));
        assertThrows(IllegalArgumentException.class, () -> NumberOperations._max(numbers));
        assertThrows(IllegalArgumentException.class, () -> NumberOperations._sum(numbers));
        assertThrows(IllegalArgumentException.class, () -> NumberOperations._mult(numbers));
    }

    // Тесты скорости
    @Test
    void testPerformance() throws IOException {
        long startTime, endTime;
        List<Integer> numbers;
        int[] fileSizes = {100, 1000, 10000, 100000, 1000000}; // Размеры файлов для тестирования

        for (int fileSize : fileSizes) {
            numbers = generateNumbers(fileSize);
            writeNumbersToFile("numbers.txt", numbers);

            startTime = System.nanoTime();
            NumberOperations._min(numbers);
            endTime = System.nanoTime();
            System.out.println("Время выполнения _min для " + fileSize + " чисел: " + (endTime - startTime) / 1000000 + " мс");

            startTime = System.nanoTime();
            NumberOperations._max(numbers);
            endTime = System.nanoTime();
            System.out.println("Время выполнения _max для " + fileSize + " чисел: " + (endTime - startTime) / 1000000 + " мс");

            startTime = System.nanoTime();
            NumberOperations._sum(numbers);
            endTime = System.nanoTime();
            System.out.println("Время выполнения _sum для " + fileSize + " чисел: " + (endTime - startTime) / 1000000 + " мс");

            startTime = System.nanoTime();
            NumberOperations._mult(numbers);
            endTime = System.nanoTime();
            System.out.println("Время выполнения _mult для " + fileSize + " чисел: " + (endTime - startTime) / 1000000 + " мс");
        }
    }

    // Дополнительный тест (проверка работы с отрицательными числами)
    @Test
    void testNegativeNumbers() {
        List<Integer> numbers = new ArrayList<>(List.of(-10, -5, -1, -3));
        assertEquals(-10, NumberOperations._min(numbers));
        assertEquals(-1, NumberOperations._max(numbers));
        assertEquals(-19, NumberOperations._sum(numbers));
        assertEquals(150, NumberOperations._mult(numbers));
    }

    private List<Integer> generateNumbers(int count) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            numbers.add((int) (Math.random() * 100)); // Генерация случайных чисел от 0 до 99
        }
        return numbers;
    }

    private void writeNumbersToFile(String filename, List<Integer> numbers) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            for (int i = 0; i < numbers.size(); i++) {
                writer.write(numbers.get(i) + " ");
            }
        }
    }
}