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
        String ieInfo = "The Information Expert principle focuses on assigning responsibilities to classes that possess the most information required to fulfill them. A class should be responsible for a particular task if it has the necessary information to perform that task effectively.";

        // Creator
        String creatorInfo = "The Creator principle guides the allocation of responsibility for creating objects. According to this principle, a class should be responsible for creating objects of other classes if the first class aggregates, contains, or has a composition relationship with the second class.";

        // Polymorphism
        String polymorphismInfo = "Polymorphism is a fundamental principle in object-oriented design that enables objects of different classes to be treated uniformly through a common interface. By leveraging polymorphism, we can design systems that are extensible and adaptable to new requirements.";

        // Indirection
        String indirectionInfo = "The Indirection principle suggests using an intermediate class to mediate between different classes, reducing the coupling between them. This principle helps in achieving a system design that is easier to maintain and modify";

        // Pure Fabrication
        String pureFabricationInfo = "The Pure Fabrication principle suggests creating a class that does not represent a concept in the problem domain but helps in achieving low coupling and high cohesion. This class is fabricated to ensure that each class adheres to the single responsibility principle and that the system as a whole remains loosely coupled.";

        return "<div class='grasp-patterns'>" +
                "<h1>GRASP Patterns:</h1>" +
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