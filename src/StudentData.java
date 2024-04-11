import java.util.*;

public class StudentData {

    public StudentData() {
    }

    // uid 0 , name 1, age 2, phone number 3, gender 4, grade 5, booked 6, cancelled 7, attained 8
    public static ArrayList<Object> studentData = new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList("JAM145", "James", 7, "07400123456", "M", 0, 0 ,0 ,0)),
            new ArrayList<>(Arrays.asList("EMI769", "Emily", 11, "07700234567", "F", 3, 0 ,0 ,0)),
            new ArrayList<>(Arrays.asList("OLI678", "Oliver", 6, "07500345678", "M", 2, 0 ,0 ,0)),
            new ArrayList<>(Arrays.asList("CHA042", "Charlotte", 5, "07800456789", "F", 1, 0 ,0 ,0)),
            new ArrayList<>(Arrays.asList("SAM123", "Sam", 8, "07900123456", "M", 1, 0 ,0 ,0)),
            new ArrayList<>(Arrays.asList("AVA456", "Ava", 9, "07900234567", "F", 2, 0 ,0 ,0)),
            new ArrayList<>(Arrays.asList("MAX789", "Max", 10, "07900345678", "M", 3, 0 ,0 ,0)),
            new ArrayList<>(Arrays.asList("LUC012", "Lucy", 11, "07900456789", "F", 4, 0 ,0 ,0)),
            new ArrayList<>(Arrays.asList("JAC345", "Jack", 4, "07900567890", "M", 5, 0 ,0 ,0)),
            new ArrayList<>(Arrays.asList("SOP678", "Sophie", 6, "07900678901", "F", 0, 0 ,0 ,0)),
            new ArrayList<>(Arrays.asList("BEN901", "Ben", 7, "07900789012", "M", 1, 0 ,0 ,0)),
            new ArrayList<>(Arrays.asList("EMM234", "Emma", 5, "07900890123", "F", 4, 0 ,0 ,0)),
            new ArrayList<>(Arrays.asList("ALE567", "Alex", 8, "07900901234", "M", 2, 0 ,0 ,0)),
            new ArrayList<>(Arrays.asList("ELL890", "Ella", 10, "07901012345", "F", 5, 0 ,0 ,0)),
            new ArrayList<>(Arrays.asList("RYA123", "Ryan", 9, "07901123456", "M", 2, 0 ,0 ,0)),
            new ArrayList<>(Arrays.asList("ZOE456", "Zoe", 6, "07901234567", "F", 1, 0 ,0 ,0)),
            new ArrayList<>(Arrays.asList("DAN789", "Daniel", 7, "07901345678", "M", 1, 0 ,0 ,0)),
            new ArrayList<>(Arrays.asList("AMY012", "Amy", 4, "07901456789", "F", 4, 0 ,0 ,0)),
            new ArrayList<>(Arrays.asList("MAT345", "Matthew", 8, "07901567890", "M", 4, 0 ,0 ,0))
            ));
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

    public static void displayUsersList(){
        for (Object lernersArray : studentData) {
            ArrayList<Object> studentInfo = (ArrayList<Object>) lernersArray;
            String name = (String) studentInfo.get(1);
            int age = (int) studentInfo.get(2);
            int grade = (int) studentInfo.get(5);
            System.out.printf("Name: %-15s\tAge: %1d\t\tGrade: %1d\n", name, age, grade);
        }
    }
}