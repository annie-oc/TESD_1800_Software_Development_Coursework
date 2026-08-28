// Author: Annie O'Connor
// Date: 8.28.26

public class MyInteger {

    private int value;
 
    public MyInteger(int value) {
        this.value = value;
    }
 
    public int getValue() {
        return value;
    }
 
    public boolean isEven() {
        return isEven(value);
    }
 
    public boolean isOdd() {
        return isOdd(value);
    }
 
    public boolean isPrime() {
        return isPrime(value);
    }
 
    public static boolean isEven(int value) {
        if ( value % 2 == 0);
            return true;
    }
 
    public static boolean isOdd(int value) {
        if ( value % 2 != 0);
            return true;
    }
 
    public static boolean isPrime(int value) {
        if (value < 2) {
            return false;
        }
 
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) {
                return false;
            }
        }
 
        return true;
    }
 
    public static boolean isEven(MyInteger value) {
        return isEven(value.getValue());
    }
 
    public static boolean isOdd(MyInteger value) {
        return isOdd(value.getValue());
    }
 
    public static boolean isPrime(MyInteger value) {
        return isPrime(value.getValue());
    }
 
    public boolean equals(int value) {
        return this.value == value;
    }
 
    public boolean equals(MyInteger value) {
        return this.value == value.getValue();
    }
 
    public static int parseInt(char[] chars) {
        int result = 0;
       
        for (int i = 0; i < chars.length; i++) {
            result = result * 10 + (chars[i] - '0');
        }
 
        return result;
    }
 
    public static int parseInt(String s) {
        return Integer.parseInt(s);
    }
 } 