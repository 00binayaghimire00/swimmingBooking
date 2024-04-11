import java.util.*;

public class CoachData {

    static ArrayList<Object> coachData = new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList("Michael", 47 , 6, 7.83)),
            new ArrayList<>(Arrays.asList("Sophie", 47 , 6, 7.8)),
            new ArrayList<>(Arrays.asList("Benjamin", 47 , 6, 7.8)),
            new ArrayList<>(Arrays.asList("Jessica", 47 , 6, 7.8))
    ));


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
        int checkingEmpty = 0;
        Scanner read = new Scanner(System.in);
        String chooseMonth = "";
        System.out.println("Enter the month: eg 3 for March");
        int chooseMonthNumber = read.nextInt();
        switch (chooseMonthNumber){
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
                chooseMonthNumber = InputHandelling.getUserIntInput();
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
        if(checkingEmpty== 0){
            System.out.println("No Record found");
            SwimmingMethod.swimmingBookingStart();
        }
        System.out.println("Monthly Report of the Coaches");
        for (Map.Entry<String, ArrayList<Integer>> entry : coachRatings.entrySet()) {
            double averageRating = entry.getValue().stream().mapToInt(Integer::intValue).average().orElse(0.0);
            System.out.println("Coach: " + entry.getKey() + ", Average Rating: " + averageRating);
        }
    }


//        final int MAX_NAME_WIDTH = 20;
//        final int MAX_RATING_WIDTH = 10;
//        for (Object coachArray : coachData){
//            ArrayList<Object> coachInfo = (ArrayList<Object>) coachArray;
//            String name = (String) coachInfo.get(0);
//            int totalRating = (int) coachInfo.get(1);
//            int numberOfLearnerGivingReview = (int) coachInfo.get(2);
//            double avarageRating = (double) coachInfo.get(3);
//            // Format the name and rating with padding to achieve equal spacing
//            String formattedName = String.format("%-" + MAX_NAME_WIDTH + "s", name);
//            String formattedRating = String.format("%-" + MAX_RATING_WIDTH + ".2f", avarageRating);
//
//            // Print the formatted coach information
//            System.out.println("Coach Name: " + formattedName + "\tRating: " + formattedRating);
//        }

    }

