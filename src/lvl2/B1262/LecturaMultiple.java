package lvl2.B1262;

import java.util.Scanner;

public class LecturaMultiple {

    /**
     * ---ENUNCIADO---
     * 1- Concurrencia --> Lectura y escritura no se puede combinar en un mismo
     * ciclo de reloj.
     * 2- Dado un historial de lecturas y escrituras que ocurren. Y un entero
     * 'procs', el cual es la cantidad de procesos que actuan imultaneamente
     * 3- Calcular la duracion minima del ciclo de reloj.
     * 4- Lectura --> 'R'.
     * 5- Escritura --> 'W'.
     * 
     * ---INPUT---
     * 1- Casos de prueba --> dos lineas,
     * + Primera linea --> una cadena con 'R' o 'W'
     * + Segunda linea --> Entero P, el numero de procesos.
     * 
     * ---OUTPUT---
     * 1- Imprimir el numero de ciclos minimo para recorrer el trace dado.
     * 
     * @param args
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String op = scanner.nextLine();
            int p = Integer.parseInt(scanner.nextLine());

            System.out.println(minClockCycle(op, p));

        }
        scanner.close();
    }

    public static int minClockCycle(String op, int p) {
        int clockCycle = 0, rCount = 0;
        for (char c : op.toCharArray()) {
            switch (c) {
                case 'W':
                    if (rCount > 0) {
                        clockCycle++;
                        rCount = 0;
                    }
                    clockCycle++;
                    break;
                case 'R':
                    rCount++;
                    if (rCount == p) {
                        clockCycle++;
                        rCount = 0;
                    }
                    break;
            }
        }
        return (rCount > 0) ? ++clockCycle : clockCycle;
    }
}
