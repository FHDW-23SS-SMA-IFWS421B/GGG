package WeatherStation;

import java.io.FileNotFoundException;

import Interfaces.IPressureSensor;
import Interfaces.ITempatureSensor;
import Interfaces.IWindspeedSensor;
import Interfaces.IRainSensor;


public class WeatherStation implements ITempatureSensor, IWindspeedSensor, IPressureSensor, IRainSensor{
	
	private IWindspeedSensor windspeed;
	private IRainSensor rain;
	private IPressureSensor pressure;
	private ITempatureSensor tempature;
	
	
	public WeatherStation(IWindspeedSensor windspeed,  ITempatureSensor tempature, IRainSensor rain, IPressureSensor pressure) {
		this.windspeed = windspeed; 
		this.tempature = tempature;
		this.pressure = pressure;
		this.rain = rain;
	}
	
	

	@Override
	public double getRain() {
		// TODO Auto-generated method stub
		return rain.getRain();
	}



	@Override
	public double getPressure() {
		// TODO Auto-generated method stub
		return pressure.getPressure();
	}



	@Override
	public double getWindspeed() {
		// TODO Auto-generated method stub
		return windspeed.getWindspeed();
	}



	@Override
	public double getTempature() {
		// TODO Auto-generated method stub
		return tempature.getTempature();
	}



	@Override
	public double getUSBTempature() {
		// TODO Auto-generated method stub
		return tempature.getUSBTempature();
	}



	

}
