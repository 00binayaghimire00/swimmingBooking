package Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidatingControllerTest {

    @BeforeEach
    void setUp() {
        // Set up any necessary data before each test
        // For example, populate BookingData and StudentData if needed
    }

    @Test
    void testCheckAge() {
        int validAge = 6;
        assertEquals(validAge, ValidatingController.checkAge(validAge));
    }

    @Test
    void testCheckPhoneNumber() {
        String validPhoneNumber = "1234567890";
        assertEquals(validPhoneNumber, ValidatingController.checkPhoneNumber(validPhoneNumber));
    }

    @Test
    void testCheckGrade() {
        int validGrade = 3;
        assertEquals(validGrade, ValidatingController.checkGrade(validGrade));
    }

    @Test
    void testBookingIDCheck() {
        String validBookingID = "S6APR34P";
        assertEquals(validBookingID, ValidatingController.bookingIDCheck(validBookingID));
    }

}
