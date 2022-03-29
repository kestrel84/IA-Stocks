import com.crazzyghost.alphavantage.*;
import com.crazzyghost.alphavantage.parameters.*;
import com.crazzyghost.alphavantage.timeseries.response.StockUnit;
import com.crazzyghost.alphavantage.timeseries.response.TimeSeriesResponse;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        //configure wrapper
        Config cfg = Config.builder()
                .key("7T61LRZASTFH3RCB")
                .timeOut(10)
                .build();

        //initialize api
        AlphaVantage.api().init(cfg);

        //get a response
        TimeSeriesResponse resp = AlphaVantage.api()
                .timeSeries()
                .intraday()
                .forSymbol("IBM")
                .interval(Interval.SIXTY_MIN)
                .outputSize(OutputSize.COMPACT)
                .dataType(DataType.JSON)
                .fetchSync();

        //print the raw response
        //System.out.println(resp.toString());

        //convert to a list
        List<StockUnit> list = resp.getStockUnits();

        for (int i = 0; i < 100; i++) {
            System.out.printf("%-15s", ("$" + list.get(i).getClose()));
            System.out.println(list.get(i).getDate());
        }


        //try a json parser
/*
        JSONParser parse = new JSONParser();
        try {
            JSONArray dataObject = (JSONArray) parse.parse(respString);

            System.out.println(dataObject.get(0));
        } catch (ParseException e) {
            e.printStackTrace();
        }
*/
// didn't work




    }


}
