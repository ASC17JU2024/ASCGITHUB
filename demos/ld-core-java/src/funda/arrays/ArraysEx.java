package funda.arrays;

import java.util.Arrays;

public class ArraysEx {
    public static void main(String[] args) {
        char[] vowels = {'u', 'e', 'i', 'o', 'a'};

//        char [] vowelsCopy = new char[5];
//        vowelsCopy[0] = 'u';
        // similar for the other vowels.
        // Sort the array in ascending order
        //Manual iterations
        Arrays.sort(vowels);
        Arrays.fill();
        System.out.println(Arrays.toString(vowels));
//        System.out.println("Sorted vowels : " + vowels);
        for(int i = 0; i<vowels.length; i++){
            System.out.println(vowels[i]);
        }
 //       System.out.println("Sorted array in ascending order: " + Arrays.toString(vowels));

        // Sort the array in descending order
        char[] reverse = new char[vowels.length];
        for (int i = 0; i < vowels.length; i++) {
            reverse[i] = vowels[vowels.length - 1 - i];
        }
        System.out.println("Sorted array in descending order: " + Arrays.toString(reverse));
        String customToString = "[";
        for(int i = 0; i<vowels.length;i++){
            if(i == (vowels.length -1) ) {
                customToString = customToString + vowels[i] ;
            }
            else
            {
                customToString = customToString + vowels[i] + ", ";
            }
        }
        customToString += "]";
        System.err.println(customToString);

// Normal (linear) search for an element in the array
char searchChar = '9';
int index = -1;
for (int i = 0; i < vowels.length; i++) {
    if (vowels[i] == searchChar) {
        index = i;
        break;
    }
}
if (index != -1) {
    System.out.println("Element " + searchChar + " found at index: " + index);
} else {
    System.out.println("Element " + searchChar + " not found in the array.");
}
   }

    public static class DataTypesEx {
        public static void main(String[] args) {
            //8 primitie datatypes
            byte byteVar = -128;
            short shortVar = 32767;
            int intVar = 2147483647;
            long longVar = 9223372036854755807L;
            float floatVar = 12345.1234567F;
            double doubleVar = 12345.123456712345678D;
            boolean booleanVar = true;
            char charVar = 'W';

            System.out.println("Value of byteVar: " + byteVar);
            System.out.println("Value of shortVar: " + shortVar);
            System.out.println("Value of intVar: " + intVar);
            System.out.println("Value of longVar: " + longVar);
            System.out.println("Value of floatVar: " + floatVar);
            System.out.println("Value of doubleVar: " + doubleVar);
            System.out.println("Value of booleanVar: " + booleanVar);
            System.out.println("Value of charVar: " + charVar);
        }
    }
}