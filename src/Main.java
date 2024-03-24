import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static String Name; // Global variable for User-Name
    public static String Uid; // Global variable for Uid

    public static int Grade;

    public static void main(String[] args) {
        ArrayList<Object> studentData = Data.getStudentData();
        Scanner read = new Scanner(System.in);
        System.out.println("Welcome to Hatfield Junior Swimming School");
        System.out.println("Are you existing User. Type 'Y' for Yes and 'N' for No.");
        String checkOption = read.next().toUpperCase();
        Student student = new Student();
        if (checkOption.equals("Y")){
            System.out.println("Please Enter your Name");
            String checkName = read.next().toUpperCase();
            boolean validName = false;
            while (!validName) {
                for (Object arrayName : Data.studentData) {
                    ArrayList<Object> studentInfo = (ArrayList<Object>) arrayName;
                    String name = ((String) studentInfo.get(1)).toUpperCase();
                    if (name.equals(checkName)) {
                        validName = true;
                        Name = ((String) studentInfo.get(1)).toUpperCase();
                        Uid = (String) studentInfo.get(0);
                        Grade = (int) studentInfo.get(5);
                        break;
                    }
                }
                if (!validName) {
                    System.out.println("\nInvalid name...");
                    System.out.println("Please enter your name again: ");
                    checkName = read.next().toUpperCase();
                }
            }

        }else if (checkOption.equals("N")){
            System.out.println("Do you with to register or exit the system");
            System.out.println("1. Add as New User. \n2. Exit");
            int checkingToAddUser = read.nextInt();
            switch (checkingToAddUser){
                case 1:
                    student.registerLerner();
                    break;
                case 2:
                    Swimming.exit();
                    break;
                default:
                    System.out.println("Invalid Input.\nPlease choose the right option");
                    checkingToAddUser = read.nextInt();
                    break;
            }
        }else{
            System.out.println("Invalid Input.\nPlease choose the right option");
            checkOption = read.next().toUpperCase();
        }
        Swimming.swimmingBookingStart();
    }
}