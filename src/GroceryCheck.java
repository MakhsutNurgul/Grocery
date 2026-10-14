
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


        System.out.println("\n=== Қате мәліметтерді тексеру ===");

        item.setPrice(-100);
        System.out.println("Қате баға енгізілгеннен кейінгі баға: "
                + item.getPrice());

        item.setWeightGrams(0);
        System.out.println("Қате салмақ енгізілгеннен кейінгі салмақ: "
                + item.getWeightGrams());


        System.out.println("\n=== Бағаны килограммен тексеру ===");

        item.setProduct("Ірімшік");
        item.setPrice(1500);
        item.setWeightGrams(500);

        System.out.println("Тауар: " + item.getProduct());
        System.out.println("Баға: " + item.getPrice() + " тг");
        System.out.println("Салмақ: " + item.getWeightGrams() + " г");
        System.out.println("1 кг бағасы 2000 теңгеден жоғары ма? "
                + item.isExpensivePerKg());


    }
}
