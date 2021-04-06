package task2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static String parseString(String string) {
        string = string.replaceAll("0", "zero");
        string = string.replaceAll("1", "one");
        string = string.replaceAll("2", "two");
        string = string.replaceAll("3", "three");
        string = string.replaceAll("4", "four");
        string = string.replaceAll("5", "five");
        string = string.replaceAll("6", "six");
        string = string.replaceAll("7", "seven");
        string = string.replaceAll("8", "eight");
        string = string.replaceAll("9", "nine");

        return string;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        System.out.println(parseString(string));
    }
}
