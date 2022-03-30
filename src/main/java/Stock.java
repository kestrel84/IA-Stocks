public class Stock extends Asset{
    private String symbol;
    private String name;

    public Stock(int amount, double price, String symbol, String name) {
        super(amount, price);
        this.symbol = symbol;
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    //TODO add a method to convert the information to a text file readable format
}
