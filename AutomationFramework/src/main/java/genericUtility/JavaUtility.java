package genericUtility;

import java.time.LocalDateTime;
import java.util.Random;

public class JavaUtility {
	/**
	 * This method is used to capture current system dare and time
	 * @return String
	 */

	public String getSystemTime()
	{
		return LocalDateTime.now().toString().replace(":", "-");
	}
	
	public int getRandomNumber()
	{
		/*
		 * This method is used to generate random numbers within 1000
		 * return int
		 */
		Random ran = new Random();
		return ran.nextInt(1000);
	}
}
