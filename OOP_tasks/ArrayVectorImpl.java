

public class ArrayVectorImpl implements ArrayVector {
    public double[] _array;
    
    public ArrayVectorImpl(){}
    
    @Override
    public void set(double... elements) {
        int count = 0;
        for (double el: elements) {
                count++; 
            }
            this._array = new double[count];
            for (int i=0; i< count; i++) {
                this._array[i] = elements[i];
            }
    }

    @Override
    public double[] get() {
        return this._array;
    }

    @Override
    public ArrayVector clone() {
        ArrayVectorImpl myArray = new ArrayVectorImpl();
        myArray._array = this._array.clone();
        return myArray;
    }

    @Override
    public int getSize(){
        return this._array.length;
    }
    
    @Override
    public void set(int index, double value) {
        if (index >= 0 && index <= this._array.length) {
            this._array[index] = value;
        } 
        else if (index > this._array.length) {
            double[] array2 = new double [index+1];
            for (int i=0 ; i < this._array.length; i++) {
                array2[i] = this._array[i];
            }
            array2[index] = value;
            this._array = new double[index+1];
            this._array = array2;
        }
    }

    @Override
    public double get(int index) throws ArrayIndexOutOfBoundsException {
        if (index < 0 || index > this._array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this._array[index];
        
    }

    @Override
    public double getMax() {
        double max = this._array[0];
        for (int i = 0; i < _array.length; i++) {
          max = Math.max(max, this._array[i]);
        }
        return max;
    }

    @Override
    public double getMin() {
        double min = this._array[0];
        for (int i = 0; i < _array.length; i++) {
          min = Math.min(min, this._array[i]);
        }
        return min;
    }

    @Override
    public void sortAscending() {
        for (int i = 0; i < this._array.length; i++) {
        
            double min = this._array[i];
            int min_i = i; 
            for (int j = i+1; j < this._array.length; j++) {
                if (_array[j] < min) {
                    min = this._array[j];
                    min_i = j;
                }
            }
        if (i != min_i) {
            double tmp = this._array[i];
            this._array[i] = this._array[min_i];
            this._array[min_i] = tmp;
        }
     }
    }


    @Override
    public void mult(double factor) {
        for (int i = 0; i < this._array.length; i++){
            this._array[i] = factor*this._array[i];
        }
    }

    @Override
    public ArrayVector sum(ArrayVector anotherVector) {
        double[] array_ = new double[this._array.length];
        if (this._array.length <= anotherVector.getSize()) {
            for (int i = 0; i < this._array.length; i++){
                array_[i] = this._array[i] + anotherVector.get(i);
            } 
            this._array = array_;
            return this;
        }
        else {
            for (int i = 0; i < anotherVector.getSize(); i++) {
                array_[i] = this._array[i] + anotherVector.get(i);
            }
            for (int i = anotherVector.getSize(); i< this._array.length; i++) {
                array_[i] = this._array[i];
            }
            this._array = array_;
            return this;
        }
    }

    @Override
    public double scalarMult(ArrayVector anotherVector) {
        int min = Math.min(anotherVector.getSize(), this._array.length);
        double result = 0;
        for (int i = 0; i < min; i++) {
            result = result + this._array[i]*anotherVector.get(i);
            //System.out.println("first " + this._array[i]*anotherVector.get(i) + " m1 " + this._array[i]  + " m2 " + anotherVector.get(i) );
        }
        return result;
    } 

    @Override
    public double getNorm() {
       double result =  0 ;
        for (int i = 0; i < this._array.length; i++) {
            result = result + this._array[i]*this._array[i];
        }
        return Math.sqrt(result); 
    }
}
