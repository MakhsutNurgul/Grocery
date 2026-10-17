import java.util.Scanner;

public class GroceryCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GroceryLog log = new GroceryLog();

        log.loadFromFile();

        boolean running = true;

        while (running) {
            System.out.println("\n АЗЫҚ-ТҮЛІК СЕБЕТІ ");
            System.out.println("1. Барлық сатып алынған тауарлар");
            System.out.println("2. Жаңа тауар қосу");
            System.out.println("3. Күн бойынша іздеу");
            System.out.println("4. Тауар бойынша іздеу");
            System.out.println("5. Жалпы нәтиже");
            System.out.println("6. Деректерді файлға сақтау");
            System.out.println("0. Бағдарламадан шығу");
            System.out.print("Таңдауың: ");

            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Сан енгіз!");
                continue;
            }

            if (choice == 1) {
                log.printAll();

            } else if (choice == 2) {
                System.out.print("Сатып алған күн (КК.АА): ");
                String date = scanner.nextLine().trim();

                System.out.print("Тауар атауы: ");
                String product = scanner.nextLine().trim();

                int price;
                int weight;

                try {
                    System.out.print("Бағасы (тг): ");
                    price = Integer.parseInt(scanner.nextLine());

                    System.out.print("Салмағы (грамм): ");
                    weight = Integer.parseInt(scanner.nextLine());

                } catch (NumberFormatException e) {
                    System.out.println("Баға мен салмақты санмен енгіз!");
                    continue;
                }

                if (log.addRecord(date, product, price, weight)) {
                    log.saveToFile();
                    System.out.println("Тауар қосылды және сақталды.");
                }

            } else if (choice == 3) {
                System.out.print("Ізделетін күн (КК.АА): ");
                String date = scanner.nextLine().trim();

                log.findByDate(date);

            } else if (choice == 4) {
                System.out.print("Тауар атауы немесе атауының бөлігі: ");
                String product = scanner.nextLine();

                log.findByProduct(product);

            } else if (choice == 5) {
                System.out.println("\n ЖАЛПЫ НӘТИЖЕ ");
                System.out.println("Барлық тауар саны: " + log.getCount());
                System.out.println("Барлық сатып алулар сомасы: "
                        + log.getTotal() + " тг");
                System.out.println("Орташа баға: " + log.getAverage() + " тг");

                Grocery max = log.findMax();

                if (max != null) {
                    System.out.println("Ең қымбат тауар:");
                    max.printInfo();
                }

            } else if (choice == 6) {
                log.saveToFile();

            } else if (choice == 0) {
                log.saveToFile();
                running = false;
                System.out.println("Бағдарлама аяқталды.");

            } else {
                System.out.println("Қате таңдау!");
            }
        }

        scanner.close();
    }
}