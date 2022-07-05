public class Stock extends Asset{
    private String symbol;
    private String name;

    //CONSTANTS
    private static final int STOCK_FILE_FORMAT_LENGTH = 100;

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
    public Stock(String fileFormat){
        //constructor that takes a string in the format used for files and converts it into a stock object
        super(Integer.parseInt(fileFormat.substring(STOCK_FILE_FORMAT_LENGTH /2, 3*(STOCK_FILE_FORMAT_LENGTH /4)).trim()), Double.parseDouble((fileFormat.substring(3*(STOCK_FILE_FORMAT_LENGTH /4), STOCK_FILE_FORMAT_LENGTH)).trim()));
        name = fileFormat.substring(0, STOCK_FILE_FORMAT_LENGTH /4);
        symbol = fileFormat.substring(STOCK_FILE_FORMAT_LENGTH /4, STOCK_FILE_FORMAT_LENGTH /2);
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
