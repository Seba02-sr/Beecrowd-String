import java.util.Scanner;

public class Led {

    private static final int[] LEDS_PER_DIGIT = { 6, 2, 5, 5, 4, 5, 6, 3, 7, 6 };

    /**
     * ---ENUNCIADO---
     * 1- Calcular la cantidad de leds necesarios para el numero ingresado.
     * 
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int line = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < line; i++) {
            String numbers = scanner.nextLine();
            System.out.println(countLeds(numbers) + " leds");
        }

        scanner.close();
    }

    private static int countLeds(String numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length(); i++) {
            sum += LEDS_PER_DIGIT[numbers.charAt(i) - '0'];
        }
        return sum;
    }

}
