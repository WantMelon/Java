import java.util.ArrayList;
import java.util.regex.Pattern;

public class Main {
    public static ArrayList<Integer> fillNumbers(String expression) {
        Pattern pattern = Pattern.compile("[+*]");
        String[] stringNumbers = pattern.split(expression);
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < stringNumbers.length; ++i) {
            numbers.add(Integer.parseInt(stringNumbers[i]));
        }
        return numbers;
    }

    public static ArrayList<Character> fillSigns(String expression) {
        Pattern pattern = Pattern.compile("\\d");
        String[] stringNumbers = pattern.split(expression);
        ArrayList<Character> signs = new ArrayList<>();
        for (int i = 0; i < stringNumbers.length; ++i) {
            if (!stringNumbers[i].equals("")) {
                signs.add(stringNumbers[i].charAt(0));
            }
        }
        return signs;
    }

    public static int operation(int n1, int n2, char sign) {
        if (sign == '*') {
            return n1 * n2;
        } else if (sign == '+') {
            return n1 + n2;
        } else {
            throw new ArithmeticException();
        }
    }

    public static int findMaxAnswer(ArrayList<Integer> numbers,
                                    ArrayList<Character> signs) {
        int[][] matrix = new int[numbers.size()][numbers.size()];
        for (int i = 0; i < numbers.size(); ++i) {
            matrix[i][i] = numbers.get(i);
        }

        //int result;
        for (int i = 1, j = 1; i < matrix.length; ++i, ++j) {
            int maxNum = Integer.MIN_VALUE;
            for (int k = 0; k < i; ++k) {
                int el1 = i - 1 - k;
                int el2 = j + i - k;
                int num = operation(el1, el2, signs.get(i));
                if (num > maxNum) {
                    maxNum = num;
                }
            }
            matrix[i][i - j] = maxNum;
        }

        return matrix[matrix.length - 1][matrix.length - 1];
    }

    public static void main(String[] args) {
        String expression = "1+2*3+4*5";
        ArrayList<Integer> numbers = fillNumbers(expression);
        ArrayList<Character> signs = fillSigns(expression);
        int maxAnswer = findMaxAnswer(numbers, signs);
        System.out.println(maxAnswer);
    }
}
