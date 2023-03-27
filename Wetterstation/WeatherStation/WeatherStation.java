package WeatherStation;

import java.io.FileNotFoundException;

import Interfaces.IPressureSensor;
import Interfaces.ITempatureReader;
import Interfaces.IWindspeedDriver;
import Interfaces.IRainSensor;
import Interfaces.IUSBTemperaturDriver;
import Sensors.SerialPressureSensor;
import Sensors.SerialTemperatureDriver;
import Sensors.SerialWindspeedDriver;
import Sensors.USBTemperatureDriver;
import Sensors.SerialRainSensor;
import Sensors.SerialPressureSensor;

public class WeatherStation implements ITempatureReader, IWindspeedDriver, IUSBTemperaturDriver, IPressureSensor, IRainSensor{
	
	private SerialWindspeedDriver windspeed;
	private SerialTemperatureDriver tempature;
	private SerialRainSensor rain;
	private SerialPressureSensor pressure;
	private USBTemperatureDriver usbTemperatur;
	
	public WeatherStation(SerialWindspeedDriver windspeed,  SerialTemperatureDriver tempature, SerialRainSensor rain, SerialPressureSensor pressure) {
		this.windspeed = windspeed; 
		this.tempature = tempature;
		this.pressure = pressure;
		this.rain = rain;
	}
	
	public WeatherStation(SerialWindspeedDriver windspeed,  USBTemperatureDriver usbTemperatur, SerialRainSensor rain, SerialPressureSensor pressure) {
		this.windspeed = windspeed;
		this.usbTemperatur = usbTemperatur;
		this.pressure = pressure;
		this.rain = rain;
		
	}
	

	@Override
	public double getCurrentTempature() {
		return tempature.read();
	}

	@Override
	public double getCurrentWindspeed() {
		return windspeed.currentWindspeed();
	}

	@Override
	public double getSensorValue() {
		return pressure.getSensorValue() + rain.getSensorValue();
	}

	@Override
	public int getCurrentTemperature() {
	return usbTemperatur.getTemperatureValue();
	}
	

}
