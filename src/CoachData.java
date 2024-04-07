import java.util.ArrayList;
import java.util.Arrays;

public class CoachData {

    static ArrayList<Object> coachData = new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList("Michael", 47 , 6, 7.83)),
            new ArrayList<>(Arrays.asList("Sophie", 47 , 6, 7.8)),
            new ArrayList<>(Arrays.asList("Benjamin", 47 , 6, 7.8)),
            new ArrayList<>(Arrays.asList("Jessica", 47 , 6, 7.8))
    ));

    public static ArrayList<Object> getCoachData() {
        return coachData;
    }

    public static void calculatingCoachRating(String coach , int rating){
        for (Object coachArray : coachData){
            ArrayList<Object> coachInfo = (ArrayList<Object>) coachArray;
            String name = (String) coachInfo.get(0);
            int totalRating = (int) coachInfo.get(1);
            int numberOfLearnerGivingReview = (int) coachInfo.get(2);
            double avarageRating = (double) coachInfo.get(3);
            if(coach.equals(name)){
                totalRating = totalRating + rating;
                numberOfLearnerGivingReview += 1;
                avarageRating = (totalRating) /numberOfLearnerGivingReview;
                coachInfo.set(1, totalRating);
                coachInfo.set(2, numberOfLearnerGivingReview);
                coachInfo.set(3,avarageRating);
            }
        }
    }
    public void coachMonthlyReport(){
        final int MAX_NAME_WIDTH = 20;
        final int MAX_RATING_WIDTH = 10;
        for (Object coachArray : coachData){
            ArrayList<Object> coachInfo = (ArrayList<Object>) coachArray;
            String name = (String) coachInfo.get(0);
            int totalRating = (int) coachInfo.get(1);
            int numberOfLearnerGivingReview = (int) coachInfo.get(2);
            double avarageRating = (double) coachInfo.get(3);
            // Format the name and rating with padding to achieve equal spacing
            String formattedName = String.format("%-" + MAX_NAME_WIDTH + "s", name);
            String formattedRating = String.format("%-" + MAX_RATING_WIDTH + ".2f", avarageRating);

            // Print the formatted coach information
            System.out.println("com.hatfield_swimmingbooking.util.Coach Name: " + formattedName + "\tRating: " + formattedRating);
        }

    }
}
