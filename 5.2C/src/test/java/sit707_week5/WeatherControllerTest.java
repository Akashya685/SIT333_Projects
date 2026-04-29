package sit707_week5;

import java.text.SimpleDateFormat;
import java.util.Date;

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
		String studentId = "s224597443";
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
		System.out.println("+++ testTemperaturePersist +++");
		
		// Arrange
		Date fixedDate = new Date(125, 0, 1, 10, 30, 15);
		wController.setFakeDateForTest(fixedDate);

		String expectedTime = new SimpleDateFormat("H:m:s").format(fixedDate);
		
		// Act
		String persistTime = wController.persistTemperature(10, 19.5);
		
		// Assert
		System.out.println("Persist time: " + persistTime + ", expected: " + expectedTime);
		
		Assert.assertEquals(expectedTime, persistTime);
	}
}