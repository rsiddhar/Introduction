public class CoreJavaBrushup1 {
    public static void main(String[] args){

        int num = 5;
        String website = "Siddhartha Rachapally";
        char letter = 'r';
        double dec = 5.99;
        boolean myCard = true;

        System.out.println(num + " is the value stored in the num variable");
        System.out.println(website);


        //Arrays - Collection of more than one value into a variable
        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 4;
        arr[3] = 5;
        arr[4] = 6;

        int[] arr2 = {1,2,4,5,6,7,8,9,10,122};


        //for loop
        for(int i=0; i<arr2.length; i++){
            System.out.println(arr2[i]);
        }
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }

        String[] name = {"rahul", "Siddhu", "selenium"};
        for(int i=0; i<name.length; i++){
            System.out.println(name[i]);
        }

        //Enhanced for loop
        for( String s : name){
            System.out.println(s);
        }



        //if else condition
        //multiples of 2 i.e 2,4,6,8,10,122
        for(int i=0; i<arr2.length; i++){
            if(arr2[i]%2 == 0){
                System.out.println(arr2[i]);
            }
            else{
                System.out.println(arr2[i] + "is not multiple of 2");
            }
        }



    }
}
