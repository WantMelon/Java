package task1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input substring for 1st part of the task: ");
        String substring = sc.next();
        FirstComparator firstComparator = new FirstComparator(substring);
        Arrays.sort(args, firstComparator);
        System.out.println(Arrays.toString(args));
        System.out.println("Compare times: " + firstComparator.getCompareCounter());

        System.out.println("Input 2 substrings for 2nd part of the task: ");
        String substringS1 = sc.next();
        String substringS2 = sc.next();
        SecondComparator secondComparator
                = new SecondComparator(substringS1, substringS2);
        Arrays.sort(args, secondComparator);
        System.out.println(Arrays.toString(args));
        System.out.println("Compare times: " + secondComparator.getCompareCounter());
    }
}
