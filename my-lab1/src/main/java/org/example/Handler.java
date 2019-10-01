package org.example;

public class Handler {

    public void isNumeric(String givenString) {
        for (String someNumber : givenString.split(" ")) {
            try {
                Double.parseDouble(someNumber);
            } catch (NumberFormatException e) {
                System.out.println("Incorrect data format! Try again, please.");
                System.exit(0);
            }
        }
    }

    public boolean isNumericBoolean(String givenString) {
        for (String someNumber : givenString.split(" ")) {
            try {
                Double.parseDouble(someNumber);
            } catch (NumberFormatException e) {
                System.out.println("Incorrect data format! Try again, please.");
                return false;
            }
        }
        return true;
    }

    public void isOneNumeric(String givenString) {
        try {
            Double.parseDouble(givenString);
        } catch (NumberFormatException e) {
            System.out.println("Incorrect data format! Try again, please.");
            System.exit(0);
        }
    }

    public String deleteSpaces(String givenString) {
        return givenString.trim();
    }

    public void checkNumberForDivide(Double someNumber) {
        if (!someNumber.isNaN() && someNumber != null && someNumber != 0)
            return;
        System.out.println("You wrote something wrong! Try again, please.");
        System.exit(0);
    }

    public boolean checkNumberForDivideBoolean(Double someNumber) {
        if (!someNumber.isNaN() && someNumber != null && someNumber != 0.0)
            return true;
        System.out.println("You wrote something wrong! Try again, please.");
        return false;
    }

    public void signTest(Double someNumber) {
        if (!someNumber.isNaN() && someNumber != null && someNumber > 0.0)
            return;
        System.out.println("You wrote something wrong! Try again, please.");
        System.exit(0);
    }

    public void simpleCheck(Double someNumber) {
        if (!someNumber.isNaN() && someNumber != null)
            return;
        System.out.println("You wrote something wrong! Try again, please.");
        System.exit(0);
    }

}