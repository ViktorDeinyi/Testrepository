package IrregularVerbs;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Run {
    public static final String UKR = "(Ukrainian)";
    public static final String V1 = "(V1 Infinitive)";
    public static final String V2 = "(V2 Past Simple)";
    public static final String V3 = "(V3 Participle)";
    public static String answer1;
    public static String answer2;
    public static String answer3;
    public static String question;

    public static Map<Integer, String> names = Map.of(
            0, "(V1 Infinitive)",
            1, "(V2 Past Simple)",
            2, "(V3 Participle)",
            3, "(Ukrainian)");

    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_YELLOW = "\u001B[33m";


    int[] checkOriginal;

    public static void lessonRun(String[][] activeMassive) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose amount of verbs you would like to learn ");
        System.out.println("[1-10 (1)]\t\t[11-20 (2)]\t\t[21-30 (3)]\t\t[31-40 (4)]\t\t[41-50 (5)]\t\t\t\t[RETURN (0)]");
        byte amountOfVerbs = 0;
        try {
            amountOfVerbs = sc.nextByte();
            sc.nextLine();
        } catch (InputMismatchException exe) {
            System.out.println("Хм, похоже ввели некорректный формат цифр ... \nДавай попробуем ввести правильно:");
            sc.nextLine();
            lessonRun(activeMassive);
        }
        if (amountOfVerbs == 1) {
            for (int i = 1; i < 11; i++) {
                System.out.println(Arrays.toString(activeMassive[i]));
            }
        } else if (amountOfVerbs == 2) {
            for (int i = 11; i < 21; i++) {
                System.out.println(Arrays.toString(activeMassive[i]));
            }
        } else if (amountOfVerbs == 3) {
            for (int i = 21; i < 31; i++) {
                System.out.println(Arrays.toString(activeMassive[i]));
            }
        } else if (amountOfVerbs == 4) {
            for (int i = 31; i < 41; i++) {
                System.out.println(Arrays.toString(activeMassive[i]));
            }
        } else if (amountOfVerbs == 5) {
            for (int i = 41; i < 51; i++) {
                System.out.println(Arrays.toString(activeMassive[i]));
            }
        } else if (amountOfVerbs == 0) {
            Menus.learningType();
        } else {
            System.out.println("Looks like we don't have enough cases for this lesson. Please choose another.");
            lessonRun(activeMassive);
        }
        System.out.println(amountOfVerbs);
        System.out.println("\n" + "What you would like to do next :  ");
        System.out.println("\t[Learn another verbs (1)]\t\t[Take a quiz with learned words (2)]\t\t\t\t[RETURN (0)]\t[EXIT (E)]");
        String nextStep = sc.next();
        if (nextStep.equals("1")) {
            lessonRun(activeMassive);
        } else if (nextStep.equals("2")) {
            examRunL(3, 0, 1, 2, activeMassive, amountOfVerbs);
        } else if (nextStep.equals("0")) {
            Menus.learningType();
        } else if (nextStep.equals("e") || nextStep.equals("E")) {
            IrregularVerbs.Run.exit();
        } else {
            System.out.println("Looks like you entered the wrong characters. Let`s try again... ");
        }
    }

//    public static void examRun(int indexQuestion, int indexAnswer1, String[][] activeMassive) {
//        Menus.amountOfTests();
//        switch (indexQuestion) {
//            case 0:
//                question = V1;
//                break;
//            case 1:
//                question = V2;
//                break;
//            case 2:
//                question = V3;
//                break;
//            case 3:
//                question = UKR;
//                break;
//        }
//        switch (indexAnswer1) {
//            case 0:
//                answer1 = V1;
//                break;
//            case 1:
//                answer1 = V2;
//                break;
//            case 2:
//                answer1 = V3;
//                break;
//            case 3:
//                answer1 = UKR;
//                break;
//        }
//        int index = 0;
//        double error = 0;
//        int[] checkOriginal = new int[Menus.cases];
//        Scanner sc = new Scanner(System.in);
//
//        LocalTime startTime = LocalTime.now();
//        do {
//            Menus.cases--;
//            int wordNumber = randomNumber(activeMassive.length - 1);
//
//            int i = 0;
//            while (i < checkOriginal.length) {
//                if (checkOriginal[i] == wordNumber) {
////                    System.out.println(wordNumber);
//                    wordNumber = randomNumber(activeMassive.length - 1);
////                    System.out.println("замена" + wordNumber);
//                    i = -1;
//                }
//                ++i;
//            }
//            checkOriginal[index] = wordNumber;
//            ++index;
//            System.out.println(Arrays.toString(checkOriginal));
//            System.out.println("\n");
//            System.out.print(index + "/" + checkOriginal.length + "   " + question + "  " + activeMassive[wordNumber][indexQuestion]);
//            System.out.print("  =  " + answer1 + "  ");
//            String name = sc.nextLine();
//            name = name.toLowerCase();
//            if (activeMassive[wordNumber][indexAnswer1].equals(name)) {
//                System.out.println("Correct: " + TEXT_GREEN + activeMassive[wordNumber][indexAnswer1] + TEXT_RESET + "  =  " + TEXT_GREEN + name + TEXT_RESET);
//            } else if (name.equals("0")) {
//                System.out.println("\n\n\n");
//                Menus.examType();
//            } else if (name.equals("e")) {
//                Run.exit();
//            } else {
//                System.out.println(TEXT_RED + "Mistake: " + TEXT_RESET + TEXT_GREEN + activeMassive[wordNumber][indexAnswer1] + TEXT_RESET + "  " + '\u2260' + "  " + TEXT_RED + name + TEXT_RESET);
//                ++error;
//            }
//        }
//        while (Menus.cases > 0);
//        LocalTime finishTime = LocalTime.now();
////        System.out.println("\n" + "Время старта теста = " + startTime);
////        System.out.println("Время окончания теста = " + finishTime + "\n");
////
////        System.out.println("Массив индексов с правильными ответами:");
////        System.out.println(Arrays.toString(checkOriginal));
////        System.out.println("\n");
//
//        int fh = finishTime.getHour();
//        int sh = startTime.getHour();
//        int fm = finishTime.getMinute();
//        int sm = startTime.getMinute();
//        int fs = finishTime.getSecond();
//        int ss = startTime.getSecond();
//        TimeCounter.timeChange(fh, fm, fs, sh, sm, ss);
//        double result = ((double) checkOriginal.length - error) / (double) (checkOriginal.length) * 100;
//        result = Math.rint(result);
//        System.out.println("Количество ошибок: " + (int) error);
//        if (result >= 80) {
//            System.out.println("Процент правильных ответов: " + TEXT_GREEN + result + " %" + TEXT_RESET);
//        } else if (result >= 40) {
//            System.out.println("Процент правильных ответов: " + TEXT_YELLOW + result + " %" + TEXT_RESET);
//        } else if (result >= 0) {
//            System.out.println("Процент правильных ответов: " + TEXT_RED + result + " %" + TEXT_RESET + "\n\n");
//        }
//        System.out.println("\t[TRY AGAIN (1)]\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t[RETURN (0)]\t[EXIT (E)]");
//        byte more = sc.nextByte();
//        if (more == 1) {
//            Run.examRun(indexQuestion, indexAnswer1, Menus.active);
//        } else if (more == 2) {
//            Menus.examType();
//        } else if (more == 0) {
//            Menus.learningType();
//        }
//    }
//
//    public static void examRun(int indexQuestion, int indexAnswer1, int indexAnswer2) {
//        Menus.amountOfTests();
//        switch (indexQuestion) {
//            case 0:
//                question = V1;
//                break;
//            case 1:
//                question = V2;
//                break;
//            case 2:
//                question = V3;
//                break;
//            case 3:
//                question = UKR;
//                break;
//        }
//        switch (indexAnswer1) {
//            case 0:
//                answer1 = V1;
//                break;
//            case 1:
//                answer1 = V2;
//                break;
//            case 2:
//                answer1 = V3;
//                break;
//            case 3:
//                answer1 = UKR;
//                break;
//        }
//        switch (indexAnswer2) {
//            case 0:
//                answer2 = V1;
//                break;
//            case 1:
//                answer2 = V2;
//                break;
//            case 2:
//                answer2 = V3;
//                break;
//            case 3:
//                answer2 = UKR;
//                break;
//        }
//        int index = 0;
//        double error = 0;
//        int[] checkOriginal = new int[Menus.cases];
//        Scanner sc = new Scanner(System.in);
//
//        LocalTime startTime = LocalTime.now();
//        do {
//            Menus.cases--;
//            int wordNumber = randomNumber(Data.getWords1().length - 1);
//
//            int i = 0;
//            while (i < checkOriginal.length) {
//                if (checkOriginal[i] == wordNumber) {
//                    wordNumber = randomNumber(Data.getWords1().length - 1);
////                    System.out.println("замена" + wordNumber);
//                    i = -1;
//                }
//                ++i;
//            }
//            checkOriginal[index] = wordNumber;
//            ++index;
////            System.out.println(Arrays.toString(checkOriginal));
//            System.out.println("\n");
//            System.out.print(index + "/" + checkOriginal.length + "   " + question + "  " + Data.getWords1()[wordNumber][indexQuestion]);
//            System.out.print("  =  " + answer1 + "  ");
//            String name = sc.nextLine();
//            name = name.toLowerCase();
//            if (Data.getWords1()[wordNumber][indexAnswer1].equals(name)) {
//                System.out.println("Correct: " + TEXT_GREEN + Data.getWords1()[wordNumber][indexAnswer1] + TEXT_RESET + "  =  " + TEXT_GREEN + name + TEXT_RESET);
//            } else if (name.equals("0")) {
//                System.out.println("\n\n\n");
//                Menus.examType();
//            } else if (name.equals("e")) {
//                Run.exit();
//            } else {
//                System.out.println(TEXT_RED + "Mistake: " + TEXT_RESET + TEXT_GREEN + Data.getWords1()[wordNumber][indexAnswer1] + TEXT_RESET + "  " + '\u2260' + "  " + TEXT_RED + name + TEXT_RESET);
//                ++error;
//            }
//
//            System.out.print("      " + question + "  " + Data.getWords1()[wordNumber][indexQuestion]);
//            System.out.print("  =  " + answer2 + "  ");
//            String name1 = sc.nextLine();
//            name1 = name1.toLowerCase();
//            if (Data.getWords1()[wordNumber][indexAnswer2].equals(name1)) {
//                System.out.println("Correct: " + TEXT_GREEN + Data.getWords1()[wordNumber][indexAnswer2] + TEXT_RESET + "  =  " + TEXT_GREEN + name1 + TEXT_RESET);
//            } else if (name1.equals("0")) {
//                System.out.println("\n\n\n");
//                Menus.examType();
//            } else if (name1.equals("e")) {
//                Run.exit();
//            } else {
//                System.out.println(TEXT_RED + "Mistake: " + TEXT_RESET + TEXT_GREEN + Data.getWords1()[wordNumber][indexAnswer2] + TEXT_RESET + "  " + '\u2260' + "  " + TEXT_RED + name1 + TEXT_RESET);
//                ++error;
//            }
//        }
//        while (Menus.cases > 0);
//        LocalTime finishTime = LocalTime.now();
//        System.out.println("\n" + "Время старта теста = " + startTime);
//        System.out.println("Время окончания теста = " + finishTime + "\n");
//
//        System.out.println("Массив индексов с правильными ответами:");
//        System.out.println(Arrays.toString(checkOriginal));
//        System.out.println("\n");
//
//        int fh = finishTime.getHour();
//        int sh = startTime.getHour();
//        int fm = finishTime.getMinute();
//        int sm = startTime.getMinute();
//        int fs = finishTime.getSecond();
//        int ss = startTime.getSecond();
//        TimeCounter.timeChange(fh, fm, fs, sh, sm, ss);
//        double result = ((((double) checkOriginal.length) * 2) - error) / ((double) checkOriginal.length * 2) * 100;
//        result = Math.rint(result);
//        System.out.println("Количество ошибок: " + (int) error);
//        if (result >= 80) {
//            System.out.println("Процент правильных ответов: " + TEXT_GREEN + result + " %" + TEXT_RESET);
//        } else if (result >= 40) {
//            System.out.println("Процент правильных ответов: " + TEXT_YELLOW + result + " %" + TEXT_RESET);
//        } else if (result >= 0) {
//            System.out.println("Процент правильных ответов: " + TEXT_RED + result + " %" + TEXT_RESET + "\n\n");
//        }
//        System.out.println("\t[TRY AGAIN (1)]\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t[RETURN (0)]\t[EXIT (E)]");
//        byte more = sc.nextByte();
//        if (more == 1) {
//            Run.examRun(indexQuestion, indexAnswer1, indexAnswer2);
//        } else if (more == 2) {
//            Menus.examType();
//        } else if (more == 0) {
//            Menus.learningType();
//        }
//    }
public static void examRunL(int indexQuestion, int indexAnswer1, int indexAnswer2, int indexAnswer3, String[][] activeMassive, int amountOfWerbs) {
    int[] indexAnswers = new int[]{indexQuestion, indexAnswer1, indexAnswer2, indexAnswer3};
    int index = 0;
    int cases = 10;
    double error = 0;
    int[] checkOriginal = new int[cases];
    Scanner sc = new Scanner(System.in);
    System.out.println(amountOfWerbs);
    do {
        cases--;
        int wordNumber = randomNumber(checkOriginal.length)+((amountOfWerbs*10)-10);

        int i = 0;
        while (i < checkOriginal.length) {
            if (checkOriginal[i] == wordNumber) {
                wordNumber = randomNumber(checkOriginal.length)+((amountOfWerbs*10)-10);
//                    System.out.println("замена" + wordNumber);
                i = -1;
            }
            ++i;
        }
        checkOriginal[index] = wordNumber;

        ++index;
        System.out.println(Arrays.toString(checkOriginal));
        System.out.print("\n" + index + "/" + checkOriginal.length + "\t");
        for (int x = 1; x <= 3; ++x) {
            System.out.print(names.get(indexAnswers[0]) + "\t" + activeMassive[wordNumber][indexAnswers[0]]);
            System.out.print("  =  " + names.get(indexAnswers[x]) + "  ");
            String name = sc.nextLine();
            name = name.toLowerCase();
            if (activeMassive[wordNumber][indexAnswers[x]].equals(name)) {
                System.out.println("Correct: " + TEXT_GREEN + activeMassive[wordNumber][indexAnswers[x]] + TEXT_RESET + "  =  " + TEXT_GREEN + name + TEXT_RESET);
            } else if (name.equals("0")) {
                System.out.println("\n\n\n");
                Menus.learningType();
            } else if (name.equals("e")) {
                IrregularVerbs.Run.exit();
            } else {
                System.out.println(TEXT_RED + "Mistake: " + TEXT_RESET + TEXT_GREEN + activeMassive[wordNumber][indexAnswers[x]] + TEXT_RESET + "  " + '\u2260' + "  " + TEXT_RED + name + TEXT_RESET);
                ++error;
            }
        }
    }
    while (cases > 0);

    System.out.println("Массив индексов с правильными ответами:");
    System.out.println(Arrays.toString(checkOriginal));
    System.out.println("\n");


    System.out.println("\t[TRY AGAIN (1)]\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t[RETURN (0)]\t[EXIT (E)]");
    String nextStep = sc.next();
    if (nextStep.equals("1")) {
        IrregularVerbs.Run.examRunL(indexQuestion, indexAnswer1, indexAnswer2, indexAnswer3, activeMassive, amountOfWerbs);
    } else if (nextStep.equals("2")) {
//        lessonRun(activeMassive);
    } else if (nextStep.equals("0")) {
        Menus.learningType();
    } else if (nextStep.equals("e") || nextStep.equals("E")) {
        IrregularVerbs.Run.exit();
    } else {
        System.out.println("Looks like you entered the wrong characters. Let`s try again... ");
    }
}
    public static void examRun(int indexQuestion, int indexAnswer1, int indexAnswer2, int indexAnswer3, String[][] activeMassive) {
        Menus.amountOfTests();
        byte amountOfAnswers = 3;
        int[] indexAnswers = new int[]{indexQuestion, indexAnswer1, indexAnswer2, indexAnswer3};
        for (int w = 0; indexAnswers.length > w; w++) {
            if (indexAnswers[w] < 0) amountOfAnswers--;
        }
        int index = 0;
        double error = 0;
        int[] checkOriginal = new int[Menus.cases];
        Scanner sc = new Scanner(System.in);

        LocalTime startTime = LocalTime.now();
        do {
            Menus.cases--;
            int wordNumber = randomNumber(activeMassive.length - 1);

            int i = 0;
            while (i < checkOriginal.length) {
                if (checkOriginal[i] == wordNumber) {
                    wordNumber = randomNumber(activeMassive.length - 1);
//                    System.out.println("замена" + wordNumber);
                    i = -1;
                }
                ++i;
            }
            checkOriginal[index] = wordNumber;

            ++index;
//            System.out.println(Arrays.toString(checkOriginal));
            System.out.print("\n" + index + "/" + checkOriginal.length + "\t");
            for (int x = 1; x <= amountOfAnswers; ++x) {
                System.out.print(names.get(indexAnswers[0]) + "\t" + activeMassive[wordNumber][indexAnswers[0]]);
                System.out.print("  =  " + names.get(indexAnswers[x]) + "  ");
                String name = sc.nextLine();
                name = name.toLowerCase();
                if (activeMassive[wordNumber][indexAnswers[x]].equals(name)) {
                    System.out.println("Correct: " + TEXT_GREEN + activeMassive[wordNumber][indexAnswers[x]] + TEXT_RESET + "  =  " + TEXT_GREEN + name + TEXT_RESET);
                } else if (name.equals("0")) {
                    System.out.println("\n\n\n");
                    Menus.examType();
                } else if (name.equals("e")) {
                    IrregularVerbs.Run.exit();
                } else {
                    System.out.println(TEXT_RED + "Mistake: " + TEXT_RESET + TEXT_GREEN + activeMassive[wordNumber][indexAnswers[x]] + TEXT_RESET + "  " + '\u2260' + "  " + TEXT_RED + name + TEXT_RESET);
                    ++error;
                }
            }
        }
        while (Menus.cases > 0);
        LocalTime finishTime = LocalTime.now();
        System.out.println("\nYour test results: ");
        System.out.println("Test start time = " + startTime);
        System.out.println("Test end time = " + finishTime + "\n");

//        System.out.println("Массив индексов с правильными ответами:");
//        System.out.println(Arrays.toString(checkOriginal));
//        System.out.println("\n");

        int fh = finishTime.getHour();
        int sh = startTime.getHour();
        int fm = finishTime.getMinute();
        int sm = startTime.getMinute();
        int fs = finishTime.getSecond();
        int ss = startTime.getSecond();
        TimeCounter.timeChange(fh, fm, fs, sh, sm, ss);

        double result = ((((double) checkOriginal.length) * amountOfAnswers) - error) / ((double) checkOriginal.length * amountOfAnswers) * 100;
        result = Math.rint(result);
        System.out.println("Number of incorrect answers: " + (int) error);
        if (result >= 80) {
            System.out.println("Percentage of correct answer " + TEXT_GREEN + result + " %" + TEXT_RESET);
        } else if (result >= 40) {
            System.out.println("Percentage of correct answer: " + TEXT_YELLOW + result + " %" + TEXT_RESET);
        } else if (result >= 0) {
            System.out.println("Percentage of correct answer: " + TEXT_RED + result + " %" + TEXT_RESET + "\n\n");
        }
        System.out.println("\t[TRY AGAIN (1)]\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t[RETURN (0)]\t[EXIT (E)]");
        String nextStep = sc.next();
        if (nextStep.equals("1")) {
            IrregularVerbs.Run.examRun(indexQuestion, indexAnswer1, indexAnswer2, indexAnswer3, activeMassive);
        } else if (nextStep.equals("2")) {
            Menus.examType();
        } else if (nextStep.equals("3")) {
//            Run.examRun(indexQuestion, indexAnswer1, indexAnswer2, indexAnswer3,checkMistakes );
        } else if (nextStep.equals("0")) {
            Menus.learningType();
        }else if (nextStep.equals("e") || nextStep.equals("E")) {
        IrregularVerbs.Run.exit();
    } else {
        System.out.println("Looks like you entered the wrong characters. Let`s try again... ");
    }
    }

    public static void superQuizRun(String[][] activeMassive) {
        Scanner sc = new Scanner(System.in);
        question = UKR;
        LocalTime startTime = LocalTime.now();
        boolean check = true;
        int index = 0;

        do {
//            System.out.println("Кол-во примеров -1: " + (Data.getWords1().length - 1));
            int wordNumber = randomNumber(activeMassive.length - 1);
            int indexAnswer1 = randomNumber(3) - 1;
//            System.out.println(indexAnswer1);
            switch (indexAnswer1) {
                case 0:
                    answer1 = V1;
                    break;
                case 1:
                    answer1 = V2;
                    break;
                case 2:
                    answer1 = V3;
                    break;
            }

            System.out.println("\n");
            System.out.print(++index + ".   " + question + "  " + activeMassive[wordNumber][3]);
            System.out.print("  =  " + answer1 + "  ");
            String name = sc.nextLine();
            name = name.toLowerCase();
            if (activeMassive[wordNumber][indexAnswer1].equals(name)) {
                System.out.println("Correct: " + TEXT_GREEN + activeMassive[wordNumber][indexAnswer1] + TEXT_RESET + "  =  " + TEXT_GREEN + name + TEXT_RESET);
            } else {
                System.out.println(TEXT_RED + "Mistake: " + TEXT_RESET + TEXT_GREEN + activeMassive[wordNumber][indexAnswer1] + TEXT_RESET + "  " + '\u2260' + "  " + TEXT_RED + name + TEXT_RESET);
                check = false;
            }
        }
        while (check);
        index--;
        LocalTime finishTime = LocalTime.now();
        System.out.println("\nYour test results: ");
        System.out.println("Test start time = " + startTime);
        System.out.println("Test end time = " + finishTime + "\n");


        int fh = finishTime.getHour();
        int sh = startTime.getHour();
        int fm = finishTime.getMinute();
        int sm = startTime.getMinute();
        int fs = finishTime.getSecond();
        int ss = startTime.getSecond();
        TimeCounter.timeChange(fh, fm, fs, sh, sm, ss);

        System.out.println(index);

        if (index >= 100) {
            System.out.println("Correct answers: " + TEXT_GREEN + index + TEXT_RESET);
        } else if (index >= 50) {
            System.out.println("Correct answers: " + TEXT_YELLOW + index + TEXT_RESET);
        } else if (index >= 0) {
            System.out.println("Correct answers: " + TEXT_RED + index + TEXT_RESET + "\n\n");
        }
        System.out.println("\t[TRY AGAIN (1)]\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t[RETURN (0)]\t[EXIT (E)]");
        String nextStep = sc.next();
        if (nextStep.equals("1")) {
            superQuizRun(activeMassive);
        } else if (nextStep.equals("0")) {
            Menus.learningType();
        }else if (nextStep.equals("e") || nextStep.equals("E")) {
            IrregularVerbs.Run.exit();
        } else {
            System.out.println("Looks like you entered the wrong characters. Let`s try again... ");
        }

    }

    public static int randomNumber(int Number) {
        boolean check = true;
        int resultRandom = 0;
        while (check) {
//            System.out.println("кол-во примеров: " + Number);
            double x = Math.random();
            resultRandom = (int) Math.round(x * Number);
//            System.out.println("Рандомное число: " + x);
//            System.out.println("Округленное рандомное число: " + Math.round(x));
//            System.out.println("Инт результата" + resultRandom);
//            System.out.println((int)resultRandom);
            if (resultRandom > 0) {
                check = false;
            }
        }
        return resultRandom;
    }

    public static void exit() {
        System.out.println("Thank you for using our application.");
        System.exit(0);
    }
}
