import java.util.InputMismatchException;
import java.util.Scanner;
public class Student extends User{
    private int grade;
    Scanner read = new Scanner(System.in);

    public void bookingClasses() {
        System.out.println("To book the class \n you need to provide you name \n Please enter your name: ");
        String checkName = read.next();

        System.out.println("Please enter your phone number: ");
        String checkPhoneNumber = read.next();

        System.out.println("Please choose available dates from following:");
        System.out.println("\t1. MON 1 APR (4-5 PM)\n" +
                "\t2. MON 1 APR (5-6 PM)\n" +
                "\t3. MON 1 APR (6-7 PM)\n" +
                "\t4. WED 3 APR (4-5 PM)\n" +
                "\t5. WED 3 APR (5-6 PM)\n" +
                "\t6. WED 3 APR (6-7 PM)\n" +
                "\t7. FRI 5 APR (4-5 PM)\n" +
                "\t8. FRI 5 APR (5-6 PM)\n" +
                "\t9. FRI 5 APR (6-7 PM)\n" +
                "\t10. SAT 6 APR (2-3 PM)\n" +
                "\t11. SAT 6 APR (3-4 PM)\n" +
                "\t12. MON 8 APR (4-5 PM)\n" +
                "\t13. MON 8 APR (5-6 PM)\n" +
                "\t14. MON 8 APR (6-7 PM)\n" +
                "\t15. WED 10 APR (4-5 PM)\n" +
                "\t16. WED 10 APR (5-6 PM)\n" +
                "\t17. WED 10 APR (6-7 PM)\n" +
                "\t18. FRI 12 APR (4-5 PM)\n" +
                "\t19. FRI 12 APR (5-6 PM)\n" +
                "\t20. FRI 12 APR (6-7 PM)\n" +
                "\t21. SAT 13 APR (2-3 PM)\n" +
                "\t22. SAT 13 APR (3-4 PM)\n" +
                "\t23. MON 15 APR (4-5 PM)\n" +
                "\t24. MON 15 APR (5-6 PM)\n" +
                "\t25. MON 15 APR (6-7 PM)\n" +
                "\t26. WED 17 APR (4-5 PM)\n" +
                "\t27. WED 17 APR (5-6 PM)\n" +
                "\t28. WED 17 APR (6-7 PM)\n" +
                "\t29. FRI 19 APR (4-5 PM)\n" +
                "\t30. FRI 19 APR (5-6 PM)\n" +
                "\t31. FRI 19 APR (6-7 PM)\n" +
                "\t32. SAT 20 APR (2-3 PM)\n" +
                "\t33. SAT 20 APR (3-4 PM)\n" +
                "\t34. MON 22 APR (4-5 PM)\n" +
                "\t35. MON 22 APR (5-6 PM)\n" +
                "\t36. MON 22 APR (6-7 PM)\n" +
                "\t37. WED 24 APR (4-5 PM)\n" +
                "\t38. WED 24 APR (5-6 PM)\n" +
                "\t39. WED 24 APR (6-7 PM)\n" +
                "\t40. FRI 26 APR (4-5 PM)\n" +
                "\t41. FRI 26 APR (5-6 PM)\n" +
                "\t42. FRI 26 APR (6-7 PM)\n" +
                "\t43. SAT 27 APR (2-3 PM)\n" +
                "\t44. SAT 27 APR (3-4 PM)\n");

        int chooseNumber = read.nextInt();
        try {
            if (chooseNumber == 1) {
                try {
                    System.out.println("Your booking has been placed for MON 1 APR (4-5 PM)");
                    Thread.sleep(1000);

                    System.out.println("Returning back to home. Please wait...");
                    Thread.sleep(2000);
                    Main.swimmingStart();
                } catch (InterruptedException e) {
                    Main.swimmingStart();
                }
            } else if (chooseNumber == 2) {
                try {
                    System.out.println("Your booking has been placed for MON 1 APR (5-6 PM)");
                    Thread.sleep(1000);

                    System.out.println("Returning back to home. Please wait...");
                    Thread.sleep(2000);
                    Main.swimmingStart();
                } catch (InterruptedException e) {
                    Main.swimmingStart();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input...");
            bookingClasses();
        }

    }

    public void bookingChanges(){
        System.out.println("Do you with to Update or Cancel booking");
        System.out.println("\t1. Update\n"+
                "\t2. Cancel");
        int n = read.nextInt();
        try{
            if(n==1){
                System.out.println("Please enter your name");
                String checkName = read.next();

                System.out.println("Please enter your phone number: ");
                String checkPhoneNumber = read.next();

            } else if (n == 2) {
                System.out.println("Please enter your name");
                String checkName = read.next();

                System.out.println("Please enter your phone number: ");
                String checkPhoneNumber = read.next();

            }else{
                System.out.println("Invalid input..");
                bookingChanges();
            }

        }catch (Exception e){
            System.out.println("Invalid input..");
            bookingChanges();
        }
    }

    public void attendSwimming(){
        System.out.println("Wait till your class completes");
        try {
            Thread.sleep(2000);
            System.out.println("You have completed the class");

            System.out.println("Returning back to home");
            Thread.sleep(2000);
            Main.swimmingStart();
        } catch (InterruptedException e) {
            System.out.println("You inturrupted the class\n" + "Please try again!!");
            attendSwimming();
        }
    }

    public void lernerMonthlyReport(){

    }

    public void registerLerner(){
        System.out.println("Welcome! Please fill the form below");
        System.out.println("Please Enter your name: ");
        String name = read.next();
        int age = checkAge();
        String phoneNumber = checkPhoneNumber();
        System.out.println("Please Enter your gender: ");
        String gender = read.next();
        System.out.println("Please Enter your grade: ");
        int grade = read.nextInt();
        Data data = new Data();
        data.createStudent(name, age, phoneNumber, gender, grade);

    }

    public int checkAge(){
        System.out.println("Please Enter your age: ");
        int age = read.nextInt();
        try {
            if (age >= 4 && age <= 11) {
                return age;
            } else {
                System.out.println("Your age must be between 4 and 11");
                checkAge();
            }
        } catch (InputMismatchException e) {
            System.err.println("Invalid Input...");
            checkAge();
        }
        return age;
    }

    public String checkPhoneNumber(){
        System.out.println("Please Enter your phone number: ");
        String phoneNumber = read.next();
        try{
            if(phoneNumber.length() == 10){
                return phoneNumber;
            }else{
                System.out.println("Your phone number must be 10 digits");
                checkPhoneNumber();
            }
        }catch (InputMismatchException e){
            System.err.println("Invalid Input...");
            checkPhoneNumber();
        }
        return phoneNumber;
    }
}
