public class MeowCounter {
    private final Cat cat;              // Ссылка на кота
    private int meowCount;        // Счетчик мяуканий

    // Конструктор
    public MeowCounter(Cat cat) {
        this.cat = cat;
        this.meowCount = 0; // Изначально кот не мяукал
    }

    // Метод для вызова мяуканья кота и увеличения счетчика
    public void meow() {
        cat.meow();              // Вызываем мяуканье кота
        meowCount++;             // Увеличиваем счетчик
    }

    // Метод для получения количества мяуканий
    public int getMeowCount() {
        return meowCount;
    }

    // Геттер для доступа к коту
    public Cat getCat() {
        return cat;
    }
}
