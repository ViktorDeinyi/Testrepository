import java.util.Scanner;

public class Stringarrayfilter {

    public static void main(String[] args) {

        String result = "Результат вашего запроса следующий :";
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите данные в формате [name1, name2, ..., nameX]");
        String str = sc.nextLine();
        String[] words = str.split(", ");
//        for (String word : words) {
//            System.out.println(word);}
        System.out.println("Какой фильтр желаете применить для данных?");
        System.out.println("1 | Максимальная длинна");
        System.out.println("2 | Начальная буква(символ)");
        System.out.println("3 | Конечная буква(символ)");
        System.out.println("4 | Содержание");
        System.out.println("0 | Выход");
        int filter = sc.nextInt();
        boolean check = true;
        while (check) {
            switch (filter) {
                case 1:
                    System.out.print("Максимальная длинна слова = ");
                    int leng = sc.nextInt();
                    System.out.println(result);
                    for (int i = 0; i < words.length; i++) {
                        if (words[i].length() <= leng) {
                            System.out.println(words[i]);}}
                    System.out.println("Еще разок? (true/false)");
                    check = sc.nextBoolean();
                    System.out.println("Какой фильтр желаете применить для данных?");
                    System.out.println("1 | Максимальная длинна");
                    System.out.println("2 | Начальная буква(символ)");
                    System.out.println("3 | Конечная буква(символ)");
                    System.out.println("4 | Содержание");
                    System.out.println("0 | Выход");
                    filter = sc.nextInt();
                    break;
                case 2:
                    System.out.print("Начальная буква(символ) = ");
                    String first = sc.next();
                    System.out.println(result);
                    for (int i = 0; i < words.length; i++) {
                        if (words[i].startsWith(first)) {
                            System.out.println(words[i]);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Конечная буква(символ) = ");
                    String last = sc.next();
                    System.out.println(result);
                    for (int i = 0; i < words.length; i++) {
                        if (words[i].endsWith(last)) {
                            System.out.println(words[i]);
                        }
                    }
                    break;
                case 4:
                    System.out.print("Поиск буквы(символа) = ");
                    String cont = sc.next();
                    System.out.println(result);
                    for (int i = 0; i < words.length; i++) {
                        if (words[i].contains(cont)) {
                            System.out.println(words[i]);
                        }
                    }
                    break;
                case 0:
                    System.out.print("Спасибо за использование программы");
                    check = false;
                    break;

            }
        }


    }

}
