import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentController {
    ArrayList<Object> bookingData = BookingData.getBookingData();
    ArrayList<Object> bookedData = BookingData.getBookedDate();
    static ArrayList<ArrayList<Object>> lessonDisplay = new ArrayList<>();
    Scanner read = new Scanner(System.in);

    public void bookingClasses() {
        System.out.println("\nPlease choose how you want to display the lessons:");
        System.out.println("\t1. By Day \n\t2. By com.hatfield_swimmingbooking.util.Coach Name \n\t3. By Grade");
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
                        System.out.println(STR."There is no available lessons on \{optionDay}-DAY");
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
                        System.out.println(STR."There is no available lessons on \{optionCoach} CoachData");
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
                        System.out.println(STR."There is no available lessons on Grade \{optionGrade}");
                    }else {
                        lessonPrint();
                    }
                    break;
            }
        }else{
            System.out.println("\nPlease enter valid option");
            System.out.println("\t1. By Day \n\t2. By com.hatfield_swimmingbooking.util.Coach Name \n\t3. By Grade");
            lessonDisplayOptions = read.nextInt();
        }
        // array list have id, day, date, month, time, coach, grade, participants, rating, review

        System.out.println("Please enter the lesson avaiable lesson booking ID");
        String choosenBookingID = read.next().toUpperCase();

        // id 0, day 1, date 2, month 3, time 4, coach 5, grade 6, participants 7, rating 8, review 9
        // (BID 0,Day 1, Date 2, Month 3, Time 4, CoachData 5, Grade 6, Participants 7)
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
                    BookingData.makeBooking(bookingID, bookingParticipants);
                    bookingInfo.set(7, bookingParticipants+1);
                    for (Object bookedArray : bookedData){
                        ArrayList<Object> bookedInfo = (ArrayList<Object>) bookedArray;
                        String bookedID = (String) bookedInfo.get(0);
                        int bookedParticipants = (int) bookedInfo.get(7);
                        int bookedNumber = (int) bookedInfo.get(8);
                        if (bookedID.equals(bookingID)){
                            bookedInfo.set(8, bookedNumber+1);
                            bookedInfo.set(7, bookedParticipants +1);
                            System.out.println("Booking conformed!!");
                            System.out.println(STR."You have lesson on \{bookingMonth} \{bookingDay} from \{bookingTime} to \{bookingTime + 1}");
                            Main.userBookedLessons += 1;
                            SwimmingController.swimmingBookingStart();
                        }
                    }
                    int booked = 1;
                    int cancelled = 0;
                    int attended = 0;
                    int rating = 0;
                    String review = "No Rating";
                    // Storing data from bookingData Array to BookedData Array
                    BookingData.bookedData(bookingID, bookingDay, bookingDate, bookingMonth, bookingTime,
                            bookingCoach, bookingGrade, bookingParticipants, booked, cancelled, attended, rating, review);
                    System.out.println("com.hatfield_swimmingbooking.util.Booking conformed!!");
                    System.out.println(STR."You have lesson on \{bookingMonth} \{bookingDay} from \{bookingTime} to \{bookingTime + 1}");
                    Main.userBookedLessons += 1;
                }
            } else {
                System.out.println("You cannot book this lesson. Your grade level doesn't match the course.");
                choosenBookingID = read.next();
            }
        }
    }

    public void bookingChanges() {
        Scanner read = new Scanner(System.in);
        for (Object bookingArray : BookingData.getBookedDate()) {
            ArrayList<Object> bookingInfo = (ArrayList<Object>) bookingArray;
            String BID = (String) bookingInfo.get(0);
            String Day = (String) bookingInfo.get(1);
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
            int bookingCancelled = (int) bookingData.get(8);
            if (BookingData.getUserLessonRecord().containsKey(bookingID)) {
                System.out.println("Do you with to Update or Cancel booking");
                System.out.println("\t1. Cancel\n" +
                        "\t2. Update");
                int choosenOption = read.nextInt();
                switch (choosenOption){
                    case 1:
                        bookingInfo.set(7, bookingParticipants-1);
                        System.out.println("com.hatfield_swimmingbooking.util.Booking Cancelled");
                        Main.userCancelledLesson += 1;
                        bookingInfo.set(8 , bookingCancelled+1);
                        break;
                    case 2:
                        bookingInfo.set(7, bookingParticipants-1);
                        System.out.println("Updating the booking com.hatfield_swimmingbooking.util.Data");
                        Main.userCancelledLesson += 1;
                        bookingInfo.set(8 , bookingCancelled+1);
                        bookingClasses();
                        break;
                    default:
                        System.out.println("Invalid Input..");
                        System.out.println("Please give the correct option");
                        choosenOption = read.nextInt();
                }
            }
        }
    }

    public void attendSwimming() {
        Scanner read = new Scanner(System.in);
        for (Object bookingArray : BookingData.getBookingData()) {
            ArrayList<Object> bookingInfo = (ArrayList<Object>) bookingArray;
            String BID = (String) bookingInfo.get(0);
            String Day = ((String) bookingInfo.get(1)).toUpperCase();
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
            ArrayList<Object> bookedInfo = (ArrayList<Object>) bookingArray;
            String bookingID = (String) bookedInfo.get(0);
            String Day = (String) bookedInfo.get(1);
            int Date = (int) bookedInfo.get(2);
            String Month = ((String) bookedInfo.get(3));
            int Time = (int) bookedInfo.get(4);
            String Coach = (String) bookedInfo.get(5);
            int Grade = (int) bookedInfo.get(6);
            int Participants = (int) bookedInfo.get(7);
            int BookedNumber = (int) bookedInfo.get(8);
            int CancelledNumber = (int) bookedInfo.get(9);
            int AttainedNumber = (int) bookedInfo.get(10);
            int Rating = (int) bookedInfo.get(11);
            String Review = (String) bookedInfo.get(12);
            if (BookingData.getUserLessonRecord().containsKey(bookingID)) {
                BookingData.addAttendanceRecord(Month);
                System.out.println("Please give ranging from 1 to 5\n\t1: Very dissatisfied\n\t2: Dissatisfied\n\t3: Ok\n\t4: Satisfied\n\t5: Very Satisfied");
                Rating = read.nextInt();
                if(Rating > 0 && Rating < 6) {
                    System.out.println("Please write short review on this lesson");
                    Review = read.nextLine();
                    if ((Main.Grade+1) == Grade || Main.Grade <= 5) {
                        Main.Grade += 1;
                    }
                    Main.userAttendedLessons +=1;
                    CoachData.calculatingCoachRating(Coach, Rating);
                    // array list have String BID 0, String Day 1, int Date 2, String Month 3, int Time 4, String CoachData 5,
                    // int Grade 6, int Participants 7,int Booked 8, int Cancelled 9, int Attended 10, int Rating 11, String Review 12
                    if(Participants == 4){
                        BookingData.addOnOldBookingData(bookingID, Day, Date, Month, Time, Coach, Grade, Participants, BookedNumber, CancelledNumber, AttainedNumber, Rating, Review);
                    }
                }else{
                    System.out.println("Your rating is more than 5 or in Negative\nPlease try again");
                    Rating = read.nextInt();
                }
            }
        }
    }

    public void lernerMonthlyReport() {
        int bookedNumber = 0; // Initialize to 0
        int cancelledNumber = 0; // Initialize to 0
        int attainedNumber = 0; // Initialize to 0
        int numberOfLearners = 0; // Initialize to 0
        Scanner read = new Scanner(System.in);
        System.out.println("Please select the Month: e.g., MAR as March");
        String chosenMonth = read.next().toUpperCase();
        for(Object oldBookedArray : BookingData.getOldBookedData()){
            ArrayList<Object> oldBookedInfo = (ArrayList<Object>) oldBookedArray;
            String obtainedMonth = ((String) oldBookedInfo.get(3)).toUpperCase();
            if(chosenMonth.equals(obtainedMonth)){
                numberOfLearners += 1; // Increment the count of learners
                bookedNumber += (int) oldBookedInfo.get(8); // Accumulate bookings
                cancelledNumber += (int) oldBookedInfo.get(9); // Accumulate cancellations
                attainedNumber += (int) oldBookedInfo.get(10); // Accumulate attendance
            }
        }
        System.out.println("Montthly Report of the Learners");
        System.out.println("No. of users: "+numberOfLearners+"\tNo. of Bookings: "+bookedNumber+"\tNo. of Cancelled: "+cancelledNumber+"\tNo. of Attaindence: "+attainedNumber);
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
        if(grade < 0 || grade > 5){
            grade = read.nextInt();
        }
        String uid = name.substring(0, 3).toUpperCase() + Integer.toString((int) (10000 + Math.random() * 9999999)).substring(2, 5);
        // how to is set Name and Uid from here to main
        StudentData.createStudent(uid, name, age, phoneNumber, gender, grade , 0 ,0 ,0);
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
        String phoneNumber = "";
        boolean validPhoneNumber = false;
        while (!validPhoneNumber) {
            try {
                System.out.println("Please Enter your phone number: ");
                phoneNumber = read.next();
                if (phoneNumber.length() == 10) {
                    validPhoneNumber = true;
                } else {
                    System.out.println("Your phone number must be 10 digits");
                    phoneNumber = read.next();
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid Input... \nPlease enter a valid phone number.");
                phoneNumber = read.next();
            }
        }
        return phoneNumber;
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
            String Coach = (String) objects.get(5); // Index 4 for CoachData
            int Grade = (int) objects.get(6); // Index 5 for Grade
            int Participants = (int) objects.get(7); //Index 7  for Participants
            System.out.printf("com.hatfield_swimmingbooking.util.Booking ID: %-10s Day: %-10s Month: %-10s Date: %-10d Time: From %-1d to %-10d com.hatfield_swimmingbooking.util.Coach: %-10s Grade: %-10d Participants: %-10d%n",
                    BID, Day, Month, Date, Time, Time + 1, Coach, Grade, Participants);}
    }

    public void checkingUser() {
        System.out.println("Are you an existing user? Type 'Y' for Yes and 'N' for No.");
        String checkOption = read.next().toUpperCase();
        while (!checkOption.equals("Y") && !checkOption.equals("N")) {
            System.out.println("Invalid input. Please choose the right option (Y/N).");
            checkOption = read.next().toUpperCase();
        }
        if (checkOption.equals("Y")) {
            System.out.println("Please enter your name:");
            String checkName = read.next().toUpperCase();
            boolean validName = false;
            for (Object arrayName : StudentData.getStudentData()) {
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
                System.out.println("Invalid name.");
                checkingUser(); // Ask again for user input
            }
        } else if (checkOption.equals("N")) {
            System.out.println("Do you wish to register or exit the system?");
            System.out.println("1. Add as a New User\n2. Exit");
            int checkingToAddUser = read.nextInt();
            switch (checkingToAddUser) {
                case 1:
                    registerLerner();
                    break;
                case 2:
                    SwimmingController.exit();
                    break;
                default:
                    System.out.println("Invalid input. Please choose the right option.");
                    checkingUser(); // Ask again for user input
                    break;
            }
        }
    }

    public void bookingIDCheck(){
        boolean validBookingID = false;
        String chosenBookingID;
        // Loop until a valid booking ID is provided
        while (!validBookingID) {
            System.out.println("Please enter the booking ID");
            chosenBookingID = read.next().toUpperCase();
            // Check if the chosen booking ID exists in the booked data
            for (Object bookingArray : bookedData) {
                ArrayList<Object> bookingInfo = (ArrayList<Object>) bookingArray;
                String bookingID = (String) bookingInfo.getFirst();
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


