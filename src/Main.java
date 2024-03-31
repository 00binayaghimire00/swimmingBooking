import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static String Name; // Global variable for User-Name
    public static String Uid; // Global variable for Uid
    public static int Grade;
    public static void main(String[] args) {
        Booking b = new Booking();
        System.out.println(b.userLessonRecord);
        ArrayList<Object> studentData = Data.getStudentData();
        Scanner read = new Scanner(System.in);
        System.out.println("Welcome to Hatfield Junior Swimming School");
        Student student = new Student();
        student.checkingUser();
        Swimming.swimmingBookingStart();
    }
}