import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Booking {

    static ArrayList<Object> coachData = Coach.getCoachData();

    static ArrayList<Object> bookingData = new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList("M1APR45P", "MON", 1, "APR", 4, "Halen", 3)),
            new ArrayList<>(Arrays.asList("M1APR56P", "MON", 1, "APR", 5, "Halen", 3)),
            new ArrayList<>(Arrays.asList("M1APR67P", "MON", 1, "APR", 6, "Halen", 2)),
            new ArrayList<>(Arrays.asList("W3APR45P", "WED", 3, "APR", 4, "Halen", 3)),
            new ArrayList<>(Arrays.asList("W3APR56P", "WED", 3, "APR", 5, "Halen", 3)),
            new ArrayList<>(Arrays.asList("W3APR67P", "WED", 3, "APR", 6, "Halen", 3)),
            new ArrayList<>(Arrays.asList("F5APR45P", "FRI", 5, "APR", 4, "Halen", 3)),
            new ArrayList<>(Arrays.asList("F5APR56P", "FRI", 5, "APR", 5, "Halen", 3)),
            new ArrayList<>(Arrays.asList("F5APR67P", "FRI", 5, "APR", 6, "Halen", 3)),
            new ArrayList<>(Arrays.asList("S6APR23P", "SAT", 6, "APR", 2, "Halen", 3)),
            new ArrayList<>(Arrays.asList("S6APR34P", "SAT", 6, "APR", 3, "Halen", 3)),
            new ArrayList<>(Arrays.asList("M8APR45P", "MON", 8, "APR", 4, "Halen", 3)),
            new ArrayList<>(Arrays.asList("M8APR56P", "MON", 8, "APR", 5, "Halen", 3)),
            new ArrayList<>(Arrays.asList("M8APR67P", "MON", 8, "APR", 6, "Halen", 3)),
            new ArrayList<>(Arrays.asList("W10APR45P", "WED", 10, "APR", 4, "Halen", 3)),
            new ArrayList<>(Arrays.asList("W10APR56P", "WED", 10, "APR", 5, "Halen", 4)),
            new ArrayList<>(Arrays.asList("W10APR67P", "WED", 10, "APR", 6, "Halen", 3)),
            new ArrayList<>(Arrays.asList("F12APR45P", "FRI", 12, "APR", 4, "Halen", 3)),
            new ArrayList<>(Arrays.asList("F12APR56P", "FRI", 12, "APR", 5, "Halen", 3)),
            new ArrayList<>(Arrays.asList("F12APR67P", "FRI", 12, "APR", 6, "Halen", 5)),
            new ArrayList<>(Arrays.asList("S13APR36P", "SAT", 13, "APR", 2, "Halen", 3)),
            new ArrayList<>(Arrays.asList("S13APR36P", "SAT", 13, "APR", 3, "Halen", 3)),
            new ArrayList<>(Arrays.asList("M15APR45P", "MON", 15, "APR", 4, "Halen", 1)),
            new ArrayList<>(Arrays.asList("M15APR56P", "MON", 15, "APR", 5, "Halen", 3)),
            new ArrayList<>(Arrays.asList("M15APR67P", "MON", 15, "APR", 6, "Halen", 3)),
            new ArrayList<>(Arrays.asList("W17APR45P", "WED", 17, "APR", 4, "Halen", 3)),
            new ArrayList<>(Arrays.asList("W17APR56P", "WED", 17, "APR", 5, "Halen", 3)),
            new ArrayList<>(Arrays.asList("W17APR67P", "WED", 17, "APR", 6, "Halen", 3)),
            new ArrayList<>(Arrays.asList("F19APR45P", "FRI", 19, "APR", 4, "Halen", 3)),
            new ArrayList<>(Arrays.asList("F19APR56P", "FRI", 19, "APR", 5, "Halen", 3)),
            new ArrayList<>(Arrays.asList("F19APR67P", "FRI", 19, "APR", 6, "Halen", 3)),
            new ArrayList<>(Arrays.asList("S20APR36P", "SAT", 20, "APR", 2, "Halen", 3)),
            new ArrayList<>(Arrays.asList("S20APR36P", "SAT", 20, "APR", 3, "Halen", 3)),
            new ArrayList<>(Arrays.asList("M22APR45P", "MON", 22, "APR", 4, "Halen", 3)),
            new ArrayList<>(Arrays.asList("M22APR56P", "MON", 22, "APR", 5, "Halen", 3)),
            new ArrayList<>(Arrays.asList("M22APR67P", "MON", 22, "APR", 6, "Halen", 3)),
            new ArrayList<>(Arrays.asList("W24APR45P", "WED", 24, "APR", 4, "Halen", 3)),
            new ArrayList<>(Arrays.asList("W24APR56P", "WED", 24, "APR", 5, "Halen", 3)),
            new ArrayList<>(Arrays.asList("W24APR67P", "WED", 24, "APR", 6, "Halen", 3)),
            new ArrayList<>(Arrays.asList("F26APR45P", "FRI", 26, "APR", 4, "Halen", 3)),
            new ArrayList<>(Arrays.asList("F26APR56P", "FRI", 26, "APR", 5, "Halen", 3)),
            new ArrayList<>(Arrays.asList("F26APR67P", "FRI", 26, "APR", 6, "Halen", 3)),
            new ArrayList<>(Arrays.asList("S27APR36P", "SAT", 27, "APR", 2, "Halen", 3)),
            new ArrayList<>(Arrays.asList("S27APR36P", "SAT", 27, "APR", 3, "Halen", 3)),
            new ArrayList<>(Arrays.asList("M29APR45P", "MON", 29, "APR", 4, "Halen", 3)),
            new ArrayList<>(Arrays.asList("M29APR56P", "MON", 29, "APR", 5, "Halen", 3)),
            new ArrayList<>(Arrays.asList("M29APR67P", "MON", 29, "APR", 6, "Halen", 3))
    ));

    // array list have id, day, date, month, time, coach, grade, participants, rating, review
    static ArrayList<Object> oldBookedData = new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList("M1MAR45P", "MON", 1, "APR", 4, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("M1MAR56P", "MON", 1, "APR", 5, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("M1MAR67P", "MON", 1, "APR", 6, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("W3MAR45P", "WED", 3, "APR", 4, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("W3MAR56P", "WED", 3, "APR", 5, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("W3MAR67P", "WED", 3, "APR", 6, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("F5MAR45P", "FRI", 5, "APR", 4, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("F5MAR56P", "FRI", 5, "APR", 5, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("F5MAR67P", "FRI", 5, "APR", 6, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("S6MAR23P", "SAT", 6, "APR", 2, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("S6MAR34P", "SAT", 6, "APR", 3, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("M8MAR45P", "MON", 8, "APR", 4, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("M8MAR56P", "MON", 8, "APR", 5, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("M8MAR67P", "MON", 8, "APR", 6, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("W10MAR45P", "WED", 10, "APR", 4, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("W10MAR56P", "WED", 10, "APR", 5, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("W10MAR67P", "WED", 10, "APR", 6, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("F12MAR45P", "FRI", 12, "APR", 4, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("F12MAR56P", "FRI", 12, "APR", 5, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("F12MAR67P", "FRI", 12, "APR", 6, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("S13MAR36P", "SAT", 13, "APR", 2, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("S13MAR36P", "SAT", 13, "APR", 3, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("M15MAR45P", "MON", 15, "APR", 4, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("M15MAR56P", "MON", 15, "APR", 5, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("M15MAR67P", "MON", 15, "APR", 6, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("W17MAR45P", "WED", 17, "APR", 4, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("W17MAR56P", "WED", 17, "APR", 5, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("W17MAR67P", "WED", 17, "APR", 6, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("F19MAR45P", "FRI", 19, "APR", 4, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("F19MAR56P", "FRI", 19, "APR", 5, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("F19MAR67P", "FRI", 19, "APR", 6, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("S20MAR36P", "SAT", 20, "APR", 2, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("S20MAR36P", "SAT", 20, "APR", 3, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("M22MAR45P", "MON", 22, "APR", 4, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("M22MAR56P", "MON", 22, "APR", 5, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("M22MAR67P", "MON", 22, "APR", 6, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("W24MAR45P", "WED", 24, "APR", 4, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("W24MAR56P", "WED", 24, "APR", 5, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("W24MAR67P", "WED", 24, "APR", 6, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("F26MAR45P", "FRI", 26, "APR", 4, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("F26MAR56P", "FRI", 26, "APR", 5, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("F26MAR67P", "FRI", 26, "APR", 6, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("S27MAR36P", "SAT", 27, "APR", 2, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("S27MAR36P", "SAT", 27, "APR", 3, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("M29MAR45P", "MON", 29, "APR", 4, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("M29MAR56P", "MON", 29, "APR", 5, "Halen", 4, 6, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("M29MAR67P", "MON", 29, "APR", 6, "Halen", 4, 6, "Good coach with good knpwledge"))
    ));

    public static ArrayList<Object> getBookingData() {
        return bookingData;
    }

    public static void setBookingData(ArrayList<Object> bookingData) {
        Booking.bookingData = bookingData;
    }

    public static ArrayList<Object> getBookedDate() {
        return bookedDate;
    }

    public static void setBookedDate(ArrayList<Object> bookedDate) {
        Booking.bookedDate = bookedDate;
    }

    static ArrayList<Object> bookedDate = new ArrayList<>();

    // array list have id, day, date, month, time, coach, grade, participants, rating, review
    static void bookedData(String BID, String Day, String Date, int Month, int Time, String Coach, int Grade, int Participants, int Rating, int Review, String review) {
        ArrayList<Object> data = new ArrayList<>();
        data.add(BID);
        data.add(Day);
        data.add(Date);
        data.add(Month);
        data.add(Time);
        data.add(Coach);
        data.add(Grade);
        data.add(Participants);
        data.add(Rating);
        data.add(Review);
        bookedDate.add(data);
    }

    static Map<String, ArrayList<String>> userLesson = new HashMap<>();

    static void addUserToLesson(String bookingId, String userId) {
        // Check if the bookingId already exists in the map
        if (userLesson.containsKey(bookingId)) {
            // If it does, get the ArrayList of user IDs and add the new user ID to it
            ArrayList<String> userIds = userLesson.get(bookingId);
            userIds.add(userId);
        } else {
            // If it doesn't, create a new ArrayList, add the user ID to it, and put it in the map
            ArrayList<String> userIds = new ArrayList<>();
            userIds.add(userId);
            userLesson.put(bookingId, userIds);
        }
    }

}
