import com.crazzyghost.alphavantage.AlphaVantage;
import com.crazzyghost.alphavantage.Config;
import com.crazzyghost.alphavantage.parameters.DataType;
import com.crazzyghost.alphavantage.parameters.Interval;
import com.crazzyghost.alphavantage.parameters.OutputSize;
import com.crazzyghost.alphavantage.timeseries.response.StockUnit;
import com.crazzyghost.alphavantage.timeseries.response.TimeSeriesResponse;


import java.util.*;

public class AlphaVantageWrapper {

    public static List<StockUnit> getIntradayPrice(String symbol, Interval interval) {
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
