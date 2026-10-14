
public class Grocery {
    private String date;
    private String product;
    private int price;
    private int weightGrams;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        if (date != null && date.matches("\\d{2}\\.\\d{2}")) {
            this.date = date;
        } else {
            System.out.println("Қате: күн КК.АА форматында болуы керек!");
        }
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        if (product != null && !product.trim().isEmpty()) {
            this.product = product;
        } else {
            System.out.println("Қате: өнім атауы бос болмауы керек!");
        }
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price >= 1 && price <= 100000) {
            this.price = price;
        } else {
            System.out.println("Қате: баға 1–100000 аралығында болуы керек!");
        }
    }

    public int getWeightGrams() {
        return weightGrams;
    }

    public void setWeightGrams(int weightGrams) {
        if (weightGrams >= 1 && weightGrams <= 20000) {
            this.weightGrams = weightGrams;
        } else {
            System.out.println("Қате: салмақ 1–20000 грамм аралығында болуы керек!");
        }
    }

    public boolean isExpensivePerKg() {
        if (weightGrams == 0) {
            return false;
        }

        return (long) price * 1000 / weightGrams > 2000;
    }

    public void printInfo() {
        System.out.println(
                date + " | " + product + " | " +
                        price + " тг | " + weightGrams + " г"
        );
    }
}
