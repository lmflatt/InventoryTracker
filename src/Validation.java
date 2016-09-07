/**
 * Created by lee on 9/6/16.
 */
public class Validation {

    public static String validateString() {
        boolean stringIsInvalid = true;
        String s = "";
        while (stringIsInvalid) {
            s = Main.scanner.nextLine();
            s = s.trim();
            if (s.length() > 0) {
                stringIsInvalid = false;
            }
            else {
                System.out.println();
                System.out.println("Invalid entry. Cannot be left blank.");
            }
        }

        return s;
    }

    public static Integer validatePositiveInt() {
        boolean intIsInvalid = true;
        Integer i = 0;
        String s = "";
        while (intIsInvalid) {

            s = Main.scanner.nextLine();
            s = s.trim();

            if (s.length() > 0) {

                try {
                    i = Integer.parseInt(s);

                    if (i > 0) {
                        intIsInvalid = false;
                    }
                    else {
                        System.out.println();
                        System.out.println("You must enter a positive whole number.");
                    }
                }
                catch (NumberFormatException e) {
                    System.out.println();
                    System.out.println("You must enter a whole number and no other characters.");
                }

            } else {
                System.out.println();
                System.out.println("Invalid entry. Cannot be left blank.");
            }

        }

        return i;
    }
}
