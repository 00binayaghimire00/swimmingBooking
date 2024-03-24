import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static javax.swing.UIManager.get;

public class Student extends User {
    private int grade;
    ArrayList<Object> studentData = Data.getStudentData();
    ArrayList<Object> bookingData = Booking.getBookingData();
    static ArrayList<ArrayList<Object>> lessonDisplay = new ArrayList<>();
    Scanner read = new Scanner(System.in);

    public Student(String name, String uid, int grade) {
        Main.Name = name;
        Main.Uid = uid;
        Main.Grade = grade;

    }

    public void bookingClasses() {
        System.out.println("\n\nPlease choose how you want to display the lessons:");
        System.out.println("\t1. By Day \n\t2. By Coach Name \n\t3. By Grade");
        int lessonDisplayOptions = read.nextInt();
        if ( lessonDisplayOptions >0 && (lessonDisplayOptions < 4)){
            switch (lessonDisplayOptions){
                case 1:
                    System.out.println("Enter Day : eg MON for Monday");
                    String optionDay = read.next().toUpperCase();
                    for (Object bookingArray : bookingData) {
                        ArrayList<Object> bookingInfo = (ArrayList<Object>) bookingArray;
                        String Day = ((String) bookingInfo.get(1)).toUpperCase();
                        if (optionDay.equals(Day)) {
                            int Date = (int) bookingInfo.get(2);
                            String Month = ((String) bookingInfo.get(3));
                            int Time = (int) bookingInfo.get(4);
                            String Coach = (String) bookingInfo.get(5);
                            int Grade = (int) bookingInfo.get(6);
                            lessonDisplay(Day, Date, Month, Time, Coach, Grade);
                        }
                    }
                    if (lessonDisplay.isEmpty()){
                        System.out.println("There is no available lessons on "+ optionDay+"-DAY");
                    }else {
                        lessonPrint();
                    }
                    break;

                case 2:
                    System.out.println("Enter the coach name: eg Halen");
                    String optionCoach = read.next().toUpperCase();
                    for (Object bookingArray : bookingData) {
                        ArrayList<Object> bookingInfo = (ArrayList<Object>) bookingArray;
                        String Coach = (String) bookingInfo.get(5);
                        if (optionCoach.equals(Coach)) {
                            int Date = (int) bookingInfo.get(2);
                            String Month = ((String) bookingInfo.get(3));
                            int Time = (int) bookingInfo.get(4);
                            int Grade = (int) bookingInfo.get(6);
                            String Day = ((String) bookingInfo.get(1)).toUpperCase();
                            lessonDisplay(Day, Date, Month, Time, Coach, Grade);
                        }
                    }
                    if (lessonDisplay.isEmpty()){
                        System.out.println("There is no available lessons on "+ optionCoach+" Coach");
                    }else {
                        lessonPrint();
                    }
                    break;
                case 3:
                    System.out.println("Enter the Grade: range 1 to 5");
                    int optionGrade = read.nextInt();
                    for (Object bookingArray : bookingData) {
                        ArrayList<Object> bookingInfo = (ArrayList<Object>) bookingArray;
                        int Grade = (int) bookingInfo.get(6);
                        if (optionGrade == Grade) {
                            int Date = (int) bookingInfo.get(2);
                            String Month = ((String) bookingInfo.get(3));
                            int Time = (int) bookingInfo.get(4);
                            String Coach = (String) bookingInfo.get(5);
                            String Day = ((String) bookingInfo.get(1)).toUpperCase();
                            lessonDisplay(Day, Date, Month, Time, Coach, Grade);
                        }
                    }
                    if (lessonDisplay.isEmpty()){
                        System.out.println("There is no available lessons on Grade "+ optionGrade);
                    }else {
                        lessonPrint();
                    }
                    break;
            }
        }else{
            System.out.println("\n\nPlease enter valid option");
            System.out.println("\n\t1. By Day \n\t2. By Coach Name \n\t3. By Grade");
            lessonDisplayOptions = read.nextInt();
        }

        // array list have id, day, date, month, time, coach, grade, participants, rating, review
        System.out.println("Please choose the lesson avaiable lesson");
        String Uid = Main.Uid;
        System.out.println("Day: eg MON for Monday");
        String chosenDay = read.next().toUpperCase();
        System.out.println("Month: eg APR for April");
        String chosenMonth = read.next().toUpperCase();
        System.out.println("Date:");
        int chosenDate = read.nextInt();
        System.out.println("Time:");
        int chosenTime = read.nextInt();
        System.out.println("Coach Name: eg Halen");
        String chosenCoach = read.next().toUpperCase();
        System.out.println("Enter your grade or one step higher:");
        int chosenGrade = read.nextInt();

        // id, day, date, month, time, coach, grade, participants, rating, review
        for (Object bookingArray : bookingData) {
            ArrayList<Object> bookingInfo = (ArrayList<Object>) bookingArray;
            String bookingId = (String) bookingInfo.get(0);
            String bookingDay = (String) bookingInfo.get(1);
            int bookingDate = (int) bookingInfo.get(2);
            String bookingMonth = (String) bookingInfo.get(3);
            int bookingTime = (int) bookingInfo.get(4);
            String bookingCoach = ((String) bookingInfo.get(5)).toUpperCase();
            int bookingGrade = (int) bookingInfo.get(6);

            if (chosenDay.equals(bookingDay) && chosenMonth.equals(bookingMonth) &&
                    chosenDate == bookingDate && chosenTime == bookingTime &&
                    chosenCoach.equals(bookingCoach) && chosenGrade == bookingGrade) {
                int participants = 0; // These variables don't need to be redeclared here
                int cancelled = 0;
                int rating = 0;
                String review = "No Rating";
                // Storing data from bookingData Array to BookedData Array
                Booking.bookedData(bookingId, chosenDay, chosenMonth, chosenDate, chosenTime,
                        chosenCoach, chosenGrade, participants, cancelled, rating);
            }
        }

        System.out.println(Booking.bookedDate); // Debug print to check if bookedDate is updated
        //System.out.println("Your booking has been placed for "+Day+" "+Date+" "+Month+" ("+Time+"-"+(Time+1)+" PM)");
        System.out.println("Your booking has been placed.\nReturning back to home menu.\nPlease wait...");
        Swimming.swimmingBookingStart();
        }


    public void bookingChanges() {
        Scanner read = new Scanner(System.in);
        System.out.println("Do you with to Update or Cancel booking");
        System.out.println("\t1. Update\n" +
                "\t2. Cancel");
        int n = read.nextInt();
        try {
            if (n == 1) {
                System.out.println("Please enter your name");
                String checkName = read.next();

                System.out.println("Please enter your phone number: ");
                String checkPhoneNumber = read.next();

            } else if (n == 2) {
                System.out.println("Please enter your name");
                String checkName = read.next();

                System.out.println("Please enter your phone number: ");
                String checkPhoneNumber = read.next();

            } else {
                System.out.println("Invalid input..");
                bookingChanges();
            }

        } catch (Exception e) {
            System.out.println("Invalid input..");
            bookingChanges();
        }
    }

    public void attendSwimming() {
        System.out.println("Wait till your class completes");
        try {
            Thread.sleep(2000);
            System.out.println("You have completed the class");

            System.out.println("Returning back to home");
            Thread.sleep(2000);
            Swimming.swimmingBookingStart();
        } catch (InterruptedException e) {
            System.out.println("You inturrupted the class\n" + "Please try again!!");
            attendSwimming();
        }
    }

    public void lernerMonthlyReport() {

    }

    public void registerLerner() {
        Scanner read = new Scanner(System.in);
        System.out.println("Welcome! Please fill the form below");
        System.out.println("Please Enter your name: ");
        String name = read.next();
        int age = checkAge();
        String phoneNumber = checkPhoneNumber();
        System.out.println("Please Enter your gender: ");
        String gender = read.next();
        System.out.println("Please Enter your grade: ");
        int grade = read.nextInt();
        String uid = name.substring(0, 3).toUpperCase() + Integer.toString((int) (10000 + Math.random() * 9999999)).substring(2, 5);
        Data data = new Data();
        // how to is set Name and Uid from here to main
        data.createStudent(uid, name, age, phoneNumber, gender, grade);
    }

    public int checkAge() {
        Scanner read = new Scanner(System.in);
        int age = 0;
        boolean validAge = false;
        while (!validAge) {
            try {
                System.out.println("Please Enter your age: ");
                age = read.nextInt();
                if (age >= 4 && age <= 11) {
                    validAge = true;
                } else {
                    System.out.println("Your age must be between 4 and 11");
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid Input... \nPlease enter a valid age.");
                read.nextLine();
            }
        }
        return age;
    }

    public String checkPhoneNumber() {
        Scanner read = new Scanner(System.in);
        double phoneNumber = 0;
        boolean validPhoneNumber = false;
        while (!validPhoneNumber) {
            try {
                System.out.println("Please Enter your phone number: ");
                phoneNumber = read.nextDouble();
                if (phoneNumber == 10) {
                    validPhoneNumber = true;
                    ;
                } else {
                    System.out.println("Your phone number must be 10 digits");
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid Input... \nPlease enter a valid phone number.");
                read.nextLine();
            }
        }
        return "" + phoneNumber;
    }

    static void lessonDisplay(String Day, int Date, String Month, int Time, String Coach, int Grade) {
        ArrayList<Object> data = new ArrayList<>();
        data.add(Day);
        data.add(Date);
        data.add(Month);
        data.add(Time);
        data.add(Coach);
        data.add(Grade);
        lessonDisplay.add(data);
    }

    public void lessonPrint(){
        for (ArrayList<Object> objects : lessonDisplay) {
            String Day = ((String) objects.get(0)).toUpperCase(); // Index 0 for Day
            int Date = (int) objects.get(1); // Index 1 for Date
            String Month = ((String) objects.get(2)); // Index 2 for Month
            int Time = (int) objects.get(3); // Index 3 for Time
            String Coach = (String) objects.get(4); // Index 4 for Coach
            int Grade = (int) objects.get(5); // Index 5 for Grade
            System.out.println("Day: " + Day + "\tMonth: " + Month + "\tDate: " + Date +"\t\tTime: From " + Time + " to " + (Time + 1) + "\t\tCoach: " + Coach + "\tGrade: " + Grade);
        }
    }


}


