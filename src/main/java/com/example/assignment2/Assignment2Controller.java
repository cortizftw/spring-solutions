package com.example.assignment2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Assignment2Controller {

    @PostMapping("/palindrome")
    public boolean checkPalindrome(@RequestParam String str) {

        return isPalindrome(str);
    }

    public static boolean isPalindrome(String str) {
        if (str.isEmpty()) {
            return false;
        }

        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }


    @GetMapping("/ascii")
    public String checkAscii(@RequestParam(value = "url") String str) {
        return asciiEncoding(str);
    }

    public static String asciiEncoding(String str) {
        if (str.isEmpty()) {
            return "Please enter a valid string.";
        }

        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    @PostMapping("/substring")
    public boolean checkSubString(@RequestParam String str1, @RequestParam String str2) {
        return substring(str1, str2);
    }

    public static boolean substring(String str1, String str2) {
        if (str1.isEmpty() || str2.isEmpty()) {
            return false;
        }
        return str1.contains(str2);
    }

    @PostMapping("/transpose")
    public int[][] checkTranspose(@RequestParam int cell00, @RequestParam int cell01, @RequestParam int cell10, @RequestParam int cell11) {
        int[][] matrix = {{cell00, cell01}, {cell10, cell11}};
        return transpose(matrix);
    }

    public static int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] transposedMatrix = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }

    @PostMapping("/unique")
    public boolean checkUnique(@RequestParam String str) {
        return isUnique(str);
    }
    public static boolean isUnique(String str) {
        if (str.isEmpty() ) {
            return false;
        }

        char[] charArray = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            for (int j = 0; j < i; j++) {
                if (charArray[j] == currentChar) {
                    return false;
                }
            }
            charArray[i] = currentChar;
        }
        return true;
    }

    @PostMapping("/grasp")
    public String grasp() {
        // Information Expert
        String ieInfo = "The Information Expert design pattern suggests assigning responsibilities to the class that has the most information required to fulfill them. In this context, it's used to ensure that each class encapsulates the data and behavior relevant to it, promoting high cohesion and reducing coupling within the system, ultimately leading to more maintainable and flexible code.";

        // Creator
        String creatorInfo = "The Creator design pattern delegates the responsibility of creating instances of classes to specialized factory classes or methods. This approach is preferred over creating objects directly in the main method because it centralizes object creation logic, promotes encapsulation, and enhances code maintainability by abstracting the creation process, allowing for easier modification and extension in the future.";

        // Polymorphism
        String polymorphismInfo = "In object-oriented programming, polymorphism allows objects of different classes to be treated as objects of a common superclass. This principle is used to achieve flexibility and extensibility in the system by allowing different classes to be used interchangeably, promoting code reuse and reducing the need for conditional statements and type checking. Polymorphism is achieved through method overriding and method overloading in Java.";

        // Indirection
        String indirectionInfo = " The object intermediates between two other objects by acting as a mediator or controller, facilitating communication and interaction between them without them having direct knowledge of each other. This pattern decouples the objects, promoting modularity, reusability, and flexibility in the system.";

        // Pure Fabrication
        String pureFabricationInfo = "In the context of design patterns, a Pure Fabrication is an artificial class introduced solely to achieve a higher degree of cohesion and encapsulation. This fabricated object typically encapsulates behaviors or responsibilities that do not naturally belong to any existing domain entity.";

        return "<div class='grasp-patterns'>" +
                "<h1>GRASP Patterns:</h1>" +
                "<h3>GRASP (General Responsibility Assignment Software Patterns) is a set of principles used in object-oriented design to assign responsibilities to classes and objects effectively. These patterns help developers design software systems that are flexible, maintainable, and scalable by defining clear guidelines for class and object interactions.</h3>" +
                "<h2>Information Expert</h2>" +
                "<p class='pattern'>" + ieInfo + "</p>" +
                "<h2>Creator</h2>" +
                "<p class='pattern'>" + creatorInfo + "</p>" +
                "<h2>Polymorphism</h2>" +
                "<p class='pattern'>" + polymorphismInfo + "</p>" +
                "<h2>Indirection</h2>" +
                "<p class='pattern'>" + indirectionInfo + "</p>" +
                "<h2>Pure Fabrication</h2>" +
                "<p class='pattern'>" + pureFabricationInfo + "</p>" +
                "</div>";
    }
}