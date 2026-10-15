
public class GroceryCheck {
    public static void main(String[] args) {

        // ===== 1-ЧЕК =====
        GroceryLog log1 = new GroceryLog();

        System.out.println("========== 1-ЧЕК ==========");

        log1.addRecord("11.10", "Макси чай", 450, 500);
        log1.addRecord("11.10", "Макси чай", 450, 500);
        log1.addRecord("11.10", "Шоколад Казахстан", 900, 100);
        log1.addRecord("11.10", "Лейс чипсы", 825, 70);

        System.out.println("1-чектегі тауарлар:");
        System.out.println("Тауар саны: " + log1.getCount());
        System.out.println("Жалпы сома: " + log1.getTotal() + " тг");
        System.out.println("Орташа баға: " + log1.getAverage() + " тг");

        if (log1.findMax() != null) {
            System.out.println("Ең қымбат тауар:");
            log1.findMax().printInfo();
        }

        // ===== 2-ЧЕК =====
        GroceryLog log2 = new GroceryLog();

        System.out.println("\n========== 2-ЧЕК ==========");

        log2.addRecord("13.10", "Фюсти", 550, 500);
        log2.addRecord("13.10", "Шоколад Казахстан", 900, 100);


        System.out.println("2-чектегі тауарлар:");
        System.out.println("Тауар саны: " + log2.getCount());
        System.out.println("Жалпы сома: " + log2.getTotal() + " тг");
        System.out.println("Орташа баға: " + log2.getAverage() + " тг");

        if (log2.findMax() != null) {
            System.out.println("Ең қымбат тауар:");
            log2.findMax().printInfo();
        }

        // ===== ЕКІ ЧЕКТІҢ ЖАЛПЫ НӘТИЖЕСІ =====
        System.out.println("\n========== ЖАЛПЫ НӘТИЖЕ ==========");

        int totalProducts = log1.getCount() + log2.getCount();
        int totalMoney = log1.getTotal() + log2.getTotal();

        System.out.println("Барлық тауар саны: " + totalProducts);
        System.out.println("Екі чектің жалпы сомасы: " + totalMoney + " тг");
    }
}
