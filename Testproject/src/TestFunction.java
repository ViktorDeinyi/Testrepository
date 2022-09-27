import java.util.Arrays;
import java.util.Scanner;

public class TestFunction {
    int num1 = 10;


    public static void main(String[] args) {
//        func(2,4);
//        entercars();
        TestFunction mynum = new TestFunction();
        mynum.num1 = mynum.num1 + 10;
        System.out.println(mynum.num1);
    }

    public static void second(String[] args) {
        TestFunction mynum2 = new TestFunction();
        System.out.println(mynum2.num1);
    }


    public static int func(int a, int w) {
        int sum = 1;
        for (int i = 0; i < w; i++) {
            sum = sum * a;
            System.out.println(sum);
        }
        return sum;
    }
    public static String [] entercars () {
        String [] cars;
        int n;
        Scanner in = new Scanner(System.in);
        Scanner ins = new Scanner(System.in);
        System.out.println("Enter size of our massive :");
        n = in.nextInt();
        cars = new String [n];
        for (int i=0; i< n; i++ ) {
            System.out.println("Enter " + (i+1) + "[" + i + "]" + " element of our massive :");
            cars[i] = ins.nextLine();
        }
        System.out.println(cars);
        System.out.println(Arrays.toString(cars));
        return cars;

    }
}
