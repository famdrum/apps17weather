import java.net.*;
import java.io.*;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class URLWeatherReader implements URLReaders{
    String description;
    Double temp;
    JSONObject json_info;
    URLcreate url_creator;

    URLWeatherReader(String city, String appid,String url) throws IOException, ParseException {
        this.url_creator = new URLcreate(city,appid,url);
        URL forecast_url = new URL(url_creator.make_url());
        BufferedReader in = new BufferedReader(
                new InputStreamReader(forecast_url.openStream()));

        String inputLine = in.readLine();

        JSONParser parser = new JSONParser();
        this.json_info = (JSONObject) parser.parse(inputLine);
        JSONObject weather_d = (JSONObject) ((ArrayList) json_info.get("weather")).get(0);
        this.description = (String) weather_d.get("description");
        this.temp = (Double) ((JSONObject) json_info.get("main")).get("temp");
    }

    public boolean get_forecast() throws Exception {
        System.out.println("There is " + this.description + " today in " + url_creator.city);
        System.out.println("Temperature in Kelvin: " + this.temp);
        System.out.println("Temperature in Kelvin: " + (this.temp - 273.15));
        return true;
    }
}