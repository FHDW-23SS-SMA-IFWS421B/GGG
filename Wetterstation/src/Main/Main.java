package Main;

import java.io.FileNotFoundException;

import Sensors.SerialTemperatureDriver;
import Sensors.SerialWindspeedDriver;
import WeatherStation.WeatherStation;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		SerialWindspeedDriver windspeed = new SerialWindspeedDriver("/dev/tty1");
		SerialTemperatureDriver tempature = new SerialTemperatureDriver("/dev/tty0");
		
		WeatherStation ws = new WeatherStation(windspeed, tempature);
		System.out.println("Wind: " + Math.round(ws.getCurrentWindspeed()) + " km/h");
		System.out.println("Temp: " + Math.round(ws.getCurrentTempature() - 273.15) + " °C");
	}

}
