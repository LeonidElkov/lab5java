public class Fraction implements FractionInterface {
    private int numerator;   // Числитель
    private int denominator; // Знаменатель
    private Double cachedValue; // Кэшированное вещественное значение

    // Конструктор
    public Fraction(int numerator, int denominator) {
        if (denominator <= 0) {
            throw new IllegalArgumentException("Знаменатель не может быть отрицательным или равным нулю.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        this.cachedValue = null; // Изначально кэш пустой
    }

    // Метод вычисляет вещественное значение дроби (кеширование позволяет избежать повторного выполнения)
    @Override
    public double toDouble() {
        if (cachedValue == null) {
            cachedValue = (double) numerator / denominator; // Кэшируем значение
        }
        return cachedValue;
    }

    // Установка числителя
    @Override
    public void setNumerator(int numerator) {
        this.numerator = numerator;
        cachedValue = null; // Сбрасываем кэш
    }

    // Установка знаменателя
    @Override
    public void setDenominator(int denominator) {
        if (denominator <= 0) {
            throw new IllegalArgumentException("Знаменатель не может быть отрицательным или равным нулю.");
        }
        this.denominator = denominator;
        cachedValue = null; // Сбрасываем кэш
    }

    // Метод для строкового представления
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    // Переопределение метода equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Сравнение с самим собой
        if (!(obj instanceof Fraction other)) return false; // Если не Fraction, вернуть false
        return this.numerator == other.numerator && this.denominator == other.denominator;
    }

    // Переопределение метода hashCode
    @Override
    public int hashCode() {
        int result = Integer.hashCode(numerator);
        result = 31 * result + Integer.hashCode(denominator);
        return result;
    }
}
