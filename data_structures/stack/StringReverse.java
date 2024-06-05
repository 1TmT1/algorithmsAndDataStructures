package data_structures.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class StringReverse {

    public static String reverse(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = str.toCharArray();

        for (char c : chars) {
            stack.push(c);
        }

        for (int i = 0; i < str.length(); i++) {
            chars[i] = stack.pop();
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter text to reverse: ");
        String str = input.nextLine();
        
        System.out.println(reverse(str));
    }
}
