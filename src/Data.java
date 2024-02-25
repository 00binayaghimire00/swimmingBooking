import java.util.ArrayList;
import java.util.Arrays;

public class Data {

    public Data() {
    }
    static ArrayList<Object> studentData = new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList("James", 7, "07400123456", "M", 0)),
            new ArrayList<>(Arrays.asList("Emily", 11, "07700234567", "F", 0)),
            new ArrayList<>(Arrays.asList("Oliver", 6, "07500345678", "M", 0)),
            new ArrayList<>(Arrays.asList("Charlotte", 5, "07800456789", "F",0))
            ));

    public static ArrayList<Object> getStudentData() {
        return studentData;
    }

    public void setStudentData(ArrayList<Object> studentData) {
        Data.studentData = studentData;
    }

    static void createStudent(String name, int age, String phoneNumber, String gender, int grade) {
        ArrayList<Object> student = new ArrayList<>();
        student.add(name);
        student.add(age);
        student.add(phoneNumber);
        student.add(gender);
        student.add(grade);
        studentData.add(student);
    }
}