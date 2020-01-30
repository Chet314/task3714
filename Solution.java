package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


/*
Древний Рим
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        Map<Integer, String> patterns = new LinkedHashMap<>();
        patterns.put(1000, "M");
        patterns.put(500, "D");
        patterns.put(100, "C");
        patterns.put(50, "L");
        patterns.put(10, "X");
        patterns.put(5, "V");
        patterns.put(1, "I");

        int result = 0;
        int lastNumber = 0;
        int latinNumber = 0;
        char[] parseString = s.toUpperCase().toCharArray();
        for (int i = 0; i < parseString.length; ) {
            for (Map.Entry<Integer, String> entry : patterns.entrySet()) {
                if (String.valueOf(parseString[i]).equals(entry.getValue())) {
                    latinNumber = entry.getKey();
                    result = process(latinNumber, lastNumber, result);
                }
            }
            lastNumber = latinNumber;
            i++;
        }
        return result;
    }

    public static int process(int latinNumber, int lastNumber, int result) {
        if (result == 0) {
                return result + latinNumber;
        } else {
            if (lastNumber < latinNumber) {
                return result + latinNumber - 2*lastNumber;
            } else {
                return result + latinNumber;
            }
        }
    }
}


