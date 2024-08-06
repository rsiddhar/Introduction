public class MethodsDemo {
    public static void main(String[] args){
        MethodsDemo d = new MethodsDemo();
        String name = d.getUserData();
        System.out.println(name);

        MethodsDemo2 d1 = new MethodsDemo2();
        d1.getUserData();

        getData2();

    }

    public String getUserData(){
        System.out.println("hello word");
        return "rahul Shetty";
    }

    public static String getData2(){
        System.out.println("hello word");
        return "rahul Shetty";
    }
}
