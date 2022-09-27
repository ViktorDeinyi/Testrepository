import java.util.Scanner;

public class cycles {
    public static void main (String[] args ) {

        for ( int num = 0; num < 5; num++ ) {
            System.out.println("Пока что: " + num);
        }

        Scanner scs = new Scanner(System.in);
        System.out.println("Какое любимое времяприпровождение твоего парня:");
        String arg = scs.nextLine();
        while (!arg.equals("Жрать")&!arg.equals("Спать")) {
            System.out.println("Ну нет\nДавай еще попытку");
            arg = scs.nextLine();
        }
        System.out.print("Знания достойные королевы");




    }
}
