package Model;

import java.util.ArrayList;

import static Model.LearnerData.LearnerData;

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
        LearnerData.add(student);
    }

    public static void displayUsersList() {
        for (Object lernersArray : LearnerData) {
            ArrayList<Object> studentInfo = (ArrayList<Object>) lernersArray;
            String name = (String) studentInfo.get(1);
            int age = (int) studentInfo.get(2);
            int grade = (int) studentInfo.get(5);
            System.out.printf("Name: %-15s\tAge: %1d\t\tGrade: %1d\n", name, age, grade);
        }
    }

    public static void addLernerStatusRecord(String BookingID, String Day, int Date, String Month, int Time , String Coach, int Grade, String UserID, String Status) {
        ArrayList<Object> newLearnerStatusRecord = new ArrayList<>();
        newLearnerStatusRecord.add(BookingID);
        newLearnerStatusRecord.add(Day);
        newLearnerStatusRecord.add(Date);
        newLearnerStatusRecord.add(Month);
        newLearnerStatusRecord.add(Time);
        newLearnerStatusRecord.add(Coach);
        newLearnerStatusRecord.add(Grade);
        newLearnerStatusRecord.add(UserID);
        newLearnerStatusRecord.add(Status);
        Model.LearnerData.lernerStatusRecord.add(newLearnerStatusRecord);
    }

}
