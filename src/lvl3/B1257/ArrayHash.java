package B1257;

import java.util.Scanner;

public class ArrayHash {

    /**
     * ---ENUNCIADO---
     * 1- Hay un valor que calcular segun la entrada de caracteres
     * 2- Valor = (Posicion en el alfabeto) + (Elemento de entrada) + (Posicion en
     * el elemento)
     * 3- Todas las posiciones comienzan desde cero. Por ejemplo 'A' es 0.
     * 4- Hash --> Suma de todos los valores de los caracteres de entrada.
     * 
     * ---INPUT---
     * 1- N --> Casos de prueba
     * 2- Casos de prueba --> Comienza con un L --> Cantidad de lineas que siguen.
     * 3- Cada linea L --> Contiene una cadena de caracteres.
     * 
     * ---OUTPUT---
     * 1- Imprimir el hash calculado segun el enunciado.
     * 
     * 
     * @param args
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) { // Cant casos de prueba

            int l = Integer.parseInt(scanner.nextLine());
            int sum = 0;
            for (int j = 0; j < l; j++) { // Cant de lienas del caso de prueba
                String input = scanner.nextLine();

                sum += getHash(input, j);

            }
            System.out.println(sum);
        }
        scanner.close();
    }

    public static int getHash(String input, int line) {
        int sum = 0, pos = 0;
        for (char c : input.toCharArray()) {
            int posLetter = (c - 'A');
            sum += posLetter + pos++ + line;
        }
        return sum;
    }
}
