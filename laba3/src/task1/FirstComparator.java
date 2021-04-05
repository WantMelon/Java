package task1;

import java.util.Comparator;

public class FirstComparator implements Comparator<String> {
    private final String substring;

    public FirstComparator(String substring) {
        this.substring = substring;
    }

    @Override
    public int compare(String s1, String s2) {
        int n1 = s1.lastIndexOf(substring);
        int n2 = s2.lastIndexOf(substring);
        return Integer.compare(n1, n2);
    }
}
