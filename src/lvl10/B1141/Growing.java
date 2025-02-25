package lvl10.B1141;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Growing {

    /**
     * 1- Agregar cadenas a izq o der, nunca en medio.
     * 2- Las cadenas deben ser diferentes
     * 
     * @param args
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            Integer lines = Integer.parseInt(scanner.nextLine());
            // Condition breaker
            if (lines == 0) {
                break;
            }

            List<String> words = new ArrayList<>();

            for (int i = 0; i < lines; i++) {
                words.add(scanner.nextLine());
            }

            GrowingStrings growingStrings = new GrowingStrings(words);

            System.out.println(growingStrings.maxSequenceLength());
        }
        scanner.close();
    }

    public record GrowingStrings(List<String> words, int maxSequenceLength) {

        public GrowingStrings(List<String> words) {
            this(words, solve(words));
        }

        private static int solve(List<String> words) {

            int maxLength = 0;

            // Sorted by length
            words.sort(Comparator.comparingInt(String::length));

            Map<String, Integer> result = new HashMap<>();

            for (String word : words) {
                result.put(word, 1);

                for (String curr : words) {
                    if (curr.length() >= word.length()) { // No shorter ones to compare
                        break;
                    }

                    if (word.contains(curr)) {
                        result.put(word, Math.max(result.get(word), result.get(curr) + 1));
                    }

                }
                maxLength = Math.max(maxLength, result.get(word));
            }

            return maxLength;
        }

    }
}
