package Model;
import java.util.*;

public class LearnerData {

    public LearnerData() {
    }

    public static ArrayList<Object> LearnerData = new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList("JAM145", "James", 7, "07400123456", "M", 1, 5, 1, 0)),
            new ArrayList<>(Arrays.asList("EMI769", "Emily", 11, "07700234567", "F", 3, 6, 1, 1)),
            new ArrayList<>(Arrays.asList("OLI678", "Oliver", 6, "07500345678", "M", 2, 5, 1, 0)),
            new ArrayList<>(Arrays.asList("CHA042", "Charlotte", 5, "07800456789", "F", 1, 5, 2, 0)),
            new ArrayList<>(Arrays.asList("SAM123", "Sam", 8, "07900123456", "M", 1, 1, 0, 0)),
            new ArrayList<>(Arrays.asList("AVA456", "Ava", 9, "07900234567", "F", 2, 0, 0, 0)),
            new ArrayList<>(Arrays.asList("MAX789", "Max", 10, "07900345678", "M", 3, 0, 0, 0)),
            new ArrayList<>(Arrays.asList("LUC012", "Lucy", 11, "07900456789", "F", 2, 1, 0, 0)),
            new ArrayList<>(Arrays.asList("JAC345", "Jack", 4, "07900567890", "M", 5, 0, 0, 0)),
            new ArrayList<>(Arrays.asList("SOP678", "Sophie", 6, "07900678901", "F", 3, 0, 0, 0)),
            new ArrayList<>(Arrays.asList("BEN901", "Ben", 7, "07900789012", "M", 1, 0, 0, 0)),
            new ArrayList<>(Arrays.asList("EMM234", "Emma", 5, "07900890123", "F", 4, 0, 0, 0)),
            new ArrayList<>(Arrays.asList("ALE567", "Alex", 8, "07900901234", "M", 2, 0, 0, 0)),
            new ArrayList<>(Arrays.asList("ELL890", "Ella", 10, "07901012345", "F", 5, 0, 0, 0)),
            new ArrayList<>(Arrays.asList("RYA123", "Ryan", 9, "07901123456", "M", 2, 1, 1, 0)),
            new ArrayList<>(Arrays.asList("ZOE456", "Zoe", 6, "07901234567", "F", 1, 0, 0, 0)),
            new ArrayList<>(Arrays.asList("DAN789", "Daniel", 7, "07901345678", "M", 1, 0 ,0 ,0)),
            new ArrayList<>(Arrays.asList("AMY012", "Amy", 4, "07901456789", "F", 4, 0 ,0 ,0)),
            new ArrayList<>(Arrays.asList("MAT345", "Matthew", 8, "07901567890", "M", 4, 0 ,0 ,0))
    ));

    public static ArrayList<Object> lernerStatusRecord = new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList("M1MAR45P", "MON", 1, "MAR", 4, "Sophie", 1, "JAM145", "Booked")),
            new ArrayList<>(Arrays.asList("M1MAR56P", "MON", 1, "MAR", 5, "Michael", 3, "EMI769", "Cancelled")),
            new ArrayList<>(Arrays.asList("M1MAR67P", "MON", 1, "MAR", 6, "Jessica", 3, "OLI678", "Booked")),
            new ArrayList<>(Arrays.asList("W3MAR45P", "WED", 3, "MAR", 4, "Sophie", 2, "CHA042", "Booked")),
            new ArrayList<>(Arrays.asList("W3MAR56P", "WED", 3, "MAR", 5, "Benjamin", 2, "OLI678", "Attended")),
            new ArrayList<>(Arrays.asList("W3MAR67P", "WED", 3, "MAR", 6, "Michael", 3, "EMI769", "Booked")),
            new ArrayList<>(Arrays.asList("F5MAR45P", "FRI", 5, "MAR", 4, "Sophie", 3, "OLI678", "Booked")),
            new ArrayList<>(Arrays.asList("F5MAR56P", "FRI", 5, "MAR", 5, "Jessica", 3, "EMI769", "Cancelled")),
            new ArrayList<>(Arrays.asList("F5MAR67P", "FRI", 5, "MAR", 6, "Sophie", 1, "CHA042", "Attended")),
            new ArrayList<>(Arrays.asList("S6MAR23P", "SAT", 6, "MAR", 2, "Benjamin", 1, "SAM123", "Booked")),
            new ArrayList<>(Arrays.asList("S6MAR34P", "SAT", 6, "MAR", 3, "Michael", 2, "OLI678", "Booked")),
            new ArrayList<>(Arrays.asList("M8MAR45P", "MON", 8, "MAR", 4, "Sophie", 3, "EMI769", "Booked")),
            new ArrayList<>(Arrays.asList("M8MAR56P", "MON", 8, "MAR", 5, "Jessica", 1, "JAM145", "Cancelled")),
            new ArrayList<>(Arrays.asList("M8MAR67P", "MON", 8, "MAR", 6, "Michael", 4, "OLI678", "Attended")),
            new ArrayList<>(Arrays.asList("W10MAR45P", "WED", 10, "MAR", 4, "Sophie", 1, "JAM145", "Booked")),
            new ArrayList<>(Arrays.asList("W10MAR56P", "WED", 10, "MAR", 5, "Benjamin", 2, "SAM123", "Cancelled")),
            new ArrayList<>(Arrays.asList("W10MAR67P", "WED", 10, "MAR", 6, "Michael", 2, "OLI678", "Cancelled")),
            new ArrayList<>(Arrays.asList("F12MAR45P", "FRI", 12, "MAR", 4, "Sophie", 4, "EMI769", "Booked")),
            new ArrayList<>(Arrays.asList("F12MAR56P", "FRI", 12, "MAR", 5, "Benjamin", 1, "CHA042", "Booked")),
            new ArrayList<>(Arrays.asList("F12MAR67P", "FRI", 12, "MAR", 6, "Sophie", 4, "OLI678", "Attended")),
            new ArrayList<>(Arrays.asList("S13MAR36P", "SAT", 13, "MAR", 2, "Jessica", 3, "EMI769", "Booked")),
            new ArrayList<>(Arrays.asList("S13MAR36P", "SAT", 13, "MAR", 3, "Michael", 1, "JAM145", "Booked")),
            new ArrayList<>(Arrays.asList("M15MAR45P", "MON", 15, "MAR", 4, "Benjamin", 1, "SAM123", "Attended")),
            new ArrayList<>(Arrays.asList("M15MAR56P", "MON", 15, "MAR", 5, "Halen", 1, "CHA042", "Attended")),
            new ArrayList<>(Arrays.asList("M15MAR67P", "MON", 15, "MAR", 6, "Sophie", 1, "JAM145", "Cancelled")),
            new ArrayList<>(Arrays.asList("W17MAR45P", "WED", 17, "MAR", 4, "Jessica", 3, "EMI769", "Booked")),
            new ArrayList<>(Arrays.asList("W17MAR56P", "WED", 17, "MAR", 5, "Benjamin", 2, "OLI678", "Cancelled")),
            new ArrayList<>(Arrays.asList("W17MAR67P", "WED", 17, "MAR", 6, "Michael", 1, "JAM145", "Booked")),
            new ArrayList<>(Arrays.asList("F19MAR45P", "FRI", 19, "MAR", 4, "Sophie", 3, "EMI769", "Cancelled")),
            new ArrayList<>(Arrays.asList("F19MAR56P", "FRI", 19, "MAR", 5, "Jessica", 1, "CHA042", "Attended")),
            new ArrayList<>(Arrays.asList("F19MAR67P", "FRI", 19, "MAR", 6, "Benjamin", 3, "OLI678", "Cancelled")),
            new ArrayList<>(Arrays.asList("S20MAR36P", "SAT", 20, "MAR", 2, "Michael", 4, "EMI769", "Booked")),
            new ArrayList<>(Arrays.asList("S20MAR36P", "SAT", 20, "MAR", 3, "Halen", 1, "JAM145", "Booked")),
            new ArrayList<>(Arrays.asList("M22MAR45P", "MON", 22, "MAR", 4, "Sophie", 1, "CHA042", "Booked")),
            new ArrayList<>(Arrays.asList("M22MAR56P", "MON", 22, "MAR", 5, "Jessica", 3, "EMI769", "Attended")),
            new ArrayList<>(Arrays.asList("M22MAR67P", "MON", 22, "MAR", 6, "Benjamin", 2, "OLI678", "Attended")),
            new ArrayList<>(Arrays.asList("W24MAR45P", "WED", 24, "MAR", 4, "Sophie", 1, "JAM145", "Cancelled")),
            new ArrayList<>(Arrays.asList("W24MAR56P", "WED", 24, "MAR", 5, "Jessica", 4, "EMI769", "Booked")),
            new ArrayList<>(Arrays.asList("W24MAR67P", "WED", 24, "MAR", 6, "Sophie", 2, "CHA042", "Booked")),
            new ArrayList<>(Arrays.asList("F26MAR45P", "FRI", 26, "MAR", 4, "Michael", 3, "EMI769", "Attended")),
            new ArrayList<>(Arrays.asList("F26MAR56P", "FRI", 26, "MAR", 5, "Jessica", 2, "OLI678", "Booked")),
            new ArrayList<>(Arrays.asList("F26MAR67P", "FRI", 26, "MAR", 6, "Sophie", 1, "JAM145", "Cancelled")),
            new ArrayList<>(Arrays.asList("S27MAR36P", "SAT", 27, "MAR", 2, "Benjamin",4, "EMI769", "Booked")),
            new ArrayList<>(Arrays.asList("S27MAR36P", "SAT", 27, "MAR", 3, "Sophie", 1, "JAM145", "Booked")),
            new ArrayList<>(Arrays.asList("M29MAR45P", "MON", 29, "MAR", 4, "Michael", 2, "OLI678", "Cancelled")),
            new ArrayList<>(Arrays.asList("M29MAR56P", "MON", 29, "MAR", 5, "Sophie", 3, "EMI769", "Attended")),
            new ArrayList<>(Arrays.asList("M29MAR67P", "MON", 29, "MAR", 6, "Benjamin", 1, "CHA042", "Attended"))
    ));
}
