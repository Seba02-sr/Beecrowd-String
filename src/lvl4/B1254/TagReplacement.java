package lvl4.B1254;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagReplacement {

    /**
     * ---ENUNCIADO---
     * 1- Hay un codigo numerico de etiquetas para renderizar documentos de
     * impresion
     * 2- Etiqueta:
     * + Inicia con <
     * + Puede seguir con letras, numeros espacios y barras.
     * + Se completa con un >
     * 
     * ---INPUT---
     * 1- Casos de prueba --> Tres lineas (ignorar mayusculas de minusculas)
     * + Primera linea --> Etiqueta original en el texto del documento. Solo a-z y
     * A-Z
     * + Numero de etiqueta por el cual reemplazar la etiqueta original
     * 
     * ---OUTPUT---
     * 1- Convertir el texto del documento utilizando las especificaciones del input
     * e imprimirlo.
     * 
     * 
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String tag = scanner.nextLine();
            String numTag = scanner.nextLine();

            tag = tag.toLowerCase();

            StringBuilder strings = new StringBuilder(scanner.nextLine());

            System.out.println(replaceTagByNumTag(strings, tag, numTag));
        }
        scanner.close();
    }

    public static StringBuilder replaceTagByNumTag(StringBuilder strings, String tag, String numTag) {

        boolean openTag = false;
        StringBuilder modified = new StringBuilder();
        StringBuilder isTag = new StringBuilder();

        Pattern p = Pattern.compile(tag, Pattern.CASE_INSENSITIVE);
        for (char c : strings.toString().toCharArray()) {
            if (c == '<') {
                openTag = true;
                modified.append('<');
                continue;
            }

            if (c == '>') {
                openTag = false;
                if (!isTag.isEmpty()) {
                    Matcher matcher = p.matcher(isTag.toString());
                    String replaced = matcher.replaceAll(numTag);
                    modified.append(replaced);
                }
                isTag.setLength(0);
                modified.append('>');
                continue;
            }

            if (openTag) {
                isTag.append(Character.valueOf(c));
            } else {
                modified.append(Character.valueOf(c));
            }
        }

        return modified;
    }
}
