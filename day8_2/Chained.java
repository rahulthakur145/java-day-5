package day8_2;
public class Chained {
    public static void main(String[] args){
        try {
            int[] n = new int[5];
            int division = 0;
            for (int i = 0; i< n.length; i++){
                int res = n[i]/division;
                System.out.println(res);
                
            }
        }
        catch (ArithmeticException e){
            throw new RuntimeException("error: Division by zero occurred", e);

        }
    }
}