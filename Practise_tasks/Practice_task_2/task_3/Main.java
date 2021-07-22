package task_3;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        ExtendedClass extended1 = new ExtendedClass();
        extended1.b = 1;
        extended1.i = 1;
        extended1.d = 0.2;
        extended1.s = "extended";

        ExtendedClass extended2 = new ExtendedClass();
        extended2.b = 1;
        extended2.i = 1;
        extended2.d = 0.2;
        extended2.s = "extended";

        ExtendedClass extended3 = new ExtendedClass();
        extended3.b = 0;
        extended3.i = 1;
        extended3.d = 0.2;
        extended3.s = "extended3";

        String s = "String";

        System.out.println(extended1.equals(extended1));
        System.out.println(extended1.equals(extended2));
        System.out.println(extended1.equals(extended3));
        System.out.println(extended1.equals(s));

        System.out.println("-------------------");

        System.out.println(extended1.hashCode() == extended1.hashCode());
        System.out.println(extended1.hashCode() == extended2.hashCode());
        System.out.println(extended1.hashCode() == extended3.hashCode());
        System.out.println(extended1.hashCode() == s.hashCode());

        System.out.println("-------------------");
        System.out.println(extended3.toString());
        
    }
}