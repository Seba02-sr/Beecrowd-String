package lvl7.B1243;

import java.util.Scanner;

public class HowEasy {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            // Si la línea está vacía, podemos decidir retornar 250, 0, etc. según convenga
            if (line.isEmpty()) {
                System.out.println(250);
                continue;
            }

            // Dividir en símbolos por espacios
            String[] symbols = line.split(" +"); // uno o más espacios
            int sumLengths = 0;
            int countWords = 0;

            for (String symbol : symbols) {
                if (isValidWord(symbol)) {
                    // Quitar el punto final si existe
                    if (symbol.endsWith(".")) {
                        symbol = symbol.substring(0, symbol.length() - 1);
                    }
                    sumLengths += symbol.length();
                    countWords++;
                }
            }

            // Cálculo del promedio (división entera)
            int averageLength = (countWords == 0) ? 0 : (sumLengths / countWords);

            // Mostrar la clasificación
            System.out.println(getPoints(averageLength));
        }
        sc.close();
    }

    /**
     * Verifica si un símbolo es una palabra válida:
     * - solo letras (a-zA-Z)
     * - opcionalmente un punto al final
     */
    private static boolean isValidWord(String symbol) {
        return symbol.matches("^[a-zA-Z]+\\.?$");
    }

    /**
     * Retorna los puntos según el promedio entero de la longitud de palabras
     */
    private static int getPoints(int avg) {
        if (avg <= 3) {
            return 250;
        } else if (avg <= 5) {
            return 500;
        } else {
            return 1000;
        }
    }
}
