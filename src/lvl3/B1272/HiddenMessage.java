package lvl3.B1272;

import java.util.Scanner;

public class HiddenMessage {

    /**
     * ---ENUNCIADO---
     * 1- Existe una forma de ocultar mensajes.
     * 2- Metodo --> Utilizar la primera letra de cada palabra del texto, en orden.
     * 3- El texto puede tener varios espacios y hasta solo contener espacios.
     * 
     * ---INPUT---
     * 1- Casos de prueba:
     * + N --> Cuantos casos de prueba.
     * + Solamente minuscular y espacios donde sea.
     * 
     * ---OUTPUT---
     * 1- Imprimir el texto oculto
     * 
     * @param args
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            StringBuilder blindLine = new StringBuilder();
            boolean newWord = true;

            for (char c : line.toCharArray()) {
                if (c != ' ') {
                    if (newWord) {
                        blindLine.append(c);
                        newWord = false;
                    }
                } else {
                    newWord = true;
                }
            }
            System.out.println(blindLine);
        }
        scanner.close();
    }
}
