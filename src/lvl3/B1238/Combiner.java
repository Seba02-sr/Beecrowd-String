package B1238;

import java.util.Scanner;

public class Combiner {

    /**
     * ---ENUNCIADO---
     * 1- Combinar 2 cadenas de texto.
     * 
     * ---INPUT---
     * 1- Casos de prueba --> Numero entero de casos de prueba.
     * 
     * ---OUTPUT---
     * 2- Combinacion de las dos cadenas
     * 
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int line = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < line; i++) {
            String[] strings = scanner.nextLine().split(" ");

            System.out.println(interleave(strings));

        }
        scanner.close();
    }

    private static String interleave(String[] strings) {

        int len1 = strings[0].length();
        int len2 = strings[1].length();
        StringBuilder finalString = new StringBuilder();
        int i = 0, j = 0;
        while (i < len1 || j < len2) {
            if (i < len1) {
                finalString.append(strings[0].charAt(i++));
            }
            if (j < len2) {
                finalString.append(strings[1].charAt(j++));
            }
        }

        return finalString.toString();
    }
}
