import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreJavaBrushup2 {
    public static void main(String[] args){
        String[] name = {"monish", "elvin", "sid"};

        ArrayList<String> a = new ArrayList<String>();
        //create object of the class - object.method
        a.add("siddhu");
        a.add("rachapally");
        a.add("academy");
        a.add("selenium");
        a.remove(2);
        System.out.println(a.get(2));

        for(int i=0; i<a.size(); i++){
            System.out.println(a.get(i));
        }
        //Enhanced for loop
        for(String val : a){
            System.out.println(val);
        }

        //item is present in Arraylist
        System.out.println(a.contains("selenium"));


        //Converting Array to ArrayList
        //we use Arrays.asList();
        List<String> nameArrayList = Arrays.asList(name);
        System.out.println(nameArrayList.contains("sid"));
    }
}
