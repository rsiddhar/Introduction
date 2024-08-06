import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamTest1 {
    public static void main(String[] args){
        //count the number of names starts with "A"
        ArrayList<String> names = new ArrayList<String>();
        names.add("Abhijeet");
        names.add("Don");
        names.add("Alekya");
        names.add("Adam");
        names.add("Ram");

        //Regular method
        int count = 0;
        for(int i =0 ; i< names.size(); i++){
            String actual = names.get(i);
            if(actual.startsWith("A")){
                count++;
            }
        }
        System.out.println(count);
    }
    @Test
    public void streamFilter(){
        ArrayList<String> names = new ArrayList<String>();
        names.add("Abhijeet");
        names.add("Don");
        names.add("Alekya");
        names.add("Adam");
        names.add("Ram");

        //Streams are extreme powerful that they can scan your whole collection parallelly.
        //There is no life for intermediate operation if there is no terminal operation.
        //We can create Stream
        //how to use filter in Stream API
        Long c = names.stream().filter(s->s.startsWith("A")).count();
        System.out.println(c);


        long d = Stream.of("Abhijeet", "Don", "Alekya", "Adam", "Ram").filter(s->{
            s.startsWith("A");
            return true;
        }).count();
        System.out.println(d);

        //print all the names of ArrayList
        names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
        names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
    }


    @Test
    public void StreamMap(){
        //print the names which have last letter as "a" with uppercase
        Stream.of("Abhijeet", "Don", "Alekya", "Adam", "Ram").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));

        //print names which have first letter as a with uppercase and sorted
        List<String> names1 = Arrays.asList("Azbhijeet", "Don", "Alekya", "Adam", "Ram");
        names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));

        //merging list A and list B
        List<String> names3 = Arrays.asList("man","don", "women");
        Stream<String> newStream = Stream.concat(names1.stream(), names3.stream());
        //newStream.sorted().forEach(s->System.out.println(s));


        //matching
        boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Adam"));
        System.out.println(flag);
        Assert.assertTrue(flag);

    }


    @Test
    public void streamCollect(){
        //list -> do some modification -> new list
        List<String> ls = Stream.of("Abhijeet", "Don", "Alekya", "Adam", "Ram").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).collect(Collectors.toList());
        System.out.println(ls.get(0));

        //print the unique number from this array
        //sort the array
        List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,7);
        values.stream().distinct().forEach(s->System.out.println(s));
        List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(li.get(2));
    }



}
