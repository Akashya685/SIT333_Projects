package edu.deakin;

import org.junit.Assert;
import org.junit.Test;

public class SimpleLoginFormTest {

    @Test
    public void testCorrectUsernameAndCorrectPassword() {
        String result = SimpleLoginForm.login("testuser", "testpass");
        Assert.assertEquals("success", result);
    }

    @Test
    public void testCorrectUsernameAndWrongPassword() {
        String result = SimpleLoginForm.login("testuser", "wrongpass");
        Assert.assertEquals("password mismatch", result);
    }

    @Test
    public void testWrongUsernameAndCorrectPassword() {
        String result = SimpleLoginForm.login("wronguser", "testpass");
        Assert.assertEquals("username mismatch", result);
    }

    @Test
    public void testWrongUsernameAndWrongPassword() {
        String result = SimpleLoginForm.login("wronguser", "wrongpass");
        Assert.assertEquals("username mismatch", result);
    }
}