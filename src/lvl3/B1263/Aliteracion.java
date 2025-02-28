package lvl3.B1263;

import java.util.Scanner;

public class Aliteracion {

    /**
     * ---ENUNCIADO---
     * 1- Aliteracion --> Dos palabras o mas que comienzan con la misma letra.
     * 2- Case insensitive.
     * 
     * ---INPUT---
     * 1- Casos de prueba --> Cada linea sera un caso de prueba
     * 2- Cada palabra es separada por un solo espacio.
     * 3- Finaliza con un EOF.
     * 
     * ---OUTPUT---
     * 1- Imprimir el numero de aliteraciones que hay en el input.
     * 
     * @param args
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {

            String[] words = scanner.nextLine().split(" ");
            int aliteracion = 0;
            char letter = '0';
            boolean firstIteration = true, inAliteration = false;

            for (String word : words) {
                if (firstIteration) {
                    letter = Character.toLowerCase(word.charAt(0));
                    firstIteration = false;
                } else {
                    char firstLetter = Character.toLowerCase(word.charAt(0));
                    if (firstLetter == letter) {
                        if (!inAliteration) {
                            aliteracion++;
                            inAliteration = true;
                        }

                    } else {
                        letter = firstLetter;
                        inAliteration = false;
                    }
                }
            }

            System.out.println(aliteracion);
        }
        scanner.close();
    }
}
