import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Student {
    ArrayList<Object> studentData = Data.getStudentData();
    ArrayList<Object> bookingData = Booking.getBookingData();
    ArrayList<Object> bookedData = Booking.getBookedDate();
    static ArrayList<ArrayList<Object>> lessonDisplay = new ArrayList<>();
    Scanner read = new Scanner(System.in);

    public void bookingClasses() {
        System.out.println("\nPlease choose how you want to display the lessons:");
        System.out.println("\t1. By Day \n\t2. By Coach Name \n\t3. By Grade");
        int lessonDisplayOptions = read.nextInt();
        if (lessonDisplayOptions > 0 && (lessonDisplayOptions < 4)) {
            switch (lessonDisplayOptions) {
                case 1:
                    System.out.println("Enter Day : eg MON for Monday");
                    String optionDay = read.next().toUpperCase();
                    for (Object bookingArray : bookingData) {
                        ArrayList<Object> bookingInfo = (ArrayList<Object>) bookingArray;
                        String Day = ((String) bookingInfo.get(1)).toUpperCase();
                        if (optionDay.equals(Day)) {
                            String BID = (String) bookingInfo.get(0);
                            Day = (String) bookingInfo.get(1);
                            int Date = (int) bookingInfo.get(2);
                            String Month = ((String) bookingInfo.get(3));
                            int Time = (int) bookingInfo.get(4);
                            String Coach = (String) bookingInfo.get(5);
                            int Grade = (int) bookingInfo.get(6);
                            int Participants = (int) bookingInfo.get(7);
                            lessonDisplay(BID,Day, Date, Month, Time, Coach, Grade, Participants);
                        }
                    }
                    if (lessonDisplay.isEmpty()) {
                        System.out.println("There is no available lessons on " + optionDay + "-DAY");
                    } else {
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
                            String BID = (String) bookingInfo.get(0);
                            String Day = (String) bookingInfo.get(1);
                            int Date = (int) bookingInfo.get(2);
                            String Month = ((String) bookingInfo.get(3));
                            int Time = (int) bookingInfo.get(4);
                            Coach = (String) bookingInfo.get(5);
                            int Grade = (int) bookingInfo.get(6);
                            int Participants = (int) bookingInfo.get(7);
                            lessonDisplay(BID,Day, Date, Month, Time, Coach, Grade, Participants);
                        }
                    }
                    if (lessonDisplay.isEmpty()) {
                        System.out.println("There is no available lessons on " + optionCoach + " Coach");
                    } else {
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
                            String BID = (String) bookingInfo.get(0);
                            String Day = (String) bookingInfo.get(1);
                            int Date = (int) bookingInfo.get(2);
                            String Month = ((String) bookingInfo.get(3));
                            int Time = (int) bookingInfo.get(4);
                            String Coach = (String) bookingInfo.get(5);
                            Grade = (int) bookingInfo.get(6);
                            int Participants = (int) bookingInfo.get(7);
                            lessonDisplay(BID,Day, Date, Month, Time, Coach, Grade, Participants);
                        }
                    }
                    if (lessonDisplay.isEmpty()) {
                        System.out.println("There is no available lessons on Grade " + optionGrade);
                    }else {
                        lessonPrint();
                    }
                    break;
            }
        }else{
            System.out.println("\nPlease enter valid option");
            System.out.println("\t1. By Day \n\t2. By Coach Name \n\t3. By Grade");
            lessonDisplayOptions = read.nextInt();
        }
        // array list have id, day, date, month, time, coach, grade, participants, rating, review
        String Uid = Main.Uid;

        System.out.println("Please enter the lesson avaiable lesson booking ID");
        String choosenBookingID = read.next().toUpperCase();

        // id 0, day 1, date 2, month 3, time 4, coach 5, grade 6, participants 7, rating 8, review 9
        // (BID 0,Day 1, Date 2, Month 3, Time 4, Coach 5, Grade 6, Participants 7)
        for (Object bookingArray : bookingData) {
            ArrayList<Object> bookingInfo = (ArrayList<Object>) bookingArray;
            String bookingID = (String) bookingInfo.get(0);
            String bookingDay = (String) bookingInfo.get(1);
            int bookingDate = (int) bookingInfo.get(2);
            String bookingMonth = (String) bookingInfo.get(3);
            int bookingTime = (int) bookingInfo.get(4);
            String bookingCoach = ((String) bookingInfo.get(5)).toUpperCase();
            int bookingGrade = (int) bookingInfo.get(6);
            int bookingParticipants = (int) bookingInfo.get(7);
            if (Main.Grade == bookingGrade || Main.Grade + 1 == bookingGrade) {
                if (choosenBookingID.equals(bookingID)) {
                    Booking.makeBooking(bookingID, bookingParticipants);
                    bookingInfo.set(7, bookingParticipants+1);
                    int cancelled = 0;
                    int rating = 0;
                    String review = "No Rating";
                    // Storing data from bookingData Array to BookedData Array
                    Booking.bookedData(bookingID, bookingDay, bookingDate, bookingMonth, bookingTime,
                            bookingCoach, bookingGrade, bookingParticipants, cancelled, rating, review);
                    System.out.println("Booking conformed!!");
                    System.out.println("You have lesson on "+bookingMonth+" "+bookingDay+" from "+bookingTime+" to "+(bookingTime+1));
                }
            } else {
                System.out.println("You cannot book this lesson. Your grade level doesn't match the course.");
                choosenBookingID = read.next();
            }
        }
    }

    public void bookingChanges() {
        Scanner read = new Scanner(System.in);
        for (Object bookingArray : Booking.bookedDate) {
            ArrayList<Object> bookingInfo = (ArrayList<Object>) bookingArray;
            String Day = ((String) bookingInfo.get(1)).toUpperCase();
            String BID = (String) bookingInfo.get(0);
            Day = (String) bookingInfo.get(1);
            int Date = (int) bookingInfo.get(2);
            String Month = ((String) bookingInfo.get(3));
            int Time = (int) bookingInfo.get(4);
            String Coach = (String) bookingInfo.get(5);
            int Grade = (int) bookingInfo.get(6);
            int Participants = (int) bookingInfo.get(7);
            lessonDisplay(BID, Day, Date, Month, Time, Coach, Grade, Participants);
        }
        bookingIDCheck();
        for (Object bookingArray : bookedData){
            ArrayList<Object> bookingInfo = (ArrayList<Object>) bookingArray;
            String bookingID = (String) bookingInfo.get(0);
            int bookingParticipants = (int) bookingInfo.get(7);
            if (Booking.userLessonRecord.containsKey(bookingID)) {
                System.out.println("Do you with to Update or Cancel booking");
                System.out.println("\t1. Cancel\n" +
                        "\t2. Update");
                int n = read.nextInt();
                switch (n){
                    case 1:
                        bookingInfo.set(7, bookingParticipants-1);
                        System.out.println("Booking Cancelled");
                        break;
                    case 2:
                        bookingInfo.set(7, bookingParticipants-1);
                        System.out.println("Updating the booking Data");
                        bookingClasses();
                        break;
                    default:
                        System.out.println("Invalid Input..");
                        System.out.println("Please give the correct option");
                        n = read.nextInt();
                }
            }
        }
    }

    public void attendSwimming() {
        Scanner read = new Scanner(System.in);
        for (Object bookingArray : Booking.bookedDate) {
            ArrayList<Object> bookingInfo = (ArrayList<Object>) bookingArray;
            String Day = ((String) bookingInfo.get(1)).toUpperCase();
            String BID = (String) bookingInfo.get(0);
            Day = (String) bookingInfo.get(1);
            int Date = (int) bookingInfo.get(2);
            String Month = ((String) bookingInfo.get(3));
            int Time = (int) bookingInfo.get(4);
            String Coach = (String) bookingInfo.get(5);
            int Grade = (int) bookingInfo.get(6);
            int Participants = (int) bookingInfo.get(7);
            lessonDisplay(BID ,Day, Date, Month, Time, Coach, Grade, Participants);
        }
        bookingIDCheck();
        for (Object bookingArray : bookedData){
            ArrayList<Object> bookingInfo = (ArrayList<Object>) bookingArray;
            String bookingID = (String) bookingInfo.get(0);
            String Day = (String) bookingInfo.get(1);
            int Date = (int) bookingInfo.get(2);
            String Month = ((String) bookingInfo.get(3));
            int Time = (int) bookingInfo.get(4);
            String Coach = (String) bookingInfo.get(5);
            int Grade = (int) bookingInfo.get(6);
            int Participants = (int) bookingInfo.get(7);
            if (Booking.userLessonRecord.containsKey(bookingID)) {
                Booking.addAttendanceRecord(Month);
                System.out.println("Please give rating on this lesson out of 10");
                int Rating = read.nextInt();
                if(Rating < 11 ) {
                    System.out.println("Please write review on this lesson");
                    String Review = read.nextLine();
                    Booking.addOnOldBookingData(bookingID, Day, Date, Month, Time, Coach, Grade, Participants,Rating, Review);
                    if (Main.Grade <= 5) {
                        Main.Grade += 1;
                    }
                }else{
                    System.out.println("your review is more than 10\nPlease try again");
                    Rating = read.nextInt();
                }
            }
        }
    }

    public void lernerMonthlyReport() {
        Scanner read = new Scanner(System.in);
        System.out.println("Please select following for report");
        System.out.println("\t1. Report of Learner.\t2.Report of Coach");
        int choosenOptions = read.nextInt();
        switch (choosenOptions){
            case 1:
                System.out.println("Report of Learner");
            case 2:
                System.out.println("Report of Coach");
            default:
                System.out.println("Invalid Input...\nPlease enter options again");
                choosenOptions = read.nextInt();
        }
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

    static void lessonDisplay(String LessonID, String Day, int Date, String Month, int Time, String Coach, int Grade, int Participants) {
        ArrayList<Object> data = new ArrayList<>();
        data.add(LessonID);
        data.add(Day);
        data.add(Date);
        data.add(Month);
        data.add(Time);
        data.add(Coach);
        data.add(Grade);
        data.add(Participants);
        lessonDisplay.add(data);
    }

    public void lessonPrint(){
        for (ArrayList<Object> objects : lessonDisplay) {
            String BID = ((String) objects.get(0)).toUpperCase();
            String Day = ((String) objects.get(1)).toUpperCase(); // Index 0 for Day
            int Date = (int) objects.get(2); // Index 1 for Date
            String Month = ((String) objects.get(3)); // Index 2 for Month
            int Time = (int) objects.get(4); // Index 3 for Time
            String Coach = (String) objects.get(5); // Index 4 for Coach
            int Grade = (int) objects.get(6); // Index 5 for Grade
            int Participants = (int) objects.get(7); //Index 7  for Participants
            System.out.println("Booking ID: "+BID+"\tDay: " + Day + "\tMonth: " + Month + "\tDate: " + Date +"\t\tTime: From " + Time + " to " + (Time + 1) + "\t\tCoach: " + Coach + "\tGrade: " + Grade+"\t Participants: "+Participants);
        }
    }

    public void checkingUser() {
        System.out.println("Are you existing User. Type 'Y' for Yes and 'N' for No.");
        String checkOption = read.next().toUpperCase();
        if (checkOption.equals("Y")){
            System.out.println("Please Enter your Name");
            String checkName = read.next().toUpperCase();
            boolean validName = false;
            while (!validName) {
                for (Object arrayName : Data.studentData) {
                    ArrayList<Object> studentInfo = (ArrayList<Object>) arrayName;
                    String name = ((String) studentInfo.get(1)).toUpperCase();
                    if (name.equals(checkName)) {
                        validName = true;
                        Main.Name = ((String) studentInfo.get(1)).toUpperCase();
                        Main.Uid = (String) studentInfo.get(0);
                        Main.Grade = (int) studentInfo.get(5);
                        break;
                    }
                }
                if (!validName) {
                    System.out.println("\nInvalid name...");
                    System.out.println("Please enter your name again: ");
                    checkName = read.next().toUpperCase();
                }
            }

        }else if (checkOption.equals("N")){
            System.out.println("Do you with to register or exit the system");
            System.out.println("1. Add as New User. \n2. Exit");
            int checkingToAddUser = read.nextInt();
            switch (checkingToAddUser){
                case 1:
                    registerLerner();
                    break;
                case 2:
                    Swimming.exit();
                    break;
                default:
                    System.out.println("Invalid Input.\nPlease choose the right option");
                    checkingToAddUser = read.nextInt();
                    break;
            }
        }else{
            System.out.println("Invalid Input.\nPlease choose the right option");
            checkOption = read.next().toUpperCase();
        }
    }

    public void bookingIDCheck(){
        boolean validBookingID = false;
        String chosenBookingID = "";
        // Loop until a valid booking ID is provided
        while (!validBookingID) {
            System.out.println("Please enter the booking ID");
            chosenBookingID = read.next().toUpperCase();
            // Check if the chosen booking ID exists in the booked data
            for (Object bookingArray : bookedData) {
                ArrayList<Object> bookingInfo = (ArrayList<Object>) bookingArray;
                String bookingID = (String) bookingInfo.get(0);
                if (chosenBookingID.equals(bookingID)) {
                    validBookingID = true;
                    break;
                }
            }
            if (!validBookingID) {
                System.out.println("Invalid booking ID. Please enter a valid one.");
            }
        }
    }

}


