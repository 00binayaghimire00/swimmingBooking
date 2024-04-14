package Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BookingData {
    //lessonDisplay(BID 0,Day 1, Date 2, Month 3, Time 4, Coach 5, Grade 6, Participants 7)
    public static ArrayList<Object> bookingData = new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList("M1APR45P", "MON", 1, "APR", 4, "Michael", 3, 4)),
            new ArrayList<>(Arrays.asList("M1APR56P", "MON", 1, "APR", 5, "Sophie", 2, 3)),
            new ArrayList<>(Arrays.asList("M1APR67P", "MON", 1, "APR", 6, "Benjamin", 3, 2)),
            new ArrayList<>(Arrays.asList("W3APR45P", "WED", 3, "APR", 4, "Jessica", 3, 1)),
            new ArrayList<>(Arrays.asList("W3APR56P", "WED", 3, "APR", 5, "Michael", 3, 3)),
            new ArrayList<>(Arrays.asList("W3APR67P", "WED", 3, "APR", 6, "Sophie", 4, 2)),
            new ArrayList<>(Arrays.asList("F5APR45P", "FRI", 5, "APR", 4, "Sophie", 5, 1)),
            new ArrayList<>(Arrays.asList("F5APR56P", "FRI", 5, "APR", 5, "Michael", 5, 2)),
            new ArrayList<>(Arrays.asList("F5APR67P", "FRI", 5, "APR", 6, "Jessica", 3, 1)),
            new ArrayList<>(Arrays.asList("S6APR23P", "SAT", 6, "APR", 2, "Benjamin", 3, 2)),
            new ArrayList<>(Arrays.asList("S6APR34P", "SAT", 6, "APR", 3, "Michael", 3, 1)),
            new ArrayList<>(Arrays.asList("M8APR45P", "MON", 8, "APR", 4, "Jessica", 1, 0)),
            new ArrayList<>(Arrays.asList("M8APR56P", "MON", 8, "APR", 5, "Michael", 4, 0)),
            new ArrayList<>(Arrays.asList("M8APR67P", "MON", 8, "APR", 6, "Benjamin", 5, 0)),
            new ArrayList<>(Arrays.asList("W10APR45P", "WED", 10, "APR", 4, "Sophie", 2, 0)),
            new ArrayList<>(Arrays.asList("W10APR56P", "WED", 10, "APR", 5, "Benjamin", 3, 0)),
            new ArrayList<>(Arrays.asList("W10APR67P", "WED", 10, "APR", 6, "Michael", 2, 0)),
            new ArrayList<>(Arrays.asList("F12APR45P", "FRI", 12, "APR", 4, "Jessica", 3, 0)),
            new ArrayList<>(Arrays.asList("F12APR56P", "FRI", 12, "APR", 5, "Sophie", 1, 0)),
            new ArrayList<>(Arrays.asList("F12APR67P", "FRI", 12, "APR", 6, "Benjamin", 5, 0)),
            new ArrayList<>(Arrays.asList("S13APR36P", "SAT", 13, "APR", 2, "Sophie", 3, 0)),
            new ArrayList<>(Arrays.asList("S13APR36P", "SAT", 13, "APR", 3, "Michael", 4, 0)),
            new ArrayList<>(Arrays.asList("M15APR45P", "MON", 15, "APR", 4, "Benjamin", 5, 0)),
            new ArrayList<>(Arrays.asList("M15APR56P", "MON", 15, "APR", 5, "Michael", 3, 0)),
            new ArrayList<>(Arrays.asList("M15APR67P", "MON", 15, "APR", 6, "Jessica", 1, 0)),
            new ArrayList<>(Arrays.asList("W17APR45P", "WED", 17, "APR", 4, "Jessica", 3, 0)),
            new ArrayList<>(Arrays.asList("W17APR56P", "WED", 17, "APR", 5, "Michael", 1, 0)),
            new ArrayList<>(Arrays.asList("W17APR67P", "WED", 17, "APR", 6, "Sophie", 3, 3)),
            new ArrayList<>(Arrays.asList("F19APR45P", "FRI", 19, "APR", 4, "Sophie", 2, 0)),
            new ArrayList<>(Arrays.asList("F19APR56P", "FRI", 19, "APR", 5, "Michael", 3, 0)),
            new ArrayList<>(Arrays.asList("F19APR67P", "FRI", 19, "APR", 6, "Jessica", 2, 0)),
            new ArrayList<>(Arrays.asList("S20APR23P", "SAT", 20, "APR", 2, "Benjamin", 4, 0)),
            new ArrayList<>(Arrays.asList("S20APR34P", "SAT", 20, "APR", 3, "Michael", 2, 0)),
            new ArrayList<>(Arrays.asList("M22APR45P", "MON", 22, "APR", 4, "Jessica", 5, 0)),
            new ArrayList<>(Arrays.asList("M22PR56P", "MON", 22, "APR", 5, "Michael", 2, 0)),
            new ArrayList<>(Arrays.asList("M22PR67P", "MON", 22, "APR", 6, "Benjamin", 1, 0)),
            new ArrayList<>(Arrays.asList("W24APR45P", "WED", 24, "APR", 4, "Sophie", 3, 0)),
            new ArrayList<>(Arrays.asList("W24APR56P", "WED", 24, "APR", 5, "Benjamin", 4, 0)),
            new ArrayList<>(Arrays.asList("W24APR67P", "WED", 24, "APR", 6, "Michael", 1, 0)),
            new ArrayList<>(Arrays.asList("F26APR45P", "FRI", 26, "APR", 4, "Jessica", 3, 0)),
            new ArrayList<>(Arrays.asList("F26APR56P", "FRI", 26, "APR", 5, "Sophie", 2, 0)),
            new ArrayList<>(Arrays.asList("F26APR67P", "FRI", 26, "APR", 6, "Benjamin", 3, 0)),
            new ArrayList<>(Arrays.asList("S27APR36P", "SAT", 27, "APR", 2, "Sophie", 5, 0)),
            new ArrayList<>(Arrays.asList("S27APR36P", "SAT", 27, "APR", 3, "Michael", 1, 0)),
            new ArrayList<>(Arrays.asList("M29APR45P", "MON", 29, "APR", 4, "Jessica", 1, 0)),
            new ArrayList<>(Arrays.asList("M29APR56P", "MON", 29, "APR", 5, "Michael", 2, 0)),
            new ArrayList<>(Arrays.asList("M29PR67P", "MON", 29, "APR", 6, "Benjamin", 4, 0)),
            new ArrayList<>(Arrays.asList("W1MAY45P", "WED", 1, "MAY", 4, "Sophie", 3, 0)),
            new ArrayList<>(Arrays.asList("W1MAY56P", "WED", 1, "MAY", 5, "Benjamin", 4, 0)),
            new ArrayList<>(Arrays.asList("W1MAY67P", "WED", 1, "MAY", 6, "Michael", 5, 0))
    ));

    // array list have String BID 0, String Day 1, int Date 2, String Month 3, int Time 4, String Coach 5,
    // int Grade 6, int Participants 7,int Booked 8, int Cancelled 9, int Attended 10, int Rating 11, String Review 12
    public static ArrayList<Object> previousBookingData = new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList("M1MAR45P", "MON", 1, "MAR", 4, "Sophie", 4, 3, 0, 0, 0, 4, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("M1MAR56P", "MON", 1, "MAR", 5, "Michael", 4, 3, 2, 4, 0, 2, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("M1MAR67P", "MON", 1, "MAR", 6, "Jessica", 4, 3, 0, 0, 0, 2, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("W3MAR45P", "WED", 3, "MAR", 4, "Sophie", 4, 3, 0, 0, 6, 4, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("W3MAR56P", "WED", 3, "MAR", 5, "Benjamin", 4, 3, 0, 0, 0, 1, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("W3MAR67P", "WED", 3, "MAR", 6, "Michael", 4, 3, 0, 0, 0, 2, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("F5MAR45P", "FRI", 5, "MAR", 4, "Sophie", 4, 3, 0, 0, 0, 0, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("F5MAR56P", "FRI", 5, "MAR", 5, "Jessica", 4, 3, 0, 0, 0, 2, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("F5MAR67P", "FRI", 5, "MAR", 6, "Sophie", 4, 3, 0, 0, 0, 4, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("S6MAR23P", "SAT", 6, "MAR", 2, "Benjamin", 4, 3, 0, 0, 0, 0, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("S6MAR34P", "SAT", 6, "MAR", 3, "Michael", 4, 3, 0, 0, 0, 0, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("M8MAR45P", "MON", 8, "MAR", 4, "Sophie", 4, 3, 0, 0, 0, 1, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("M8MAR56P", "MON", 8, "MAR", 5, "Jessica", 4, 3, 0, 0, 0, 4, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("M8MAR67P", "MON", 8, "MAR", 6, "Michael", 4, 3, 0, 0, 0, 5, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("W10MAR45P", "WED", 10, "MAR", 4, "Sophie", 4, 3, 0, 0, 0, 3, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("W10MAR56P", "WED", 10, "MAR", 5, "Benjamin", 4, 3, 0, 0, 0, 4, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("W10MAR67P", "WED", 10, "MAR", 6, "Michael", 4, 3, 0, 0, 0, 2, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("F12MAR45P", "FRI", 12, "MAR", 4, "Sophie", 4, 3, 0, 0, 0, 2, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("F12MAR56P", "FRI", 12, "MAR", 5, "Benjamin", 4, 3, 0, 0, 0, 4, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("F12MAR67P", "FRI", 12, "MAR", 6, "Sophie", 4, 3, 0, 0, 0, 2, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("S13MAR36P", "SAT", 13, "MAR", 2, "Jessica", 4, 3, 0, 0, 0, 2, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("S13MAR36P", "SAT", 13, "MAR", 3, "Michael", 4, 3, 0, 0, 0, 1, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("M15MAR45P", "MON", 15, "MAR", 4, "Benjamin", 4, 3, 0, 0, 0, 0, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("M15MAR56P", "MON", 15, "MAR", 5, "Halen", 4, 3, 0, 0, 0, 0, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("M15MAR67P", "MON", 15, "MAR", 6, "Sophie", 4, 3, 0, 0, 0, 0, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("W17MAR45P", "WED", 17, "MAR", 4, "Jessica", 4, 3, 0, 0, 0, 4, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("W17MAR56P", "WED", 17, "MAR", 5, "Benjamin", 4, 3, 0, 0, 0, 3, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("W17MAR67P", "WED", 17, "MAR", 6, "Michael", 4, 3, 0, 0, 0, 4, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("F19MAR45P", "FRI", 19, "MAR", 4, "Sophie", 4, 3, 0, 0, 0, 5, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("F19MAR56P", "FRI", 19, "MAR", 5, "Jessica", 4, 3, 0, 0, 0, 2, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("F19MAR67P", "FRI", 19, "MAR", 6, "Benjamin", 4, 3, 0, 0, 0, 1, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("S20MAR36P", "SAT", 20, "MAR", 2, "Michael", 4, 3, 0, 0, 0, 1, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("S20MAR36P", "SAT", 20, "MAR", 3, "Halen", 4, 3, 0, 0, 0, 1, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("M22MAR45P", "MON", 22, "APR", 4, "Sophie", 4, 3, 0, 0, 0, 3, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("M22MAR56P", "MON", 22, "APR", 5, "Jessica", 4, 3, 0, 0, 0, 4, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("M22MAR67P", "MON", 22, "APR", 6, "Benjamin", 4, 3, 0, 0, 0, 2, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("W24MAR45P", "WED", 24, "APR", 4, "Sophie", 4, 3, 0, 0, 0, 1, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("W24MAR56P", "WED", 24, "APR", 5, "Jessica", 4, 3, 0, 0, 0, 3, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("W24MAR67P", "WED", 24, "APR", 6, "Sophie", 4, 3, 0, 0, 0, 4, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("F26MAR45P", "FRI", 26, "APR", 4, "Michael", 4, 3, 0, 0, 0, 3, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("F26MAR56P", "FRI", 26, "APR", 5, "Jessica", 4, 3, 0, 0, 0, 4, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("F26MAR67P", "FRI", 26, "APR", 6, "Sophie", 4, 3, 0, 0, 0, 2, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("S27MAR36P", "SAT", 27, "APR", 2, "Benjamin", 4, 3, 0, 0, 0, 1, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("S27MAR36P", "SAT", 27, "APR", 3, "Sophie", 4, 3, 0, 0, 0, 1, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("M29MAR45P", "MON", 29, "APR", 4, "Michael", 4, 3, 0, 0, 0, 0, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("M29MAR56P", "MON", 29, "APR", 5, "Sophie", 4, 3, 0, 0, 0, 4, "Good coach with good knpwledge")),
            new ArrayList<>(Arrays.asList("M29MAR67P", "MON", 29, "APR", 6, "Benjamin", 4, 3, 0, 0, 0, 3, "Good coach with good knpwledge"))
    ));

    public static ArrayList<Object> bookedDate = new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList("M1APR45P", "MON", 1, "APR", 4, "Michael", 3, 4, 4, 0, 0, 0, " ")),
            new ArrayList<>(Arrays.asList("M1APR56P", "MON", 1, "APR", 5, "Sophie", 2, 3, 3, 2, 1, 0, " ")),
            new ArrayList<>(Arrays.asList("M1APR67P", "MON", 1, "APR", 6, "Benjamin", 3, 2, 3, 0, 0, 0, " ")),
            new ArrayList<>(Arrays.asList("W3APR45P", "WED", 3, "APR", 4, "Jessica", 3, 1, 1, 0, 0, 0, " ")),
            new ArrayList<>(Arrays.asList("W3APR56P", "WED", 3, "APR", 5, "Michael", 3, 3, 3, 0, 0, 0, " ")),
            new ArrayList<>(Arrays.asList("W3APR67P", "WED", 3, "APR", 6, "Sophie", 4, 2, 3, 1, 0, 0, " ")),
            new ArrayList<>(Arrays.asList("F5APR45P", "FRI", 5, "APR", 4, "Sophie", 5, 1, 1, 0, 0, 0, " ")),
            new ArrayList<>(Arrays.asList("F5APR56P", "FRI", 5, "APR", 5, "Michael", 4, 2, 2, 1, 0, 0, " ")),
            new ArrayList<>(Arrays.asList("F5APR67P", "FRI", 5, "APR", 6, "Jessica", 3, 1, 1, 0, 0, 0, " ")),
            new ArrayList<>(Arrays.asList("S6APR23P", "SAT", 6, "APR", 2, "Benjamin", 3, 2, 4, 2, 0, 0, " ")),
            new ArrayList<>(Arrays.asList("S6APR34P", "SAT", 6, "APR", 3, "Michael", 3, 1, 1, 0, 0, " "))
    ));
    public static Map<String, ArrayList<String>> usersBookedStatus = new HashMap<>() {{
        put("M1APR45P", new ArrayList<>(Arrays.asList("EMI769", "OLI678", "AVA456", "JAM145")));
        put("M1APR56P", new ArrayList<>(Arrays.asList("")));
        put("M1APR67P", new ArrayList<>(Arrays.asList("SAM123", "LUC012", "JAM145")));
        put("W3APR45P", new ArrayList<>(Arrays.asList("BEN901")));
        put("W3APR56P", new ArrayList<>(Arrays.asList("EMI769", "OLI678", "AVA456")));
        put("W3APR67P", new ArrayList<>(Arrays.asList("EMI769", "OLI678")));
        put("F5APR45P", new ArrayList<>(Arrays.asList("JAM145")));
        put("F5APR56P", new ArrayList<>(Arrays.asList("OLI678")));
        put("F5APR67P", new ArrayList<>(Arrays.asList("EMI769")));
        put("S6APR23P", new ArrayList<>(Arrays.asList("CHA042", "JAM145")));
        put("S6APR34P", new ArrayList<>(Arrays.asList("EMI769")));
    }};
    public static Map<String, ArrayList<String>> usersCancelledStatus = new HashMap<>() {{
        put("M1APR56P", new ArrayList<>(Arrays.asList("OLI678", "CHA042")));
        put("W3APR67P", new ArrayList<>(Arrays.asList("MAX789")));
        put("F5APR56P", new ArrayList<>(Arrays.asList("EMI769")));
        put("S6APR23P", new ArrayList<>(Arrays.asList("RYA123", "JAM145")));
    }};
    public static Map<String, ArrayList<String>> userAttendedStatus = new HashMap<>() {{
        put("M1APR56P", new ArrayList<>(Arrays.asList("EMI769")));
    }};

    public static Map<String, ArrayList<String>> userLessonRecord = new HashMap<>() {{
        put("M1APR45P", new ArrayList<>(Arrays.asList("JAM145", "OLI678", "AVA456", "JAM145")));
        put("M1APR56P", new ArrayList<>(Arrays.asList("OLI678", "CHA042", "EMI769")));
        put("M1APR67P", new ArrayList<>(Arrays.asList("SAM123", "LUC012", "JAM145")));
        put("W3APR45P", new ArrayList<>(Arrays.asList("BEN901")));
        put("W3APR56P", new ArrayList<>(Arrays.asList("EMI769", "OLI678", "AVA456")));
        put("W3APR67P", new ArrayList<>(Arrays.asList("EMI769", "OLI678", "MAX789")));
        put("F5APR45P", new ArrayList<>(Arrays.asList("JAM145")));
        put("F5APR56P", new ArrayList<>(Arrays.asList("OLI678", "EMI769")));
        put("F5APR67P", new ArrayList<>(Arrays.asList("EMI769")));
        put("S6APR23P", new ArrayList<>(Arrays.asList("CHA042", "JAM145", "RYA123", "AVA456")));
        put("S6APR34P", new ArrayList<>(Arrays.asList("EMI769")));
    }};

    public static Map<String, Integer> attendanceRecord = new HashMap<>();
}