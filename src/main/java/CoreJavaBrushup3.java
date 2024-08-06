public class CoreJavaBrushup3 {
    public static void main(String[] args){
        //String an object that represents sequence of the characters //String literal
        //No matter many times you create a new string with the same value it all points to a single location.
        //it wouldn't create new object
        //String str1 = "Hello, World!"; // Using string literal
        String s0 = "Siddhartha Rachapally Academy";
        String s1 = "Siddhartha Rachapally Academy";

        //another way of creating String
        //here we are explicitly creating. so for every creation a new location is allocated even if the value is same.
        //it will create new object.
        //String str2 = new String("Hello, World!"); // Using new keyword
        String s2 = new String("Welcome");
        String s3 = new String("Welcome");

        String s = "rahul shetty academy";
        String[] splittedString = s.split("shetty");
        System.out.println(splittedString[0]);
        System.out.println(splittedString[1]);
        System.out.println(splittedString[1].trim());

        for(int i=0; i<s.length(); i++){
            System.out.println(s.charAt(i));
        }

        for(int i=s.length()-1; i>=0; i--){
            System.out.println(s.charAt(i));
        }


    }
}
