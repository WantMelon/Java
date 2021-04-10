package task4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[] arr = {"sssl", "slss", "lsss", "ssss", "sssssl"};

        System.out.println(Arrays.toString(arr));
        BubbleSort<String> bubbleSort = new BubbleSort<>(arr);
        bubbleSort.sort(new task1.FirstComparator("l"));
        System.out.println(Arrays.toString(arr));
        System.out.println(bubbleSort.getCompareCounter());
        System.out.println(bubbleSort.getSwapCounter());
    }
}
