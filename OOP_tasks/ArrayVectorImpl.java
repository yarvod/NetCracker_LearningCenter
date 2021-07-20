import Arrays;

public class ArrayVectorImpl implements ArrayVector {
    ArrayVectorImpl[] vector;
    
    @Override
    void set(double... elements) {
        this.vector = Arrays.asList(elements);
    }

    @Override
    double[] get() {
    }

    // @Override
    // ArrayVector clone() {

    // }

    // int getSize(){

    // }

    // void set(int index, double value) {

    // }

    // double get(int index) throws ArrayIndexOutOfBoundsException {

    // }

    // double getMax() {

    // }

    // double getMin() {

    // }

    // void sortAscending() {

    // }


    // void mult(double factor) {

    // }

    // ArrayVector sum(ArrayVector anotherVector) {

    // }
 
    // double scalarMult(ArrayVector anotherVector) {
    //     return 2;
    // } 

    // double getNorm() {
    //     return 2;
    // }
}
