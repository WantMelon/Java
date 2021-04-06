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
        int index1 = s1.indexOf(startSubstring);
        int index2 = s1.lastIndexOf(endSubstring);
        if (index1 == -1 || index2 == -1 || index1 > index2) {
            return 1;
        }
        s1 = s1.substring(index1, index2);

        index1 = s2.indexOf(startSubstring) + startSubstring.length();
        index2 = s2.lastIndexOf(endSubstring);
        if (index1 == -1 || index2 == -1 || index1 > index2) {
            return -1;
        }
        s2 = s2.substring(index1, index2);
//        String substringS1 = s1.substring(s1.indexOf(startSubstring),
//                s1.lastIndexOf(endSubstring));
//        String substringS2 = s2.substring(s2.indexOf(startSubstring),
//                s2.lastIndexOf(endSubstring));

        return s1.compareToIgnoreCase(s2);
    }
}
