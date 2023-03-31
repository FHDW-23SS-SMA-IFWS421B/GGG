package Sensors;

import java.io.FileNotFoundException;
import java.util.Random;

import Interfaces.ITempatureSensor;

/**
 * Fictional driver to represent a USB temperature sensor
 * @author Matthias Füller
 *
 */
public class USBTemperatureSensor implements ITempatureSensor {

	/** 
	 * Init USB with given serial device
	 * @param devicename
	 * @throws FileNotFoundException
	 */
	public USBTemperatureSensor(String devicename) throws FileNotFoundException {
		if (devicename.startsWith("/dev/ttyUSB") == false) {
			throw new FileNotFoundException("Could not find USB device");
		}
	}
	
	/**
	 * Return the current temperature in Kelvin
	 * @return current temperature in Kelvin
	 */
	public int getTemperatureValue() {
		Random rnd = new Random();

		return (int) (-20 + 50 * rnd.nextDouble());
	}

	@Override
	public double getTempature() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getUSBTempature() {
		// TODO Auto-generated method stub
		return getTemperatureValue();
	}
}
