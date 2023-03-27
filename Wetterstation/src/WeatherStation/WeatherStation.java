package WeatherStation;

import java.io.FileNotFoundException;

import Interfaces.ITempatureReader;
import Interfaces.IWindspeedDriver;
import Sensors.SerialTemperatureDriver;
import Sensors.SerialWindspeedDriver;

public class WeatherStation implements ITempatureReader, IWindspeedDriver{
	
	private SerialWindspeedDriver windspeed;
	private SerialTemperatureDriver tempature;
	
	public WeatherStation(SerialWindspeedDriver windspeed,  SerialTemperatureDriver tempature) {
		this.windspeed = windspeed;
		this.tempature = tempature;
	}

	@Override
	public double getCurrentTempature() {
		return tempature.read();
	}

	@Override
	public double getCurrentWindspeed() {
		return windspeed.currentWindspeed();
	}

}
