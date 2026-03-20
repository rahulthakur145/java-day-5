package casestudy7;
abstract class device{
    String id;
    device(String id){
        this.id=id;
    }
    abstract void operate();
}
class tv extends device{
    String name;
    tv(String id, String name){
        super(id);
        this.name=name;
    }
    @Override
    void operate(){
        System.out.println("TV [" + name + "] is booting...");
    }

    void operating(String action){
        System.out.println("TV [" + name + "] conneting 5g...");
    }
}




public class case_2 {
    public static void main(String[] args) {
        device d = new tv("D101", "Sony");
        d.operate();
        tv d2 = new tv("D102", "lg");
        d2.operating("5g");
    }
    
}
