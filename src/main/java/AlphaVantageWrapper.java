import com.crazzyghost.alphavantage.AlphaVantage;
import com.crazzyghost.alphavantage.Config;
import com.crazzyghost.alphavantage.parameters.DataType;
import com.crazzyghost.alphavantage.parameters.Interval;
import com.crazzyghost.alphavantage.parameters.OutputSize;
import com.crazzyghost.alphavantage.timeseries.response.QuoteResponse;
import com.crazzyghost.alphavantage.timeseries.response.StockUnit;
import com.crazzyghost.alphavantage.timeseries.response.TimeSeriesResponse;


import java.util.*;

public class AlphaVantageWrapper {

    public static List<StockUnit> getIntradayPrice(String symbol, Interval interval) {
        //returns an array of stockUnits that is the data every set interval

        //get a response
        TimeSeriesResponse resp = AlphaVantage.api()
                .timeSeries()
                .intraday()
                .forSymbol(symbol)
                .interval(interval)
                .outputSize(OutputSize.COMPACT)
                .dataType(DataType.JSON)
                .fetchSync();

        //convert to stockUnit list
        return resp.getStockUnits();
    }

    public static double getClosingDailyPrice(String symbol){
        TimeSeriesResponse resp = AlphaVantage.api()
                .timeSeries()
                .intraday()
                .forSymbol(symbol)
                .interval(Interval.SIXTY_MIN)
                .outputSize(OutputSize.COMPACT)
                .dataType(DataType.JSON)
                .fetchSync();

            if (resp.getStockUnits().size() > 0) {
                return resp.getStockUnits().get(0).getClose();
            } else {
                return 0.0;
            }
    }

    public static void testQuoteResponse(String symbol){
        QuoteResponse resp = AlphaVantage.api()
                .timeSeries()
                .quote()
                .forSymbol(symbol)
                .fetchSync();

        System.out.println("High:               " + resp.getHigh());
        System.out.println("Low:                " + resp.getLow());
        System.out.println("Open:               " + resp.getOpen());
        //System.out.println(resp.getClose());
        System.out.println("Volume:             " + resp.getVolume());
        System.out.println("Symbol:             " + resp.getSymbol());
        System.out.println("Latest Trading Day: " + resp.getLatestTradingDay());
        System.out.println("Previous Close:     " + resp.getPreviousClose());
        System.out.println("Change:             " + resp.getChange());
        System.out.println("Percent Change:     " + resp.getChangePercent());
        System.out.println();
    }


    public static void initialiseApi(){
        //configure wrapper
        Config cfg = Config.builder()
                .key("7T61LRZASTFH3RCB")
                .timeOut(10)
                .build();
        //initialize api
        AlphaVantage.api().init(cfg);
    }

}
