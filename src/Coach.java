import java.util.ArrayList;
import java.util.Arrays;

public class Coach {

    public Coach(){}

    static ArrayList<Object> coachData = new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList("Michael", 47 , 6, 7.83)),
            new ArrayList<>(Arrays.asList("Sophie", 47 , 6, 7.8)),
            new ArrayList<>(Arrays.asList("Benjamin", 47 , 6, 7.8)),
            new ArrayList<>(Arrays.asList("Jessica", 47 , 6, 7.8))
    ));

    public static ArrayList<Object> getCoachData() {
        return coachData;
    }

    public static void setCoachData(ArrayList<Object> coachData) {
        Coach.coachData = coachData;
    }

    public void coachMonthlyReport(){

    }
}
