public class CachedFraction implements FractionOperations {
    private Fraction fraction; // Экземпляр класса Fraction
    private Double cachedValue; // Кэшированное значение

    // Конструктор
    public CachedFraction(int numerator, int denominator) {
        this.fraction = new Fraction(numerator, denominator);
        this.cachedValue = null; // Изначально кэш не инициализирован
    }

    // Метод для получения вещественного значения
    @Override
    public double getValue() {
        if (cachedValue == null) {
            // Вычисляем вещественное значение и кэшируем его
            cachedValue = (double) fraction.getNumerator() / fraction.getDenominator();
        }
        return cachedValue;
    }

    // Метод для установки числителя
    @Override
    public void setNumerator(int numerator) {
        fraction = new Fraction(numerator, fraction.getDenominator());
        cachedValue = null; // Сбрасываем кэш
    }

    // Метод для установки знаменателя
    @Override
    public void setDenominator(int denominator) {
        fraction = new Fraction(fraction.getNumerator(), denominator);
        cachedValue = null; // Сбрасываем кэш
    }

    // Метод для отображения дроби
    public String toString() {
        return fraction.toString();
    }
}
