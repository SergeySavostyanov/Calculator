import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static String number1, number2;
    public static String operand;


    public static ArrayList<String> romanNumbers = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        System.out.println("Римско арабский калькулятор");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String enteredExample = reader.readLine();
        reader.close();

            System.out.println(calc(enteredExample));


    }

    public static String calc(String input) {

        if (input.contains("+")) {
            operand = "\\+";
        } else if (input.contains("-")) {
            operand = "-";
        } else if (input.contains("/")) {
            operand = "/";
        } else if (input.contains("*")) {
            operand = "\\*";
        }

        numberSearch(input);

        input = switch (operand) {
            case "\\+" -> sum();
            case "-" -> subtracting();
            case "/" -> division();
            case "\\*" -> multiplication();
            default -> "ошибка";

        };

        return input;
    }

    public static void numberSearch(String input) {

        String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

        for (String s : roman) romanNumbers.add(s);
        input=input.replaceAll("\\s+", "");
        String[] numbers = input.split(operand);
        if (numbers.length == 2) {

            try {
                if ((Integer.parseInt(numbers[0]) <= 10) && (Integer.parseInt(numbers[0]) > 0) &&
                        (Integer.parseInt(numbers[1]) <= 10) && (Integer.parseInt(numbers[1]) > 0)) {
                    number1 = numbers[0];
                    number2 = numbers[1];
                }
            } catch (Exception e) {
                if ((romanNumbers.indexOf(numbers[0]) < 10) && (romanNumbers.indexOf(numbers[0]) >= 0) &&
                        (romanNumbers.indexOf(numbers[1]) < 10) && (romanNumbers.indexOf(numbers[1]) >= 0)) {
                    number1 = numbers[0];
                    number2 = numbers[1];
                }
            }
        }
    }

    public static String sum() {
        String sum = "";
        try {
            if ((Integer.parseInt(number1) <= 10) && (Integer.parseInt(number1) >= 0) &&
                    (Integer.parseInt(number2) <= 10) && (Integer.parseInt(number1) >= 0)) {
                sum = String.valueOf(Integer.parseInt(number1) + (Integer.parseInt(number2)));
            }
        } catch (NumberFormatException e) {
            try {
                sum = romanNumbers.get((romanNumbers.indexOf(number1)+1) + ((romanNumbers.indexOf(number2)+1))-1);
            } catch (Exception ex) {
                sum = "ошибка ввода данных";
            }
        }
        return sum;
    }

    public static String subtracting() {
        String subtracting = "";
        try {
            if ((Integer.parseInt(number1) <= 10) && (Integer.parseInt(number1) >= 0) &&
                    (Integer.parseInt(number2) <= 10) && (Integer.parseInt(number1) >= 0)) {
                subtracting = String.valueOf(Integer.parseInt(number1) - (Integer.parseInt(number2)));
            }
        } catch (NumberFormatException e) {
            try {
                subtracting = romanNumbers.get((romanNumbers.indexOf(number1)+1) - ((romanNumbers.indexOf(number2)+1))-1);
            } catch (Exception ex) {
                System.out.println("в римской системе нет отрицательных чисел");
            }
        }
        return subtracting;
    }

    public static String multiplication() {

        String multiplication = "";
        try {
            if ((Integer.parseInt(number1) <= 10) && (Integer.parseInt(number1) >= 0) &&
                    (Integer.parseInt(number2) <= 10) && (Integer.parseInt(number1) >= 0)) {
                multiplication = String.valueOf(Integer.parseInt(number1) * (Integer.parseInt(number2)));
            }
        } catch (NumberFormatException e) {
            multiplication =romanNumbers.get((romanNumbers.indexOf(number1)+1) * ((romanNumbers.indexOf(number2)+1))-1);
        }
        if (number1 == null || number2 == null) return "Ошибка ввода данных";
        return multiplication;
    }

    public static String division() {
        String division = "";
        try {
            if ((Integer.parseInt(number1) <= 10) && (Integer.parseInt(number1) >= 0) &&
                    (Integer.parseInt(number2) <= 10) && (Integer.parseInt(number1) >= 0)) {
                division = String.valueOf(Integer.parseInt(number1) / (Integer.parseInt(number2)));
            }
        } catch (NumberFormatException e) {

            division = romanNumbers.get((romanNumbers.indexOf(number1)+1) / ((romanNumbers.indexOf(number2)+1))-1);

        }
        if (number1 == null || number2 == null) return "Ошибка ввода данных";
        return division;
    }
}




