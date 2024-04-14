package Controller;
import Data.BookingData;
import Data.SettingUserData;
import Data.StudentData;
import ExceptionHandeling.InputHandeling;
import Main.Main;
import View.SwimmingLessonView;
import java.util.ArrayList;
import static Controller.ValidatingController.bookingIDCheck;

public class LernerController {
    static ArrayList<Object> lessonDisplay = new ArrayList<>();
    public static boolean isBookingDone;
    static ArrayList<Object> bookingData = BookingData.bookingData;
    static ArrayList<Object> bookedData = BookingData.bookedDate;

    public static void availableLessonsDisplayAndBooking(){
        ValidatingController.checkingUser(View.UserInput.yesOrNo());
        System.out.println("\nPlease choose how you want to display the lessons:");
        System.out.println("\t1. By Day \n\t2. By Coach Name \n\t3. By Grade");
        int chosenLessonDisplayOptions = InputHandeling.getUserIntInput();
        DisplayController.displayLessonOnOptions(chosenLessonDisplayOptions);
        String UserId = Main.Uid;
        // array list have id, day, date, month, time, coach, grade, participants, rating, review
        System.out.println("Please enter the available lesson booking ID");
        String chosenBookingID = InputHandeling.getUserStringInput().toUpperCase();
        bookingIDCheck(chosenBookingID);
        bookingLesson(chosenBookingID, UserId);
        SwimmingLessonView.swimmingBookingStart();
    }

    public static boolean bookingLesson(String chosenBookingID, String UserID) {
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
                    boolean IDavailableInBookedData = false;
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
                        System.out.println("Booking confirmed!!");
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
                        System.out.println(BookingData.bookedDate);
                        System.out.println(bookingInfo);

                    }
                    isBookingDone = true;
                    Main.userBookedLessons++;
                    BookingDataController.addUser(BookingData.usersBookedStatus, bookingID, Main.Uid);
                    SettingUserData.setUserRecord();
                }
            }
        }
        if (!isBookingDone) {
            System.out.println("\033[0;31m"+"Your Grade doesn't match the lesson."+"\033[0m");
        }
        return isBookingDone;
    }

    public static boolean bookingChanges(String chosenBookingID, int choosenOption, String userID) {
        boolean bookingChanged = false;
        for (Object bookingArray : BookingData.bookedDate) {
            ArrayList<Object> bookingInfo = (ArrayList<Object>) bookingArray;
            String bookingID = (String) bookingInfo.get(0);
            int bookingParticipants = ((Integer) bookingInfo.get(7)).intValue();
            int bookingCancelled = (int) bookingInfo.get(9);
            if (BookingData.userLessonRecord.containsKey(bookingID)) {
                while (true) {
                    if (choosenOption == 1) {
                        bookingInfo.set(7, bookingParticipants - 1);
                        bookingInfo.set(9, bookingCancelled + 1);
                        System.out.println("Booking Cancelled!");
                        Main.userCancelledLesson++;
                        BookingDataController.moveUser(userID, bookingID, BookingData.usersBookedStatus, BookingData.usersCancelledStatus);
                        SettingUserData.setUserRecord();
                        bookingChanged = true;
                        break;
                    } else if (choosenOption == 2) {
                        bookingInfo.set(7, bookingParticipants - 1);
                        bookingInfo.set(9, bookingCancelled + 1);
                        System.out.println("Updating the booking Data");
                        Main.userCancelledLesson++;
                        BookingDataController.moveUser(userID, bookingID, BookingData.usersBookedStatus, BookingData.usersCancelledStatus);
                        SettingUserData.setUserRecord();
                        availableLessonsDisplayAndBooking();
                        bookingChanged = true;
                        break;
                    } else {
                        System.out.println("Invalid Input..");
                        System.out.println("Please give the correct option");
                        choosenOption = InputHandeling.getUserIntInput();
                    }
                }
            }
            if (bookingChanged) {
                break;
            }
        }
        return bookingChanged;
    }

    public static void attendSwimming(String choosenBookingID) {
        for (Object bookingArray : bookedData) {
            ArrayList<Object> bookedInfo = (ArrayList<Object>) bookingArray;
            String bookingID = (String) bookedInfo.get(0);
            if (bookingID.equals(choosenBookingID)) {
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
                // Check and upgrade user grade
                int bookingGrade = (int) bookedInfo.get(6);
                if (bookingGrade > Main.Grade && Main.Grade < 5){
                    Main.Grade++;
                }
                System.out.println("setting the grade");
                System.out.println("Grade: "+ Main.Grade);
                SettingUserData.setUserRecord();
                break;
            }
        }
    }

    public static void lernerMonthlyReport() {
        System.out.println("Previous Monthly Report of the Learners");
        for (Object lernersArray : StudentData.studentData) {
            ArrayList<Object> studentInfo = (ArrayList<Object>) lernersArray;
            String name = (String) studentInfo.get(1);
            int grade = (int) studentInfo.get(5);
            int booked = (int) studentInfo.get(6);
            int cancelled = (int) studentInfo.get(7);
            int attended = (int) studentInfo.get(8);
            System.out.printf("Name: %-15s\tGrade: %1d\t\tLessons Booked: %1d\tLessons Cencelled: %1d\tLessons Attended: %1d\n", name, grade, booked, cancelled, attended);
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