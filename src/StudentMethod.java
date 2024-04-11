import java.util.*;

public class StudentMethod {
    ArrayList<Object> bookingData = BookingData.bookingData;
    ArrayList<Object> bookedData = BookingData.bookedDate;
    static ArrayList<Object> lessonDisplay = new ArrayList<>();
    Scanner read = new Scanner(System.in);

    public void bookingClasses() {
        System.out.println("\nPlease choose how you want to display the lessons:");
        System.out.println("\t1. By Day \n\t2. By Coach Name \n\t3. By Grade");
        int lessonDisplayOptions = InputHandelling.getUserIntInput();
        if (lessonDisplayOptions > 0 && (lessonDisplayOptions < 4)) {
            switch (lessonDisplayOptions) {
                case 1:
                    System.out.println("Enter Day : eg MON for Monday");
                    String optionDay = InputHandelling.getUserStringInput().toUpperCase();
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
                            lessonDisplay(BID, Day, Date, Month, Time, Coach, Grade, Participants);
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
                    String optionCoach = InputHandelling.getUserStringInput().toUpperCase();
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
                            lessonDisplay(BID, Day, Date, Month, Time, Coach, Grade, Participants);
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
                    int optionGrade = InputHandelling.getUserIntInput();
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
                            lessonDisplay(BID, Day, Date, Month, Time, Coach, Grade, Participants);
                        }
                    }
                    if (lessonDisplay.isEmpty()) {
                        System.out.println(STR."There is no available lessons on Grade \{optionGrade}");
                    } else {
                        lessonPrint();
                    }
                    break;
            }
        } else {
            System.out.println("\nPlease enter valid option");
            System.out.println("\t1. By Day \n\t2. By Coach Name \n\t3. By Grade");
            lessonDisplayOptions = InputHandelling.getUserIntInput();
        }
        // array list have id, day, date, month, time, coach, grade, participants, rating, review
        System.out.println("Please enter the available lesson booking ID");
        String chosenBookingID = InputHandelling.getUserStringInput().toUpperCase();
        bookingIDCheck(chosenBookingID);
        boolean isBookingDone = false;

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
            if (chosenBookingID.equals(bookingID)) {
                System.out.println("Main Grade: " + Main.Grade + "\nBooking Grade: " + bookingGrade);
                if (Main.Grade == bookingGrade || (Main.Grade + 1) == bookingGrade) {
                    BookingData.makeBooking(bookingID, bookingParticipants);
                    bookingInfo.set(7, bookingParticipants + 1);
                    boolean IDavailableInBookedData = false;
                    for (Object bookedArray : bookedData) {
                        ArrayList<Object> bookedInfo = (ArrayList<Object>) bookedArray;
                        String bookedID = (String) bookedInfo.get(0);
                        int bookedParticipants = (int) bookedInfo.get(7);
                        int bookedNumber = (int) bookedInfo.get(8);
                        if (bookedID.equals(bookingID)) {
                            IDavailableInBookedData = true;
                            bookedInfo.set(8, bookedNumber + 1);
                            bookedInfo.set(7, bookedParticipants + 1);
                            break;
                        }
                    }
                    if (IDavailableInBookedData) {
                        System.out.println("Booking confirmed!!");
                        System.out.println("You have lesson on " + bookingMonth + " " + bookingDate + ", " + bookingDay + " from " + bookingTime + " to " + (bookingTime + 1));
                        SwimmingMethod.swimmingBookingStart();
                        isBookingDone = true;
                    } else {
                        int booked = 1;
                        int cancelled = 0;
                        int attended = 0;
                        int rating = 0;
                        String review = " ";
                        // Storing data from bookingData Array to BookedData Array
                        BookingData.addBookedData(bookingID, bookingDay, bookingDate, bookingMonth, bookingTime,
                                bookingCoach, bookingGrade, bookingParticipants, booked, cancelled, attended, rating, review);
                        System.out.println("Booking confirmed!!");
                        System.out.println("You have a lesson on " + bookingDay + " " + bookingDate + " " + bookingMonth + ", from " + bookingTime + " to " + (bookingTime + 1) + " o'clock.");
                        System.out.println(BookingData.bookedDate);
                        System.out.println(bookingInfo);
                        isBookingDone = true;

                    }
                    Main.userBookedLessons++;
                    SwimmingMethod.setUserRecord();
                    break;
                }
            }
        }

        if (!isBookingDone) {
            System.out.println("Your Grade doesn't match the lesson.");
            SwimmingMethod.swimmingBookingStart();
        }
    }
    public void bookingChanges() {
        checkingUser();
        Scanner read = new Scanner(System.in);
        displayUsersLesson();
        System.out.println("Please enter the your lesson booking ID");
        String choosenBookingID = InputHandelling.getUserStringInput().toUpperCase();
        bookingIDCheck(choosenBookingID);
        for (Object bookingArray : BookingData.bookedDate) {
            ArrayList<Object> bookingInfo = (ArrayList<Object>) bookingArray;
            String bookingID = (String) bookingInfo.get(0);
            int bookingParticipants = (int) bookingInfo.get(7);
            int bookingCancelled = (int) bookingInfo.get(8);
            if (BookingData.userLessonRecord.containsKey(bookingID)) {
                int choosenOption = 0;
                while (choosenOption != 1 && choosenOption != 2) {
                    System.out.println("Do you with to Update or Cancel booking");
                    System.out.println("\t1. Cancel\n" +
                            "\t2. Update");
                    choosenOption = InputHandelling.getUserIntInput();
                    if (choosenOption == 1) {
                        bookingInfo.set(7, bookingParticipants - 1);
                        System.out.println("Booking Cancelled");
                        Main.userCancelledLesson++;
                        BookingData.moveUser(Main.Uid, bookingID, BookingData.usersBookedStatus, BookingData.usersCancelledStatus);
                        SwimmingMethod.setUserRecord();
                    } else if (choosenOption == 2) {
                        bookingInfo.set(7, bookingParticipants - 1);
                        System.out.println("Updating the booking Data");
                        Main.userCancelledLesson++;
                        BookingData.moveUser(Main.Uid, bookingID, BookingData.usersBookedStatus, BookingData.usersCancelledStatus);
                        SwimmingMethod.setUserRecord();
                        bookingClasses();
                    } else {
                        System.out.println("Invalid Input..");
                        System.out.println("Please give the correct option");
                    }
                }
            }
        }
    }

    public void attendSwimming() {
        checkingUser();
        Scanner read = new Scanner(System.in);
        for (Object bookingArray : BookingData.bookedDate) {
            ArrayList<Object> bookingInfo = (ArrayList<Object>) bookingArray;
            String BID = (String) bookingInfo.get(0);
            String Day = ((String) bookingInfo.get(1)).toUpperCase();
            int Date = (int) bookingInfo.get(2);
            String Month = ((String) bookingInfo.get(3));
            int Time = (int) bookingInfo.get(4);
            String Coach = (String) bookingInfo.get(5);
            int Grade = (int) bookingInfo.get(6);
            int Participants = (int) bookingInfo.get(7);
            System.out.printf("Booking ID: %-10s Day: %-10s Month: %-10s Date: %-10d Time: From %-1d to %-10d Coach: %-10s Grade: %-10d Participants: %-10d%n",
                    BID, Day, Month, Date, Time, Time + 1, Coach, Grade, Participants);
        }
        System.out.println("Please enter the your lesson booking ID");
        String choosenBookingID = InputHandelling.getUserStringInput().toUpperCase();
        bookingIDCheck(choosenBookingID);
        for (Object bookingArray : bookedData) {
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
            if (BookingData.userLessonRecord.containsKey(bookingID)) {
                BookingData.addAttendanceRecord(Month);
                while (true) {
                    System.out.println("Please give ranging from 1 to 5\n\t1: Very dissatisfied\n\t2: Dissatisfied\n\t3: Ok\n\t4: Satisfied\n\t5: Very Satisfied");
                    int rating = InputHandelling.getUserIntInput();
                    read.nextLine();
                    if (rating > 0 && rating < 6) {
                        System.out.println("Please write short review on this lesson");
                        String newReview = read.nextLine();
                        Review = Review + " | " + newReview;
                        bookedInfo.set(11, Rating + rating);
                        bookedInfo.set(12, Review);
                        Main.userAttendedLessons++;
                        SwimmingMethod.setUserRecord();
                        CoachData.calculatingCoachRating(Coach, Rating);
                        break;
                    } else {
                        System.out.println("Your rating is more than 5 or in Negative\nPlease try again");
                        Rating = InputHandelling.getUserIntInput();
                    }
                    BookingData.moveUser(Main.Uid, bookingID, BookingData.usersBookedStatus , BookingData.userAttendedStatus);
                    SwimmingMethod.setUserRecord();
                    CoachData.calculatingCoachRating(Coach, Rating);
                    // array list have String BID 0, String Day 1, int Date 2, String Month 3, int Time 4, String CoachData 5,
                    // int Grade 6, int Participants 7,int Booked 8, int Cancelled 9, int Attended 10, int Rating 11, String Review 12
                    if (Participants == 4) {
                        BookingData.addOnPreviousBookingData(bookingID, Day, Date, Month, Time, Coach, Grade, Participants, BookedNumber, CancelledNumber, AttainedNumber, Rating, Review);
                    }
                    break;
                }
            }
        }
    }

    public void lernerMonthlyReport() {
        System.out.println("Previous Montthly Report of the Learners");
        for (Object lernersArray : StudentData.studentData) {
            ArrayList<Object> studentInfo = (ArrayList<Object>) lernersArray;
            String name = (String) studentInfo.get(1);
            int grade = (int) studentInfo.get(5);
            int booked = (int) studentInfo.get(6);
            int cancelled = (int) studentInfo.get(7);
            int attended = (int) studentInfo.get(8);
            System.out.printf("Name: %-15s\tGrade: %1d\t\tLessons Booked: %1d\tLessons Cencelled: %1d\tLessons Attended: %1d\n", name, grade, booked, cancelled, attended);
        }
    }

    public void registerLerner() {
        Scanner read = new Scanner(System.in);
        System.out.println("Welcome! Please fill the form below");
        System.out.println("Please Enter your name: ");
        String name = InputHandelling.getUserStringInput();
        ;
        int age = checkAge();
        String phoneNumber = checkPhoneNumber();
        System.out.println("Please Enter your gender: M or F");
        String gender = InputHandelling.getUserStringInput().toUpperCase();
        ;
        int grade = -1;
        while (grade < 0 || grade > 5) {
            System.out.println("Please Enter your grade: ");
            try {
                grade = InputHandelling.getUserIntInput();
                if (grade < 0 || grade > 5) {
                    System.out.println("Your grade must be between 0 and 5");
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid Input... \nPlease enter a valid grade.");
                read.nextLine(); // Consume the invalid input before retrying
            }
        }
        String uid = name.substring(0, 3).toUpperCase() + Integer.toString((int) (10000 + Math.random() * 9999999)).substring(2, 5);
        // how to is set Name and Uid from here to main
        StudentData.createStudent(uid, name, age, phoneNumber, gender, grade, 0, 0, 0);
        Main.Name = name.toUpperCase();
        Main.Uid = uid;
        Main.Grade = grade;
    }

    public int checkAge() {
        Scanner read = new Scanner(System.in);
        int age = 0;
        boolean validAge = false;
        while (!validAge) {
            try {
                System.out.println("Please Enter your age: ");
                age = InputHandelling.getUserIntInput();
                read.nextLine(); // Consume newline left-over
                if (age >= 4 && age <= 11) {
                    validAge = true;
                } else {
                    System.out.println("Your age must be between 4 and 11");
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid Input... \nPlease enter a valid age.");
                read.nextLine(); // Consume the invalid input before retrying
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
                phoneNumber = InputHandelling.getUserStringInput();
                ;
                if (phoneNumber.length() == 10) {
                    validPhoneNumber = true;
                } else {
                    System.out.println("Your phone number must be 10 digits");
                    phoneNumber = InputHandelling.getUserStringInput();
                    ;
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid Input... \nPlease enter a valid phone number.");
                phoneNumber = InputHandelling.getUserStringInput();
                ;
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

    public void lessonPrint() {
        for (Object objectsArray : lessonDisplay) {
            ArrayList<Object> objects = (ArrayList<Object>) objectsArray;
            String BID = ((String) objects.get(0)).toUpperCase();
            String Day = ((String) objects.get(1)).toUpperCase(); // Index 0 for Day
            int Date = (int) objects.get(2); // Index 1 for Date
            String Month = ((String) objects.get(3)); // Index 2 for Month
            int Time = (int) objects.get(4); // Index 3 for Time
            String Coach = (String) objects.get(5); // Index 4 for CoachData
            int Grade = (int) objects.get(6); // Index 5 for Grade
            int Participants = (int) objects.get(7); //Index 7  for Participants
            System.out.printf("Booking ID: %-10s Day: %-10s Month: %-10s Date: %-10d Time: From %-1d to %-10d Coach: %-10s Grade: %-10d Participants: %-10d%n",
                    BID, Day, Month, Date, Time, Time + 1, Coach, Grade, Participants);
        }
    }

    public void checkingUser() {
        System.out.println("You need to verify by giving your name\nDo you wish to see your name: 'Y' or 'N'");
        String choosenOption = read.next().toUpperCase();
        if(choosenOption == "Y"){StudentData.displayUsersList();}
        System.out.println("Please enter your name:");
        String checkName = InputHandelling.getUserStringInput().toUpperCase();
        boolean validName = false;
        while (!validName) {
            for (Object arrayName : StudentData.studentData) {
                ArrayList<Object> studentInfo = (ArrayList<Object>) arrayName;
                String name = ((String) studentInfo.get(1)).toUpperCase();
                if (name.equals(checkName)) {
                    validName = true;
                    Main.Name = ((String) studentInfo.get(1)).toUpperCase();
                    Main.Uid = (String) studentInfo.get(0);
                    Main.Grade = (int) studentInfo.get(5);
                    Main.userAttendedLessons = (int) studentInfo.get(8);
                    Main.userCancelledLesson = (int) studentInfo.get(7);
                    Main.userBookedLessons = (int) studentInfo.get(6);
                    break;
                }
            }
            if (!validName) {
                System.out.println("Invalid name. Please enter your name again:");
                checkName = InputHandelling.getUserStringInput().toUpperCase();
            }
        }
    }


    public String bookingIDCheck(String chosenBookingID) {
        boolean validBookingID = false;
        // Loop until a valid booking ID is provided
        while (!validBookingID) {
            // Check if the chosen booking ID exists in the booked data
            for (Object bookingArray : bookingData) {
                ArrayList<Object> bookingInfo = (ArrayList<Object>) bookingArray;
                String bookingID = (String) bookingInfo.get(0);
                if (chosenBookingID.equals(bookingID)) {
                    validBookingID = true;
                    break;
                }
            }
            if (!validBookingID) {
                System.out.println("Invalid booking ID.");
                SwimmingMethod.swimmingBookingStart();
            }
        }
        return chosenBookingID;
    }

    public static void displayUsersLesson() {
        ArrayList<String> outputData = new ArrayList<>();
        for (Map.Entry<String, ArrayList<String>> entry : BookingData.usersBookedStatus.entrySet()) {
            String bookingId = entry.getKey();
            ArrayList<String> userIds = entry.getValue();
            for (String userId : userIds) {
                if (userId.equals(Main.Uid)) {
                    for (Object bookingArray : BookingData.bookedDate) {
                        ArrayList<Object> bookingInfo = (ArrayList<Object>) bookingArray;
                        String BID = (String) bookingInfo.get(0);
                        if (bookingId.equals(BID)) {
                            String Day = ((String) bookingInfo.get(1)).toUpperCase();
                            int Date = (int) bookingInfo.get(2);
                            String Month = ((String) bookingInfo.get(3));
                            int Time = (int) bookingInfo.get(4);
                            String Coach = (String) bookingInfo.get(5);
                            int Grade = (int) bookingInfo.get(6);
                            String status = "Booked";
                            String output = String.format("Booking ID: %-10s Day: %-10s Month: %-10s Date: %-10d Time: From %-1d to %-10d Coach: %-10s Grade: %-10d Status: %-10s",
                                    BID, Day, Month, Date, Time, Time + 1, Coach, Grade, status);
                            outputData.add(output);
                        }
                    }
                }
            }
        }
        for (Map.Entry<String, ArrayList<String>> entry : BookingData.usersCancelledStatus.entrySet()) {
            String bookingId = entry.getKey();
            ArrayList<String> userIds = entry.getValue();
            for (String userId : userIds) {
                if (userId.equals(Main.Uid)) {
                    for (Object bookingArray : BookingData.bookedDate) {
                        ArrayList<Object> bookingInfo = (ArrayList<Object>) bookingArray;
                        String BID = (String) bookingInfo.get(0);
                        if (bookingId.equals(BID)) {
                            String Day = ((String) bookingInfo.get(1)).toUpperCase();
                            int Date = (int) bookingInfo.get(2);
                            String Month = ((String) bookingInfo.get(3));
                            int Time = (int) bookingInfo.get(4);
                            String Coach = (String) bookingInfo.get(5);
                            int Grade = (int) bookingInfo.get(6);
                            int Participants = (int) bookingInfo.get(7);
                            String status = "Cancelled";
                            System.out.printf("Booking ID: %-10s Day: %-10s Month: %-10s Date: %-10d Time: From %-1d to %-10d Coach: %-10s Grade: %-10d Status: %-10s",
                                    BID, Day, Month, Date, Time, Time + 1, Coach, Grade, status);
                        }
                    }
                }
            }
        }
        for (Map.Entry<String, ArrayList<String>> entry : BookingData.userAttendedStatus.entrySet()) {
            String bookingId = entry.getKey();
            ArrayList<String> userIds = entry.getValue();
            for (String userId : userIds) {
                if (userId.equals(Main.Uid)) {
                    for (Object bookingArray : BookingData.bookedDate) {
                        ArrayList<Object> bookingInfo = (ArrayList<Object>) bookingArray;
                        String BID = (String) bookingInfo.get(0);
                        if (bookingId.equals(BID)) {
                            String Day = ((String) bookingInfo.get(1)).toUpperCase();
                            int Date = (int) bookingInfo.get(2);
                            String Month = ((String) bookingInfo.get(3));
                            int Time = (int) bookingInfo.get(4);
                            String Coach = (String) bookingInfo.get(5);
                            int Grade = (int) bookingInfo.get(6);
                            String status = "Attended";
                            System.out.printf("Booking ID: %-10s Day: %-10s Month: %-10s Date: %-10d Time: From %-1d to %-10d Coach: %-10s Grade: %-10d Status: %-10s",
                                    BID, Day, Month, Date, Time, Time + 1, Coach, Grade, status);;
                        }
                    }
                }
            }
        }

        if (outputData.isEmpty()) {System.out.println("No data available");
        }
    }

//    public static boolean userBookedToCancellationStatus() {
//        try {
//            for (Iterator<Map.Entry<String, ArrayList<String>>> iterator = BookingData.usersBookedStatus.entrySet().iterator(); iterator.hasNext();) {
//                Map.Entry<String, ArrayList<String>> entry = iterator.next();
//                String bookingId = entry.getKey();
//                ArrayList<String> userIds = entry.getValue();
//                for (Iterator<String> userIterator = userIds.iterator(); userIterator.hasNext();) {
//                    String userId = userIterator.next();
//                    if (userId.equals(Main.Uid)) {
//                        // Remove the user from the booked status
//                        userIterator.remove();
//
//                        // If there are no more users for this booking, remove the booking
//                        if (userIds.isEmpty()) {
//                            iterator.remove();
//                        }
//
//                        // Add the user to the cancelled status
//                        ArrayList<String> cancelledUserIds = BookingData.usersCancelledStatus.get(bookingId);
//                        if (cancelledUserIds == null) {
//                            cancelledUserIds = new ArrayList<>();
//                            BookingData.usersCancelledStatus.put(bookingId, cancelledUserIds);
//                        }
//                        cancelledUserIds.add(userId);
//                    }
//                }
//            }
//            return true;  // Return true if the method executes successfully
//        } catch (Exception e) {
//            e.printStackTrace();  // Print the stack trace for debugging
//            return false;  // Return false if an exception is caught
//        }
//    }
}