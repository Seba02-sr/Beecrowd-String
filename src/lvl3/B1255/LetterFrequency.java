package B1255;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LetterFrequency {

    /**
     * ---ENUNCIADO---
     * 1- Se interesa saber la frecuencia de las letras que ocurren en el texto,
     * ignorando case.
     * 
     * ---INPUT---
     * 1- N --> Casos de prueba.
     * 2- Casos de Prueba --> Puede contener numeros y almenos una letra.
     * 
     * ---OUTPUT---
     * 1- Imprimir la letra que mas frecuencia hay, si hay empate imprimirlas todas
     * en orden alfabetico
     * 
     * 
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            HashMap<Character, Integer> frequency = new HashMap<>();
            String text = scanner.nextLine();

            for (char c : text.toCharArray()) {
                if (Character.isLetter(c)) {
                    c = Character.toLowerCase(c);
                    frequency.put(c, frequency.getOrDefault(c, 0) + 1);
                }
            }

            printMoreFrequency(frequency);
            System.out.println();
        }
        scanner.close();
    }

    public static void printMoreFrequency(HashMap<Character, Integer> frequency) {
        int maxValue = Collections.max(frequency.values());

        List<Character> maxFrequencyCharacter = frequency.entrySet().stream()
                .filter(e -> e.getValue() == maxValue)
                .map(Map.Entry::getKey)
                .sorted(Comparator.comparingInt(Character::toLowerCase))
                .collect(Collectors.toList());

        for (Character c : maxFrequencyCharacter) {
            System.out.print(c);
        }
    }
}
