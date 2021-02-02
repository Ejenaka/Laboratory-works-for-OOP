package Lab2.StringComparators;

import java.util.Comparator;

public class StringVowelsComparator implements Comparator<String> {

    private final char[] vowels = {'A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', 'u', 'Y', 'y'};

    private int getVowelsCount(String str) {
        int vowelsCount = 0;
        for (int i = 0; i < str.length(); i++) {
            for (char vowel : vowels) {
                if (str.charAt(i) == vowel) {
                    vowelsCount++;
                }
            }
        }
        return vowelsCount;
    }

    @Override
    public int compare(String a, String b) {
        return getVowelsCount(a) - getVowelsCount(b);
    }
}


