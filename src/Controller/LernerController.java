package Controller;

import Model.*;
import ExceptionHandeling.InputHandeling;
import Main.Main;
import View.SwimmingLessonView;

import java.util.ArrayList;

import static Controller.ValidatingController.bookingIDCheck;

public class LernerController {
    static ArrayList<Object> lessonDisplay = new ArrayList<>();
    public static boolean isBookingDone = false;
    static ArrayList<Object> bookingData = BookingData.bookingData;
    static ArrayList<Object> bookedData = BookingData.bookedDate;

    public static void availableLessonsDisplayAndBooking(){
        System.out.println("\nPlease choose how you want to display the lessons:");
        System.out.println("\t1. By Day \n\t2. By Coach Name \n\t3. By Grade");
        int chosenLessonDisplayOptions = InputHandeling.getUserIntInput();
        if (!(chosenLessonDisplayOptions == 1) && !(chosenLessonDisplayOptions == 2) && !(chosenLessonDisplayOptions == 3)) {
            System.out.println("Invalid Input..");
            System.out.println("Please give the correct option");
            chosenLessonDisplayOptions = InputHandeling.getUserIntInput();
        }
        DisplayController.displayLessonOnOptions(chosenLessonDisplayOptions);
        String UserId = Main.Uid;
        lessonDisplay = new ArrayList<>();
        // array list have id, day, date, month, time, coach, grade, participants, rating, review
        System.out.println("Please enter the available lesson booking ID");
        String chosenBookingID = InputHandeling.getUserStringInput().toUpperCase();
        String newChosenBookingID = bookingIDCheck(chosenBookingID);
        isBookingDone = false;
        bookingLesson(newChosenBookingID, UserId);
        SwimmingLessonView.swimmingBookingStart();
    }

    public static boolean bookingLesson(String chosenBookingID, String UserID) {
        boolean IDavailableInBookedData = false;
        for (Object bookingArray : bookingData) {
            ArrayList<Object> bookingInfo = (ArrayList<Object>) bookingArray;
            String bookingID = (String) bookingInfo.get(0);
            String bookingDay = (String) bookingInfo.get(1);
            int bookingDate = (int) bookingInfo.get(2);
            String bookingMonth = (String) bookingInfo.get(3);
            int bookingTime = (int) bookingInfo.get(4);
            String bookingCoach = ((String) bookingInfo.get(5)).toUpperCase();
            int bookingGrade = (int) bookingInfo.get(6);
            int bookingParticipants = (int) bookingInfo.get(7);
            if (chosenBookingID.equals(bookingID)) {
                if (Main.Grade == bookingGrade || (Main.Grade + 1) == bookingGrade) {
                    BookingDataController.makeBooking(bookingID, bookingParticipants, UserID);
                    bookingInfo.set(7, bookingParticipants + 1);
                    for (Object bookedArray : bookedData) {
                        ArrayList<Object> bookedInfo = (ArrayList<Object>) bookedArray;
                        String bookedID = (String) bookedInfo.get(0);
                        int bookedParticipants = (int) bookedInfo.get(7);
                        int bookedNumber = (int) bookedInfo.get(8);
                        if (bookedID.equals(bookingID)) {
                            IDavailableInBookedData = true;
                            bookedInfo.set(8, bookedNumber + 1);
                            bookedInfo.set(7, bookedParticipants + 1);
                            break;
                        }
                    }
                    if (IDavailableInBookedData) {
                        System.out.println("\033[0;92m"+"Booking confirmed!!"+"\033[0m");
                        System.out.println("You have lesson on " + bookingMonth + " " + bookingDate + ", " + bookingDay + " from " + bookingTime + " to " + (bookingTime + 1));
                        break;
                    } else {
                        int booked = 1;
                        int cancelled = 0;
                        int attended = 0;
                        int rating = 0;
                        String review = " ";
                        // Storing data from bookingData Array to BookedData Array
                        BookingDataController.addBookedData(bookingID, bookingDay, bookingDate, bookingMonth, bookingTime,
                                bookingCoach, bookingGrade, bookingParticipants, booked, cancelled, attended, rating, review);
                        System.out.println("\033[0;92m"+"Booking confirmed!!"+"\033[0m");
                        System.out.println("You have a lesson on " + bookingDay + " " + bookingDate + " " + bookingMonth + ", from " + bookingTime + " to " + (bookingTime + 1) + " o'clock.");


                    }
                    isBookingDone = true;
                    Main.userBookedLessons++;
                    BookingDataController.addUser(BookingData.usersBookedStatus, bookingID, Main.Uid);
                    StudentDataController.addLernerStatusRecord(bookingID, bookingDay, bookingDate, bookingMonth,bookingTime, bookingCoach, bookingGrade, Main.Uid, "Booked");
                    SettingUserData.setUserRecord();
                    System.out.println(BookingData.bookedDate);
                    System.out.println(bookingInfo);
                    break;
                }
            }
        }
        if (!isBookingDone) {
            System.out.println("\033[0;31m"+"Your Grade doesn't match the lesson."+"\033[0m");
        }
        return isBookingDone;
    }

    public static boolean bookingChanges(String chosenBookingID) {
        boolean bookingChanged = false;
        for (Object bookingArray : BookingData.bookedDate) {
            ArrayList<Object> bookingInfo = (ArrayList<Object>) bookingArray;
            String bookingID = (String) bookingInfo.get(0);
            String bookingDay = (String) bookingInfo.get(1);
            int bookingDate = (int) bookingInfo.get(2);
            String bookingMonth = ((String) bookingInfo.get(3)).toUpperCase();
            int bookingTime = (int) bookingInfo.get(4);
            String bookingCoach = ((String) bookingInfo.get(5)).toUpperCase();
            int bookingGrade = (int) bookingInfo.get(6);
            int bookingParticipants = (int) bookingInfo.get(7);
            int bookingCancelled = (int) bookingInfo.get(9);
            if (bookingID.equals(chosenBookingID)) {
                bookingInfo.set(7, bookingParticipants - 1);
                bookingInfo.set(9, bookingCancelled + 1);
                System.out.println("Booking Cancelled!");
                Main.userCancelledLesson++;
                BookingDataController.moveUser(Main.Uid, bookingID, BookingData.usersBookedStatus, BookingData.usersCancelledStatus);
                StudentDataController.addLernerStatusRecord(bookingID, bookingDay, bookingDate, bookingMonth,bookingTime, bookingCoach, bookingGrade, Main.Uid, "Cancelled");
                SettingUserData.setUserRecord();
                bookingChanged = true;
            }
            if (bookingChanged) {
                break;
            }
        }
        return bookingChanged;
    }

    public static void attendSwimming(String chosenBookingID) {
        for (Object bookingArray : bookedData) {
            ArrayList<Object> bookedInfo = (ArrayList<Object>) bookingArray;
            String bookingID = (String) bookedInfo.get(0);
            //"M1MAR45P", "MON", 1, "MAR", 4, "Sophie", 4, 3, 0, 0, 0, 4, "Good coach with g
            String bookingDay = (String) bookedInfo.get(1);
            int bookingDate = (int) bookedInfo.get(2);
            String bookingMonth = ((String) bookedInfo.get(3)).toUpperCase();
            int bookingTime = (int) bookedInfo.get(4);
            String bookingCoach = ((String) bookedInfo.get(5)).toUpperCase();
            int bookingGrade = (int) bookedInfo.get(6);
            if (bookingID.equals(chosenBookingID)) {
                int rating;
                do {
                    System.out.println("Please give ranging from 1 to 5\n\t1: Very dissatisfied\n\t2: Dissatisfied\n\t3: Ok\n\t4: Satisfied\n\t5: Very Satisfied");
                    rating = InputHandeling.getUserIntInput();
                    if (rating <= 0 || rating > 5) {
                        System.out.println("Your rating is more than 5 or in Negative\nPlease try again");
                    }
                } while (rating <= 0 || rating > 5);

                System.out.println("Please write short review on this lesson");
                String newReview = InputHandeling.getUserStringInput();
                String Review = (String) bookedInfo.get(12);
                Review = Review + " | " + newReview;
                int Rating = (int) bookedInfo.get(11);
                bookedInfo.set(11, Rating + rating);
                bookedInfo.set(12, Review);
                Main.userAttendedLessons++;
                String Coach = (String) bookedInfo.get(5);
                CoachDataController.calculatingCoachRating(Coach, Rating);
                BookingDataController.moveUser(Main.Uid, bookingID, BookingData.usersBookedStatus, BookingData.userAttendedStatus);
                SettingUserData.setUserRecord();
                CoachDataController.calculatingCoachRating(Coach, Rating);
                if (bookingGrade > Main.Grade && Main.Grade < 5){
                    Main.Grade++;
                }
                System.out.println("You have attended the lesson.");
                System.out.println("setting the grade");
                System.out.println("Grade: "+ Main.Grade);
                StudentDataController.addLernerStatusRecord(bookingID, bookingDay, bookingDate, bookingMonth,bookingTime, bookingCoach, bookingGrade, Main.Uid, "Attended");
                SettingUserData.setUserRecord();
                break;
            }
        }
    }

    public static void lernerMonthlyReport(int chooseMonthNumber) {
        int checkingEmpty = 0;
        String chooseMonth = "";
        System.out.println("\nMonthly Report of the Learner \n");
        switch (chooseMonthNumber) {
            case 1:
                chooseMonth = "JAN";
                break;
            case 2:
                chooseMonth = "FEB";
                break;
            case 3:
                chooseMonth = "MAR";
                break;
            case 4:
                chooseMonth = "APR";
                break;
            case 5:
                chooseMonth = "MAY";
                break;
            case 6:
                chooseMonth = "JUN";
                break;
            case 7:
                chooseMonth = "JUL";
                break;
            case 8:
                chooseMonth = "AUG";
                break;
            case 9:
                chooseMonth = "SEP";
                break;
            case 10:
                chooseMonth = "OCT";
                break;
            case 11:
                chooseMonth = "NOV";
                break;
            case 12:
                chooseMonth = "DEC";
                break;
            default:
                chooseMonthNumber = InputHandeling.getUserIntInput();
                break;
        }
        boolean isMonthAvailable = false;
        for (Object userArray : LearnerData.LearnerData) {
            ArrayList<Object> newUserInfo = (ArrayList<Object>) userArray;
            String newUserID = (String) newUserInfo.get(0);
            System.out.println("Report of "+ newUserInfo.get(1));
            int bookedNumber =  0;
            int cancelledNumber = 0;
            int attendedNumber = 0;
            boolean isDataAvailableForUser = false;
            for (Object UserStatusArray : LearnerData.lernerStatusRecord) {
                ArrayList<Object> statusInfo = (ArrayList<Object>) UserStatusArray;
                String userID = (String) statusInfo.get(7);
                String userStatus = (String) statusInfo.get(8);
                String Month = (String) statusInfo.get(3);
                if (Month.equals(chooseMonth)) {
                    isMonthAvailable = true;
                    if (userID.equals(newUserID)) {
                        isDataAvailableForUser = true;
                        if(userStatus.equals("Booked")){
                            bookedNumber++;
                        } else if(userStatus.equals("Cancelled")){
                            cancelledNumber++;
                        } else if(userStatus.equals("Attended")){
                            attendedNumber++;
                        }
                        String Day = (String) statusInfo.get(1);
                        int Date = (int) statusInfo.get(2);
                        int Time = (int) statusInfo.get(4);
                        String Coach = (String) statusInfo.get(5);
                        int Grade = (int) statusInfo.get(6);
                        String Status = (String) statusInfo.get(8);
                        System.out.printf("Day: %-10s Month: %-10s Date: %-10d Time: From %-1d to %-10d Coach: %-10s Grade: %-10d Status: %-10s%n",
                                Day, Month, Date, Time, Time + 1, Coach, Grade, Status);
                    }
                }
            }
            if (!isDataAvailableForUser) {
                System.out.println("No Data is available...\n");
            }else{
            System.out.println("Booked: " + bookedNumber+"\tCancelled: "+cancelledNumber +"\tAttended: "+attendedNumber);
            System.out.println("\n");}
        }
        if (!isMonthAvailable) {
            System.out.println("No Data on "+chooseMonth+ " Month");
            SwimmingLessonView.swimmingBookingStart();
        }
    }

    public static void registerLerner(String name, int age, String phoneNumber, String gender, int grade) {
        String uid = name.substring(0, 3).toUpperCase() + Integer.toString((int) (10000 + Math.random() * 9999999)).substring(2, 5);
        StudentDataController.createStudent(uid, name, age, phoneNumber, gender, grade, 0, 0, 0);
        Main.Name = name.toUpperCase();
        Main.Uid = uid;
        Main.Grade = grade;
    }
}