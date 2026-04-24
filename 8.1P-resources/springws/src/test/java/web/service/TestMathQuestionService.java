package web.service;

import org.junit.Assert;
import org.junit.Test;

import web.service.MathQuestionService;

public class TestMathQuestionService {

	@Test
	public void testTrueAdd() {
		Assert.assertEquals(MathQuestionService.q1Addition("1", "2"), 3, 0);
	}

	@Test(expected = NumberFormatException.class)
	public void testAddNumber1Empty() {
		MathQuestionService.q1Addition("", "2");
	}	
	
	@Test
	public void testTrueSubtract() {
		Assert.assertEquals(MathQuestionService.q2Subtraction("5", "2"), 3, 0);
	}
	
	@Test(expected = NumberFormatException.class)
	public void testSubtractNumber1Empty() {
		MathQuestionService.q2Subtraction("", "2");
	}

	@Test
	public void testTrueMultiply() {
		Assert.assertEquals(MathQuestionService.q3Multiplication("3", "4"), 12, 0);
	}

	@Test(expected = NumberFormatException.class)
	public void testMultiplyNumber1Empty() {
		MathQuestionService.q3Multiplication("", "4");
	}
}