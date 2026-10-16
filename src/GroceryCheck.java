
import java.util.Scanner;

public class GroceryCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        GroceryLog log1 = new GroceryLog();

        log1.addRecord("11.10", "Макси чай", 450, 500);
        log1.addRecord("11.10", "Макси чай", 450, 500);
        log1.addRecord("11.10", "Шоколад Казахстан", 900, 100);
        log1.addRecord("11.10", "Лейс чипсы", 825, 70);

        GroceryLog log2 = new GroceryLog();

        log2.addRecord("13.10", "Фюсти", 550, 500);
        log2.addRecord("13.10", "Шоколад Казахстан", 900, 100);

        boolean running = true;

        while (running) {
            System.out.println("\n АЗЫҚ-ТҮЛІК СЕБЕТІ");
            System.out.println("1. Бірінші чекті көрсету");
            System.out.println("2. Екінші чекті көрсету");
            System.out.println("3. Күн бойынша іздеу");
            System.out.println("4. Тауар бойынша іздеу");
            System.out.println("5. Екі чектің жалпы нәтижесі");
            System.out.println("0. Бағдарламадан шығу");
            System.out.print("Таңдауың: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("\n 1-ЧЕК: 11.10 ");
                log1.findByDate("11.10");
                System.out.println("Тауар саны: " + log1.getCount());
                System.out.println("Жалпы сома: " + log1.getTotal() + " тг");
                System.out.println("Орташа баға: " + log1.getAverage() + " тг");

                if (log1.findMax() != null) {
                    System.out.println("Ең қымбат тауар:");
                    log1.findMax().printInfo();
                }

            } else if (choice == 2) {
                System.out.println("\n2-ЧЕК: 13.10 ");
                log2.findByDate("13.10");
                System.out.println("Тауар саны: " + log2.getCount());
                System.out.println("Жалпы сома: " + log2.getTotal() + " тг");
                System.out.println("Орташа баға: " + log2.getAverage() + " тг");

                if (log2.findMax() != null) {
                    System.out.println("Ең қымбат тауар:");
                    log2.findMax().printInfo();
                }

            } else if (choice == 3) {
                System.out.print("Күнді енгіз (КК.АА): ");
                String date = scanner.nextLine();

                System.out.println("\n ІЗДЕУ НӘТИЖЕСІ ");
                System.out.println("1-чектен:");
                log1.findByDate(date);

                System.out.println("2-чектен:");
                log2.findByDate(date);

            } else if (choice == 4) {
                System.out.print("Тауар атауын енгіз: ");
                String product = scanner.nextLine();

                System.out.println("\n ІЗДЕУ НӘТИЖЕСІ ");
                System.out.println("1-чектен:");
                log1.findByProduct(product);

                System.out.println("2-чектен:");
                log2.findByProduct(product);

            } else if (choice == 5) {
                int totalProducts = log1.getCount() + log2.getCount();
                int totalMoney = log1.getTotal() + log2.getTotal();

                System.out.println("\n ЖАЛПЫ НӘТИЖЕ ");
                System.out.println("Барлық тауар саны: " + totalProducts);
                System.out.println("Бірінші чек: " + log1.getTotal() + " тг");
                System.out.println("Екінші чек: " + log2.getTotal() + " тг");
                System.out.println("Екі чектің жалпы сомасы: "
                        + totalMoney + " тг");

            } else if (choice == 0) {
                running = false;
                System.out.println("Бағдарлама аяқталды.");

            } else {
                System.out.println("Қате таңдау! Қайта енгіз.");
            }
        }

        scanner.close();
    }
}
