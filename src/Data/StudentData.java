package Data;

import java.util.*;

public class StudentData {

    public StudentData() {
    }

    // uid 0 , name 1, age 2, phone number 3, gender 4, grade 5, booked 6, cancelled 7, attained 8
    public static ArrayList<Object> studentData = new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList("JAM145", "James", 7, "07400123456", "M", 1, 5, 1, 0)),
            new ArrayList<>(Arrays.asList("EMI769", "Emily", 11, "07700234567", "F", 3, 6, 1, 1)),
            new ArrayList<>(Arrays.asList("OLI678", "Oliver", 6, "07500345678", "M", 2, 5, 1, 0)),
            new ArrayList<>(Arrays.asList("CHA042", "Charlotte", 5, "07800456789", "F", 1, 5, 2, 0)),
            new ArrayList<>(Arrays.asList("SAM123", "Sam", 8, "07900123456", "M", 1, 1, 0, 0)),
            new ArrayList<>(Arrays.asList("AVA456", "Ava", 9, "07900234567", "F", 2, 0, 0, 0)),
            new ArrayList<>(Arrays.asList("MAX789", "Max", 10, "07900345678", "M", 3, 0, 0, 0)),
            new ArrayList<>(Arrays.asList("LUC012", "Lucy", 11, "07900456789", "F", 2, 1, 0, 0)),
            new ArrayList<>(Arrays.asList("JAC345", "Jack", 4, "07900567890", "M", 5, 0, 0, 0)),
            new ArrayList<>(Arrays.asList("SOP678", "Sophie", 6, "07900678901", "F", 0, 0, 0, 0)),
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
}