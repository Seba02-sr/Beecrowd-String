package lvl6.B1277;

import java.util.Scanner;

public class ShortAttendance {

    /**
     * ---ENUNCIADO---
     * 1- En una escuela solamente con 75% de asistencia se puede presentar al
     * examen.
     * 2- A partir de una lsita imprimir los nombres de los que no pueden acceder al
     * examen.
     * 
     * ---INPUT---
     * 1- T --> Casos de prueba.
     * 2- Casos de Prueba --> Compuesto por 3 lineas.
     * + Primera linea --> N, numero de estudiantes de la clase.
     * + Segunda linea --> Los N estudiantes separados por espacio.
     * + Tercera linea --> N registros de asistencia.
     * 3- Registro de asistencia :
     * + P --> Presente
     * + A --> Ausente.
     * + M --> Ausente pero justificado.
     * 4- Ausente pero justificado --> No se cuenta como porcentaje de asistencia.
     * 
     * ---OUTPUT
     * 1- Por cada caso de prueba, imprimir los nobmres de los estudiantes que no
     * pueden acceder al examen.
     * 
     * @param args
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int t = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < t; i++) {

            int n = Integer.parseInt(scanner.nextLine());
            String[] students = scanner.nextLine().trim().split(" ");
            String[] attendances = scanner.nextLine().trim().split(" ");

            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < n; j++) {
                if (!accedeAlExamen(attendances[j])) {
                    if (sb.length() > 0) {
                        sb.append(" ");
                    }
                    sb.append(students[j]);
                }
            }

            System.out.println(sb);

        }
        scanner.close();
    }

    public static boolean accedeAlExamen(String attendance) {

        int pCount = 0;
        int length = attendance.length();
        for (char c : attendance.toCharArray()) {
            if (c == 'P') {
                pCount++;
                continue;
            }
            if (c == 'M') {
                length--;
            }
        }
        return length * 0.75 <= pCount;
    }

}
