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


public class WeatherStation implements ITempatureReader, IWindspeedDriver, IPressureSensor, IRainSensor{
	
	private SerialWindspeedDriver windspeed;
	private SerialTemperatureDriver tempature;
	private SerialRainSensor rain;
	private SerialPressureSensor pressure;
	
	public WeatherStation(SerialWindspeedDriver windspeed,  SerialTemperatureDriver tempature, SerialRainSensor rain, SerialPressureSensor pressure) {
		this.windspeed = windspeed; 
		this.tempature = tempature;
		this.pressure = pressure;
		this.rain = rain;
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
	public double getCurrentTempature() {
		return tempature.read();
	}



	

}
