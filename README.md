# Simplified Java

## Overview

Simplified Java is a Java package that provides a simplified and efficient input/output mechanism for competitive programming and other scenarios requiring fast I/O operations. The package includes the `StdIO` class, which facilitates easy input and output operations, inspired by various sources in the programming community.

## Acknowledgments

This project stands on the shoulders of the following individuals and sources, to whom we express our gratitude:

1. **Professor Robert Sedgewick (Princeton University):**
    - The design and inspiration for the `StdIO` class were based on Prof. Sedgewick's `StdIn` class.
    - [Source](https://introcs.cs.princeton.edu/java/stdlib/StdIn.java.html)

2. **sagar797 (from GeeksforGeeks):**
    - The BufferedWriter implementation used in this code was adapted from sagar797's code on GeeksforGeeks.
    - [Source](https://www.geeksforgeeks.org/how-to-print-fast-output-in-competitive-programming-using-java/)

3. **Kushleen Waraich (from Coding Ninjas):**
    - The custom Reader class based on DataInputStream and pre-defined buffer used in this code was adapted from Kushleen Waraich's code on Coding Ninjas.
    - [Source](https://www.codingninjas.com/studio/library/fast-io-in-java-for-competitive-programming/)

## Features

- **Efficient Input/Output:**
    - The `StdIO` class provides efficient methods for reading various data types and printing output.

- **Data Type Agnostic:**
    - Supports input and output for various data types, including primitive types and Strings.

- **Fast I/O for Competitive Programming:**
    - Optimized for scenarios where fast I/O operations are crucial, such as competitive programming contests.

- **Convenient and Easy to Use:**
    - Simplifies the process of reading input and printing output in Java, reducing boilerplate code.

## Examples

### Reading Input:

```java
int n = scanInt();
String word = scanWord();
double value = scanDouble();
```

### Printing Output:

```java
print("Hello, ");
println("World!");
```

## Usage

1. Clone the repository:

```bash
git clone https://github.com/your-username/SimplifiedJava.git
```

2. Include the `StdIO` class in your Java project:

```java
import javaNeo.StdIO;
```

3. Start using the `StdIO` class for efficient I/O operations in your Java code.

## Contributors

- Divyanshu Mishra (myself)

## License

This project is not yet licensed.

---

Feel free to contribute, report issues, or suggest improvements. Happy coding!