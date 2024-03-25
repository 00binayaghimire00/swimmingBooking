import java.util.Scanner;

public class Swimming {

    public static void swimmingBookingStart(){
        try{
            Scanner reader = new Scanner(System.in);
            System.out.println("Please Choose Numbers from the followings");
            System.out.println("\t1. Book a Swimming Lesson\n" +
                    "\t2. Change/Cancel a Booking\n" +
                    "\t3. Attend a Swimming Lesson\n" +
                    "\t4. Monthly Learner Report\n" +
                    "\t5. Monthly Coach Report\n" +
                    "\t6. Exit the System\n");
            System.out.println("Enter: ");
            int chooseNumber = reader.nextInt();
            Student student = new Student();
            Coach coach = new Coach();
            if(chooseNumber>=1 && chooseNumber<8 ){
                switch (chooseNumber){
                    case 1:
                        student.bookingClasses();
                    case 2:
                        student.bookingChanges();
                    case 3:
                        student.attendSwimming();
                    case 4:
                        student.lernerMonthlyReport();
                    case 5:
                        coach.coachMonthlyReport();
                    case 6:
                        exit();
                }
            }else {
                System.out.println("Invalid Input..");
                swimmingBookingStart();
            }
        }catch (Exception e) {
            System.err.println("Invalid Input ( Main Method )..");
            swimmingBookingStart();
        }
    }
    public static void exit() {
        System.out.println("Exiting the system...");
        System.exit(0);
    }
}
