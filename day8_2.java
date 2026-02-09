public class day8_2 {
    public static void main(String[] args) {
        int num1=10;
        int num2=0;
        try {
            int result = num1 / num2;  
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: cannot divide by zero.");
            System.out.println("Cannot divide by zero: " + e.getMessage());
        }
        System.out.println("Program continues after exception handling.");

    }
    
}
