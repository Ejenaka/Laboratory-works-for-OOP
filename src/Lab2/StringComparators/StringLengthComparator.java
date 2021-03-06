package Lab2.StringComparators;

import java.util.Comparator;

public class StringLengthComparator implements Comparator<String> {

    @Override
    public int compare(String a, String b) {
        return a.length() - b.length();
    }
}
