package KI.Romaniuk.Lab6;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас Shed представляє хлів, який може містити об’єкти типу Animal або Tool.
 * Клас дозволяє додавати, видаляти та знаходити об'єкти за певними критеріями.
 *
 * @param <T> тип об’єктів, які зберігаються в Shed, повинен наслідувати StorableItem.
 */
public class Shed<T extends StorableItem> {
    private List<T> items;

    /**
     * Конструктор для створення порожнього хліва.
     */
    public Shed() {
        items = new ArrayList<>();
    }

    /**
     * Метод для додавання об’єкта до хліва.
     *
     * @param item об’єкт для додавання
     */
    public void addItem(T item) {
        items.add(item);
    }

    /**
     * Метод для видалення об’єкта з хліва.
     *
     * @param item об’єкт для видалення
     * @return true якщо об’єкт було видалено, інакше false
     */
    public boolean removeItem(T item) {
        return items.remove(item);
    }

    /**
     * Метод для пошуку об’єкта з максимальною непарною вагою.
     *
     * @return об’єкт з максимальною непарною вагою або null, якщо таких об’єктів немає
     */
    public T findMaxOddWeightItem() {
        T maxOddWeightItem = null;

        for (T item : items) {
            if ((int) item.getWeight() % 2 != 0) {
                if (maxOddWeightItem == null || item.getWeight() > maxOddWeightItem.getWeight()) {
                    maxOddWeightItem = item;
                }
            }
        }

        return maxOddWeightItem;
    }




    /**
     * Метод для отримання всіх об’єктів у хліві.
     *
     * @return список усіх об’єктів
     */
    public List<T> getItems() {
        return new ArrayList<>(items);
    }
}

// Інтерфейс StorableItem для об’єктів, які можна зберігати в Shed.
interface StorableItem {
    double getWeight();
}

// Клас Animal представляє тварину з вагою.
class Animal implements StorableItem {
    private String name;
    private double weight;

    public Animal(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }


    public String toString() {
        return "Animal{name='" + name + "', weight=" + weight + "}";
    }
}

// Клас Tool представляє інструмент з вагою.
class Tool implements StorableItem {
    private String type;
    private double weight;

    public Tool(String type, double weight) {
        this.type = type;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }


    public String toString() {
        return "Tool{type='" + type + "', weight=" + weight + "}";
    }
}


