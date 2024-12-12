import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите действие:");
        System.out.println("1 - Дроби");
        System.out.println("2 - Коты");
        System.out.println("3 - Ввод уникальных элементов из двух списков");
        System.out.println("4 - Средний балл");
        System.out.println("5 - Какие цифры встречаются в тексте?");
        System.out.println("6 - Проверка равенства участка очереди");
        System.out.println("7 - Стрим ");
        System.out.println("8 - Номер ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 0:
                System.out.println("Программа завершена.");
                return;

            case 1:
                System.out.println("Введите первую дробь: (числитель и знаменатель)");
                while (!scanner.hasNextInt()) { // Проверка на ввод числа
                    System.out.print("Ошибка! Введите целое число: ");
                    scanner.next(); // Очистка ввода
                }
                int c = scanner.nextInt();
                while (!scanner.hasNextInt()) { // Проверка на ввод числа
                    System.out.print("Ошибка! Введите целое число: ");
                    scanner.next(); // Очистка ввода
                }
                int d1 = scanner.nextInt();

                // Создаем экземпляр CachedFraction
                CachedFraction fraction1 = new CachedFraction(c, d1);
                System.out.println("Полученная дробь: " + fraction1);
                System.out.println("Десятичный вид дроби: " + fraction1.getValue());

                // Изменяем дробь
                System.out.print("Введите новый числитель: ");
                while (!scanner.hasNextInt()) { // Проверка на ввод числа
                    System.out.print("Ошибка! Введите целое число: ");
                    scanner.next(); // Очистка ввода
                }
                int c1 = scanner.nextInt();
                fraction1.setNumerator(c1); // Меняем числитель дроби
                System.out.println("Новая дробь: " + fraction1);
                System.out.println("Десятичный вид дроби: " + fraction1.getValue());

                System.out.print("Введите новый знаменатель: ");
                while (!scanner.hasNextInt()) { // Проверка на ввод числа
                    System.out.print("Ошибка! Введите целое число: ");
                    scanner.next(); // Очистка ввода
                }
                int d2 = scanner.nextInt();
                fraction1.setDenominator(d2); // Меняем знаменатель
                System.out.println("Новая дробь: " + fraction1);
                System.out.println("Десятичный вид дроби: " + fraction1.getValue());
                break;


            case 2:
                List<MeowCounter> counters = new ArrayList<>(); // Список счетчиков котов
                System.out.print("Введите количество котов/кошек: ");
                while (!scanner.hasNextInt()) { // Проверка на ввод числа
                    System.out.print("Ошибка! Введите целое число: ");
                    scanner.next(); // Очистка ввода
                }
                int numberOfCats = scanner.nextInt();
                scanner.nextLine(); // Очистка буфера после ввода числа

                for (int i = 0; i < numberOfCats; i++) {
                    System.out.print("Введите имя кота/кошки " + (i + 1) + ": ");
                    String name = scanner.nextLine();
                    counters.add(new MeowCounter(new Cat(name))); // Создаем кота и добавляем в список счетчиков
                }

                // Вывод строкового представления всех котов
                System.out.println("Список животных: ");
                for (int i = 0; i < counters.size(); i++) {
                    System.out.println(i + 1 + ". " + counters.get(i).getCat().toString()); // Выводим строковое представление кота с индексом
                }

                // Цикл для мяуканья
                while (true) {
                    System.out.print("Выберите кота или кошку для поглаживания (введите номер животного).\nВведите 0, чтобы погладить всех\nВведите -1, чтобы закончить.");
                    while (!scanner.hasNextInt()) { // Проверка на ввод числа
                        System.out.print("Ошибка! Введите целое число: ");
                        scanner.next(); // Очистка ввода
                    }
                    int choice2 = scanner.nextInt();

                    if (choice2 == 0) {
                        // Гладим всех котов/кошек
                        System.out.println("Все животные: ");
                        for (MeowCounter counter : counters) {
                            counter.meow(); // Вызываем мяуканье для каждого кота
                        }
                    } else if (choice2 == -1) {
                        break;
                    } else if (choice2 > 0 && choice2 <= counters.size()) {
                        // Гладим выбранного кота
                        counters.get(choice2 - 1).meow(); // Вызываем мяуканье для выбранного кота
                    } else {
                        System.out.println("Выбран неверный номер животного.");
                    }
                }

                // Вывод количества мяуканий для каждого кота
                System.out.println("\nКоличество мяуканий для каждого животного:");
                for (MeowCounter counter : counters) {
                    System.out.println(counter.getCat().toString() + " мяукнул(а) " + counter.getMeowCount() + " раз(а).");
                }
                System.out.println(); // Оставляем пустую строку для красоты
                break;

            case 3: {
                List<Integer> list1 = new ArrayList<>();
                List<Integer> list2 = new ArrayList<>();

                // Ввод элементов для первого списка
                System.out.println("Введите элементы для первого списка (введите 'end' для завершения):");
                while (true) {
                    String input = scanner.nextLine();
                    if (input.equalsIgnoreCase("end")) {
                        break;
                    }
                    try {
                        int number = Integer.parseInt(input);
                        list1.add(number);
                    } catch (NumberFormatException e) {
                        System.out.println("Пожалуйста, введите целое число или 'end' для завершения.");
                    }
                }

                // Ввод элементов для второго списка
                System.out.println("Введите элементы для второго списка (введите 'end' для завершения):");
                while (true) {
                    String input = scanner.nextLine();
                    if (input.equalsIgnoreCase("end")) {
                        break;
                    }
                    try {
                        int number = Integer.parseInt(input);
                        list2.add(number);
                    } catch (NumberFormatException e) {
                        System.out.println("Пожалуйста, введите целое число или 'end' для завершения.");
                    }
                }

                // Формирование списка L с уникальными элементами
                HashSet<Integer> set1 = new HashSet<>(list1);
                HashSet<Integer> set2 = new HashSet<>(list2);
                List<Integer> uniqueElements = new ArrayList<>();

                // Уникальные элементы из первого списка
                for (Integer element : set1) {
                    if (!set2.contains(element)) {
                        uniqueElements.add(element);
                    }
                }

                // Уникальные элементы из второго списка
                for (Integer element : set2) {
                    if (!set1.contains(element)) {
                        uniqueElements.add(element);
                    }
                }

                // Вывод результата
                System.out.println("Список уникальных элементов: " + uniqueElements);
                break; // Выход из блока case
            }
            case 4:
                String fileName = "students.txt"; // Имя файла с данными
                List<Student> students = new ArrayList<>();

                // Чтение данных из файла
                try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                    int N = Integer.parseInt(br.readLine().trim()); // Число учеников

                    for (int i = 0; i < N; i++) {
                        String line = br.readLine().trim();
                        String[] parts = line.split(" ");

                        // Проверка входных данных
                        if (parts.length != 4) {
                            System.out.println("Некорректные данные: " + line);
                            continue;
                        }

                        String surname = parts[0];
                        String name = parts[1];
                        int schoolNumber;
                        int score;

                        try {
                            schoolNumber = Integer.parseInt(parts[2]);
                            score = Integer.parseInt(parts[3]);
                        } catch (NumberFormatException e) {
                            System.out.println("Некорректные данные: " + line);
                            continue;
                        }

                        students.add(new Student(surname, name, schoolNumber, score));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }

                // Создание объекта района и получение школ с выше среднего баллом
                District district = new District(students);
                HashMap<Integer, School> schoolsAboveAverage = district.getSchoolsAboveAverage();

                // Вывод результатов
                if (schoolsAboveAverage.isEmpty()) {
                    System.out.println("Нет школ с баллом выше среднего.");
                } else {
                    for (School school : schoolsAboveAverage.values()) {
                        System.out.println(school);
                    }
                    break;
                }
            case 5:
                // Укажите имя файла, из которого нужно извлечь цифры
                String fileName2 = "text.txt"; // Замените на ваше имя файла
                DigitExtractor digitExtractor = new DigitExtractor(fileName2);

                // Извлечение уникальных цифр
                HashSet<Character> digits = digitExtractor.extractDigits();

                // Вывод уникальных цифр
                if (digits.isEmpty()) {
                    System.out.println("Цифры не найдены в тексте.");
                } else {
                    System.out.print("Найденные цифры: ");
                    for (char digit : digits) {
                        System.out.print(digit + " ");
                    }
                    System.out.println();
                }
                break;
            case 6:
                // Создаем очередь и добавляем элементы
                Queue<Integer> queue = new LinkedList<>();
                System.out.println("Введите элементы очереди (введите 'end' для завершения):");

                while (true) {
                    String input = scanner.nextLine();
                    if (input.equalsIgnoreCase("end")) {
                        break;
                    }
                    try {
                        int number = Integer.parseInt(input);
                        queue.add(number);
                    } catch (NumberFormatException e) {
                        System.out.println("Пожалуйста, введите корректное целое число.");
                    }
                }

                // Запрашиваем индексы у пользователя
                int startIndex = -1;
                int endIndex = -1;

                while (true) {
                    System.out.print("Введите начальный индекс (i): ");
                    startIndex = scanner.nextInt();
                    System.out.print("Введите конечный индекс (j): ");
                    endIndex = scanner.nextInt();

                    try {
                        QueueEqualityChecker checker = new QueueEqualityChecker(queue, startIndex, endIndex);
                        boolean areEqual = checker.checkEquality();
                        System.out.println(checker);
                        System.out.println("Элементы с " + startIndex + " по " + endIndex + " равны: " + areEqual);
                        break; // Выходим из цикла после успешной проверки
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                break;

            case 7:
                List<Point> points = new ArrayList<>(); // Создаём пустой список точек
                System.out.print("Введите количество точек для ввода: ");
                while (!scanner.hasNextInt()) { // Проверка на ввод числа
                    System.out.print("Ошибка! Введите целое число: ");
                    scanner.next();
                }
                int kt = scanner.nextInt();
                scanner.nextLine();

                for (int i = 0; i < kt; i++) { // Ввод точек
                    System.out.print("Введите координаты точки " + (i + 1) + " в формате 'X Y': ");
                    String input = scanner.nextLine();
                    String[] coordinates = input.trim().split("\\s+"); // Удаляем лишние пробелы и разбиваем по пробелам

                    if (coordinates.length != 2) {
                        System.out.println("Неверный формат. Пожалуйста, введите координаты в формате 'X Y'.");
                        i--; // Уменьшаем счётчик, чтобы повторно запросить ввод для этой точки
                        continue;
                    }

                    try { // Проверка точек
                        double x = Double.parseDouble(coordinates[0]);
                        double y = Double.parseDouble(coordinates[1]);
                        points.add(new Point(x, y));
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка ввода. Пожалуйста, введите числовые координаты.");
                        i--;
                    }
                }

                // Обработка точек
                Polyline polyline = new Polyline(points.stream()
                        .distinct() // Убираем дубликаты
                        .map(point -> new Point(point.getX(), Math.abs(point.getY()))) // Делаем Y положительными
                        .sorted(Comparator.comparingDouble(Point::getX)) // Сортируем по X
                        .collect(Collectors.toList())); // Собираем в список
                System.out.println(polyline);
                break;
            case 8:
                PersonProcessor processor = new PersonProcessor();
                String FileName3 = "text72.txt";

                // Выводим содержимое файла
                processor.printFileContent(FileName3);

                // Обрабатываем файл
                Map<Integer, List<String>> groupedPeople = processor.processFile(FileName3);
                System.out.println(); // Оставляем пустую строку для красоты
                System.out.println("Полученный результат группировки: ");
                System.out.println(groupedPeople);


                System.out.println(); // Оставляем пустую строку для красоты
                break;
        }
        }
    }

