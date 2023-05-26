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
	
		
	public WeatherStation(IWindspeedSensor windspeed,  ITempatureSensor tempature, IRainSensor rain, IPressureSensor pressure) {
		this.windspeed = windspeed; 
		this.tempature = tempature;
		this.pressure = pressure;
		this.rain = rain;
	}
	 
	
	public void processData()
	{
		WeatherData data = new WeatherData(this);
		//String data =readWeatherData();
		int i = 0;
		int eventCount = 0;
		try {
			for (IWeatherObserver o: observers)
		{
			if(event[i][1]==Events.STORM.getID()){
				if (Math.round(data.getPressure())>=Events.STORM.getMin()){
					o.newWeatherData(data.toString() + "Es liegt eine Sturmmeldung vor \n");
					break;
				}
				eventCount++;
			}
			if(event[i][2]==Events.HEATWAVE.getID()){
				if (( Math.round(data.getTempature())- 273.15) >= Events.HEATWAVE.getMin()){
					o.newWeatherData(data.toString() + "Es liegt eine Hitzewelle vor \n");
					break;
				}
				eventCount++;
			}
			if(event[i][3]==Events.HEAVYRAIN.getID()){
				if(Math.round(data.getRain())>= Events.HEAVYRAIN.getMin()){
					o.newWeatherData(data.toString() + "Es liegt Starkregen vor \n");
					break;
				}
				eventCount++;
			}
			if (eventCount==0){
			
				o.newWeatherData(data.toString());}
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
