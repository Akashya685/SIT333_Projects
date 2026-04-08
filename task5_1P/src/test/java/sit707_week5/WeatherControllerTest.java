package sit707_week5;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class WeatherControllerTest {

	private static WeatherController wController;
	private static int nHours;
	private static double[] temperatures;

	@BeforeClass
	public static void setUp() {
		wController = WeatherController.getInstance();
		nHours = wController.getTotalHours();

		temperatures = new double[nHours];
		for (int i = 0; i < nHours; i++) {
			temperatures[i] = wController.getTemperatureForHour(i + 1);
		}
	}

	@Test
	public void testStudentIdentity() {
		String studentId = "224597443";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Akashya Mann";
		Assert.assertNotNull("Student name is null", studentName);
	}

	@Test
	public void testTemperatureMin() {
		System.out.println("+++ testTemperatureMin +++");
		
		double minTemperature = 1000;
		for (int i = 0; i < nHours; i++) {
			if (minTemperature > temperatures[i]) {
				minTemperature = temperatures[i];
			}
		}
		
		Assert.assertTrue(wController.getTemperatureMinFromCache() == minTemperature);
	}
	
	@Test
	public void testTemperatureMax() {
		System.out.println("+++ testTemperatureMax +++");
		
		double maxTemperature = -1;
		for (int i = 0; i < nHours; i++) {
			if (maxTemperature < temperatures[i]) {
				maxTemperature = temperatures[i];
			}
		}
		
		Assert.assertTrue(wController.getTemperatureMaxFromCache() == maxTemperature);
	}

	@Test
	public void testTemperatureAverage() {
		System.out.println("+++ testTemperatureAverage +++");
		
		double sumTemp = 0;
		for (int i = 0; i < nHours; i++) {
			sumTemp += temperatures[i];
		}
		double averageTemp = sumTemp / nHours;
		
		Assert.assertTrue(wController.getTemperatureAverageFromCache() == averageTemp);
	}
	
	@Test
	public void testTemperaturePersist() {
		/*
		 * Remove below comments ONLY for 5.3C task.
		 */
//		System.out.println("+++ testTemperaturePersist +++");
//		
//		// Initialise controller
//		WeatherController wController = WeatherController.getInstance();
//		
//		String persistTime = wController.persistTemperature(10, 19.5);
//		String now = new SimpleDateFormat("H:m:s").format(new Date());
//		System.out.println("Persist time: " + persistTime + ", now: " + now);
//		
//		Assert.assertTrue(persistTime.equals(now));
//		
//		wController.close();
	}
}