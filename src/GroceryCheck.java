
public class GroceryCheck {
    public static void main(String[] args) {
        Grocery item = new Grocery();

        item.setDate("14.10");
        item.setProduct("Нан");
        item.setPrice(250);
        item.setWeightGrams(500);

        System.out.println("=== Азық-түлік тексеру нәтижесі ===");
        item.printInfo();

        System.out.println("Тауар атауы: " + item.getProduct());
        System.out.println("Бағасы: " + item.getPrice() + " тг");
        System.out.println("Салмағы: " + item.getWeightGrams() + " г");
        System.out.println("Қымбат тауар ма? " + item.isExpensivePerKg());
    }
}
