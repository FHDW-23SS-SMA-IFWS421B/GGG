package WeatherStation;

import java.io.FileNotFoundException;

import Interfaces.ITempatureReader;
import Interfaces.IWindspeedDriver;
import Sensors.SerialTemperatureDriver;
import Sensors.SerialWindspeedDriver;

public class WeatherStation implements ITempatureReader, IWindspeedDriver, IPressurSensor, IRainSensor, IUSBTempaturDriver{
	
	private SerialWindspeedDriver windspeed;
	private SerialTemperatureDriver tempature;
	private SerialRainSensor rain;
	private SerialPressureDriver pressure;
	private USBTemperaturDriver usbTemperatur;
	
	public WeatherStation(SerialWindspeedDriver windspeed,  SerialTemperatureDriver tempature, SerialRainSensor rain, SerialPressureDriver pressure) {
		this.windspeed = windspeed;
		this.tempature = tempature;
		this.pressure = pressure;
		this.rain = rain;
	}
	
	public WeatherStation(SerialWindspeedDriver windspeed,  USBTemperaturDriver usbTemperatur, SerialRainSensor rain, SerialPressureDriver pressure) {
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
	
	@Ovveride
	public double getCurrentPressure {
		return pressure.getSensorValue();
	}
	
	@Ovveride
	public double getCurrentRain() {
		return rain.getSensorValue();
	}
	
	@Ovveride
	public int getCurrentTemperature() {
		return usbTemperatur.getTemperaturValue();
	}

}
