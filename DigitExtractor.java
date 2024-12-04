import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class DigitExtractor {
    private String fileName2;

    public DigitExtractor(String fileName2) {
        this.fileName2 = fileName2;
    }

    public HashSet<Character> extractDigits() {
        HashSet<Character> digits = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName2))) {
            String line;
            while ((line = br.readLine()) != null) {
                for (char ch : line.toCharArray()) {
                    if (Character.isDigit(ch)) {
                        digits.add(ch);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return digits;
    }
}
