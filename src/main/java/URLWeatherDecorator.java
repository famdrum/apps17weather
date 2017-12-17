public class URLWeatherDecorator {
    URLWeatherReader reader;
    URLWeatherDecorator(URLWeatherReader reader){
        this.reader = reader;
    }
    public boolean get_forecast_happy() throws Exception {
        System.out.println("--- Merry Christmas! Here's your forecast ^-^ ---\n");
        reader.get_forecast();
        return true;
    }
}
