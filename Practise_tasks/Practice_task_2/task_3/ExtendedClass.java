package task_3;

import java.util.Objects;

public class ExtendedClass {
    byte b;
    int i;
    double d;
    String s;

    @Override
    public boolean equals(Object anObject) {
        if (anObject == this) {
            return true;
        } else if (anObject == null || anObject.getClass() != this.getClass()) {
            return false;
        }

        ExtendedClass extendedClass = (ExtendedClass) anObject;
        if (this.b == extendedClass.b && this.i  == extendedClass.i && this.d == extendedClass.d && this.s == extendedClass.s) {
            return true;
        } 
        else {
            return false;
        }    
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(b);
        result = 31 * result + Objects.hashCode(i);
        result = 31 * result + Objects.hashCode(d);
        result = 31 * result + Objects.hashCode(s);
        return result;
    }

    @Override
    public String toString() {

        return "byte: "+ b + "\n" + "int: " +"i "+ "\n" + "double: " + d + "\n" + "String: " + s ;
    }
}
