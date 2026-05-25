public class StringTest {
    public static void main(String[] args) {

        // 1. String() - Creates an empty String
        String emptyStr = new String();
        System.out.println("1. Empty string: [" + emptyStr + "]");

        // 2. String(char[] value) - Creates a String from a char array
        char[] charArray = {'H', 'e', 'l', 'l', 'o'};
        String strFromArray = new String(charArray);
        System.out.println("2. String from char array: " + strFromArray);

        // 3. String(String original) - Creates a copy of the given string
        String originalStr = "Hello";
        String copiedStr = new String(originalStr);
        System.out.println("3. Copied string: " + copiedStr);

        // 4. int length() - Returns the length of the string
        int len = copiedStr.length();
        System.out.println("4. String length: " + len);

        // 5. char charAt(int index) - Returns character at specified index
        char ch = copiedStr.charAt(1);
        System.out.println("5. Character at index 1: " + ch);

        // 6. boolean equals(Object anObject) - Compares content of two strings
        boolean isEqual = strFromArray.equals(copiedStr);
        System.out.println("6. Are strFromArray and copiedStr equal? " + isEqual);

        // 7. int indexOf(int ch) - Finds first occurrence of a character
        int index1 = copiedStr.indexOf('e');
        System.out.println("7. First index of 'e': " + index1);

        // 8. int indexOf(String str) - Finds first occurrence of a substring
        int index2 = copiedStr.indexOf("ll");
        System.out.println("8. First index of \"ll\": " + index2);

        // 9. boolean startsWith(String prefix) - Checks prefix
        boolean startsWith = copiedStr.startsWith("He");
        System.out.println("9. Does it start with \"He\"? " + startsWith);

        // 10. String substring(int begin, int end) - Extracts substring
        String subStr = copiedStr.substring(1, 4);
        System.out.println("10. Substring from index 1 to 4: " + subStr);
    }
}