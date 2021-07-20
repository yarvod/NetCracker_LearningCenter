import java.util.Arrays;

public class Main {

    class MyArray {
        double[] array;
        int count = 0;

        void set(double... elements) {
            for (double el: elements) {
                this.count++; 
            }
            this.array = new double[this.count];
            for (int i=0; i<this.count; i++) {
                this.array[i] = elements[i];
            }

        }

        double[] get() { 
            return this.array;
        }

        MyArray clone() {
            MyArray myArray = new MyArray();
            myArray.array = this.array.clone();
            // System.arrayCopy(this.array, 0, myArray.array, 0, this.count);
            return myArray;
        }


    }

    public static void main (String[] args) {
        Main Main_class = new Main();
        MyArray vector = Main_class.new MyArray();

        vector.set(1,2,3);

        }

    
}
