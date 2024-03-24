import java.util.ArrayList;
import java.util.Arrays;

public class Data {

    public Data() {
    }
    static ArrayList<Object> studentData = new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList("JAM145", "James", 7, "07400123456", "M", 0)),
            new ArrayList<>(Arrays.asList("EMI769", "Emily", 11, "07700234567", "F", 4)),
            new ArrayList<>(Arrays.asList("OLI678", "Oliver", 6, "07500345678", "M", 2)),
            new ArrayList<>(Arrays.asList("CHA042", "Charlotte", 5, "07800456789", "F", 1))
            ));

    public static ArrayList<Object> getStudentData() {
        return studentData;
    }

    public void setStudentData(ArrayList<Object> studentData) {
        Data.studentData = studentData;
    }

    static void createStudent(String uid, String name, int age, String phoneNumber, String gender, int grade) {
        ArrayList<Object> student = new ArrayList<>();
        student.add(uid);
        student.add(name);
        student.add(age);
        student.add(phoneNumber);
        student.add(gender);
        student.add(grade);
        studentData.add(student);
    }

}