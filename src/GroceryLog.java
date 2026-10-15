
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

}
