import java.util.InputMismatchException;
import java.util.Scanner;

public class caclculator {
    public static void main(String[] args) {
        double sum, num1=0, num2=0;
        String arg;
        Scanner sc = new Scanner(System.in);
        System.out.println("Давай попробуем что-то посчитать");
        System.out.println("Введи первую цифру...");
        boolean check = true;
        while (check)
            try {
                num1 = sc.nextDouble();
                check = false;
            } catch (InputMismatchException exe) {
                System.out.println("Хм, похоже ввели некорректный формат цифр ... \nДавай попробуем ввести правильно:");
                sc.nextLine();
            }
        System.out.print(num1);
        System.out.println(" |Теперь оператор...");
        arg = sc.next();
        while (!arg.equals("+") & !arg.equals("-") & !arg.equals("*") & !arg.equals("/") & !arg.equals("%")) {
            System.out.println("С таким оператором мы еще не научились работать...  \nДавай попробуем ввести другой:");
            arg = sc.next();
        }
        System.out.print(num1 + " " + arg);
        System.out.println(" |Ну а теперь вторую цифру...");
        check = true;
        while (check)
            try {
                num2 = sc.nextDouble();
                check = false;
            } catch (InputMismatchException exe) {
                System.out.println("Хм, похоже ввели некорректный формат цифр ... \nДавай попробуем ввести правильно:");
                sc.nextLine();
            }
        if (arg.equals("+")) {
            sum = num1 + num2;
            System.out.println("Результат сложения: " + num1 + " " + arg + " " + num2 + " = " + sum);
        } else if (arg.equals("-")) {
            sum = (num1 - num2);
            System.out.println("Результат вычитания: " + num1 + " " + arg + " " + num2 + " = " + sum);
        } else if (arg.equals("*")) {
            sum = (num1 * num2);
            System.out.println("Результат умножения: " + num1 + " " + arg + " " + num2 + " = " + sum);
        } else if (arg.equals("/")) {
            sum = (num1 / num2);
            System.out.println("Результат деления: " + num1 + " " + arg + " " + num2 + " = " + sum);
        } else if (arg.equals("%")) {
            sum = (num1 % num2);
            System.out.println("Результат вычисления модуля: " + num1 + " " + arg + " " + num2 + " = " + sum);
        } else {
            System.out.println(" |Что-то пошло не так... ");
        }
    }
}
