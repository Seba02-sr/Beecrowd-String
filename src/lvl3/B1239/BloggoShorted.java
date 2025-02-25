package B1239;

import java.util.Scanner;

public class BloggoShorted {

    /**
     * ---ENUNCIADO---
     * 1- Tomar un texto escrito con atajos y traducirlo a HTML adecuado.
     * 2- Reglas:
     * + Cursiva --> <i>text</i> = _text_
     * - Aparecen un numero par de veces
     * + Negrita --> <b>text</b> = *text*
     * 
     * ---INPUT---
     * 1- Varios casos de prueba --> cadena de texto con solo letras.
     * 2- Termina con EOF
     * 
     * @param args
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String strings = scanner.nextLine();

            StringBuilder modifier = new StringBuilder();

            boolean undercoreOpen = false;
            boolean starOpen = false;

            for (char c : strings.toCharArray()) {

                if (c == '_') {
                    if (undercoreOpen) {
                        modifier.append("</i>");
                        undercoreOpen = false;
                    } else {
                        modifier.append("<i>");
                        undercoreOpen = true;
                    }
                } else if (c == '*') {
                    if (starOpen) {
                        modifier.append("</b>");
                        starOpen = false;
                    } else {
                        modifier.append("<b>");
                        starOpen = true;
                    }
                } else {
                    modifier.append(c);
                }
            }

            System.out.println(modifier);
        }

        scanner.close();
    }
}
