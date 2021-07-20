public class test {

    class Base {
        void test() {
            System.out.println("Base.test()");
        }
    }
    public class Child extends Base {
        void test() {
            System.out.println("Child.test()");
        }
    }

    public static void main(String[] args) {
        test k = new test();
        Child anobj = k.new Child();

        Base baseobj = (Base) anobj;
        baseobj.test();        
    }


    
}
