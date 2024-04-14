package Controller;
import Data.BookingData;
import ExceptionHandeling.InputHandeling;
import View.SwimmingLessonView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static Data.CoachData.coachData;

public class CoachDataController {
    public static double calculatingCoachRating(String coach, int rating) {
        double avarageRating = 0;
        for (Object coachArray : coachData) {
            ArrayList<Object> coachInfo = (ArrayList<Object>) coachArray;
            String name = (String) coachInfo.get(0);
            int totalRating = (int) coachInfo.get(1);
            int numberOfLearnerGivingReview = (int) coachInfo.get(2);
            avarageRating = (double) coachInfo.get(3);
            if (coach.equals(name)) {
                totalRating = totalRating + rating;
                numberOfLearnerGivingReview += 1;
                avarageRating = (double) (totalRating) / numberOfLearnerGivingReview;
                coachInfo.set(1, totalRating);
                coachInfo.set(2, numberOfLearnerGivingReview);
                coachInfo.set(3, avarageRating);
            }
        }
        return avarageRating;
    }

    public static void coachMonthlyReport(int chooseMonthNumber) {
        int checkingEmpty = 0;
        String chooseMonth = "";
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
        HashMap<String, ArrayList<Integer>> coachRatings = new HashMap<>();

        for (Object bookedArray : BookingData.previousBookingData) {
            ArrayList<Object> bookedInfo = (ArrayList<Object>) bookedArray;
            String bookedMonth = ((String) bookedInfo.get(3)).toUpperCase();
            if (chooseMonth.equals(bookedMonth)) {
                String coachName = (String) bookedInfo.get(5);
                int rating = (int) bookedInfo.get(11);

                if (!coachRatings.containsKey(coachName)) {
                    coachRatings.put(coachName, new ArrayList<>());
                }
                coachRatings.get(coachName).add(rating);
                checkingEmpty++;
            }
        }
        if (checkingEmpty == 0) {
            System.out.println("No Record found");
            SwimmingLessonView.swimmingBookingStart();
        }
        System.out.println("Monthly Report of the Coaches");
        for (Map.Entry<String, ArrayList<Integer>> entry : coachRatings.entrySet()) {
            double averageRating = entry.getValue().stream().mapToInt(Integer::intValue).average().orElse(0.0);
            String formattedAverage = String.format("%.2f", averageRating);
            System.out.printf("Coach: %-15s Average Rating: %s%n", entry.getKey(), formattedAverage);
        }
    }
}
