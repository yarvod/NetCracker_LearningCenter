

public class Main{
    public static void main(String[] args) {
        ArrayVector myArray =  new ArrayVectorImpl();
        myArray.set(1, -2, 3);
        // System.out.println(myArray.getMax());
        // System.out.println(myArray.getNorm());
        // System.out.println(myArray.getSize());

        ArrayVector myArray2 =  new ArrayVectorImpl();
        myArray2.set(1, 2, 3, 7);
        myArray.set(7, 4.8);
        for (int i=0; i < myArray.getSize(); i++) {
            System.out.println(myArray.get(i));
        }
        // myArray.sum(myArray2);
        // for (int i=0; i < myArray.getSize(); i++) {
        //     System.out.println(myArray.get(i));
        // }
        //System.out.println(myArray.scalarMult(myArray2));
       // System.out.println(myArray.get(4));

    }
}