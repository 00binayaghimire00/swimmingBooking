package Main;
import View.SwimmingLessonView;

public class Main {
    public static String Name;
    public static String Uid;
    public static int Grade;
    public static int userBookedLessons;
    public static int userCancelledLesson;
    public static int userAttendedLessons;

    public static void main(String[] args) {
        System.out.println("\033[0;93m" + "If you wish to return to the main menu, you have two options:");
        System.out.println("\033[0;93m" + "\t1. If you're being asked for a character or string input, simply type 'menu'.");
        System.out.println("\033[0;93m" + "\t2. If you're being asked for a number, just enter '0' (Zero)."+ "\033[0m");
        System.out.println("Either of these actions will take you back to the main menu. Enjoy navigating through the application!" );
        SwimmingLessonView.swimmingBookingStart();
    }
}