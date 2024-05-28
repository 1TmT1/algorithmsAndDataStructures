package data_structures;

public class StringUtils {

    // Time - O(n), Space - O(n)
    public static boolean isPalindrome(String word) {
        char[] wordChars = word.toCharArray();
        int start = 0;
        int end = word.length() - 1;

        while (start < end) {
            if (wordChars[start] != wordChars[end]) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {
        String word = "WoW";
        System.out.println("Is " + word + " palindrome: " + isPalindrome(word));
        
        word = "Test";
        System.out.println("Is " + word + " palindrome: " + isPalindrome(word));
    }
}
