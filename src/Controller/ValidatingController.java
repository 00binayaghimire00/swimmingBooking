package Controller;
import Data.BookingData;
import Data.StudentData;
import ExceptionHandeling.InputHandeling;
import Main.Main;
import View.SwimmingLessonView;

import java.util.ArrayList;
import static Data.BookingData.bookingData;

public class ValidatingController {
    public static int checkAge(int age) {
        while (age < 4 || age > 11) {
            System.out.println("Your age must be between 4 and 11. Please enter your age again: ");
            age = InputHandeling.getUserIntInput();

        }
        return age;
    }

    public static String checkPhoneNumber(String phoneNumber) {
        while (!phoneNumber.matches("\\d{10}")) {
            System.out.println("Invalid input. Please enter a 10-digit phone number: ");
            phoneNumber = InputHandeling.getUserStringInput();
        }
        return phoneNumber;
    }

    public static int checkGrade(int grade) {
        while (grade < 1 || grade > 5) {
            System.out.println("Your grade must be between 1 and 5. Please enter your grade again: ");
            grade = InputHandeling.getUserIntInput();
        }
        return grade;
    }

    public static void checkingUser(String choosenOption) {
        checkingYorM(choosenOption);
        if (choosenOption.equals("Y")) {
            StudentDataController.displayUsersList();
        }
        System.out.println("Please enter your name:");
        String checkName = InputHandeling.getUserStringInput().toUpperCase();
        checkingUserName(checkName);
    }

    public static String bookingIDCheck(String chosenBookingID) {
        boolean validBookingID = false;
        while (!validBookingID) {
            for (Object bookingArray : bookingData) {
                ArrayList<Object> bookingInfo = (ArrayList<Object>) bookingArray;
                String bookingID = (String) bookingInfo.get(0);
                if (chosenBookingID.equals(bookingID)) {
                    validBookingID = true;
                    break;
                }
            }
            if (!validBookingID) {
                System.out.println("Invalid booking ID.");
                SwimmingLessonView.swimmingBookingStart();
            }
        }
        return chosenBookingID;
    }

    public static String userbookingStatusCheck(String choosenBookingID){
        if (BookingData.userAttendedStatus.containsKey(choosenBookingID) &&
                BookingData.userAttendedStatus.get(choosenBookingID).contains(Main.Uid)) {
            System.out.println("\033[0;31m"+"You already attended this lesson."+"\033[0m");
            SwimmingLessonView.swimmingBookingStart();
        }
        if (BookingData.usersCancelledStatus.containsKey(choosenBookingID) &&
                BookingData.usersCancelledStatus.get(choosenBookingID).contains(Main.Uid)) {
            System.out.println("\033[0;31m"+"You already cancelled this lesson."+"\033[0m");
            SwimmingLessonView.swimmingBookingStart();
        }
        return choosenBookingID;
    }

    public static void checkingYorM(String choosenOption){
        while (!choosenOption.equals("Y") && !choosenOption.equals("N")) {
            System.out.println("Invalid input. Please enter 'Y' or 'N':");
            choosenOption = InputHandeling.getUserStringInput().toUpperCase();
        }
    }

    public static void checkingUserName(String chosenName){
        boolean validName = false;
        while (!validName) {
            for (Object arrayName : StudentData.studentData) {
                ArrayList<Object> studentInfo = (ArrayList<Object>) arrayName;
                String name = ((String) studentInfo.get(1)).toUpperCase();
                if (name.equals(chosenName)) {
                    validName = true;
                    Main.Name = ((String) studentInfo.get(1)).toUpperCase();
                    Main.Uid = (String) studentInfo.get(0);
                    Main.Grade = (int) studentInfo.get(5);
                    Main.userAttendedLessons = (int) studentInfo.get(8);
                    Main.userCancelledLesson = (int) studentInfo.get(7);
                    Main.userBookedLessons = (int) studentInfo.get(6);
                    break;
                }
            }
            if (!validName) {
                System.out.println("Invalid name. Please enter your name again:");
                chosenName = InputHandeling.getUserStringInput().toUpperCase();
            }
        }
    }
}
