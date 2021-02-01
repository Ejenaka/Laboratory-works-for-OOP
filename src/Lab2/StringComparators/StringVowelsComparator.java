package Lab2.StringComparators;

import java.util.Comparator;

public class StringVowelsComparator implements Comparator<String> {

    private final char[] vowels = {'A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', 'u', 'Y', 'y'};

    @Override
    public int compare(String a, String b) {
        int vowelsCountA = 0;
        int vowelsCountB = 0;
        for (int i = 0; i < a.length(); i++) {
            for (char vowel : vowels) {
                if (a.charAt(i) == vowel) {
                    vowelsCountA++;
                }
            }
        }
        for (int i = 0; i < b.length(); i++) {
            for (char vowel : vowels) {
                if (b.charAt(i) == vowel) {
                    vowelsCountB++;
                }
            }
        }

        return vowelsCountA - vowelsCountB;
    }
}


