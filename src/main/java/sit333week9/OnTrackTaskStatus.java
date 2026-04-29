package sit333week9;

public class OnTrackTaskStatus {

    public String getStatus(String studentId, String taskCode) {

        if (studentId.equals("s224597443") && taskCode.equals("1.1P")) {
            return "Working On It";
        }

        if (studentId.equals("s224597443") && taskCode.equals("5.2C")) {
            return "Ready for Feedback";
        }

        if (studentId.equals("s224597443") && taskCode.equals("6.1P")) {
            return "Need Help";
        }

        return "Not Started";
    }
}