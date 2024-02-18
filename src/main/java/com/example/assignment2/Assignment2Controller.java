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
    public String checkAscii(@RequestParam(value="url",defaultValue="test string") String str) {
        return asciiEncoding(str);
    }
    public static String asciiEncoding(String str) {
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
        return str1.contains(str2);
    }


    public static int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] transposedMatrix = new int[n][m];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }
}