# Incubyte TDD Kata

This project is a Test-Driven Development (TDD) Kata for Placement Assesment.

## Project Setup

To create the project, use the following Maven command:

```sh
mvn archetype:generate '-DgroupId=com.kata' '-DartifactId=Incubyte_TDD_Kata' '-DarchetypeArtifactId=maven-archetype-quickstart' '-DarchetypeVersion=1.4' '-DinteractiveMode=false'
```

To test the project :

```sh
mvn test
```
## Testcases Covered
    1. Empty string
    2. Single number string
    3. Comma seperated numbers
    4. Newline seperated numbers
    5. Custom delimiter
    6. String with negative numbers
    7. String with number greater than 1000
    8. Multiple delimeters

## Useful Resources

[JUnit Test with Maven in VSCode](https://www.freecodecamp.org/news/cjn-junit-test-with-maven-in-vscode)

[Split String by Multiple Delimiters in Java](https://beginnersbook.com/2022/09/split-string-by-multiple-delimiters-in-java)