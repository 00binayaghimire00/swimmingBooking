package Controller;

import java.util.ArrayList;

import static Data.StudentData.studentData;

public class StudentDataController {
    public static void createStudent(String uid, String name, int age, String phoneNumber, String gender, int grade, int booked, int cancelled, int attended) {
        ArrayList<Object> student = new ArrayList<>();
        student.add(uid);
        student.add(name);
        student.add(age);
        student.add(phoneNumber);
        student.add(gender);
        student.add(grade);
        student.add(booked);
        student.add(cancelled);
        student.add(attended);
        studentData.add(student);
    }

    public static void displayUsersList() {
        for (Object lernersArray : studentData) {
            ArrayList<Object> studentInfo = (ArrayList<Object>) lernersArray;
            String name = (String) studentInfo.get(1);
            int age = (int) studentInfo.get(2);
            int grade = (int) studentInfo.get(5);
            System.out.printf("Name: %-15s\tAge: %1d\t\tGrade: %1d\n", name, age, grade);
        }
    }
}
