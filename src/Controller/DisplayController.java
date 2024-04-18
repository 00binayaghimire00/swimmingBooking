package Controller;
import Model.BookingData;
import ExceptionHandeling.InputHandeling;
import Main.Main;
import View.SwimmingLessonView;

import java.util.ArrayList;
import java.util.Map;
import static Controller.LernerController.lessonDisplay;
import static Model.BookingData.bookingData;

public class DisplayController {
    static void lessonDisplay(String LessonID, String Day, int Date, String Month, int Time, String Coach, int Grade, int Participants) {
        ArrayList<Object> data = new ArrayList<>();
        data.add(LessonID);
        data.add(Day);
        data.add(Date);
        data.add(Month);
        data.add(Time);
        data.add(Coach);
        data.add(Grade);
        data.add(Participants);
        lessonDisplay.add(data);
    }

    public static void lessonPrint() {
        for (Object objectsArray : lessonDisplay) {
            ArrayList<Object> objects = (ArrayList<Object>) objectsArray;
            String BID = ((String) objects.get(0)).toUpperCase();
            String Day = ((String) objects.get(1)).toUpperCase(); // Index 0 for Day
            int Date = (int) objects.get(2); // Index 1 for Date
            String Month = ((String) objects.get(3)); // Index 2 for Month
            int Time = (int) objects.get(4); // Index 3 for Time
            String Coach = (String) objects.get(5); // Index 4 for Data.CoachData
            int Grade = (int) objects.get(6); // Index 5 for Grade
            int Participants = (int) objects.get(7); //Index 7  for Participants
            System.out.printf("Booking ID: %-10s Day: %-10s Month: %-10s Date: %-10d Time: From %-1d to %-10d Coach: %-10s Grade: %-10d Participants: %-10d%n",
                    BID, Day, Month, Date, Time, Time + 1, Coach, Grade, Participants);
        }
    }

    public static void displayUsersLesson() {
        int checkEmpty = 0;
        for (Map.Entry<String, ArrayList<String>> entry : BookingData.usersBookedStatus.entrySet()) {
            String bookingId = entry.getKey();
            ArrayList<String> userIds = entry.getValue();
            for (String userId : userIds) {
                if (userId.equals(Main.Uid)) {
                    for (Object bookingArray : BookingData.bookedDate) {
                        ArrayList<Object> bookingInfo = (ArrayList<Object>) bookingArray;
                        String BID = (String) bookingInfo.get(0);
                        if (bookingId.equals(BID)) {
                            String Day = ((String) bookingInfo.get(1)).toUpperCase();
                            int Date = (int) bookingInfo.get(2);
                            String Month = ((String) bookingInfo.get(3));
                            int Time = (int) bookingInfo.get(4);
                            String Coach = (String) bookingInfo.get(5);
                            int Grade = (int) bookingInfo.get(6);
                            int Participants = (int) bookingInfo.get(7);
                            String status = "Booked";
                            System.out.printf("Booking ID: %-10s Day: %-10s Month: %-10s Date: %-10d Time: From %-1d to %-10d Coach: %-10s Grade: %-10d Status: %-10s\n",
                                    BID, Day, Month, Date, Time, Time + 1, Coach, Grade, status);
                            checkEmpty++;
                        }
                    }
                }
            }
        }
        for (Map.Entry<String, ArrayList<String>> entry : BookingData.usersCancelledStatus.entrySet()) {
            String bookingId = entry.getKey();
            ArrayList<String> userIds = entry.getValue();
            for (String userId : userIds) {
                if (userId.equals(Main.Uid)) {
                    for (Object bookingArray : BookingData.bookedDate) {
                        ArrayList<Object> bookingInfo = (ArrayList<Object>) bookingArray;
                        String BID = (String) bookingInfo.get(0);
                        if (bookingId.equals(BID)) {
                            String Day = ((String) bookingInfo.get(1)).toUpperCase();
                            int Date = (int) bookingInfo.get(2);
                            String Month = ((String) bookingInfo.get(3));
                            int Time = (int) bookingInfo.get(4);
                            String Coach = (String) bookingInfo.get(5);
                            int Grade = (int) bookingInfo.get(6);
                            int Participants = (int) bookingInfo.get(7);
                            String status = "Cancelled";
                            System.out.printf("Booking ID: %-10s Day: %-10s Month: %-10s Date: %-10d Time: From %-1d to %-10d Coach: %-10s Grade: %-10d Status: %-10s\n",
                                    BID, Day, Month, Date, Time, Time + 1, Coach, Grade, status);
                            checkEmpty++;
                        }
                    }
                }
            }
        }
        for (Map.Entry<String, ArrayList<String>> entry : BookingData.userAttendedStatus.entrySet()) {
            String bookingId = entry.getKey();
            ArrayList<String> userIds = entry.getValue();
            for (String userId : userIds) {
                if (userId.equals(Main.Uid)) {
                    for (Object bookingArray : BookingData.bookedDate) {
                        ArrayList<Object> bookingInfo = (ArrayList<Object>) bookingArray;
                        String BID = (String) bookingInfo.get(0);
                        if (bookingId.equals(BID)) {
                            String Day = ((String) bookingInfo.get(1)).toUpperCase();
                            int Date = (int) bookingInfo.get(2);
                            String Month = ((String) bookingInfo.get(3));
                            int Time = (int) bookingInfo.get(4);
                            String Coach = (String) bookingInfo.get(5);
                            int Grade = (int) bookingInfo.get(6);
                            String status = "Attended";
                            System.out.printf("Booking ID: %-10s Day: %-10s Month: %-10s Date: %-10d Time: From %-1d to %-10d Coach: %-10s Grade: %-10d Status: %-10s\n",
                                    BID, Day, Month, Date, Time, Time + 1, Coach, Grade, status);
                            checkEmpty++;
                        }
                    }
                }
            }
        }

        if (checkEmpty == 0) {
            System.out.println("No data available");
            SwimmingLessonView.swimmingBookingStart();
        }
    }

    public static void displayLessonOnOptions(int lessonDisplayOptions){
        boolean isLessonAvailable = false;
        if (lessonDisplayOptions > 0 && (lessonDisplayOptions < 4)) {
            switch (lessonDisplayOptions) {
                case 1:
                    System.out.println("Enter Day : eg MON for Monday");
                    String optionDay = InputHandeling.getUserStringInput().toUpperCase();
                    for (Object bookingArray : bookingData) {
                        ArrayList<Object> bookingInfo = (ArrayList<Object>) bookingArray;
                        String chooseDay = ((String) bookingInfo.get(1)).toUpperCase();
                        if (optionDay.equals(chooseDay)) {
                            isLessonAvailable = true;
                            String BID = (String) bookingInfo.get(0);
                            String Day = (String) bookingInfo.get(1);
                            int Date = (int) bookingInfo.get(2);
                            String Month = ((String) bookingInfo.get(3));
                            int Time = (int) bookingInfo.get(4);
                            String Coach = (String) bookingInfo.get(5);
                            int Grade = (int) bookingInfo.get(6);
                            int Participants = (int) bookingInfo.get(7);
                            lessonDisplay(BID, Day, Date, Month, Time, Coach, Grade, Participants);
                        }
                    }
                    if (!isLessonAvailable) {
                        System.out.println("There is no available lessons on " + optionDay + "-DAY");
                        SwimmingLessonView.swimmingBookingStart();
                    } else {
                        DisplayController.lessonPrint();
                    }
                    break;


                case 2:
                    System.out.println("Enter the coach name: i.e. Michael, Sophie, Benjamin, Jessica");
                    String optionCoach = InputHandeling.getUserStringInput().toUpperCase();
                    for (Object bookingArray : bookingData) {
                        ArrayList<Object> bookingInfo = (ArrayList<Object>) bookingArray;
                        String chooseCoach = ((String) bookingInfo.get(5)).toUpperCase();
                        if (optionCoach.equals(chooseCoach)) {
                            isLessonAvailable = true;
                            String BID = (String) bookingInfo.get(0);
                            String Day = (String) bookingInfo.get(1);
                            int Date = (int) bookingInfo.get(2);
                            String Month = ((String) bookingInfo.get(3));
                            int Time = (int) bookingInfo.get(4);
                            String Coach = (String) bookingInfo.get(5);
                            int Grade = (int) bookingInfo.get(6);
                            int Participants = (int) bookingInfo.get(7);
                            lessonDisplay(BID, Day, Date, Month, Time, Coach, Grade, Participants);
                        }
                    }
                    if (!isLessonAvailable) {
                        System.out.println("There is no available lessons for " + optionCoach);
                        SwimmingLessonView.swimmingBookingStart();
                    } else {
                        DisplayController.lessonPrint();
                    }
                    break;

                case 3:
                    System.out.println("Enter the Grade: range 1 to 5");
                    int optionGrade = InputHandeling.getUserIntInput();
                    for (Object bookingArray : bookingData) {
                        ArrayList<Object> bookingInfo = (ArrayList<Object>) bookingArray;
                        int chooseGrade = (int) bookingInfo.get(6);
                        if (optionGrade == chooseGrade) {
                            isLessonAvailable = true;
                            String BID = (String) bookingInfo.get(0);
                            String Day = (String) bookingInfo.get(1);
                            int Date = (int) bookingInfo.get(2);
                            String Month = ((String) bookingInfo.get(3));
                            int Time = (int) bookingInfo.get(4);
                            String Coach = (String) bookingInfo.get(5);
                            int Grade = (int) bookingInfo.get(6);
                            int Participants = (int) bookingInfo.get(7);
                            lessonDisplay(BID, Day, Date, Month, Time, Coach, Grade, Participants);
                        }
                    }
                    if (!isLessonAvailable) {
                        System.out.println("There is no available lessons on " + optionGrade + " grade");
                        SwimmingLessonView.swimmingBookingStart();
                    } else {
                        DisplayController.lessonPrint();
                    }
                    break;
            }
        } else {
            System.out.println("\nPlease enter valid option");
            System.out.println("\t1. By Day \n\t2. By Coach Name \n\t3. By Grade");
            lessonDisplayOptions = InputHandeling.getUserIntInput();
        }
    }
}
