//Implement a simple file I/O operation to read data from a text file.
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadData {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("sample.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
