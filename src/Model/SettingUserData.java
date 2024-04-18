package Model;
import Main.Main;
import java.util.List;

public class SettingUserData {
    public static void setUserRecord() {
        for (Object userArray : LearnerData.LearnerData) {
            List<Object> userInfo = (List<Object>) userArray;
            String userID = (String) userInfo.get(0);
            if (Main.Uid.equals(userID)) {
                userInfo.set(5, Main.Grade);
                userInfo.set(6, Main.userBookedLessons);
                userInfo.set(7, Main.userCancelledLesson);
                userInfo.set(8, Main.userAttendedLessons);
            }
        }
    }
}