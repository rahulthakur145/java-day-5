package day8_2;

// Checking Method Arguments
import java.io.*;

class EXCP {

    public static void main(String[] args) {

        String s;

        // Case 1: Empty string
        s = "";
        try {
            System.out.println(getLength(s));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Case 2: Valid string
        s = "GeeksforGeeks";
        try {
            System.out.println(getLength(s));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Case 3: Null string
        s = null;
        try {
            System.out.println(getLength(s));
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    // Function to return length of string s.
    // It throws IllegalArgumentException if s is null.
    public static int getLength(String s) {

        if (s == null)
            throw new IllegalArgumentException("The argument cannot be null");

        return s.length();
    }
}