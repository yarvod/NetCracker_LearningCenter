import java.util.Scanner;

public class Solver {

    class Discr {

        public double discr_calc(int a, int b, int c) {
            double discr = b*b - 4*a*c;
            return discr;
        }
    }

    public static double[] answer(int a, int b, double discr) {
        double[] res = new double[2];
        for (int i=0; i<2; i++) {
            res[i] = (-b + Math.pow(-1, i) * Math.sqrt(discr)) / (2 * a);
        }
        return res;
    }

    public static void main(String[] args) {

        int[] coeffs;
        double[] answer = new double[2];

        Scanner in = new Scanner(System.in);

        coeffs = new int [3];
        for (int i=0; i<3; i++) {
            System.out.print("Enter coeff " + i + " : ");
            coeffs[i] = in.nextInt();
        }
        in.close();

        int a = coeffs[0];
        int b = coeffs[1];
        int c = coeffs[2];

        Solver solver = new Solver();
        Discr discr = solver.new Discr();

        double discriminante = discr.discr_calc(a, b, c);

        if (a == 0 && b == 0 && c == 0) {
        System.out.println("The Answer: Infinity amount of solutions!");

        } else {
            if (discriminante < 0) {
                System.out.println("The Answer: No solution in Real numbers!");
            } else {
                if (a == 0) {
                    double answer_linear = -c / b;
                    System.out.println("The Answer: " + answer_linear);
    
                } if (a == 0 && b == 0 && c != 0) {
                    System.out.println("The Answer: No solution");
    
                } if (a != 0) {
                answer = answer(a, b, discriminante);
                System.out.println("The Answer: " + answer[0] + " and " + answer[1]);
                }
            }
        } 
    }
}













