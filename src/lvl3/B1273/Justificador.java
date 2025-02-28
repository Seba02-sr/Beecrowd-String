package lvl3.B1273;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Justificador {

    /**
     * ---ENUNCIADO---
     * 1- Hay palabras que hay que justificar a la derecha
     * 
     * ---INPUT---
     * 1- Casos de prueba:
     * + Primera Linea --> N, numero de palabras siguientes
     * + Finaliza --> N = 0.
     * 
     * ---OUTPUT---
     * 1- Imprimir las palabras justificadas a la derecha
     * 2- Agregar espacios a izquierda segun el max length de las palabras del caso
     * de prueba
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
                lines.add(scanner.nextLine());
            }

            if (!firstCase) {
                System.out.println();
            }

            firstCase = false;

            printPadLeft(lines, maxLength(lines));
        }

        scanner.close();
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
