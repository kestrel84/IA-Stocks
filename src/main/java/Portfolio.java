import java.util.ArrayList;


public class Portfolio {
    private static final int lineLength=100;
    private ArrayList<Stock> portfolio;
    private Database db;

    public Portfolio(String fileName){
        portfolio = new ArrayList<>();
        db = new Database(fileName, lineLength, "##DELETED##");
    }
    //TODO: add a method that uses a text file to initialise the portfolio, requires a method in stock that initialises from a file format

    public void addStock(Stock stock){
        portfolio.add(stock);
    }
    public void updateAllPrices(){
        //updates all the prices of all the assets
    }

    public void writeToFile(){
        //writes the entire arraylist to a file

        for (Stock a:
             portfolio) {
            db.appendRecord(a.convertToFileFormat());
        }
    }

    public String getStockStringAt(int i){
        return portfolio.get(i).convertToFileFormat();
    }

}
