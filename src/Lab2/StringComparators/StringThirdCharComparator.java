package Lab2.StringComparators;

import java.util.Comparator;

public class StringThirdCharComparator implements Comparator<String > {

    @Override
    public int compare(String a, String b) {
        return a.charAt(2) - b.charAt(2);
    }
}
