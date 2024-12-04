import java.util.LinkedList;
import java.util.Queue;

public class QueueEqualityChecker {
    private Queue<Integer> queue;
    private int startIndex;
    private int endIndex;

    public QueueEqualityChecker(Queue<Integer> queue, int startIndex, int endIndex) {
        this.queue = queue;
        setIndices(startIndex, endIndex);
    }

    public void setIndices(int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex >= queue.size() || startIndex >= endIndex) {
            throw new IllegalArgumentException("Неверные индексы: " + startIndex + ", " + endIndex);
        }
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public boolean checkEquality() {
        Queue<Integer> tempQueue = new LinkedList<>(queue);
        Integer firstElement = null;

        for (int index = 0; index <= endIndex; index++) {
            Integer currentElement = tempQueue.poll();
            if (index == startIndex) {
                firstElement = currentElement;
            } else if (index >= startIndex && index <= endIndex) {
                if (!currentElement.equals(firstElement)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Очередь: " + queue.toString() + ", Индексы: [" + startIndex + ", " + endIndex + "]";
    }
}
