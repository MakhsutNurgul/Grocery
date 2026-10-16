
public class GroceryLog {
    private Grocery[] items = new Grocery[30];
    private int count = 0;

    public int getCount() {
        return count;
    }

    public boolean addRecord(String date, String product,
                             int price, int weightGrams) {
        if (count >= items.length) {
            System.out.println("Журнал толып кетті!");
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
        item.setProduct(product);
        item.setPrice(price);
        item.setWeightGrams(weightGrams);

        items[count] = item;
        count++;

        return true;
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
        int i = 0;
        boolean found = false;

        while (i < count) {
            if (items[i].getDate().equals(date)) {
                items[i].printInfo();
                found = true;
            }
            i++;
        }

        if (!found) {
            System.out.println("Бұл күнге тиесілі тауар табылмады.");
        }
    }


    public void findByProduct(String product) {
        int i = 0;
        boolean found = false;

        while (i < count) {
            if (items[i].getProduct().equalsIgnoreCase(product.trim())) {
                items[i].printInfo();
                found = true;
            }
            i++;
        }

        if (!found) {
            System.out.println("Мұндай тауар табылмады.");
        }
    }
}
