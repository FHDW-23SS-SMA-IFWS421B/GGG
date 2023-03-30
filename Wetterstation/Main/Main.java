package Main;

import java.io.FileNotFoundException;

import Sensors.SerialPressureSensor;
import Sensors.SerialRainSensor;
import Sensors.SerialTemperatureDriver;
import Sensors.SerialWindspeedDriver;
import Sensors.USBTemperatureDriver;
import WeatherStation.WeatherStation;

import Interfaces.IPressureSensor;
import Interfaces.ITempatureSensor;
import Interfaces.IWindspeedSensor;
import Interfaces.IRainSensor;
import Sensors.SerialPressureSensor;
import Sensors.USBTemperatureDriver;
import Sensors.SerialRainSensor;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		SerialWindspeedDriver windspeed = new SerialWindspeedDriver("/dev/tty1");
		SerialTemperatureDriver tempature = new SerialTemperatureDriver("/dev/tty0");
		SerialPressureSensor pressure = new SerialPressureSensor("/dev/tty");
		SerialRainSensor rain = new SerialRainSensor("/dev/tty");
		
		WeatherStation ws = new WeatherStation(windspeed, tempature, rain, pressure);
		System.out.println("Wind: " + Math.round(ws.getWindspeed()) + " km/h");
		System.out.println("Temp: " + Math.round(ws.getTempature() - 273.15) + " °C");
		System.out.println("pressure: " + Math.round(ws.getPressure()) + " hPa");
		System.out.println("rain: " + Math.round(ws.getRain()) + "mm/h");
		System.out.println("\n");
	
	}

}
