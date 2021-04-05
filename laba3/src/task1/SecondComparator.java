package task1;

import java.util.Comparator;

public class SecondComparator implements Comparator<String> {
    private final String startSubstring;
    private final String endSubstring;

    public SecondComparator(String startSubstring, String endSubstring) {
        this.startSubstring = startSubstring;
        this.endSubstring = endSubstring;
    }

    @Override
    public int compare(String s1, String s2) {
        String substringS1 = s1.substring(s1.indexOf(startSubstring),
                s1.lastIndexOf(endSubstring));
        String substringS2 = s2.substring(s2.indexOf(startSubstring),
                s2.lastIndexOf(endSubstring));

        return substringS1.compareToIgnoreCase(substringS2);
    }
}
