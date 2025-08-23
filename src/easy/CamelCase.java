package easy;

import java.util.Arrays;
import java.util.Scanner;

public class CamelCase {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String input = scanner.nextLine();
            String[] splited = input.split(";");
            StringBuilder sb = new StringBuilder();
            System.out.println(Arrays.toString(splited));
            // to splite input
            if (splited[0].equals("S")) {
                // all upper case
                boolean isLowerNextChar = splited[1].equals("C") ? true : false;
                for(char character : splited[2].toCharArray()) {
                    if (isLowerNextChar) {
                        sb.append(Character.toLowerCase(character));
                        isLowerNextChar = false;
                    } else if (character == '(') {
                        break;
                    } else if (Character.isUpperCase(character)) {
                        sb.append(' ');
                        sb.append(Character.toLowerCase(character));
                    } else {
                        sb.append(character);
                    }
                }
                System.out.println(sb.toString());
            } else {
                boolean isUpperNextChar = splited[1].equals("C") ? true : false;
                for (char character : splited[2].toCharArray()) {
                    if (isUpperNextChar) {
                        sb.append(Character.toUpperCase(character));
                        isUpperNextChar = false;
                    } else if (character == ' ') {
                        isUpperNextChar = true;
                    } else {
                        sb.append(character);
                    }
                }
                if (splited[1].equals("M")) {
                    sb.append("()");
                }
                System.out.println(sb.toString());
            }
        }
        scanner.close();
    }
}
