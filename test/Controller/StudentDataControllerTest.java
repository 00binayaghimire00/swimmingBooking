package Controller;

import Model.LearnerData;
import Model.StudentDataController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentDataControllerTest {

    @BeforeEach
    void setUp() {
        // Clear student data before each test
        LearnerData.LearnerData.clear();
    }

    @Test
    void testCreateStudent() {
        String uid = "123ABC";
        String name = "John Doe";
        int age = 10;
        String phoneNumber = "1234567890";
        String gender = "Male";
        int grade = 5;
        int booked = 2;
        int cancelled = 1;
        int attended = 1;

        StudentDataController.createStudent(uid, name, age, phoneNumber, gender, grade, booked, cancelled, attended);
        ArrayList<Object> student = (ArrayList<Object>) LearnerData.LearnerData.get(0);
        assertEquals(uid, student.get(0));
        assertEquals(name, student.get(1));
        assertEquals(age, student.get(2));
        assertEquals(phoneNumber, student.get(3));
        assertEquals(gender, student.get(4));
        assertEquals(grade, student.get(5));
        assertEquals(booked, student.get(6));
        assertEquals(cancelled, student.get(7));
        assertEquals(attended, student.get(8));
    }

    @Test
    void testDisplayUsersList() {
        StudentDataController.displayUsersList();
    }
}
