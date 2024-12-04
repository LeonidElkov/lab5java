import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PersonProcessor {

    // Метод для чтения и вывода содержимого файла
    public void printFileContent(String fileName3) {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName3))) { // Чтение построчно
            String line;
            System.out.println("Содержимое файла:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<Integer, List<String>> processFile(String fileName3) {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName3))) {
            return br.lines()
                    .map(line -> line.split(":"))
                    .filter(parts -> parts.length == 2 && !parts[1].trim().isEmpty())
                    .map(parts -> new Person(parts[0].trim(), Integer.parseInt(parts[1].trim())))
                    .filter(person -> person.getNumber() != null)
                    .collect(Collectors.groupingBy(
                            Person::getNumber,
                            Collectors.mapping(person -> capitalizeFirstLetter(person.getName().toLowerCase()), Collectors.toList())
                    ));
        } catch (IOException e) {
            e.printStackTrace();
            return Map.of(); // Возвращаем пустую карту в случае ошибки
        }
    }

    private String capitalizeFirstLetter(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }
}
