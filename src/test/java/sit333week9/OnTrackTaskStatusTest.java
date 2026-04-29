package sit333week9;
//Passing )
import org.junit.Assert;
import org.junit.Test;

public class OnTrackTaskStatusTest {

    @Test
    public void testWorkingOnIt() {
        OnTrackTaskStatus checker = new OnTrackTaskStatus();

        String result = checker.getStatus("s224597443", "1.1P");

        Assert.assertEquals("Working On It", result);
    }

    @Test
    public void testReadyForFeedback() {
        OnTrackTaskStatus checker = new OnTrackTaskStatus();

        String result = checker.getStatus("s224597443", "5.2C");

        Assert.assertEquals("Ready for Feedback", result);
    }

    @Test
    public void testNeedHelp() {
        OnTrackTaskStatus checker = new OnTrackTaskStatus();

        String result = checker.getStatus("s224597443", "6.1P");

        Assert.assertEquals("Need Help", result);
    }

    @Test
    public void testNotStarted() {
        OnTrackTaskStatus checker = new OnTrackTaskStatus();

        String result = checker.getStatus("s224597443", "9.1P");

        Assert.assertEquals("Not Started", result);
    }

    @Test
    public void testDifferentStudent() {
        OnTrackTaskStatus checker = new OnTrackTaskStatus();

        String result = checker.getStatus("s111111111", "1.1P");

        Assert.assertEquals("Not Started", result);
    }
}