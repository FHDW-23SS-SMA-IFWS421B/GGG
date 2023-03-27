package Sensors;

import java.io.FileNotFoundException;
import java.util.Random;

/**
 * Fictional driver to represent a serial presure sensor
 * @author Matthias Füller
 *
 */
public class SerialPressureSensor {

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
}
