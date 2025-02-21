package B1234;

import java.util.Scanner;

public class DancingSentence {

    /**
     * 
     * ---ENUNCIADO---
     * 1- Oracion bailarina:
     * + Intercalan Mayuscura y Minuscula.
     * + Espacios se mantienen.
     * ---INPUT---
     * 1- Varias entradas, contiene una oracion.
     * 
     * ---OUTPUT---
     * 1- Convierte la oración en una oración bailarina.
     * 
     * @param args
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String words = scanner.nextLine();
            maptoDancing(words);
        }

        scanner.close();
    }

    private static void maptoDancing(String word) {

        StringBuilder dancingWord = new StringBuilder();
        Boolean isUpperCase = true;
        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                // If it is a letter, map to dancing
                if (isUpperCase) {
                    dancingWord.append(Character.toUpperCase(c));
                } else {
                    dancingWord.append(Character.toLowerCase(c));
                }
                isUpperCase = !isUpperCase;
            } else {
                // If it is a space, do nothing
                dancingWord.append(c);
            }
        }
        System.out.println(dancingWord);

    }
}
