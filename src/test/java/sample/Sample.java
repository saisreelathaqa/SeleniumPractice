package sample;

import java.util.ArrayList;
import java.util.Iterator;

public class Sample {

    static void mymethod1()
    {
        System.out.println("in static method.......");
    }
    public void mymethod2()
    {
        System.out.println("in public mehtod....");
    }

    public static void main(String[] args) {
        mymethod1();
        Sample s = new Sample();
        s.mymethod2();
        ArrayList<String > ar= new ArrayList<>();
        ar.add("Siva");
        ar.add("Prakash");
        ar.add("Suseela");
        Iterator<String> itr= ar.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
