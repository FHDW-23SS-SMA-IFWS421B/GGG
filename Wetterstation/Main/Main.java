package Main;

import java.io.FileNotFoundException;

import javax.xml.crypto.Data;

import Sensors.SerialPressureSensor;
import Sensors.SerialRainSensor;
import Sensors.SerialTemperatureSensor;
import Sensors.SerialWindspeedSensor;
import WeatherStation.WeatherStation;
import observer.IWeatherObserver;


public class Main implements IWeatherObserver{

	public static void main(String[] args) throws Exception {
		
		SerialWindspeedSensor windspeed = new SerialWindspeedSensor("/dev/tty1");
		SerialTemperatureSensor tempature = new SerialTemperatureSensor("/dev/tty0");
		SerialPressureSensor pressure = new SerialPressureSensor("/dev/tty");
		SerialRainSensor rain = new SerialRainSensor("/dev/tty");
		
		WeatherStation ws = new WeatherStation(windspeed, tempature, rain, pressure);
		IWeatherObserver wo = new Main();
		/*System.out.println("Wind: " + Math.round(ws.getWindspeed()) + " km/h");
		System.out.println("Temp: " + Math.round(ws.getTempature() - 273.15) + " °C");
		System.out.println("pressure: " + Math.round(ws.getPressure()) + " hPa");
		System.out.println("rain: " + Math.round(ws.getRain()) + "mm/h");
		System.out.println("\n");*/
		System.out.println(ws.readWeatherData());
		ws.subscribe(wo);
		int i=0;
		while(true){
			Thread.sleep(3*1000);
			ws.processData();
			System.out.println(ws.getSubscribers());
			i++;
			if(i>2){
				ws.unsubcribe(wo);
				break;
			}
		}
		System.out.println(ws.getSubscribers());

	
	}

	@Override
	public void newWeatherData(String data) {
		System.out.println("New Sensordata received %s" + data);
	}

}
