package lvl3.B1276;

import java.util.Arrays;
import java.util.Scanner;

public class LetterRange {

    /**
     * ---ENUNCIADO---
     * 1- Rango de letras --> conjunto de letras conseecutivas alfabeticamente,
     * separadas por un ':'.
     * 
     * ---INPUT---
     * 1- Caso de prueba --> cadena de letras minusculas y espacios.
     * 
     * ---OUTPUT
     * 1- Imprimir los rangos de letras que se encuentre en la cadena del input.
     * 
     * @param args
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {

            String line = scanner.nextLine().trim();

            if (line.isEmpty()) {
                System.out.println();
                continue;
            }

            char[] characters = line.toCharArray();
            Arrays.sort(characters);
            char lastLetter = ' ';
            StringBuilder range = new StringBuilder();
            boolean firstIteration = true;

            for (char c : characters) {

                if (c == ' ') {
                    continue;
                }

                if (firstIteration) {
                    lastLetter = c;
                    range.append(c);
                    firstIteration = false;
                    continue;
                }

                if (c == lastLetter) {
                    continue;
                }

                if (lastLetter == c - 1) {
                    range.append(c);
                    lastLetter = c;
                } else {
                    printRange(range);
                    System.out.print(", ");
                    range.setLength(0);
                    range.append(c);
                    lastLetter = c;
                }
            }
            if (!range.isEmpty()) {
                printRange(range);
            }
            System.out.println();
        }
        scanner.close();
    }

    public static void printRange(StringBuilder range) {

        System.out.print(range.charAt(0) + ":" + range.charAt(range.length() - 1));
    }
}
