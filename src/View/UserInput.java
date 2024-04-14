package View;

import ExceptionHandeling.InputHandeling;
public class UserInput {

    public static String yesOrNo(){
        System.out.println("You need to verify by giving your name\nDo you wish to see your name: 'Y' or 'N'");
        return InputHandeling.getUserStringInput().toUpperCase();
    }
}
