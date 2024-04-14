package ExceptionHandeling;

import View.SwimmingLessonView;

import java.util.Scanner;

public class InputHandeling {

    public static String getUserStringInput() {
        Scanner read = new Scanner(System.in);
        String input = read.nextLine().trim().toLowerCase();
        if (input.equals("menu")) {
            SwimmingLessonView.swimmingBookingStart();
        }
        return input;
    }

    public static int getUserIntInput() {
        Scanner read = new Scanner(System.in);
        int input = read.nextInt();
        if (input == 0) {
            SwimmingLessonView.swimmingBookingStart();
        }
        return input;
    }
}
