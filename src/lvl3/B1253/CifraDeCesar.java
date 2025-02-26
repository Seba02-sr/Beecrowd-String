package B1253;

import java.util.Scanner;
import java.util.stream.Collectors;

public class CifraDeCesar {

    /**
     * ---ENUNCIADO---
     * 1- Cifrado Cesar -->Desplazar cada letra 2 lugares
     * 
     * ---INPUT---
     * 1- N --> Casos de Prueba.
     * 2- Casos de prueba --> Dos lineas
     * + Cadena de caracteres que esta codificado.
     * + El desplazamiento segun cifredo cesar.
     * 
     * ---OUTPUT---
     * 1- Decodificar la cadena de caracteres, gracias a su desplazamiento.
     * 
     * @param args
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            StringBuilder text = new StringBuilder(scanner.nextLine());
            int encription = Integer.parseInt(scanner.nextLine());

            String result = text.chars()
                    .map(c -> 'A' + (c - 'A' - encription + 26) % 26) // Shift left uppercase letter in ASCII
                    .mapToObj(c -> String.valueOf((char) c))
                    .collect(Collectors.joining());

            System.out.println(result);
        }
        scanner.close();
    }

}
