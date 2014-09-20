package Main;

/**
 * Created by Андрей on 19.09.2014.
 */
public class AlgoWithString {
    public static int getStringPosFromSequence(String in){
        return adaptationKnuthMorrisPrattAlgorithm(in);
    }

    private static int adaptationKnuthMorrisPrattAlgorithm(String pattern) {
        int[] AllowableShift = computeAllowableShift(pattern);
        int currentPattertIndex = 0;
        int absoluteIndex = 0;
        int deletedSymbolsCount = 0;
        int currentNumber = 1;
        String text = new String();
        while(true) {
            if(text.length() > absoluteIndex - deletedSymbolsCount) {
                while (pattern.charAt(currentPattertIndex) != text.charAt(absoluteIndex - deletedSymbolsCount) && currentPattertIndex > 0) {
                    currentPattertIndex = AllowableShift[currentPattertIndex - 1];
                }
                if (pattern.charAt(currentPattertIndex) == text.charAt(absoluteIndex - deletedSymbolsCount)) {
                    currentPattertIndex = currentPattertIndex + 1;
                    if (currentPattertIndex == pattern.length()) {
                        return absoluteIndex + 1 - currentPattertIndex + 1;
                    }
                } else {
                    currentPattertIndex = 0;
                }
                ++absoluteIndex;
            } else {
                text += currentNumber++;
                text = text.substring(absoluteIndex-deletedSymbolsCount);
                deletedSymbolsCount = absoluteIndex;
            }
        }
    }

    private static int[] computeAllowableShift(String text) {
        int[] AllowableShift = new int[text.length()];
        AllowableShift[0] = 0;
        for(int i = 1; i < text.length(); ++i) {
            int k = AllowableShift[i - 1];
            while(text.charAt(k) != text.charAt(i) && k > 0) {
                k = AllowableShift[k - 1];
            }
            if(text.charAt(k) == text.charAt(i)) {
                AllowableShift[i] = k + 1;
            } else {
                AllowableShift[i] = 0;
            }
        }
        return AllowableShift;
    }
}
