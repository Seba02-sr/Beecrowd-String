package lvl1.B1278;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JustifierII {

    /**
     * ---ENUNCIADO---
     * 1- Justificar a la derecha las entradas.
     * 
     * ---INPUT---
     * 1- Casos de prueba:
     * + Primer Linea --> Un entero N, el numero de lineas que forman el texto.
     * + Siguientes Lineas --> N lineas con X cantidad de espacios donde sea.
     * 2- Finaliza con N = 0.
     * 
     * ---OUTPUT---
     * 1- Por cada caso de prueba, imprimir las lineas de texto con un solo espacio
     * entre palabras
     * 2- Rellenar todas las lineas con espacios a la izquiera hasta que tengan la
     * misma longitud que la palabra con mas longitud
     * 
     * @param args
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean firstCase = true;

        while (true) {

            int n = Integer.parseInt(scanner.nextLine());
            if (n == 0) {
                break;
            }

            List<String> lines = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                lines.add(formattedLine(scanner.nextLine().trim()));
            }

            if (!firstCase) {
                System.out.println();
            }

            firstCase = false;

            printPadLeft(lines, maxLength(lines));
        }
        scanner.close();
    }

    public static String formattedLine(String line) {
        StringBuilder ret = new StringBuilder();
        boolean firstSpace = true;

        for (char c : line.toCharArray()) {
            if (c == ' ' && firstSpace) {
                ret.append(c);
                firstSpace = false;
                continue;
            }

            if (Character.isLetter(c)) {
                ret.append(c);
                firstSpace = true;
            }
        }
        return ret.toString();
    }

    public static int maxLength(List<String> lines) {
        return lines.stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);
    }

    public static void printPadLeft(List<String> lines, int maxLength) {
        for (String line : lines) {
            System.out.println(" ".repeat(maxLength - line.length()) + line);
        }
    }
}
