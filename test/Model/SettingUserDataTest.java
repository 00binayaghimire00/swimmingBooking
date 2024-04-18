package Model;

import Main.Main;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SettingUserDataTest {

    @Test
    public void testSetUserRecord() {
        LearnerData.LearnerData.clear();
        LearnerData.LearnerData.add(new ArrayList<>(Arrays.asList("UID1", "John", 10, "1234567890", "Male", 3, 5, 2, 3)));
        LearnerData.LearnerData.add(new ArrayList<>(Arrays.asList("UID2", "Alice", 8, "9876543210", "Female", 4, 3, 1, 4)));

        Main.Uid = "UID1";
        Main.Grade = 4;
        Main.userBookedLessons = 6;
        Main.userCancelledLesson = 3;
        Main.userAttendedLessons = 4;

        List<Object> expectedUserRecord = new ArrayList<>(Arrays.asList("UID1", "John", 10, "1234567890", "Male", 4, 6, 3, 4));

        SettingUserData.setUserRecord();

        List<Object> actualUserRecord = null;
        for (Object userArray : LearnerData.LearnerData) {
            List<Object> userInfo = (List<Object>) userArray;
            String userID = (String) userInfo.get(0);
            if (Main.Uid.equals(userID)) {
                actualUserRecord = userInfo;
                break;
            }
        }

        assertEquals(expectedUserRecord, actualUserRecord);
    }
}
