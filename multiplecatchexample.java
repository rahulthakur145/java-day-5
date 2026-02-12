public class multiplecatchexample {
    public static void main(String[] args){
        try{
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("Error: Null pointer exception! object is null.");
        } catch (Exception e) {
            System.out.println("some other error occurred.");
        }
        System.out.println("Program continues after exception handling.");


    }
    
}
