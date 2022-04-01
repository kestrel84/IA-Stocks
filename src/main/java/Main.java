import com.crazzyghost.alphavantage.parameters.*;
import com.crazzyghost.alphavantage.timeseries.response.StockUnit;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        AlphaVantageWrapper.initialiseApi();
        List<StockUnit> list = AlphaVantageWrapper.getIntradayPrice("IBM", Interval.SIXTY_MIN);

        Stock stock = new Stock(10, list.get(0).getClose(), "IBM", "IBM");

        Portfolio portfolio = new Portfolio("\\\\bex-file-01\\studenthome$\\16\\16Ashton_M\\CSH IB\\IA-Stonks\\Portfolio1.txt");

        portfolio.addStock(stock);
        portfolio.addStock(new Stock(10, "BCS", "Barclays"));
        portfolio.writeToFile();



/*
        for (int i = 0; i < 100; i++) {
            System.out.printf("%-15s", ("$" + list.get(i).getClose()));
            System.out.println(list.get(i).getDate());
        }*/
    }
}
