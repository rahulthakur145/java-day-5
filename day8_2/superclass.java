package day8_2;

 class superclass {
    void method() {
        System.out.println("superclass method executed");
    }
    
}
class subclass extends superclass {
    void method() throws ArithmeticException {
        System.out.println("subclass method executed");
        throw new ArithmeticException("Exception in subclass");
    }

    public static void main(String[] args) {
        subclass s = new subclass();
        try {
            s.method();
        } catch (ArithmeticException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
    
}
