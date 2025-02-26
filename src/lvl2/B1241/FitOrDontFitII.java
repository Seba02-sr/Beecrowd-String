package lvl2.B1241;

import java.util.Scanner;

public class FitOrDontFitII {

    /**
     * ---ENUNCIADO---
     * 1- Dado dos numeros A y B, corroborar si B es el ultimo digito de A.
     * 
     * ---INPUT---
     * 1- Numero entero --> Casos de pruebas.
     * 2- Caso de prueba --> Dos numeros mayor que cero.
     * 
     * ---OUTPUT---
     * 1- Imprimir si B encaja en A
     * + "encaixa" --> Encaja
     * + "nao encaixa" --> No encaja
     * 
     * @param args
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] numbers = scanner.nextLine().split(" ");

            String firstNum = numbers[0];
            String secondNum = numbers[1];

            int lenF = firstNum.length(), lenS = secondNum.length();
            
            if (lenS > lenF){
                System.out.println("nao encaixa");
            }else if (firstNum.equals(secondNum)) {
                System.out.println("encaixa");
            } else {
                String subNum = firstNum.substring(lenF - lenS, lenF);

                if (subNum.equals(secondNum)) {
                    System.out.println("encaixa");
                } else {
                    System.out.println("nao encaixa");
                }
            }

        }
        scanner.close();
    }

}
