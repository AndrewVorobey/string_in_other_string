package Main;

import java.util.Arrays;

/**
 * Created by Андрей on 19.09.2014.
 */
public class AlgoWithString {
    public static int getStringPosFromSequence(String in){
        return adaptationKnuthMorrisPrattAlgorithm(in);
    }

    private static int adaptationKnuthMorrisPrattAlgorithm(String pattern) {
        int[] pfl = pfl(pattern);
        int k = 0;
        int i = 0;
        int delta = 0;
        int currentNumber = 1;
        String text = new String();
        while(true) {
            if(text.length() > i - delta) {
                while (pattern.charAt(k) != text.charAt(i - delta) && k > 0) {
                    k = pfl[k - 1];
                }
                if (pattern.charAt(k) == text.charAt(i - delta)) {
                    k = k + 1;
                    if (k == pattern.length()) {
                        return i + 1 - k + 1;
                    }
                } else {
                    k = 0;
                }
                ++i;
            } else {
                text += currentNumber++;
                text = text.substring(i-delta);
                delta = i;
            }
        }
    }

    private static int[] pfl(String text) {
        int[] pfl = new int[text.length()];
        pfl[0] = 0;
        for(int i = 1; i < text.length(); ++i) {
            int k = pfl[i - 1];
            while(text.charAt(k) != text.charAt(i) && k > 0) {
                k = pfl[k - 1];
            }
            if(text.charAt(k) == text.charAt(i)) {
                pfl[i] = k + 1;
            } else {
                pfl[i] = 0;
            }
        }
        return pfl;
    }
}
