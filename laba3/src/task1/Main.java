package task1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input substring for 1st part of the task: ");
        String substring = sc.next();
        System.out.println(Arrays.stream(args).sorted(new FirstComparator(substring)));

        System.out.println("Input 2 substrings for 2nd part of the task: ");
        String substringS1 = sc.next();
        String substringS2 = sc.next();
        System.out.println(Arrays.stream(args).sorted
                (new SecondComparator(substringS1, substringS2)));
    }
}
