import java.util.ArrayList;

public class Data {
    ArrayList<Object> studentData = new ArrayList<>();

    public ArrayList<Object> getStudentData() {
        return studentData;
    }

    public void setStudentData(ArrayList<Object> studentData) {
        this.studentData = studentData;
    }

    public Data() {

        studentData.add(createStudent("James", 7, "07400123456", "M", 0));
        studentData.add(createStudent("Emily", 11, "07700234567", "F", 0));
        studentData.add(createStudent("Oliver", 6, "07500345678", "M", 0));
        studentData.add(createStudent("Charlotte", 5, "07800456789", "M", 0));
    }
    
    public ArrayList<Object> createStudent(String name, int age, String phoneNumber, String gender, int grade) {
        ArrayList<Object> student = new ArrayList<>();
        student.add(name);
        student.add(age);
        student.add(phoneNumber);
        student.add(gender);
        student.add(grade);
        return student;
    }
}

