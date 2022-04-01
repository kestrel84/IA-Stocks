public class Stock extends Asset{
    private String symbol;
    private String name;

    public Stock(int amount, double price, String symbol, String name) {
        super(amount, price);
        this.symbol = symbol;
        this.name = name;
    }
    public Stock(int amount, String symbol, String name){
        super(amount, AlphaVantageWrapper.getClosingDailyPrice(symbol));
        this.symbol = symbol;
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }
    public String getName() {
        return name;
    }
    public void updatePrice(){
        super.setPrice(AlphaVantageWrapper.getClosingDailyPrice(symbol));
    }

    public String convertToFileFormat(){
        return (String.format("%-25s", name) + String.format("%-25s", symbol) + String.format("%-25s", getAmount()) + String.format("%-25s", getPrice()));
    }

    public int REMOVETHIS(){
        return (String.format("%-25s", name) + String.format("%-25s", symbol) + String.format("%-25s", getAmount()) + String.format("%-25s", getPrice())).length();
    }
    //TODO add a method to convert the information to a text file readable format
}
