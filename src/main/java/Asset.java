public class Asset {
    private int amount;
    private double price;

    public Asset(int amount, double price) {
        this.amount = amount;
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }
    public double getPrice() {
        return price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
