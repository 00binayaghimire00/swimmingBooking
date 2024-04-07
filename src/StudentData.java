import java.util.*;

public class StudentData {

    public StudentData() {
    }

    // uid 0 , name 1, age 2, phone number 3, gender 4, grade 5, booked 6, cancelled 7, attained 8
    static ArrayList<Object> studentData = new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList("JAM145", "James", 7, "07400123456", "M", 0, 0 ,0 ,0)),
            new ArrayList<>(Arrays.asList("EMI769", "Emily", 11, "07700234567", "F", 4, 0 ,0 ,0)),
            new ArrayList<>(Arrays.asList("OLI678", "Oliver", 6, "07500345678", "M", 2, 0 ,0 ,0)),
            new ArrayList<>(Arrays.asList("CHA042", "Charlotte", 5, "07800456789", "F", 1, 0 ,0 ,0))
            ));

    public static ArrayList<Object> getStudentData() {
        return studentData;
    }

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

}