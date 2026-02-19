package day8;

class ExceptionExample {

    static void checkNumber(int num) {
        try {
            if (num < 0) {
                throw new IllegalArgumentException("Negative number not allowed");
            }
        } 
        catch (IllegalArgumentException e) {
            System.out.println("Caught inside checkNumber()");
            throw e;  
        }
    }

    public static void main(String[] args) {
        try {
            checkNumber(-5);
        } 
        catch (IllegalArgumentException e) {
            System.out.println("Caught in main()");
        }
    }
}
