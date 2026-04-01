package sit707_week4;
import org.junit.Assert;
import org.junit.Test;
/**
 * Tests functions in LoginForm.
 * @author Ahsan Habib
 */
public class LoginFormTest 
{

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
    public void testFailEmptyUsernameAndEmptyPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login(null, null);
		Assert.assertTrue(status.isLoginSuccess() == false);
		Assert.assertEquals("Empty Username", status.getErrorMsg());
    }
	
	@Test
	public void testFailEmptyUsernameAndWrongPassword() {
		LoginStatus status = LoginForm.login(null, "xyz");
		Assert.assertFalse(status.isLoginSuccess());
		Assert.assertEquals("Empty Username", status.getErrorMsg());
	}
	
	@Test
	public void testFailWrongUsernameAndWrongPassword() {
		LoginStatus status = LoginForm.login("abc", "xyz");
		Assert.assertFalse(status.isLoginSuccess());
		Assert.assertEquals("Credential mismatch", status.getErrorMsg());}
	@Test
	public void testFailCorrectUsernameAndEmptyPassword() {
		LoginStatus status = LoginForm.login("ahsan", null);
		Assert.assertFalse(status.isLoginSuccess());
		Assert.assertEquals("Empty Password", status.getErrorMsg());
	}
	@Test
	public void testFailCorrectUsernameAndWrongPassword() {
		LoginStatus status = LoginForm.login("ahsan", "xyz");
		Assert.assertFalse(status.isLoginSuccess());
		Assert.assertEquals("Credential mismatch", status.getErrorMsg());
	}
	@Test
	public void testFailEmptyUsernameAndCorrectPassword() {
		LoginStatus status = LoginForm.login(null, "ahsan_pass");
		Assert.assertFalse(status.isLoginSuccess());
		Assert.assertEquals("Empty Username", status.getErrorMsg());
	}
	@Test
	public void testFailWrongUsernameAndCorrectPassword() {
		LoginStatus status = LoginForm.login("abc", "ahsan_pass");
		Assert.assertFalse(status.isLoginSuccess());
		Assert.assertEquals("credential mismatch", status.getErrorMsg());
	}
	
	@Test
	public void testSuccessCorrectUsernameAndCorrectPassword() {
		LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
		Assert.assertTrue(status.isLoginSuccess());
		Assert.assertEquals("123456", status.getErrorMsg());
	}
	
	@Test
	public void testValidateCodeWithEmptyCode() {
		Assert.assertFalse(LoginForm.validateCode(null));
	}
	@Test
	public void testValidateCodeWithWrongCode() {
		Assert.assertFalse(LoginForm.validateCode("abcd"));
	}
	@Test
	public void testValidateCodeWithCorrectCode() {
		Assert.assertTrue(LoginForm.validateCode("123456"));
	}
}