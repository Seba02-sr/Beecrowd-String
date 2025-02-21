package lvl6.B1237;

import java.util.Scanner;

public class CompareSubstring {

    /**
     * ---ENUNCIADO---
     * 1- Buscar la cadena mas larga que comparten dos textos.
     * 2- Si no hay subcadena devolver 0.
     * 3- Debe ser sensible a mayusculas y minusculas.
     * 
     * ---INPUT---
     * 1- Varios casos de prueba --> Dos lineas, que pueden contener espacios.
     * 
     * ---OUTPUT---
     * 1-Mayor subcadena que comparten las dos lienas.
     * 
     * @param args
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {

            String firstLine = scanner.nextLine();
            String secondLine = scanner.nextLine();

            System.out.println(maxLengthSubstring(firstLine, secondLine));
        }

        scanner.close();
    }

    private static int maxLengthSubstring(String firstLine, String secondLine) {

        int sizeFirst = firstLine.length();
        int sizeSecond = secondLine.length();
        int maxLength = 0;
        int[][] substringLength = new int[sizeFirst + 1][sizeSecond + 1];

        for (int i = 1; i <= sizeFirst; i++) {
            for (int j = 1; j <= sizeSecond; j++) {
                if (firstLine.charAt(i - 1) == secondLine.charAt(j - 1)) {
                    substringLength[i][j] = substringLength[i - 1][j - 1] + 1;
                    maxLength = Math.max(maxLength, substringLength[i][j]);
                }
            }
        }

        return maxLength;
    }
}
