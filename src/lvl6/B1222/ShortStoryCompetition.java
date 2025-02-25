package lvl6.B1222;

import java.util.Scanner;

public class ShortStoryCompetition {

    /**
     * ---ENUNCIADO---
     * 1- Reglas:
     * + Limite en numero de palabras del cuento
     * + Limite en numero maximo de lineas por pagina.
     * + Limite en numero maximo de caracteres por linea.
     * + Cada palabra debe estar en una sola linea.
     * ---ENTRADA---
     * 1- Tres enteros:
     * + Numero de palabras del cuento.
     * + Numero maximo de lineas por pagina.
     * + Numero maximo de caracteres por linea.
     * 2- El cuento
     * 
     * ---SALIDA---
     * 1- Teniendo en cuenta las reglas del concurso:
     * + Calcular el numero de pagianas que ocupara el cuento.
     * 
     * @param args
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            // Input
            String[] input = scanner.nextLine().split(" ");
            // int wordCount = Integer.parseInt(input[0]);
            int maxLinesPerPage = Integer.parseInt(input[1]);
            int maxCharsPerLine = Integer.parseInt(input[2]);

            // Story
            String[] words = scanner.nextLine().split(" ");

            int charPerLine = 0;
            int linePerPage = 1;
            int page = 1;

            for (String word : words) {
                if (charPerLine + word.length() <= maxCharsPerLine) {
                    charPerLine += word.length() + 1;
                } else {
                    charPerLine = word.length() + 1;
                    linePerPage++;
                    if (linePerPage > maxLinesPerPage) {
                        linePerPage = 1;
                        page++;
                    }
                }
            }

            System.out.println(page);
        }

        scanner.close();
    }

}
