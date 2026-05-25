# Java Basic Concepts

## 1. What is `package` in Java

A `package` is used to organize Java classes.

It is similar to a folder in a file system.

Benefits:

* Organizes code
* Avoids class name conflicts
* Makes programs easier to manage

Example:

```java id="jmt6lf"
package com.example;

public class Test {
}
```

Here:

* `com.example` is the package name
* `Test` belongs to this package

---

## 2. What is the Fully Qualified Name of a Class

A fully qualified name includes:

* package name
* class name

Format:

```text id="mp5jlwm"
packageName.className
```

Example:

```text id="5fx2vf"
java.util.Scanner
```

Where:

* `java.util` → package
* `Scanner` → class

---

## 3. How to Use `import` Statement

`import` is used to use classes from other packages.

Example:

```java id="jlwmq9"
import java.util.Scanner;
```

Then you can write:

```java id="uyjlwm"
Scanner sc = new Scanner(System.in);
```

instead of:

```java id="rm3q9g"
java.util.Scanner sc =
    new java.util.Scanner(System.in);
```

---

## 4. How to Use `String`

`String` is used to store text.

Example:

```java id="rwjl0n"
String name = "Alice";
```

Common methods:

```java id="3vlzgn"
name.length()
name.toUpperCase()
name.substring(0, 3)
```

Example:

```java id="g8z3a0"
String s = "Java";

System.out.println(s.length());
```

Output:

```text id="o2t0jo"
4
```

---

## 5. How to Use `StringTokenizer`

`StringTokenizer` splits a string into tokens.

Usually used for input processing.

Example:

```java id="6o3x17"
import java.util.StringTokenizer;

String line = "10 20 30";

StringTokenizer st =
    new StringTokenizer(line);

while (st.hasMoreTokens()) {
    System.out.println(st.nextToken());
}
```

Output:

```text id="e7xj6o"
10
20
30
```

---

## 6. How to Use `BufferedReader`

`BufferedReader` is used for fast text input.

Example:

```java id="tbmdah"
import java.io.*;

BufferedReader br =
    new BufferedReader(
        new InputStreamReader(System.in)
    );

String line = br.readLine();

System.out.println(line);
```

Features:

* Fast
* Reads line by line
* Often used in competitive programming

---

## 7. How to Use `PrintWriter`

`PrintWriter` is used for output.

It can write to:

* console
* files

Example:

```java id="w4ik2g"
import java.io.*;

PrintWriter out =
    new PrintWriter(System.out);

out.println("Hello Java");

out.flush();
```

Writing to a file:

```java id="4p2upm"
PrintWriter out =
    new PrintWriter("output.txt");

out.println("Hello");

out.close();
```

Important:

* `flush()` sends buffered output
* `close()` closes the stream properly
