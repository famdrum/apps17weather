import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class URLTest {
    public static void main(String[] args) throws Exception {
        URLWeatherReader reader = new URLWeatherReader("Lviv","5496614f4ca95e6dcc0445c1e7f3916d","http://api.openweathermap.org/data/2.5/weather");
        reader.get_forecast();
        assert(reader.get_forecast() == true);
        Double d = 21.2;
        assert(reader.temp.getClass() == d.getClass());
        assert(reader.description == "fog");
        URLcreate creator = new URLcreate("Lviv","5496614f4ca95e6dcc0445c1e7f3916d","http://api.openweathermap.org/data/2.5/weather");
        assert(creator.city == "Lviv");
        assert(creator.url == "http://api.openweathermap.org/data/2.5/weather");
        assert(creator.appid == "5496614f4ca95e6dcc0445c1e7f3916d");
        assert(creator.make_url() == "http://api.openweathermap.org/data/2.5/weather?APPID=5496614f4ca95e6dcc0445c1e7f3916d&q=Lviv");
        URLWeatherDecorator decorator = new URLWeatherDecorator(reader);
        assert(decorator.reader.getClass() == reader.getClass());
        assert(decorator.get_forecast_happy() == true);
        JSONObject test = new JSONObject();
        assert(reader.json_info.getClass() == test.getClass());
        System.out.println("");
        decorator.get_forecast_happy();
    }
}
