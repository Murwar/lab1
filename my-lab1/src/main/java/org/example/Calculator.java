package org.example;

import javax.lang.model.util.ElementScanner6;

public class Calculator {

    private double res;
    Handler nHandler = new Handler();

    public void menu() {
        System.out.println(
                "What do you want to do?\n    1. Single-number operation\n    2. Multi-number operation\n    3. Exit");
        String choice = System.console().readLine();
        switch (choice) {

        case "1":
            System.out.println(
                    "Which one?\n    1. Square\n    2. Square root\n    3. Cos\n    4. Sin \n    5. Log\n    6. Module\n    7. Tg\n    8. Ctg\n    9. Round");
            String monoOperator = System.console().readLine();
            System.out.print("Please enter a number: ");
            String number = System.console().readLine();
            nHandler.isOneNumeric(number);
            nHandler.deleteSpaces(number);

            switch (monoOperator) {
            case "1":
                res = square(number);
                break;
            case "2":
                res = squareRoot(number);
                break;
            case "3":
                res = log(number);
                break;
            case "6":
                res = module(number);
                break;
            case "7":
                res = tangOperator(number);
                break;
            case "8":
                res = ctngOperator(number);
                break;
            case "9":
                res = round(number);
                break;

            default:
                System.out.println("Wrong option. Select a number from 1 to 8.");
                System.exit(0);
            }
            break;

        case "2":
            System.out.println(
                    "Which one?\n    1. Add\n    2. Minus\n    3. Multiply\n    4. Divide \n    5. Power\n    6. Max");
            String multiOperator = System.console().readLine();
            System.out.print("Please enter numbers through the space bar: ");
            String givenString = System.console().readLine();
            nHandler.isNumeric(givenString);
            nHandler.deleteSpaces(givenString);

            switch (multiOperator) {
            case "1":
                res = add(givenString);
                break;
            case "2":
                res = minus(givenString);
                break;
            case "3":
                res = multiply(givenString);
                break;
            case "4":
                res = divide(givenString);
                break;
            case "5":
                res = power(givenString);
                break;
            case "6":
                res = max(givenString);
                break;
            default:
                System.out.println("Wrong option. Select a number from 1 to 5.");
                System.exit(0);
            }
            break;

        case "3":
            System.exit(0);
        default:
            System.out.println("Wrong option. Select a number from 1 to 3.");
            System.exit(0);
        }
    }

    protected double add(String givenString) {
        double res = 0;
        for (String someNumber : givenString.split(" ")) {
            nHandler.simpleCheck(Double.valueOf(someNumber));
            res += Double.valueOf(someNumber);
        }
        return res;
    }

    protected double minus(String givenString) {
        res = Double.MAX_VALUE;
        for (String someNumber : givenString.split(" ")) {
            nHandler.simpleCheck(Double.valueOf(someNumber));
            if (res == Double.MAX_VALUE)
                res = Double.valueOf(someNumber);
            else
                res -= Double.valueOf(someNumber);
        }
        return res;
    }

    protected double power(String givenString) {
        res = Double.MAX_VALUE;
        for (String someNumber : givenString.split(" ")) {
            nHandler.simpleCheck(Double.valueOf(someNumber));
            if (res == Double.MAX_VALUE)
                res = Double.valueOf(someNumber);
            else
                res = Math.pow(res, Double.valueOf(someNumber));
        }
        return res;
    }

    protected double multiply(String givenString) {
        res = 1;
        for (String someNumber : givenString.split(" ")) {
            nHandler.simpleCheck(Double.valueOf(someNumber));
            res *= Double.valueOf(someNumber);
        }
        return res;

    }

    protected double divide(String givenString) {
        res = Double.MAX_VALUE;
        for (String someNumber : givenString.split(" ")) {
            nHandler.checkNumberForDivide(Double.valueOf(someNumber));
            if (res == Double.MAX_VALUE)
                res = Double.valueOf(someNumber);
            else
                res /= Double.valueOf(someNumber);
        }
        return res;
    }

    protected double log(String givenString) {
        nHandler.signTest(Double.valueOf(givenString));
        return Math.log(Double.valueOf(givenString));
    }

    protected double sinOpertor(String givenString) {
        return Math.sin(Double.valueOf(givenString));
    }

    protected double cosOperator(String givenString) {
        return Math.cos(Double.valueOf(givenString));
    }

    protected double tangOperator(String givenString) {
        return Math.tan(Double.valueOf(givenString));
    }

    protected double ctngOperator(String givenString) {
        return 1 / Math.tan(Double.valueOf(givenString));
    }

    protected double square(String givenString) {
        return Double.valueOf(givenString) * Double.valueOf(givenString);
    }

    protected double squareRoot(String givenString) {
        nHandler.signTest(Double.valueOf(givenString));
        return Math.sqrt(Double.valueOf(givenString));
    }

    protected void showResult() {
        System.out.println("Result of evaluate: " + res);
    }

    protected double round(String givenString) {
        return Math.round(Double.valueOf(givenString));
    }

    protected double module(String givenString) {
        return Math.abs(Double.valueOf(givenString));
    }

    protected double max(String givenString) {
        double firstNumber = Double.MIN_VALUE;
        double secondNumber = Double.MIN_VALUE;
        for (String someItem : givenString.split(" ")) {
            if (firstNumber == Double.MIN_VALUE)
                firstNumber = Double.valueOf(someItem);
            else if (secondNumber == Double.MIN_VALUE)
                secondNumber = Double.valueOf(someItem);
            else
                break;
        }
        return Math.max(firstNumber, secondNumber);
    }
}