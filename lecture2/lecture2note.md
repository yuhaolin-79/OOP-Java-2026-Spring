# Unit 1.1 Java Applications

## 1.1.3 Beginning with the Java API

### 1. Java API

- The Java API (Application Programming Interface) is a collection of pre-written classes and methods that provide functionality for various tasks, such as input/output operations, data manipulation, and more.
- For example, [java.util.Scanner](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Scanner.html) is a class in the Java API that allows you to read input from various sources, such as the keyboard or a file.

### 2. Pakage

- Packages are typically used to organize classes belonging to the same category or providing similar functionality.
  - A package provides a unique namespace for the types it contains.
  - Classes in the same package can access each other's package-access members.

> If you use a package declaration, it must be the first thing in your Java file, and the import declarations must be put immediately after it. If you do not have a package declaration, the import declarations must be the first thing in your Java file.

- The fully qualified name of a class that is part of a package is the package name and the class name separated by a dot.
for example: `java.util.Scanner` is the fully qualified name of the Scanner class in the java.util package.

- To use a package's classes inside a Java source file, it is convenient to import the classes from the package with an import declaration, so that the simple name of a class can be used directly in the source code.
- The import declaration has the following syntax:

```java
import java.util.Scanner; // package name + class name
```

### 3. Import statement

- If you use only a few classes from a package, it is good style to import them individually. This makes it easier to see which classes your program actually uses.

```java
import java.util.Scanner; // import the Scanner class from the java.util package
```

- If you use a lot of classes from a package, it probably makes more sense to use a wild card to import them all.

```java
import java.util.*; // import all classes from the java.util package
```

> The import statement will not increase the overload of programs, it acts just as a indicator to tell the compiler where to find the classes be used. BTW, *Classes java.lang.\* are automatically imported.*

Then, I will give an example.

```java
import java.lang.String;
import java.io.FileWriter;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("hello.txt");
            String h = "Hello"; 
            String w = "World";
            fw.write(h+ " " + w); 
            fw.close ();
        }
        catch (IOException e) {
            System.out.println("Error writing to file:" + e);
        }
    }
}
```

```bash
PS E:\OOP-Java-2026-Spring\lecture2> javac Test.java
PS E:\OOP-Java-2026-Spring\lecture2> java Test
PS E:\OOP-Java-2026-Spring\lecture2> cat hello.txt
Hello World
```

### 4. Java.lang.String Class

- String is a sequence of characters.
- Member methods of class String：
  - `String()`. Constructs a new String object that represents an empty character sequence.
  - `String(char[] value)`. Constructs a new String object that represents the sequence of characters contained in the character array.
  - `String(String original)`. Constructs a new String object that represents the same sequence of characters as the argument.
  - `int length()`. Obtains the number of characters in the String.
  - `char charAt(int index)`. Returns the character at the specified index.
  - `boolean equals(Object anObject)`. Returns true if the specified Object represents a String with the same sequence of characters.
  - `int indexOf(int ch)`. Returns the index of the first occurrence of the character.
  - `int indexOf(String str)`. Returns the index of the first occurrence of the String.
  - `boolean startsWith(String prefix)`. Checks if the String has the specified prefix.
  - `String substring(int beginIndex, int endIndex)`. Returns a substring.

- Comparison operations on String：
  - `==` operator compares the references of two String objects, not their contents. It returns true if both references point to the same object in memory.
  - `equals()` method compares the contents of two String objects. It returns true if the sequences of characters in both strings are identical.

- Strings are more commonly concatenated with the + operator

```java
String s1 = "Hello";
String s2 = "World";
int age = 25;
String s3 = s1 + " " + s2 + " " + age; // Concatenates s1, a space, s2, another space, and age
System.out.println(s3); // Output: Hello World 25
```

Now, I will give a program about String with the methods mentioned above.

```java
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
```

Here is the output of the above program:

```bash
PS E:\OOP-Java-2026-Spring\lecture2> javac StringTest.java
PS E:\OOP-Java-2026-Spring\lecture2> java StringTest
1. Empty string: []
2. String from char array: Hello
3. Copied string: Hello
4. String length: 5
5. Character at index 1: e
6. Are strFromArray and copiedStr equal? true
7. First index of 'e': 1
8. First index of "ll": 2
9. Does it start with "He"? true
10. Substring from index 1 to 4: ell
```

### 5. Java.util.StringTokenizer Class

- Tokenizing is the process of breaking a string into smaller pieces called tokens.
  - `"This string has five tokens"`
  - Popular delimiters include the white space, underline ( _ ) and the comma ( , ).
- Class StringTokenizer is grouped in java.util package：
  - StringTokenizer(String str). Constructs a string tokenizer. The     tokenizer uses the default delimiter set, white space.
  - StringTokenizer(String str, String delim). Constructs a string tokenizer. The argument delim contains the character delimiters for separating tokens.
  - boolean hasMoreTokens(). Tests if there are more tokens to extract.
  - String nextToken(String delim). Returns the next token in the string.
  - int countTokens(). Obtains the number of tokens left to be extracted, not the number of tokens in the string.

Now, I will give a program about StringTokenizer with the methods mentioned above.

```java
import java.util.*; 
public class ProductInfo { 
    public static void main(String[] args) {
      String data = "Mini Discs 74 Minute (10-Pack)_5_9.00"; 
      StringTokenizer tknzr = new StringTokenizer(data, "_"); 
      String name = tknzr.nextToken(); 
      String quantity = tknzr.nextToken(); 
      String price = tknzr.nextToken(); 
      System.out.println("Name: " + name); 
      System.out.println("Quantity: " + quantity); 
      System.out.println("Price: " + price); 
    }
}
```

Here is the output of the above program:

```bash
PS E:\OOP-Java-2026-Spring\lecture2> javac ProductInfo.java
PS E:\OOP-Java-2026-Spring\lecture2> java ProductInfo
Name: Mini Discs 74 Minute (10-Pack)
Quantity: 5
Price: 9.00
```

### 6. The Wrapper Classes

- The wrapper classes are used to wrap primitive data types into objects. They provide a way to use primitive data types as objects, which can be useful in certain situations, such as when working with collections or when you need to use methods that require objects.

- The wrapper classes in Java are:
  - `Byte` for `byte`
  - `Short` for `short`
  - `Integer` for `int`
  - `Long` for `long`
  - `Float` for `float`
  - `Double` for `double`
  - `Character` for `char`
  - `Boolean` for `boolean`

Here is an example of using wrapper classes:

```java
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
```

Here is the output of the above program:

```bash
PS E:\OOP-Java-2026-Spring\lecture2> javac WrapperExample.java
PS E:\OOP-Java-2026-Spring\lecture2> java WrapperExample
Integer object: 10
Primitive int: 10
Double object: 3.14
Primitive double: 3.14
String value of Integer: 10
```

And then, we can also use the wrapper classes to convert between strings and primitive data types:

```java
import java.util.*; 
public class ProductInfo { 
    public static void main(String[] args) {
    String data = "Mini Discs 74 Minute (10-Pack)_5_9.00"; 
    StringTokenizer tknzr = new StringTokenizer(data, "_"); 
    String name = tknzr.nextToken(); 
    //   String quantity = tknzr.nextToken(); 
    //   String price = tknzr.nextToken(); 
    int quantity = Integer.parseInt(tknzr.nextToken());
    double price = Double.parseDouble(tknzr.nextToken());
        System.out.println("Name: " + name); 
        System.out.println("Quantity: " + quantity); 
        System.out.println("Price: " + price); 
    }
}
```

The output is the same as before.

- J2SE 5.0 introduced autoboxing of primitive types into their wrapper object, and automatic unboxing of the wrapper objects into their primitive value.

```java
Integer a = 9; // Boxing
int b = a; // automatic unboxing
```

The traditional "boxing" example:

```java
List ssnList = new ArrayList(); // List of String objects
int ssn =  getSocSecNum();
Integer ssnObj = new Integer(ssn); // Boxing
ssnList.add(ssnObj); // Add the Integer object to the list
```

The autoboxing example:

```java
List ssnList = new ArrayList(); // List of String objects
int ssn =  getSocSecNum();
ssnList.add(ssn); // Autoboxing: the int ssn is automatically boxed into an Integer object
```

> The essence of autoboxing is compiler syntactic sugar, which still creates objects under the hood. In scenarios with high-frequency loops or large volumes of data, frequent boxing/unboxing operations generate a large number of temporary objects, increasing GC (Garbage Collection) pressure, which requires attention and optimization.

#### Core Question: Why Must We Convert `int` to `Integer`?

This is a fundamental constraint of the Java language, with 3 key reasons:

##### 1. The Nature of Type Erasure in Java Collections

Java collections (e.g., `List`, `ArrayList`) **only store objects (reference types)**, not primitive types (e.g., `int`, `char`, `double`).
Collections are designed around object references, and all elements must be subclasses of `Object`. Since `int` is a standalone primitive type that does **not** inherit from `Object`, it cannot be stored directly in a collection.

##### 2. Core Differences: Primitive `int` vs. Wrapper `Integer`

| Feature | Primitive `int` | Wrapper `Integer` |
| :--- | :--- | :--- |
| Nature | Stack-stored numeric value, not an object | Heap-stored object, inherits from `Object` |
| Storage | Stack memory (for local variables) | Heap memory, with a reference stored on the stack |
| Storable in Collections | ❌ No | ✅ Yes |
| Invocable Methods | ❌ None | ✅ Full set of object methods |

##### 3. Purpose of Boxing

Boxing "wraps" a primitive type into an object, granting it the properties of a reference type for use in collections, generics, and other scenarios that require objects.

BTW, null value assignment

```java
Integer a = null; // Valid: Integer can be null
int b = null; // Invalid: int cannot be null, will cause a compile-time error
```

- `a` is assigned null (which is legal), and then `a` is unboxed into `b`. However, null isn't a legal value for a primitive, so this code throws a `NullPointerException`.

### 7. Incrementing and Decrementing Warpper Types

- Every operation available to a primitive should be available to its wrapper-type counterpart, and vice versa:

```java
Integer counter = 1;
while(true) {
    System.out.println("Iteration %d%n", counter++);
    if(counter > 1000) {
        break;
    }
}
```

- Remember that counter is an Integer. So the value in counter was first auto-unboxed into an int, as that's the type required for the `++` operator. Once the value is unboxed, it is incremented. Then, the new value has to be stored back in counter, which requires a boxing operation.

> This is a typical example of performance loss from frequent boxing/unboxing.
1000 loop iterations mean **1000 unboxing + 1000 boxing operations**, creating 1000 temporary `Integer` objects.
The cache for values `-128~127` helps, but values beyond this range create new objects every time, increasing memory usage and GC pressure.
In contrast, using `int counter` only modifies a stack value with **zero object creation**, making it far more efficient.

- **Avoid in loops**: Use primitive `int` for computations; use `Integer` only for collections/generics.
- **Null risk**: `counter++` throws `NullPointerException` if `counter` is `null`.
- **Immutability**: `Integer` is immutable—all value changes create new objects (the root of performance loss).

## 1.1.4 Console I/O

### 1. Stream Input and Output

- A stream is a sequence of data that can be read from or written to. It provides a way to handle input and output (I/O) operations in Java.
  - **Bytes -> InputStream, OutputStream** Byte streams are used for data-based I/O, called input streams and output streams
  - **Characters -> FileReader, PrintWriter** Character streams are used for character-based I/O, called readers and writers.
- From a source to a destination
  - Keyboard File Network Memory

### 2. Standard Input and Output

- Provided in System class in java.lang
- `System.in` is an instance of InputStream that reads from the keyboard (standard input).
- `System.out` is an instance of PrintStream that writes to the console (standard output).
- `System.err` is an instance of PrintStream that writes to the console (standard error).(allow error messages to be sent to screen)

### 3. `Java.io` package

- Class java.io.BufferedReader
  - public BufferedReader(Reader in). Creates a buffering character-input stream that uses an input character stream.
- **readLine()** method of BufferedReader reads a line of text.
- read() method of BufferedReader reads a single character.

- Class java.io.PrintWriter
  - public PrintWriter(Writer out). Creates a new PrintWriter, without automatic line flushing, from an existing Writer.
- print() method of PrintWriter prints a string.
- println() method of PrintWriter prints a string and then terminates the line.

Here is an example of using BufferedReader and PrintWriter for console I/O:

```java
import java.io.*;
public class ConsoleIOExample {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out, true); // true for auto-flush

        try {
            writer.println("Enter your name:");
            String name = reader.readLine(); // Read a line of input from the user
            writer.println("Hello, " + name + "!"); // Greet the user
        } catch (IOException e) {
            writer.println("An error occurred: " + e.getMessage());
        }
    }
}
```

The output of the above program will be:

```bash
PS E:\OOP-Java-2026-Spring\lecture2> javac ConsoleIOExample.java
PS E:\OOP-Java-2026-Spring\lecture2> java ConsoleIOExample
Enter your name:
Fish
Hello, Fish!
```

### 4. `BufferedReader` vs. `Scanner`

#### 4.1 `Scanner`

Used for **easy input parsing**.

```java
Scanner sc = new Scanner(System.in);
Scanner sc2 = new Scanner(new File(filename));
int x = sc.nextInt();
String s = sc.next();
```

Features:

- Easy to use
- Can directly read `int`, `double`, `String`, etc.
- Slower performance

Common methods:

- `nextInt()`
- `nextDouble()`
- `next()`
- `nextLine()`

#### 4.2 `BufferedReader`

Used for **fast text input**.

```java
BufferedReader br =
    new BufferedReader(
        new InputStreamReader(System.in)
    );
BufferedReader br2 = new BufferedReader(new FileReader(filename));
String line = br.readLine();
```

Features:

- Faster than `Scanner`
- Reads text line by line
- Needs manual type conversion

Example:

```java
int x = Integer.parseInt(br.readLine());
```

#### 4.3 Main Differences

| `Scanner`                 | `BufferedReader`     |
| ------------------------- | -------------------- |
| Easy to use               | Faster               |
| Parses data automatically | Reads only text      |
| Slower                    | Better performance   |
| Good for beginners        | Good for large input |

#### 4.4 Recommendation

- Use `Scanner` for:
  - beginners
  - small programs

- Use `BufferedReader` for:
  - competitive programming
  - large input data
  - better performance

### 5. Using `printf()` Convenience Method

- `printf()` is a method of `PrintStream` that allows you to format output using format specifiers.

```java
import java.io.*;
public class PrintTester { 
    public static void main(String[] args) {
        String filename = args[0]; 
        try { 
            File file = new File(filename); 
            FileReader fileReader = new FileReader(file); 
            BufferedReader reader = new BufferedReader(fileReader); 
            String line; 
            int i = 1; 
            while ((line = reader.readLine( )) != null) { 
                System.out.printf("Line %d: %s%n", i++, line); 
            } 
        } catch (Exception e) { 
            System.err.printf("Unable to open file named '%s': %s",
                          filename, e.getMessage( )); 
        }  
    } 
}
```

Here is the output of the above program when run with a file named `test.txt` containing the following lines:

```bash
PS E:\OOP-Java-2026-Spring\lecture2> javac PrintTester.java
PS E:\OOP-Java-2026-Spring\lecture2> java PrintTester test.txt
Line 1: This file is a test file for PrintTester
Line 2: Autor fish
Line 3: Date  2026/05/25
```
