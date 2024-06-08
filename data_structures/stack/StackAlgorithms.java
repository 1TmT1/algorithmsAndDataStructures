package data_structures.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class StackAlgorithms {

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

    public static int[] nextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = arr.length - 1; i > -1; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }

            stack.push(arr[i]);
        }
        
        return result;
    }

    public static boolean isValidParentheses(String str) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : str.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char top = stack.peek();
                    if ((c == ')' && top == '(') ||
                        (c == ']' && top == '[') || 
                        (c == '}' && top == '{')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        // Scanner input = new Scanner(System.in);
        // System.out.println("Enter text to reverse: ");
        // String str = input.nextLine();
        
        String str = "Hello";
        System.out.println(reverse(str));

        int[] numbers = new int[]{5, 4, 2, 1, 1, 6, 8, 10, 12, 5, 4, 10};
        System.out.println(Arrays.toString(nextGreaterElement(numbers)));
    
        String parentheses = "{[]([()])}";
        System.out.println(parentheses + ": " + isValidParentheses(parentheses));
        
        parentheses = "{[][([)]}]";
        System.out.println(parentheses + ": " + isValidParentheses(parentheses));
    }
}
