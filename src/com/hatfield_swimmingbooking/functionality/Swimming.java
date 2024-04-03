package com.hatfield_swimmingbooking.functionality;

import com.hatfield_swimmingbooking.functionality.Coach;
import com.hatfield_swimmingbooking.functionality.Student;
import com.hatfield_swimmingbooking.main.Main;
import com.hatfield_swimmingbooking.util.Data;

import java.util.ArrayList;
import java.util.Scanner;
 public  class Swimming{

 public static void swimmingBookingStart(){
     try{
         Scanner reader = new Scanner(System.in);
         System.out.println("Please Choose Numbers from the followings");
         System.out.println("""
                    \t1. Book a Swimming Lesson
                    \t2. Change/Cancel a Booking
                    \t3. Attend a Swimming Lesson
                    \t4. Monthly Learner Report
                    \t5. Monthly Coach Report
                    \t6. Sign Out
                    \t7. Exit the System
                    """);
         System.out.println("Enter: ");
         int chooseNumber = reader.nextInt();
         Student student = new Student();
         Coach coach = new Coach();
         if(chooseNumber>=1 && chooseNumber<8 ){
             switch (chooseNumber){
                 case 1:
                     student.bookingClasses();swimmingBookingStart();
                     break;
                 case 2:
                     student.bookingChanges();swimmingBookingStart();
                     break;
                 case 3:
                     student.attendSwimming();swimmingBookingStart();
                     break;
                 case 4:
                     student.lernerMonthlyReport();swimmingBookingStart();
                     break;
                 case 5:
                     coach.coachMonthlyReport();swimmingBookingStart();
                     break;
                 case 6:
                     for(Object userArray : Data.getStudentData()){
                         ArrayList<Object> userInfo = (ArrayList<Object>) userArray;
                         String userID = (String) userInfo.getFirst();
                         if(Main.Uid.equals(userID)){
                             userInfo.set(6, Main.userBookedLessons);
                             userInfo.set(7, Main.userCancelledLesson);
                             userInfo.set(8, Main.userAttendedLessons);
                         }
                     }
                     signInSignOut();
                     break;
                 case 7:
                     exit();
                     break;
             }
         }else {
             System.out.println("Invalid Input..");
             swimmingBookingStart();
         }
     }catch (Exception e) {
         System.out.println(e.getMessage());
         System.out.println("Invalid Input ( com.hatfield_swimmingbooking.main.Main Method )..");
         swimmingBookingStart();
     }
 }

 public static void signInSignOut(){
     ArrayList<Object> studentData = Data.getStudentData();
     System.out.println("Welcome to Hatfield Junior com.hatfield_swimmingbooking.functionality.Swimming School");
     Student student = new Student();
     student.checkingUser();
     swimmingBookingStart();
 }
 public static void exit() {
     // uid 0 , name 1, age 2, phone number 3, gender 4, grade 5, booked 7, cancelled 8, attained 9
     for(Object userArray : Data.getStudentData()){
         ArrayList<Object> userInfo = (ArrayList<Object>) userArray;
         String userID = (String) userInfo.getFirst();
         if(Main.Uid.equals(userID)){
             userInfo.set(6, Main.userBookedLessons);
             userInfo.set(7, Main.userCancelledLesson);
             userInfo.set(8, Main.userAttendedLessons);
         }
     }
     System.out.println("Exiting the system...");
     System.exit(0);
 }

 }