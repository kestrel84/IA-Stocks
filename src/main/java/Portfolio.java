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
    }

    public void addStock(Stock stock){
        portfolio.add(stock);
    }
    public void updateAllPrices(){
        //TODO: updates all the prices of all the assets
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

    public String getName() {
        return name;
    }


}
