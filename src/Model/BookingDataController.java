package Model;

import View.SwimmingLessonView;

import java.util.ArrayList;
import java.util.Map;

import static Model.BookingData.*;
public class BookingDataController {

    public static void moveUser(String userID, String bookingID, Map<String, ArrayList<String>> fromMap, Map<String, ArrayList<String>> toMap) {
        boolean isRemoved = false;
        if (fromMap.containsKey(bookingID)) {
            ArrayList<String> users = fromMap.get(bookingID);
            if (users.contains(userID)) {
                // Remove user from the booked status
                fromMap.get(bookingID).remove(userID);
                //fromMap.put(bookingID, users);
                isRemoved = true;
            }
        }
        if(isRemoved){
            // Add user to the new status
            ArrayList<String> newUsers;
            if (toMap.containsKey(bookingID)) {
                newUsers = toMap.get(bookingID);
            } else {
                newUsers = new ArrayList<>();
            }
            newUsers.add(userID);
            toMap.put(bookingID, newUsers);
        }
    }

    public static void makeBooking(String bookingId, int bookingParticipants, String userId) {
        ArrayList<String> users = new ArrayList<>();
        if (userLessonRecord.containsKey(bookingId)) {
            users = userLessonRecord.get(bookingId);
        }
        for (String usersID : users) {
            if (usersID.equals(userId)) {
                System.out.println("We're sorry, but you cannot book this lesson." +
                        "\nEither you have already booked or cancelled this lesson before," +
                        "\nPlease try booking a different lesson.");
                SwimmingLessonView.swimmingBookingStart();
                return;
            }
        }
        if (bookingParticipants >= 4) {
            System.out.println("Sorry, maximum users reached for this lesson.");
            SwimmingLessonView.swimmingBookingStart();
        } else {
            users.add(userId);
            userLessonRecord.put(bookingId, users);
        }
    }

    public static void addAttendanceRecord(String Month) {
        // Construct the key for the attendance record
        String attendanceKey = Month.toLowerCase() + "AttendanceRecord";
        // Check if the attendance record for the given month already exists
        if (attendanceRecord.containsKey(attendanceKey)) {
            // If the attendance record exists, increment the value by 1
            int currentValue = attendanceRecord.get(attendanceKey);
            attendanceRecord.put(attendanceKey, currentValue + 1);
        } else {
            // If the attendance record does not exist, create a new entry with a value of 1
            attendanceRecord.put(attendanceKey, 1);
        }
    }

    public static void addUser(Map<String, ArrayList<String>> usersBookedStatus, String bookingID, String userID) {
        ArrayList<String> users = usersBookedStatus.get(bookingID);
        if (users == null) {
            // bookingID does not exist in the map, create a new list and add it to the map
            users = new ArrayList<>();
            users.add(userID);
            usersBookedStatus.put(bookingID, users);
        } else {
            // bookingID exists, add the userID to the existing list
            users.add(userID);
            BookingData.usersBookedStatus.put(bookingID, users);
        }
    }

    public static void addBookedData(String BID, String Day, int Date, String Month, int Time, String Coach, int Grade, int Participants, int Booked, int Cancelled, int Attended, int Rating, String Review) {
        ArrayList<Object> data = new ArrayList<>();
        data.add(BID);
        data.add(Day);
        data.add(Date);
        data.add(Month);
        data.add(Time);
        data.add(Coach);
        data.add(Grade);
        data.add(Participants);
        data.add(Booked);
        data.add(Cancelled);
        data.add(Attended);
        data.add(Rating);
        data.add(Review);
        bookedDate.add(data);
    }

    public static void addOnPreviousBookingData(String lessonID, String day, int date, String month, int time, String coach, int grade, int participants, int booked, int cancelled, int attainedd, int rating, String review) {
        ArrayList<Object> student = new ArrayList<>();
        student.add(lessonID);
        student.add(day);
        student.add(date);
        student.add(month);
        student.add(time);
        student.add(coach);
        student.add(grade);
        student.add(participants);
        student.add(booked);
        student.add(cancelled);
        student.add(attainedd);
        student.add(rating);
        student.add(review);
        previousBookingData.add(student);
    }

}
