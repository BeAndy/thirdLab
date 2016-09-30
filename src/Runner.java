import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runner {
    public static void main(String[] args) {
        fibNumbers(parseElements("Fibonacci", 3, "Input 3 numbers(x0,x1,N)"));
        createPascal(parseElements("Pascal", 1, "Input 1 number(N)"));
    }

    private static void fibNumbers(int[] elArray) {
        try {
            int[] elementsArray = new int[elArray[2]];
            elementsArray[0] = elArray[0];
            elementsArray[1] = elArray[1];
            for (int i = 2; i < elArray[2]; i++) {
                int tempElement = elementsArray[i - 1] + elementsArray[i - 2];
                elementsArray[i] = tempElement;
            }
            System.out.println(Arrays.toString(elementsArray) + "\n");
        } catch (Exception e) {
            System.err.println("There is no 3 numbers in the string");
        }
    }

    private static String inputEquation(String whatInput) {
        Scanner input = new Scanner(System.in);
        System.out.println(whatInput);
        return input.nextLine();
    }

    private static int[] parseElements(String taskType, int elementsNumber, String whatInput) {
        System.out.println(taskType + " task:");
        Pattern p = Pattern.compile("\\d+");
        String inString = inputEquation(whatInput);
        Matcher m = p.matcher(inString);
        int[] inElements = new int[elementsNumber];
        int i = 0;
        while (m.find() && i < elementsNumber) {
            inElements[i] = Integer.parseInt(m.group());
            i++;
        }
        System.out.println(Arrays.toString(inElements));
        return inElements;
    }

    private static void printMatrix(int[][] pascalArray) {
        for (int i = 0; i < pascalArray.length; i++) {
            for (int j = 0; j < pascalArray[i].length; j++) {
                System.out.print(pascalArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void createPascal(int[] elArray) {
        int numStrings = elArray[0];
        int[][] pascalArray = new int[numStrings][0];
        pascalArray[0] = new int[1];
        pascalArray[1] = new int[2];
        pascalArray[0][0] = 1;
        pascalArray[1][0] = 1;
        pascalArray[1][1] = 1;
        for (int i = 2; i < numStrings; i++) {
            pascalArray[i] = new int[i + 1];
            pascalArray[i][0] = 1;
            pascalArray[i][i] = 1;
            for (int j = 1; j < i; j++) {
                pascalArray[i][j] = pascalArray[i - 1][j - 1] + pascalArray[i - 1][j];
            }
        }
        printMatrix(pascalArray);
    }
}
