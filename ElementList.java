import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ElementList {
    private List<Integer> elements;

    public ElementList(List<Integer> elements) {
        if (elements == null) {
            throw new IllegalArgumentException("Список не может быть null");
        }
        this.elements = new ArrayList<>(elements);
    }

    public List<Integer> getElements() {
        return elements;
    }

    public List<Integer> getUniqueElements(ElementList other) {
        HashSet<Integer> set1 = new HashSet<>(this.elements);
        HashSet<Integer> set2 = new HashSet<>(other.getElements());

        // Уникальные элементы из первого списка
        HashSet<Integer> uniqueElements = new HashSet<>(set1);
        uniqueElements.removeAll(set2);

        // Уникальные элементы из второго списка
        HashSet<Integer> uniqueFromOther = new HashSet<>(set2);
        uniqueFromOther.removeAll(set1);

        // Объединяем уникальные элементы
        uniqueElements.addAll(uniqueFromOther);

        return new ArrayList<>(uniqueElements);
    }

    @Override
    public String toString() {
        return "Элементы: " + elements;
    }
}
