import java.util.ArrayList;

public class Portfolio {
    private static final int lineLength=100;
    private final ArrayList<Stock> portfolio;
    private final Database db;
    private String name;

    //a method that uses a text file to initialise the portfolio using the stock constructor that takes a file string
    public Portfolio(String fileName){
        //constructs a portfolio from an existing text file

        portfolio = new ArrayList<>();
        db = new Database(fileName, lineLength);

        name = fileName.substring(GUIMainFrame.generalFilePath.length());
        //import the file into local memory
        for (int i = 0; i < db.getSize(); i++) {
            portfolio.add(new Stock(db.getRecordAt(i)));
        }

        //update the price of all the stocks
        for (Stock s:
                portfolio) {
            s.updatePrice();
        }
    }

    public void addStock(Stock stock){
        portfolio.add(stock);
        db.appendRecord(stock.convertToFileFormat());
    }
    public void updateAllPrices(){
        //TODO: updates all the prices of all the assets
    }
    public String getStockStringAt(int i){
        return portfolio.get(i).convertToFileFormat();
    }

    public String getName() {
        return name;
    } //TODO: This getName needs a lot of refining to remove the userid and portfolio number either side of it
    public ArrayList<Stock> getStockList(){
        return portfolio;
    }
    public Stock[] getStockArray(){
        Stock[] stocks = new Stock[portfolio.size()];
        for (int i = 0; i < portfolio.size(); i++) {
            stocks[i] = portfolio.get(i);
        }
        return stocks;
    }
    public String[] getStockNamesArray(){
        String[] names = new String[portfolio.size()];

        for (int i = 0; i < portfolio.size(); i++) {
            names[i]=portfolio.get(i).getName();
        }
        return names;
    }

}
