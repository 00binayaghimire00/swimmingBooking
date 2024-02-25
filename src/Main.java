import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Hatfield Junior Swimming School");
        swimmingStart();
        ArrayList<Object> data = Data.getStudentData();
        System.out.println(data);
    }

    public static void swimmingStart(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Please Choose Numbers from the followings");
        System.out.println("\t1. Book a Swimming Lesson\n" +
                        "\t2. Change/Cancel a Booking\n" +
                        "\t3. Attend a Swimming Lesson\n" +
                        "\t4. Monthly Learner Report\n" +
                        "\t5. Monthly Coach Report\n" +
                        "\t6. Register a New Learner\n" +
                        "\t7. Exit the System\n");
        System.out.println("Enter: ");
        int chooseNumber = reader.nextInt();
        Student student = new Student();
        Coach   coach = new Coach();
        try{
            if(chooseNumber>=1 && chooseNumber<8 ){
                if(chooseNumber == 1){
                    student.bookingClasses();
                } else if (chooseNumber == 2) {
                    student.bookingChanges();
                } else if (chooseNumber == 3) {
                    student.attendSwimming();
                } else if (chooseNumber == 4) {
                    student.lernerMonthlyReport();
                } else if (chooseNumber == 5) {
                    coach.coachMonthlyReport();
                } else if (chooseNumber == 6) {
                    student.registerLerner();
                } else if (chooseNumber == 7) {
                    exit();
                }else {
                    System.out.println("Invalid Input..");
                    swimmingStart();
                }
            }
        }
        catch (Exception e) {
            System.err.println("Invalid Input..");
            swimmingStart();
        }
    }
    public static void exit() {
        System.out.println("Exiting the system...");
        System.exit(0);
    }
}