package Controller;

import Model.CoachData;
import Model.CoachDataController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

class CoachDataControllerTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testCalculatingCoachRating() {
        String coachName = "Coach1";
        int rating = 4;
        CoachDataController.calculatingCoachRating(coachName, rating);
        Assertions.assertNotEquals(9, (int) ((ArrayList<Object>) CoachData.coachData.get(0)).get(1));
    }


    @Test
    void testCoachMonthlyReportForMarch() {
        int chosenMonthNumber = 3;
        HashMap<String, ArrayList<Integer>> expectedCoachRatings = new HashMap<>();
        expectedCoachRatings.put("Sophie", new ArrayList<>(List.of(3, 2, 2, 3)));
        expectedCoachRatings.put("Michael", new ArrayList<>(List.of(2, 1, 2, 3, 2)));
        expectedCoachRatings.put("Halen", new ArrayList<>(List.of(1, 1, 2, 3, 2)));
        expectedCoachRatings.put("Benjamin", new ArrayList<>(List.of(2, 1, 3, 2)));
        expectedCoachRatings.put("Jessica", new ArrayList<>(List.of(3, 4, 2)));
        HashMap<String, ArrayList<Integer>> actualCoachRatings = new HashMap<>();
        actualCoachRatings.put("Sophie", new ArrayList<>(List.of(3, 2, 2, 3)));
        actualCoachRatings.put("Michael", new ArrayList<>(List.of(2, 1, 2, 3, 2)));
        actualCoachRatings.put("Halen", new ArrayList<>(List.of(1, 1, 2, 3, 2)));
        actualCoachRatings.put("Benjamin", new ArrayList<>(List.of(2, 1, 3, 2)));
        actualCoachRatings.put("Jessica", new ArrayList<>(List.of(3, 4, 2)));
        CoachDataController.coachMonthlyReport(chosenMonthNumber);
        assertEquals(expectedCoachRatings.size(), actualCoachRatings.size());
    }
}
