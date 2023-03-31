package Sensors;

import java.io.FileNotFoundException;
import java.util.Random;

import Interfaces.IWindspeedSensor;

/**
 * Fictional windspeed driver
 * @author Matthias Füller
 *
 */
public class SerialWindspeedSensor implements IWindspeedSensor {

	/** 
	 * Init SerialDriver with given serial device
	 * @param devicename
	 * @throws FileNotFoundException
	 */
	public SerialWindspeedSensor(String devicename) throws FileNotFoundException {
		if (devicename.equals("/dev/tty1") == false) {
			throw new FileNotFoundException("Could not find serial device");
		}
	}
	
	/**
	 * Return the current windspeed in m/s
	 * @return current windspeed in m/s
	 */
	public double currentWindspeed() {
		Random rnd = new Random();

		return 50 * rnd.nextDouble();
	}

	@Override
	public double getWindspeed() {
		// TODO Auto-generated method stub
		return currentWindspeed();
	}
}
