package WeatherStation;


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
	
	
	
	public void processData()
	{
		String data =readWeatherData();
		try {
			for (IWeatherObserver o: observers)
		{
			o.newWeatherData(data);
		}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	public void subscribe (IWeatherObserver o){
		IWeatherObserver answer = null;
		int i=0;
		do{
			answer = observers[i];
			i++;
		} while (!(answer==null));
		observers [i-1] = o;	
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
		sortObserverafterunsubscribe (i);
		
	}
	private void sortObserverafterunsubscribe(int i){
		while (!(observers[i+1]==null)){
			observers[i]=observers[i+1];
			i++;
		}
	}

	public String getSubscribers(){
		int i = 0;
		String subscriber="Subsriber List: ";
		if(!(observers[i]== null)){
			subscriber = subscriber + observers[i].toString();
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
