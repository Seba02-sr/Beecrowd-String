import java.util.Arrays;
import java.util.Scanner;

public class PlanDeDieta {

    /**
     * ---ENUNCIADO---
     * 1- Hay una dieta de comida, que corresponden cada caracter.
     * 2- Hay que comer el resto de alimentos en la cena.
     * 3- Si hay trampa, comer comida que no esta en la dieta o coemr demasiado de
     * uno, imprimir "CHEATER".
     * 
     * ---INPUT---
     * 1- N --> numero de casos de prueba
     * 2- Casos de prueba --> Tres cadenas, cada una separadas por una linea
     * diferente.
     * + Cadena 1 --> Dieta.
     * + Cadena 2 --> Desayuno.
     * + Cadena 3 --> Almuerzo.
     * 
     * ---OUTPUT---
     * 1- Imprimir lo que hay que comer en la Cena para completar la dieta
     * 
     * @param args
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            StringBuilder diet = new StringBuilder(scanner.nextLine());
            String breakfast = scanner.nextLine();
            String lunch = scanner.nextLine();

            if (isCheater(diet, breakfast)) {
                System.out.println("CHEATER");
                continue;
            }
            if (isCheater(diet, lunch)) {
                System.out.println("CHEATER");
                continue;
            }

            char[] sorted = diet.toString().toCharArray();

            Arrays.sort(sorted);

            diet.setLength(0);
            diet.append(sorted);
            System.out.println(diet.toString());

        }
        scanner.close();
    }

    public static boolean isCheater(StringBuilder diet, String food) {

        if (food.length() > diet.length()) {
            return true;
        }
        for (char c : food.toCharArray()) {
            int index = diet.indexOf(String.valueOf(c));

            if (index != -1) {
                diet.deleteCharAt(index);
            } else {
                return true;
            }
        }
        return false;
    }
}
