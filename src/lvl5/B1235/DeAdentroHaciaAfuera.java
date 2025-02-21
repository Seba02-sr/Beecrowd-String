package lvl5.B1235;

import java.util.Scanner;

public class DeAdentroHaciaAfuera {

    /**
     * ---ENUNCIADO---
     * 1- Se esta imprimiendo desde el medio hacia la izquiera y luego hacia la
     * derecha.
     * 2- Siempre hay un numero par de caracteres.
     * 
     * ---INPUT---
     * 1- Un numero --> casos de prueba.
     * 2- N lineas con caracteres.
     * 
     * ---OUTPUT---
     * 1- Producir una linea con cada mensaje decifrado segun el problema.
     * 
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int line = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < line; i++) {
            String words = scanner.nextLine();
            System.out.println(decoder(words));
        }

        scanner.close();
    }

    private static String decoder(String words) {
        int middle = words.length() / 2;
        String firstText = words.substring(0, middle);
        String lastText = words.substring(middle, words.length());

        firstText = new StringBuilder(firstText).reverse().toString();
        lastText = new StringBuilder(lastText).reverse().toString();
        return firstText + lastText;
    }
}
