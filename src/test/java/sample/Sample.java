package sample;

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
    }
}
