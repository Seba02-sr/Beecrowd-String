import java.util.Scanner;

public class ContractRevision {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();

            if ("0 0".equals(line)) {
                break;
            }

            int spaceIndex = line.indexOf(' ');

            if (spaceIndex == -1)
                continue;

            String toRemove = line.substring(0, spaceIndex);
            String target = line.substring(spaceIndex + 1);

            String result = target.replaceAll(toRemove, "");

            result = result.replaceFirst("^0+", ""); // remove Leading Zeros

            System.out.println(result.isEmpty() || result.matches("0+") ? "0" : result);
        }

        scanner.close();
    }
}
