import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NumberOperationsPerformance {

    public static void main(String[] args) throws IOException {
        int[] fileSizes = {100, 1000, 10000, 100000, 1000000};
        File resultsFile = new File("performance-results.csv");
        FileWriter writer = new FileWriter(resultsFile);

        writer.write("File Size,Time (ms)\n");
        for (int fileSize : fileSizes) {
            List<Integer> numbers = generateNumbers(fileSize);
            writeNumbersToFile("numbers.txt", numbers);

            long startTime = System.nanoTime();
            NumberOperations._sum(numbers);
            long endTime = System.nanoTime();
            long timeMs = (endTime - startTime) / 1000000;

            writer.write(fileSize + "," + timeMs + "\n");
        }

        writer.close();

    }

    private static List<Integer> generateNumbers(int count) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            numbers.add((int) (Math.random() * 100));
        }
        return numbers;
    }

    private static void writeNumbersToFile(String filename, List<Integer> numbers) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            for (int i = 0; i < numbers.size(); i++) {
                writer.write(numbers.get(i) + " ");
            }
        }
    }
}