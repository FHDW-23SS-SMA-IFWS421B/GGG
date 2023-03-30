package Sensors;

import java.io.FileNotFoundException;
import java.util.Random;

import Interfaces.IPressureSensor;

/**
 * Fictional driver to represent a serial presure sensor
 * @author Matthias Füller
 *
 */
public class SerialPressureSensor implements IPressureSensor {

	/** 
	 * Init SerialDriver with given serial device
	 * @param devicename
	 * @throws FileNotFoundException
	 */
	public SerialPressureSensor(String devicename) throws FileNotFoundException {
		if (devicename.startsWith("/dev/tty") == false) {
			throw new FileNotFoundException("Wrong serial device given " + devicename);
		}
	}
	
	/**
	 * Return the current air pressure in hPa
	 * @return current air pressure in hPa
	 */
	public double getSensorValue() {
		Random rnd = new Random();

		return 950 + 100 * rnd.nextDouble();
	}

	@Override
	public double getPressure() {
		// TODO Auto-generated method stub
		return getSensorValue();
	}
}
