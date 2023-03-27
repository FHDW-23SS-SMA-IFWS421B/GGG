package Main;

import java.io.FileNotFoundException;

import Sensors.SerialTemperatureDriver;
import Sensors.SerialWindspeedDriver;
import WeatherStation.WeatherStation;
import WeatherStation.WeatherSationUSB;
import Interfaces.IPressureSensor;
import Interfaces.ITempatureReader;
import Interfaces.IWindspeedDriver;
import Interfaces.IRainSensor;
import Interfaces.IUSBTemperaturDriver;
import Sensors.SerialPressureSensor;
import Sensors.USBTemperatureDriver;
import Sensors.SerialRainSensor;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		SerialWindspeedDriver windspeed = new SerialWindspeedDriver("/dev/tty1");
		SerialTemperatureDriver tempature = new SerialTemperatureDriver("/dev/tty0");
		SerialPressureSensor pressure = new SerialPressureSensor("/dev/tty");
		SerialRainSensor rain = new SerialRainSensor("/dev/tty");
		USBTemperatureDriver usbTempature = new USBTemperatureDriver("/dev/ttyUSB");
		
		WeatherStation ws = new WeatherStation(windspeed, tempature, rain, pressure);
		System.out.println("Wind: " + Math.round(ws.getCurrentWindspeed()) + " km/h");
		System.out.println("Temp: " + Math.round(ws.getCurrentTempature() - 273.15) + " C");
		System.out.println("pressure: " + ws.getSensorValue());
		System.out.println("rain: " + ws.getSensorValue());
		
		WeatherSationUSB wsUsb = new WeatherSationUSB(windspeed, usbTempature, rain, pressure);
		System.out.println("Wind: " + Math.round(ws.getCurrentWindspeed()) + " km/h");
		System.out.println("Temp: " + ws.getCurrentTempature());
		System.out.println("pressure: " + ws.getSensorValue());
		System.out.println("rain: " + ws.getSensorValue());
	}

}
