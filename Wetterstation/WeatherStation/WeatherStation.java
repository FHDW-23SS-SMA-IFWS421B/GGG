package WeatherStation;


import java.util.ArrayList;

import Interfaces.IPressureSensor;
import Interfaces.ITempatureSensor;
import Interfaces.IWeatherObserver;
import Interfaces.IWindspeedSensor;
import Interfaces.IRainSensor;


public class WeatherStation implements ITempatureSensor, IWindspeedSensor, IPressureSensor, IRainSensor{
	
	private IWindspeedSensor windspeed;
	private IRainSensor rain;
	private IPressureSensor pressure;
	private ITempatureSensor tempature;
	
	IWeatherObserver observers[] = new IWeatherObserver[100];
	int event[][] = new int[100][4];
	
		
	
	public void processData()
	{
		String data =readWeatherData();
		int i = 0;
		try {
			for (IWeatherObserver o: observers)
		{
			if(event[i][1]==Events.STORM.getID()||event[i][2]==Events.HEAVYRAIN.getID()||event[i][3]==Events.HEATWAVE.getID())
			{
				if(Math.round(getPressure())<= Events.STORM.getMin()){
					o.newWeatherData(data);
					break;
				}
				if(Math.round(getTempature())<= Events.HEATWAVE.getMin()){
					o.newWeatherData(data);
					break;
				}
				if(Math.round(getRain())<= Events.HEAVYRAIN.getMin()){
					o.newWeatherData(data);
					break;
				}
				break;
			}
			o.newWeatherData(data);
		}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	public void subscribe (IWeatherObserver o){
		subscribe(o, false, false, false);
	}

	public void subscribe (IWeatherObserver o, boolean storm, boolean heatwave,boolean heavyrain ){
		IWeatherObserver answer = null;
		
		int i=0;
		do{
			answer = observers[i];
			i++;
		} while (!(answer==null));
		observers [i-1] = o;	
		event[i-1][0]= i-1;
		event[i-1][1]= Events.STORM.getID(storm);
		event[i-1][2]= Events.HEATWAVE.getID(heatwave);
		event[i-1][3]= Events.HEAVYRAIN.getID(heavyrain);
	}

	public void unsubcribe(IWeatherObserver o) throws Exception {
		int i=0;
		while (!observers[i].equals(o)){
			i++;
			if(observers[i]== null){
				throw(new Exception("Observer Fehler"));
			}
		}
		observers[i]=null;
		event[i][0]= -1;
		event[i][1]= 0;
		event[i][2]= 0;
		event[i][3]= 0;
		sortObserverafterunsubscribe (i);
		
	}
	private void sortObserverafterunsubscribe(int i){
		while (!(observers[i+1]==null)){
			observers[i]=observers[i+1];
			event[i][0]= event[i+1][0];
			event[i][1]= event[i+1][1];
			event[i][2]= event[i+1][2];
			event[i][3]= event[i+1][3];
			i++;
		}
	}

	public String getSubscribers(){
		int i = 0;
		String subscriber="Subsriber List: ";
		if(!(observers[i]== null)){
			subscriber = subscriber + observers[i].toString() + event[i][1]  + event[i][2]+ event[i][3];
		}
		return subscriber;
	}
		
	public String readWeatherData() {
		return "Wind: " + Math.round(getWindspeed()) + " km/h \n" 
			+ "Temp: " + Math.round(getTempature() - 273.15) + " °C \n"
			+ "pressure: " + Math.round(getPressure()) + " hPa \n"
			+ "rain: " + Math.round(getRain()) + "mm/h \n";

	}
	
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
