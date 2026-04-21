package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class WeatherAndMathUtilsTest {
	
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
	public void testFalseNumberIsEven() {
		Assert.assertFalse(WeatherAndMathUtils.isEven(3));
	}
	
	@Test
	public void testTrueNumberIsEven() {
		Assert.assertTrue(WeatherAndMathUtils.isEven(4));
	}
	
    @Test
    public void testCancelWeatherAdvice() {
    	Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(70.1, 0.0));
    }
    
    @Test
    public void testCancelWeatherAdviceByRain() {
    	Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(0.0, 6.1));
    }
    
    @Test
    public void testCancelWeatherAdviceByWindAndRain() {
    	Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(46.0, 4.1));
    }
    
    @Test
    public void testWarnWeatherAdviceByWind() {
    	Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(46.0, 0.0));
    }
    
    @Test
    public void testWarnWeatherAdviceByRain() {
    	Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(0.0, 4.1));
    }
    
    @Test
    public void testAllClearWeatherAdvice() {
    	Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(30.0, 2.0));
    }
    
    @Test
    public void testPrimeOne() {
    	Assert.assertTrue(WeatherAndMathUtils.isPrime(1));
    }
    
    @Test
    public void testPrimeTwo() {
    	Assert.assertTrue(WeatherAndMathUtils.isPrime(2));
    }
    
    @Test
    public void testPrimeThree() {
    	Assert.assertTrue(WeatherAndMathUtils.isPrime(3));
    }
    
    @Test
    public void testPrimeFour() {
    	Assert.assertFalse(WeatherAndMathUtils.isPrime(4));
    }
}