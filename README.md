# String Compression and Decompression Method Creation Task for Sourcery Academy

### Main Task:
The goal is to create a method that **compresses** a string by reducing sequences of repeating characters into the character followed by the number of times it repeats consecutively.

### Compression Input:
- The input string will contain **only lowercase letters**.
- The input string **might be empty**.

### Compression Output:
- For a string like `"aaabb"`, the output should be `"a3b2"`.
- For a string like `"abc"`, the output should be `"a1b1c1"`.
- For an empty string, the output should be `""`.

### Optional Task: Decompression Method
Implement a decompression method to reconstruct the original string from the compressed format.

### Decompression Input:
- The input string will contain **only lowercase letters** and **numbers**, where the number indicates how many times the preceding character is repeated.
- The input string **might be empty**.

### Decompression Output:
- For a string like `"a3b2"`, the output should be `"aaabb"`.
- For a string like `"a1b1c1"`, the output should be `"abc"`.
- For an empty string, the output should be `""`.

### How to Run
1. Ensure you have Java and Maven installed on your system.
2. Navigate to the project directory.
3. Compile the project using Maven: ```mvn compile```
4. Run the application:  ```mvn exec:java```

### How to Run Tests
1. Ensure you have Java and Maven installed on your system.
2. Navigate to the project directory.
3. Run the tests using Maven: ```mvn test```