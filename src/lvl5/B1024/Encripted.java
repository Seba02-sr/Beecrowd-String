import java.util.Scanner;

public class Encripted {

    /**
     * 1- Cada minuscula o mayuscula se debe desplazar 3 posiciones hacia la
     * derecha, segun tabla ASCII.
     * 2- Cada linea se debe invertir.
     * 3- Caracteres desde mitad en adelante (truncado)--> Moverse una posicion a
     * izquierda segun tabla ASCII
     * 
     * ---Entrada---
     * + Numero entero --> cantidad de lineas a encriptar.
     * 
     * @param args
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        StringBuilder encriptedLine = new StringBuilder();

        for (int i = 0; i < number; i++) {
            String line = scanner.nextLine();
            for (char letter : line.toCharArray()) {
                if (Character.isLetter(letter)) {
                    encriptedLine.append((char) (letter + 3));
                } else {
                    encriptedLine.append(letter);
                }
            }
            encriptedLine.reverse();
            int middle = encriptedLine.length() / 2;
            for (int j = middle; j < encriptedLine.length(); j++) {
                encriptedLine.setCharAt(j, (char) (encriptedLine.charAt(j) - 1));
            }
            System.out.println(encriptedLine);
            encriptedLine.setLength(0);
        }

        scanner.close();
    }
}