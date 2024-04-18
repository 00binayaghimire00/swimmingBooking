package Controller;

import Model.BookingData;
import Main.Main;
import Model.BookingDataController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookingDataControllerTest {

    private static BookingDataController bookingDataController;

    @BeforeAll
    public static void setUp() {
        bookingDataController = new BookingDataController();
    }


    @Test
    void testMakeBooking() {
        String bookingId = "";
        int bookingParticipants = 0;
        String UID = "";
        BookingDataController.makeBooking(bookingId, bookingParticipants, UID);
        Assertions.assertFalse(BookingData.userLessonRecord.get(bookingId).contains(Main.Uid), "User should be able to make a booking");
    }


    @Test
    public void testAddUser() {
        Map<String, ArrayList<String>> usersBookedStatus = new HashMap<>();
        String bookingID = "TEST_BOOKING";
        String userID = "TEST_USER";
        BookingDataController.addUser(usersBookedStatus, bookingID, userID);
        assertTrue(usersBookedStatus.containsKey(bookingID));
        assertTrue(usersBookedStatus.get(bookingID).contains(userID));
        bookingDataController.addUser(usersBookedStatus, bookingID, "OTHER_USER");
        assertTrue(usersBookedStatus.get(bookingID).contains("OTHER_USER"));
    }

    @Test
    public void testAddBookedData() {
        ArrayList<ArrayList<Object>> bookedDate = new ArrayList<>();
        String BID = "TEST_BOOKING";
        String Day = "Monday";
        int Date = 1;
        String Month = "January";
        int Time = 10;
        String Coach = "John";
        int Grade = 1;
        int Participants = 5;
        int Booked = 1;
        int Cancelled = 0;
        int Attended = 0;
        int Rating = 0;
        String Review = "";
        bookingDataController.addBookedData(BID, Day, Date, Month, Time, Coach, Grade, Participants, Booked, Cancelled, Attended, Rating, Review);
        assertNotEquals(1, bookedDate.size());
    }

    @Test
    void testAddAttendanceRecord() {
        String month = "APR";
        String attendanceKey = "aprAttendanceRecord";
        BookingDataController.addAttendanceRecord(month);
        Assertions.assertEquals(1, (int) BookingData.attendanceRecord.get(attendanceKey), "Attendance record should be incremented");
    }
}
