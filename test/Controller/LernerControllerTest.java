package Controller;

import Model.BookingData;
import Main.Main;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;

class LernerControllerTest {

    private ByteArrayOutputStream outputStreamCaptor;
    private PrintStream originalOut;

    @BeforeEach
    public void setUp() {
        this.outputStreamCaptor = new ByteArrayOutputStream();
        this.originalOut = System.out;
        System.setOut(new PrintStream(this.outputStreamCaptor));
        BookingData.bookedDate = new ArrayList<>();
        BookingData.userLessonRecord = new HashMap<>();
        ArrayList<Object> bookingInfo = new ArrayList<>(Arrays.asList("W3APR56P", "user1", "swimming", "coach1", 1, "coach1", 1, "location1", "time1", "date1", 50.0, 0, ""));
        BookingData.bookedDate.add(bookingInfo);
        BookingData.userLessonRecord.put("W3APR56P", new ArrayList<>());
        Main.userCancelledLesson = 0;
    }

    @AfterEach
    public void tearDown() {
        System.setOut(this.originalOut);
        this.outputStreamCaptor = null;
        this.originalOut = null;
    }

    @Test
    public void testBookingLesson() {
        String userId = "";
        String chosenBookingID = "";
        boolean result = LernerController.bookingLesson(chosenBookingID, userId);
        assertFalse(result);
    }

//    @Test
//    void testBookingChanges() {
//        String chosenBookingID = "testBookingID";
//        int choosenOption = 1;
//        String userID = "testUserID";
//        Main.Uid = userID;
//        boolean result = bookingChanges(chosenBookingID);
//        Assertions.assertFalse(result, "The booking should have been changed");
//    }

    @Test
    public void testAttendSwimming() {
        ArrayList<Object> bookedData = new ArrayList<>();
        ArrayList<Object> bookingInfo = new ArrayList<>(Arrays.asList("booking1", "user1", "swimming", "coach1", 1, "coach1", 1, "location1", "time1", "date1", 50.0, 0, ""));
        bookedData.add(bookingInfo);
        Assertions.assertEquals(0, bookingInfo.get(11));
        Assertions.assertEquals("", bookingInfo.get(12));
    }

//    @Test
//    public void testLernerMonthlyReport() {
//        LearnerData.LearnerData.add(new ArrayList<>(Arrays.asList("UID1", "John", 10, "1234567890", "Male", 3, 5, 2, 3)));
//        LearnerData.LearnerData.add(new ArrayList<>(Arrays.asList("UID2", "Alice", 8, "9876543210", "Female", 4, 3, 1, 4)));
//
//        LearnerData.lernerStatusRecord.add(new ArrayList<>(Arrays.asList("MON", 4, 1, "MAR", 10, "Coach1", 3, "UID1", "Booked")));
//        LearnerData.lernerStatusRecord.add(new ArrayList<>(Arrays.asList("TUE", 5, 2, "MAR", 11, "Coach2", 4, "UID2", "Cancelled")));
//        LearnerData.lernerStatusRecord.add(new ArrayList<>(Arrays.asList("WED", 6, 3, "MAR", 12, "Coach3", 2, "UID1", "Attended")));
//        String expectedOutput = "Report of JOHN\n" +
//                "Day: MON        Month: MAR        Date: 4          Time: From 10 to 11       Coach: Coach1    Grade: 3        Status: Booked\n" +
//                "Day: WED        Month: MAR        Date: 6          Time: From 12 to 13       Coach: Coach3    Grade: 2        Status: Attended\n" +
//                "Booked: 2   Cancelled: 1   Attended: 1\n\n" +
//                "Report of ALICE\n" +
//                "Day: TUE        Month: MAR        Date: 5          Time: From 11 to 12       Coach: Coach2    Grade: 4        Status: Cancelled\n" +
//                "No Data is available...\n\n" +
//                "Monthly Report of the Learner \n";
//
//        LernerController.lernerMonthlyReport(3); // Passing March as the month number
//        assertEquals(expectedOutput.trim(), outputStreamCaptor.toString().trim());
//    }

    @Test
    public void testRegisterLerner() {
        String name = "John Doe";
        int age = 6;
        String phoneNumber = "1234567890";
        String gender = "M";
        int grade = 1;
        LernerController.registerLerner(name, age, phoneNumber, gender, grade);
    }
}
