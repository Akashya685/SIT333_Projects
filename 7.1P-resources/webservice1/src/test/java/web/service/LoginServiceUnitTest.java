package web.service;

import org.junit.Assert;
import org.junit.Test;

public class LoginServiceUnitTest {

	@Test
	public void testValidLogin() {
		Assert.assertTrue(LoginService.login("ahsan", "ahsan_pass", "2000-01-01"));
	}
	
	@Test
	public void testInvalidUsername() {
		Assert.assertFalse(LoginService.login("wrong", "ahsan_pass", "2000-01-01"));
	}
	
	@Test
	public void testInvalidPassword() {
		Assert.assertFalse(LoginService.login("ahsan", "wrong_pass", "2000-01-01"));
	}
	
	@Test
	public void testInvalidDob() {
		Assert.assertFalse(LoginService.login("ahsan", "ahsan_pass", "1999-01-01"));
	}
	
	@Test
	public void testNullUsername() {
		Assert.assertFalse(LoginService.login(null, "ahsan_pass", "2000-01-01"));
	}
	
	@Test
	public void testNullPassword() {
		Assert.assertFalse(LoginService.login("ahsan", null, "2000-01-01"));
	}
	
	@Test
	public void testNullDob() {
		Assert.assertFalse(LoginService.login("ahsan", "ahsan_pass", null));
	}
	
	@Test
	public void testEmptyValues() {
		Assert.assertFalse(LoginService.login("", "", ""));
	}
	
	@Test
	public void testPartiallyEmptyValues() {
		Assert.assertFalse(LoginService.login("ahsan", "", "2000-01-01"));
	}
	
	@Test
	public void testLoginServiceConstructor() {
		LoginService service = new LoginService();
		Assert.assertNotNull(service);
	}
}