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
    public Stock(String fileFormat, int lineLength){
        //constructor that takes a string in the format used for files and converts it into a stock object
        super(Integer.parseInt(fileFormat.substring(lineLength/2, 3*(lineLength/4)).trim()), Double.parseDouble((fileFormat.substring(3*(lineLength/4), lineLength)).trim()));
        name = fileFormat.substring(0,lineLength/4);
        symbol = fileFormat.substring(lineLength/4, lineLength/2);

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
    public void displayFileFormat(){
        System.out.println(String.format("%-25s", name) + String.format("%-25s", symbol) + String.format("%-25s", getAmount()) + String.format("%-25s", getPrice()));
    }
}
