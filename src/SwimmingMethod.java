import java.util.ArrayList;
import java.util.Scanner;
 public  class SwimmingMethod {

 public static void swimmingBookingStart(){
     try{
         Scanner reader = new Scanner(System.in);
         System.out.println(StudentData.studentData);
         System.out.println("Booked: "+Main.userBookedLessons+"\tCancelled: "+Main.userCancelledLesson+"\tAttained: "+Main.userAttendedLessons);
         System.out.println("Please Choose Numbers from the followings");
         System.out.println("""
                    \t1. Book a Swimming Lesson
                    \t2. Change/Cancel a Booking
                    \t3. Attend a Swimming Lesson
                    \t4. Monthly Learner Report
                    \t5. Monthly Coach Report
                    \t6. Register New Lerner
                    \t7. Exit the System
                    """);
         System.out.println("Enter: ");
         int chooseNumber = reader.nextInt();
         StudentMethod student = new StudentMethod();
         CoachData coach = new CoachData();
         if(chooseNumber>=1 && chooseNumber<8 ){
             switch (chooseNumber){
                 case 1:
                     student.bookingClasses();swimmingBookingStart();
                     break;
                 case 2:
                     student.bookingChanges();swimmingBookingStart();
                     break;
                 case 3:
                     student.attendSwimming();swimmingBookingStart();
                     break;
                 case 4:
                     student.lernerMonthlyReport();swimmingBookingStart();
                     break;
                 case 5:
                     coach.coachMonthlyReport();swimmingBookingStart();
                     break;
                 case 6:

                     student.registerLerner();
                     break;
                 case 7:
                     exit();
                     break;
             }
         }else {
             System.out.println("Invalid Input..");
             swimmingBookingStart();
         }
     }catch (Exception e) {
         System.out.println(e.getMessage());
         System.out.println("Invalid Input ( Main Method )..");
         swimmingBookingStart();
     }
 }


 public static void setUserRecord(){
     for(Object userArray : StudentData.studentData){
         ArrayList<Object> userInfo = (ArrayList<Object>) userArray;
         String userID = (String) userInfo.get(0);
         if(Main.Uid.equals(userID)){
             userInfo.set(5, Main.Grade);
             userInfo.set(6, Main.userBookedLessons);
             userInfo.set(7, Main.userCancelledLesson);
             userInfo.set(8, Main.userAttendedLessons);
         }
     }
 }
 public static void exit() {
     // uid 0 , name 1, age 2, phone number 3, gender 4, grade 5, booked 7, cancelled 8, attained 9
     setUserRecord();
     System.out.println("Exiting the system...");
     System.exit(0);
 }

 }