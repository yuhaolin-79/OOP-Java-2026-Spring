# Lecture 2 — Java API & Console I/O

Unit 1.1.3: Beginning with the Java API  
Unit 1.1.4: Console I/O

## Topics Covered

### Java API & Packages
- Overview of the Java API (pre-written classes and methods)
- Packages as namespace organizers (`java.util`, `java.io`, `java.lang`)
- Import declarations — single class vs. wildcard imports
- Fully qualified names (`java.util.Scanner`)

### String Class (`java.lang.String`)
- String constructors: `String()`, `String(char[])`, `String(String)`
- Key methods: `length()`, `charAt()`, `equals()`, `indexOf()`, `startsWith()`, `substring()`
- `==` vs. `equals()` — reference comparison vs. content comparison
- String concatenation with `+`

### StringTokenizer (`java.util.StringTokenizer`)
- Tokenizing strings with custom delimiters
- Methods: `hasMoreTokens()`, `nextToken()`, `countTokens()`

### Wrapper Classes
- Boxing / Unboxing primitives (`Integer`, `Double`, `Boolean`, etc.)
- Autoboxing (J2SE 5.0+) — compiler syntactic sugar
- Performance implications of boxing in loops
- Null safety: `Integer` can be `null`, primitive `int` cannot
- Type conversion: `Integer.parseInt()`, `Double.parseDouble()`
- Incrementing wrapper types and the hidden boxing/unboxing cost

### Console I/O
- Stream concepts: byte streams vs. character streams
- `System.in`, `System.out`, `System.err`
- `BufferedReader` + `InputStreamReader` for fast line-based input
- `PrintWriter` for formatted output
- `Scanner` vs. `BufferedReader` comparison
- `printf()` format specifiers (`%d`, `%s`, `%n`)
- `String.split()` with regex (in `examples/`)

## Files

| File | Description |
|---|---|
| `lecture2note.md` | Full bilingual notes for Unit 1.1.3 & 1.1.4 |
| `Review.md` | Quick-reference review of key concepts |
| `Test.java` | Package & import demo — writes "Hello World" to file via `FileWriter` |
| `StringTest.java` | Demonstrates 10 `String` class methods |
| `ProductInfo.java` | `StringTokenizer` + wrapper class parsing (`Integer.parseInt`, `Double.parseDouble`) |
| `WrapperExample.java` | Boxing/unboxing with `Integer` and `Double` |
| `ConsoleIOExample.java` | `BufferedReader` + `PrintWriter` console interaction |
| `PrintTester.java` | Reads a file and prints numbered lines using `printf()` |
| `test.txt` | Sample input file for `PrintTester` |
| `examples/Sample.java` | Compares `Scanner`, `BufferedReader`, and `FileReader` approaches |
| `examples/SplitRegexDemo.java` | `String.split()` with regex patterns (delimiters, escaping, digit extraction, limit) |

## Run Examples

```bash
# Package & import demo
javac Test.java && java Test && cat hello.txt

# String methods
javac StringTest.java && java StringTest

# StringTokenizer + Wrappers
javac ProductInfo.java && java ProductInfo

# Wrapper classes
javac WrapperExample.java && java WrapperExample

# Console I/O (interactive)
javac ConsoleIOExample.java && java ConsoleIOExample

# printf file reader
javac PrintTester.java && java PrintTester test.txt

# Regex split demo
cd examples && javac SplitRegexDemo.java && java SplitRegexDemo
```
