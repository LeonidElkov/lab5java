public class Cat implements Meowable {
    private final String name; // Имя кота

    // Конструктор
    public Cat(String name) {
        this.name = name;
    }

    // Метод для получения текстового представления кота
    @Override
    public String toString() {
        return name;
    }

    // Реализация метода meow
    @Override
    public void meow() {
        System.out.println(name + ": мяу!");
    }
}
