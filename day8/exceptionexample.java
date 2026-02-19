package day8;

public class exceptionexample {
     static void checkNumber(int num) {
      
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
