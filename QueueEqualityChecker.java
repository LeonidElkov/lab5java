import java.util.LinkedList;
import java.util.Queue;

// Класс для проверки равенства элементов в очереди
public class QueueEqualityChecker<T> {
    private Queue<T> queue;
    private int startIndex;
    private int endIndex;

    // Конструктор, инициализирующий очередь и индексы
    public QueueEqualityChecker(Queue<T> queue, int startIndex, int endIndex) {
        this.queue = queue; // Инициализация очереди
        setIndices(startIndex, endIndex); // Установка индексов
    }

    // Установка индексов
    public void setIndices(int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex >= queue.size() || startIndex >= endIndex) {
            throw new IllegalArgumentException("Неверные индексы: " + startIndex + ", " + endIndex);
        }
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    // Проверка равенства элементов в заданном диапазоне индексов
    public boolean checkEquality() {
        Queue<T> tempQueue = new LinkedList<>(queue); // Временная очередь
        T firstElement = null; // Первый элемент для сравнения

        for (int index = 0; index <= endIndex; index++) {
            T currentElement = tempQueue.poll(); // Извлечение элемента
            if (index == startIndex) {
                firstElement = currentElement; // Сохранение первого элемента
            } else if (index >= startIndex && index <= endIndex) {
                if (!currentElement.equals(firstElement)) {
                    return false; // Элементы не равны
                }
            }
        }
        return true; // Все элементы равны
    }

    @Override
    public String toString() {
        return "Очередь: " + queue.toString() + ", Индексы: [" + startIndex + ", " + endIndex + "]";
    }
}
