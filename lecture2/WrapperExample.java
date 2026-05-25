public class WrapperExample {
    public static void main(String[] args) {
        // Using Integer wrapper class
        Integer intObj = Integer.valueOf(10); // Boxing
        int primitiveInt = intObj.intValue(); // Unboxing

        System.out.println("Integer object: " + intObj);
        System.out.println("Primitive int: " + primitiveInt);

        // Using Double wrapper class
        Double doubleObj = Double.valueOf(3.14); // Boxing
        double primitiveDouble = doubleObj.doubleValue(); // Unboxing

        System.out.println("Double object: " + doubleObj);
        System.out.println("Primitive double: " + primitiveDouble);

        String stringValue = intObj.toString(); // Convert Integer to String
        System.out.println("String value of Integer: " + stringValue);
    }
}