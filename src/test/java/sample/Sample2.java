package sample;

import java.util.ArrayList;
import java.util.Iterator;

public class Sample2 {
    public static void main(String[] args) {


        System.out.println("lalalla.......");

        String strName = "sreelatha";
        String dup =null;
        ArrayList<String> dummy = new ArrayList<>();
        char[] chr = strName.toCharArray();

        for(int i =0;i<=strName.length()-1;i++){
           String str = String.valueOf(chr[i]);

           if(!dummy.contains(str)){

               dummy.add(str);
           }

        }
        System.out.print(dummy);
    }

}
