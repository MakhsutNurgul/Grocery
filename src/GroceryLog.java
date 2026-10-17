import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class GroceryLog {
    private Grocery[] items = new Grocery[300];
    private int count = 0;

    public int getCount() {
        return count;
    }

    public boolean addRecord(String date, String product,
                             int price, int weightGrams) {
        if (count >= items.length) {
            System.out.println("Тізім толып кетті!");
            return false;
        }

        if (date == null || !date.matches("\\d{2}\\.\\d{2}")
                || product == null || product.trim().isEmpty()
                || price < 1 || price > 100000
                || weightGrams < 1 || weightGrams > 20000) {
            System.out.println("Қате мәлімет енгізілді!");
            return false;
        }

        Grocery item = new Grocery();
        item.setDate(date);
        item.setProduct(product.trim());
        item.setPrice(price);
        item.setWeightGrams(weightGrams);

        items[count] = item;
        count++;

        return true;
    }

    public void printAll() {
        if (count == 0) {
            System.out.println("Әзірге сатып алу жазбалары жоқ.");
            return;
        }

        System.out.println("\n АЗЫҚ-ТҮЛІКТЕРДІҢ ЖАЛПЫ ТІЗІМІ ");

        int i = 0;
        while (i < count) {
            items[i].printInfo();
            i++;
        }

        System.out.println("Тауар саны: " + count);
        System.out.println("Жалпы сома: " + getTotal() + " тг");
    }

    public int getTotal() {
        int total = 0;
        int i = 0;

        while (i < count) {
            total += items[i].getPrice();
            i++;
        }

        return total;
    }

    public int getAverage() {
        if (count == 0) {
            return 0;
        }

        return getTotal() / count;
    }

    public Grocery findMax() {
        if (count == 0) {
            return null;
        }

        Grocery max = items[0];
        int i = 1;

        while (i < count) {
            if (items[i].getPrice() > max.getPrice()) {
                max = items[i];
            }
            i++;
        }

        return max;
    }

    public void findByDate(String date) {
        boolean found = false;
        int i = 0;
        int total = 0;

        while (i < count) {
            if (items[i].getDate().equals(date)) {
                items[i].printInfo();
                total += items[i].getPrice();
                found = true;
            }
            i++;
        }

        if (found) {
            System.out.println("Осы күнгі сатып алулар сомасы: "
                    + total + " тг");
        } else {
            System.out.println("Бұл күнге жазба табылмады.");
        }
    }

    public void findByProduct(String product) {
        boolean found = false;
        int i = 0;

        while (i < count) {
            if (items[i].getProduct()
                    .toLowerCase()
                    .contains(product.trim().toLowerCase())) {
                items[i].printInfo();
                found = true;
            }
            i++;
        }

        if (!found) {
            System.out.println("Бұл тауар табылмады.");
        }
    }

    public void loadFromFile() {
        count = 0;

        try (BufferedReader reader =
                     new BufferedReader(new FileReader("receipts.csv"))) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",", -1);

                if (data.length == 4) {
                    try {
                        String date = data[0].trim();
                        String product = data[1].trim();
                        int price = Integer.parseInt(data[2].trim());
                        int weight = Integer.parseInt(data[3].trim());

                        addRecord(date, product, price, weight);
                    } catch (NumberFormatException e) {
                        System.out.println("Қате жол өткізіліп кетті: " + line);
                    }
                }
            }

            System.out.println("Файлдан оқылған жазбалар: " + count);

        } catch (IOException e) {
            System.out.println("Файлды оқу қатесі: " + e.getMessage());
        }
    }

    public void saveToFile() {
        try (PrintWriter writer =
                     new PrintWriter(new FileWriter("receipts.csv"))) {

            int i = 0;

            while (i < count) {
                writer.println(
                        items[i].getDate() + ","
                                + items[i].getProduct() + ","
                                + items[i].getPrice() + ","
                                + items[i].getWeightGrams()
                );
                i++;
            }

            System.out.println("Барлық жазба receipts.csv файлына сақталды.");

        } catch (IOException e) {
            System.out.println("Файлды сақтау қатесі: " + e.getMessage());
        }
    }
}