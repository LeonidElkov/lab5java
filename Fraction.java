public class Fraction {
    private int numerator; // Числитель
    private int denominator; // Знаменатель

    // Конструктор
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify(); // Упрощаем дробь при создании
    }

    // Метод для упрощения дроби
    private void simplify() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    // Метод для нахождения наибольшего общего делителя (НОД)
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // Геттеры
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    // Сеттеры
    public void setNumerator(int numerator) {
        this.numerator = numerator;
        simplify(); // Упрощаем дробь после изменения
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю.");
        }
        this.denominator = denominator;
        simplify(); // Упрощаем дробь после изменения
    }

    // Метод для отображения дроби
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    // Пример использования
    public static void main(String[] args) {
        try {
            Fraction fraction1 = new Fraction(3, 4);
            Fraction fraction2 = new Fraction(2, 5);

            System.out.println("Первая дробь: " + fraction1);
            System.out.println("Вторая дробь: " + fraction2);

            // Пример арифметических операций
            Fraction sum = fraction1.add(fraction2);
            System.out.println("Сумма дробей: " + sum);

            Fraction difference = fraction1.subtract(fraction2);
            System.out.println("Разность дробей: " + difference);

            Fraction product = fraction1.multiply(fraction2);
            System.out.println("Произведение дробей: " + product);

            Fraction quotient = fraction1.divide(fraction2);
            System.out.println("Частное дробей: " + quotient);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    // Метод для сложения дробей
    public Fraction add(Fraction other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    // Метод для вычитания дробей
    public Fraction subtract(Fraction other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    // Метод для умножения дробей
    public Fraction multiply(Fraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    // Метод для деления дробей
    public Fraction divide(Fraction other) {
        if (other.numerator == 0) {
            throw new IllegalArgumentException("Деление на ноль недопустимо.");
        }
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new Fraction(newNumerator, newDenominator);
    }
}
