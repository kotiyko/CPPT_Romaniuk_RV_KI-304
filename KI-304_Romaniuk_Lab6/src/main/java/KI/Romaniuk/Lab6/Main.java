package KI.Romaniuk.Lab6;

class Driver {
    public static void main(String[] args) {
        // Створюємо екземпляр Shed для зберігання тварин
        Shed<Animal> animalShed = new Shed<>();
        animalShed.addItem(new Animal("Cow", 500));
        animalShed.addItem(new Animal("Sheep", 71));  // Оновлена вага
        animalShed.addItem(new Animal("Pig", 151));   // Оновлена вага
        animalShed.addItem(new Animal("Pi", 151));
        animalShed.addItem(new Animal("P", 151));
        System.out.println("тварини в хліві:");
        animalShed.getItems().forEach(System.out::println);

        System.out.println("Найважча тварина з непарною вагою:");
        System.out.println(animalShed.findMaxOddWeightItem());


        // Створюємо екземпляр Shed для зберігання інструментів
        Shed<Tool> toolShed = new Shed<>();
        toolShed.addItem(new Tool("Shovel", 5));
        toolShed.addItem(new Tool("Hammer", 1.5));
        toolShed.addItem(new Tool("Saw", 2.3));

        System.out.println("\nІнструменти в хліві:");
        toolShed.getItems().forEach(System.out::println);

        System.out.println("Найважчий інструмент з непарною вагою:");
        System.out.println(toolShed.findMaxOddWeightItem());


    }
}