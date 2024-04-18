package View;

import Model.CoachDataController;
import Controller.DisplayController;
import Controller.LernerController;
import Controller.ValidatingController;
import Model.LearnerData;
import ExceptionHandeling.ExitSystem;
import ExceptionHandeling.InputHandeling;
import Main.Main;

import java.util.InputMismatchException;

import static Controller.LernerController.availableLessonsDisplayAndBooking;
import static Controller.ValidatingController.bookingIDCheck;
import static Controller.ValidatingController.userbookingStatusCheck;

public class SwimmingLessonView {

    public static void swimmingBookingStart() {
        try {
            System.out.println(LearnerData.LearnerData);
            System.out.println("Booked: " + Main.userBookedLessons + "\tCancelled: " + Main.userCancelledLesson + "\tAttained: " + Main.userAttendedLessons);
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
            int chooseNumber = InputHandeling.getUserIntInput();
            if (chooseNumber >= 1 && chooseNumber < 8) {
                switch (chooseNumber) {
                    case 1:
                        ValidatingController.checkingUser(yesOrNo());
                        availableLessonsDisplayAndBooking();
                        swimmingBookingStart();
                        break;
                    case 2:
                        System.out.println("You need to verify by giving your name\nDo you wish to see your name: 'Y' or 'N'");
                        ValidatingController.checkingUser(InputHandeling.getUserStringInput().toUpperCase());
                        DisplayController.displayUsersLesson();
                        System.out.println("Please enter the your lesson booking ID");
                        String chosenBookingID = InputHandeling.getUserStringInput().toUpperCase();
                        bookingIDCheck(chosenBookingID);
                        userbookingStatusCheck(chosenBookingID);
                        int choosenOption = 0;
                        System.out.println("Do you with to Update or Cancel booking");
                        System.out.println("\t1. Cancel\n" +
                                "\t2. Update");
                        choosenOption = InputHandeling.getUserIntInput();
                        if (!(choosenOption == 1) && !(choosenOption == 2)) {
                            System.out.println("Invalid Input..");
                            System.out.println("Please give the correct option");
                            choosenOption = InputHandeling.getUserIntInput();
                        }
                        LernerController.bookingChanges(chosenBookingID);
                        if(choosenOption == 2){
                            System.out.println("Updating your booking");
                            LernerController.isBookingDone = false;
                            availableLessonsDisplayAndBooking();
                        }
                        swimmingBookingStart();
                        break;
                    case 3:
                        System.out.println("You need to verify by giving your name\nDo you wish to see your name: 'Y' or 'N'");
                        ValidatingController.checkingUser(InputHandeling.getUserStringInput().toUpperCase());
                        DisplayController.displayUsersLesson();
                        System.out.println("Please enter the your lesson booking ID");
                        chosenBookingID = InputHandeling.getUserStringInput().toUpperCase();
                        bookingIDCheck(chosenBookingID);
                        userbookingStatusCheck(chosenBookingID);
                        LernerController.attendSwimming(chosenBookingID);
                        swimmingBookingStart();
                        break;
                    case 4:
                        System.out.println("Enter the month: eg 3 for March");
                        int chooseMonthNumber = InputHandeling.getUserIntInput();
                        LernerController.lernerMonthlyReport(chooseMonthNumber);
                        swimmingBookingStart();
                        break;
                    case 5:
                        System.out.println("Enter the month: eg 3 for March");
                        chooseMonthNumber = InputHandeling.getUserIntInput();
                        CoachDataController.coachMonthlyReport(chooseMonthNumber);
                        swimmingBookingStart();
                        break;
                    case 6:
                        System.out.println("Welcome! Please fill the form below");
                        System.out.println("Please Enter your name: ");
                        String name = InputHandeling.getUserStringInput();
                        System.out.println("Please Enter your age: ");
                        int age = ValidatingController.checkAge(InputHandeling.getUserIntInput());
                        System.out.println("Please Enter your phone number: ");
                        String phoneNumber = ValidatingController.checkPhoneNumber(InputHandeling.getUserStringInput());
                        System.out.println("Please Enter your gender: M or F");
                        String gender = InputHandeling.getUserStringInput().toUpperCase();
                        System.out.println("Please Enter your grade: ");
                        int chosenGrade = InputHandeling.getUserIntInput();
                        int grade = ValidatingController.checkGrade(chosenGrade);
                        LernerController.registerLerner(name, age, phoneNumber, gender, grade);
                        SwimmingLessonView.swimmingBookingStart();
                        break;
                    case 7:
                        ExitSystem.exit();
                        break;
                }
            } else {
                System.out.println("\033[0;33m"+"Invalid Input.."+"\033[0m");
                swimmingBookingStart();
            }
        } catch (InputMismatchException e) {
            System.out.println("\033[0;31m"+"Invalid Input ( Main Method ).."+"\033[0m");
            swimmingBookingStart();
        }
    }

    public static String yesOrNo(){
        System.out.println("You need to verify by giving your name\nDo you wish to see your name: 'Y' or 'N'");
        return InputHandeling.getUserStringInput().toUpperCase();
    }
}