package Controller;

import Model.LearnerData;
import Model.StudentDataController;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class StudentControllerDataTest {

    @Test
    public void testCreateStudent() {
        String uid = "TEST001";
        String name = "Test";
        int age = 15;
        String phoneNumber = "07123456789";
        String gender = "M";
        int grade = 10;
        int booked = 1;
        int cancelled = 0;
        int attended = 1;
        StudentDataController.createStudent(uid, name, age, phoneNumber, gender, grade, booked, cancelled, attended);
        ArrayList<Object> student = (ArrayList<Object>) LearnerData.LearnerData.get(LearnerData.LearnerData.size() - 1);
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

}
