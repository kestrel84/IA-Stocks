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
    //TODO urgent: make a constructor that can be passed a file format string and make a stock object out of it


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
    public void displayFileFormat(){
        System.out.println(String.format("%-25s", name) + String.format("%-25s", symbol) + String.format("%-25s", getAmount()) + String.format("%-25s", getPrice()));
    }
}
