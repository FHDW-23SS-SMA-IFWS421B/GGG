package WeatherStation;

public class WeatherData {
    
    WeatherStation ws;
    double pressure;
    double rain;
    double tempature;
    double windspeed;


    public WeatherData (WeatherStation ws)
    {
        this.ws = ws;
        this.pressure = ws.getPressure();
        this.rain = ws.getRain();
        this.tempature = ws.getTempature();
        this.windspeed = ws.getWindspeed();
    

    }
     public String toString()
     {
        
            return "Wind: " + Math.round(windspeed) + " km/h \n" 
                + "Temp: " + Math.round(tempature - 273.15) + " °C \n"
                + "pressure: " + Math.round(pressure) + " hPa \n"
                + "rain: " + Math.round(rain) + "mm/h \n";
    
        }
    public double getPressure() {
        return pressure;
    }
    public double getTempature() {
        return tempature;
    }
    public double getRain() {
        return rain;
    }
}


