package ru.vsu.chuprikov.task11;

import java.util.HashMap;
import java.util.Map;

public class StringUtils {
    static final Map<Integer, String> numbers = new HashMap<Integer, String>() {{
        put(0, "ноль");
        put(1, "один");
        put(2, "два");
        put(3, "три");
        put(4, "четыре");
        put(5, "пять");
        put(6, "шесть");
        put(7, "семь");
        put(8, "восемь");
        put(9, "девять");
    }};
    static final Map<Integer, String> numbersFemale = new HashMap<Integer, String>() {{
        put(1, "одна");
        put(2, "две");
    }};
    static final Map<Integer, String> tens = new HashMap<Integer, String>() {{
        put(10, "десять");
        put(20, "двадцать");
        put(30, "тридцать");
        put(40, "сорок");
        put(50, "пятьдесят");
        put(60, "шестьдесят");
        put(70, "семьдесят");
        put(80, "восемьдесят");
        put(90, "девяносто");
    }};
    static final Map<Integer, String> twenties = new HashMap<Integer, String>() {{
        put(11, "одиннадцать");
        put(12, "двенадцать");
        put(13, "тринадцать");
        put(14, "четырнадцать");
        put(15, "пятнадцать");
        put(16, "шестнадцать");
        put(17, "семнадцать");
        put(18, "восемнадцать");
        put(19, "девятнадцать");
    }};
    static final Map<Integer, String> hundreds = new HashMap<Integer, String>() {{
        put(100, "сто");
        put(200, "двести");
        put(300, "триста");
        put(400, "четыреста");
        put(500, "пятьсот");
        put(600, "шестьсот");
        put(700, "семьсот");
        put(800, "восемьсот");
        put(900, "девятьсот");
    }};

    public static String getStringRepresentation(int number) throws NumberFormatException {
        StringBuilder result = new StringBuilder();

        if (number < 0 || number > 1e9) {
            throw new NumberFormatException("Поддерживаются числа от 0 до 1.000.000.000.");
        }

        int billion = number / 1000000000;
        number %= 1000000000;
        if (billion > 0) {
            result.append("один миллиард");
        }

        int million = number / 1000000;
        number %= 1000000;
        if (million > 0) {
            if (result.toString() != "") {
                result.append(" ");
            }
            result.append(lessThanThousand(million, false));
            million %= 100;
            if (million > 10 && million < 20) {
                result.append(" миллионов");
            } else {
                switch (million % 10) {
                    case 1:
                        result.append(" миллион");
                        break;
                    case 2:
                    case 3:
                    case 4:
                        result.append(" миллиона");
                        break;
                    default:
                        result.append(" миллионов");
                }
            }
        }

        int thousand = number / 1000;
        number %= 1000;
        if (thousand > 0) {
            if (result.toString() != "") {
                result.append(" ");
            }
            result.append(lessThanThousand(thousand, true));
            thousand %= 100;
            if (thousand > 10 && thousand < 20) {
                result.append(" тысяч");
            } else {
                switch (thousand % 10) {
                    case 1:
                        result.append(" тысяча");
                        break;
                    case 2:
                    case 3:
                    case 4:
                        result.append(" тысячи");
                        break;
                    default:
                        result.append(" тысяч");
                }
            }
        }

        if (number > 0 || result.toString() == "") {
            if (result.toString() != "") {
                result.append(" ");
            }
            result.append(lessThanThousand(number, false));
        }

        result.setCharAt(0, Character.toUpperCase(result.charAt(0)));
        return result.toString();
    }

    private static String lessThanThousand(int number, boolean isFemale) {
        StringBuilder result = new StringBuilder();

        int hundred = number / 100;
        number %= 100;
        if (hundred > 0) {
            result.append(hundreds.get(hundred * 100));
        }

        if (number > 10 && number < 20) {
            if (result.toString() != "") {
                result.append(" ");
            }
            return result.append(twenties.get(number)).toString();
        }

        int ten = number / 10;
        number %= 10;
        if (ten > 0) {
            if (result.toString() != "") {
                result.append(" ");
            }
            result.append(tens.get(ten * 10));
        }

        if (number > 0 || result.toString() == "") {
            if (result.toString() != "") {
                result.append(" ");
            }
            if (isFemale && number > 0 && number < 3) {
                result.append(numbersFemale.get(number));
            } else {
                result.append(numbers.get(number));
            }
        }
        return result.toString();
    }
}
