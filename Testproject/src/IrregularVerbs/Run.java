package IrregularVerbs;

import java.time.LocalTime;
import java.util.*;

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
    public static boolean checkNewTest = true;

    public static void lessonRun(String[][] activeMassive) {
        //запуск обучения lesson (выбор слов)
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
//запуск обучения lesson (вывод слов)
        System.out.printf("Nfyz , %10d", "N1111 , %10d" );
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

        //запуск обучения lesson (варианты перехода при окончании lesson)
        System.out.println("\n" + "What you would like to do next :  ");
        System.out.println("\t[Learn another verbs (1)]\t\t[Take a quiz with learned words (2)]\t\t\t\t[RETURN (0)]\t[EXIT (E)]");
        String nextStep = sc.next();
        if (nextStep.equals("1")) {
            lessonRun(activeMassive);
        } else if (nextStep.equals("2")) {
            //переход на exam по выученным словам
            examRunL(3, 0, 1, 2, activeMassive, amountOfVerbs);
        } else if (nextStep.equals("0")) {
            Menus.learningType();
        } else if (nextStep.equals("e") || nextStep.equals("E")) {
            IrregularVerbs.Run.exit();
        } else {
            System.out.println("Looks like you entered the wrong characters. Let`s try again... ");
        }
    }

    public static void examRunL(int indexQuestion, int indexAnswer1, int indexAnswer2, int indexAnswer3, String[][] activeMassive, int amountOfWerbs) {
        //exam после для lesson (статистики тут нет)
        int[] indexAnswers = new int[]{indexQuestion, indexAnswer1, indexAnswer2, indexAnswer3};
        int index = 0;
        int cases = 10;
        double error = 0;
        int[] checkOriginal = new int[cases];
        Scanner sc = new Scanner(System.in);
        System.out.println(amountOfWerbs);
        do {
            cases--;
            int wordNumber = randomNumber(checkOriginal.length) + ((amountOfWerbs * 10) - 10);

            int i = 0;
            while (i < checkOriginal.length) {
                if (checkOriginal[i] == wordNumber) {
                    wordNumber = randomNumber(checkOriginal.length) + ((amountOfWerbs * 10) - 10);
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

        //конец exam по lesson варианты перехода дальше
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
        //Exam (статистика тут есть)
        if (checkNewTest) {
            Menus.amountOfTests();
        }
        byte amountOfAnswers = 3;
        int[] indexAnswers = new int[]{indexQuestion, indexAnswer1, indexAnswer2, indexAnswer3};
        for (int w = 0; indexAnswers.length > w; w++) {
            if (indexAnswers[w] < 0) amountOfAnswers--;
        }
        System.out.println(Menus.cases);
        int index = 0;
        double error = 0;
        int[] checkOriginal = new int[Menus.cases];
        ArrayList<Integer> checkMistakes = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
// время старта exam
        LocalTime startTime = LocalTime.now();
        //рандомный выбор слов для exam (без повторений)
        do {
            Menus.cases--;
            int wordNumber = randomNumber(activeMassive.length - 1);

            int i = 0;
            while (i < checkOriginal.length) {
                if (checkOriginal[i] == wordNumber) {
                    wordNumber = randomNumber(activeMassive.length - 1);
                    System.out.println("замена" + wordNumber);
                    i = -1;
                }
                ++i;
            }
            checkOriginal[index] = wordNumber;

            ++index;
//            System.out.println(Arrays.toString(checkOriginal));
            //вывод вопрос-ответ
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
                    Run.exit();
                } else {
                    System.out.println(TEXT_RED + "Mistake: " + TEXT_RESET + TEXT_GREEN + activeMassive[wordNumber][indexAnswers[x]] + TEXT_RESET + "  " + '\u2260' + "  " + TEXT_RED + name + TEXT_RESET);

                    if (!(checkMistakes.contains(wordNumber))) {
                        checkMistakes.add(wordNumber);
                    }
                    ++error;
                }
            }
        }
        while (Menus.cases > 0);
        //время окончания exam
        LocalTime finishTime = LocalTime.now();

        //создание массива слов пройденных тестов
        String correct[][] = new String[checkOriginal.length + 1][4];
        correct[0][0] = activeMassive[0][0];
        correct[0][1] = activeMassive[0][1];
        correct[0][2] = activeMassive[0][2];
        correct[0][3] = activeMassive[0][3];
        for (int i = 0; i < checkOriginal.length; i++) {
            int x = checkOriginal[i];
            for (int j = 0; j < 4; j++) {
                correct[i + 1][j] = activeMassive[x][j];
            }
        }
//        System.out.println(correct.length);
//        System.out.println(correct[1].length);
//        System.out.println(checkMistakes);
//        System.out.println(checkMistakes.get(0));
//        System.out.println(checkMistakes.size());
//        System.out.println(checkMistakes.get(1));

        //создание массива слов тестов с ошибками
        String mistakes[][] = new String[checkMistakes.size() + 1][4];
        mistakes[0][0] = activeMassive[0][0];
        mistakes[0][1] = activeMassive[0][1];
        mistakes[0][2] = activeMassive[0][2];
        mistakes[0][3] = activeMassive[0][3];
        for (int i = 0; i < checkMistakes.size(); i++) {
            int x = checkMistakes.get(i);
            for (int j = 0; j < 4; j++) {
                mistakes[i + 1][j] = activeMassive[x][j];
            }
        }

        System.out.println("\nYour test results: ");
        System.out.println("Test start time = " + startTime);
        System.out.println("Test end time = " + finishTime + "\n");

//        System.out.println("Массив индексов с правильными ответами:");
//        System.out.println(Arrays.toString(checkOriginal));
//        System.out.println("\n");

        //обработка времени начала и конца
        int fh = finishTime.getHour();
        int sh = startTime.getHour();
        int fm = finishTime.getMinute();
        int sm = startTime.getMinute();
        int fs = finishTime.getSecond();
        int ss = startTime.getSecond();
        TimeCounter.timeChange(fh, fm, fs, sh, sm, ss);

        //обработка результата
        double result = (((checkOriginal.length) * amountOfAnswers) - error) / (checkOriginal.length * amountOfAnswers) * 100;
//        double result = ((((double) checkOriginal.length) * amountOfAnswers) - error) / ((double) checkOriginal.length * amountOfAnswers) * 100;
        result = Math.rint(result);

        System.out.println("Number of incorrect answers: " + (int) error);
        if (result >= 80) {
            System.out.println("Percentage of correct answer " + TEXT_GREEN + result + " %" + TEXT_RESET);
        } else if (result >= 40) {
            System.out.println("Percentage of correct answer: " + TEXT_YELLOW + result + " %" + TEXT_RESET);
        } else if (result >= 0) {
            System.out.println("Percentage of correct answer: " + TEXT_RED + result + " %" + TEXT_RESET + "\n\n");
        }

        //запись выбранной статистики в файл
        NewFile.writeToFile(NewFile.userName, Menus.choosenExamType + TimeCounter.timeChange + ".  Errors = " + error + ". Persent of wright answers = " + result + " %.\n");

        //конец exam варианты перехода дальше
        if (error == 0)
            System.out.println("\n\t[TRY AGAIN (1)]\t\t[TRY SAME (2)]\t\t\t\t\t\t\t\t\t\t\t\t\t[RETURN (0)]\t[EXIT (E)]");
        else
            System.out.println("\t[TRY AGAIN (1)]\t\t[TRY SAME (2)]\t\t[WORK ON ERROR (3)]\t\t\t\t\t\t\t[RETURN (0)]\t[EXIT (E)]");
        String nextStep = sc.next();
        if (nextStep.equals("1")) {
            checkNewTest = true;
            Run.examRun(indexQuestion, indexAnswer1, indexAnswer2, indexAnswer3, Menus.active);
        } else if (nextStep.equals("2")) {
            checkNewTest = false;
            Menus.cases = correct.length - 1;
            System.out.println(Menus.cases);
            Run.examRun(indexQuestion, indexAnswer1, indexAnswer2, indexAnswer3, correct);
        } else if (nextStep.equals("3")) {
            System.out.println(TEXT_GREEN + "Let's go working with your mistakes: " + TEXT_RESET + "\n");
            checkNewTest = false;
            Menus.cases = mistakes.length - 1;
            System.out.println(Menus.cases);
            Run.examRun(indexQuestion, indexAnswer1, indexAnswer2, indexAnswer3, mistakes);
        } else if (nextStep.equals("0")) {
            Menus.examType();
        } else if (nextStep.equals("e") || nextStep.equals("E")) {
            IrregularVerbs.Run.exit();
        } else {
            System.out.println("Looks like you entered the wrong characters. Let`s try again... ");
        }
    }

    public static void superQuizRun(String[][] activeMassive) {
        Scanner sc = new Scanner(System.in);
        question = UKR;
        LocalTime startTime = LocalTime.now();
        byte error = 3;
        boolean check = true;
        int index = 0;
        String life1 = Graphics.redHeart;
        String life2 = Graphics.redHeart;



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
            System.out.print(++index + ". " + life1 + " " + life2 + " " + Graphics.redHeart + " " + question + "  " + activeMassive[wordNumber][3]);
            System.out.print("  =  " + answer1 + "  ");
            String name = sc.nextLine();
            name = name.toLowerCase();
            if (activeMassive[wordNumber][indexAnswer1].equals(name)) {
                System.out.println("Correct: " + TEXT_GREEN + activeMassive[wordNumber][indexAnswer1] + TEXT_RESET + "  =  " + TEXT_GREEN + name + TEXT_RESET);
            } else {
                System.out.println(TEXT_RED + "Mistake: " + TEXT_RESET + TEXT_GREEN + activeMassive[wordNumber][indexAnswer1] + TEXT_RESET + "  " + '\u2260' + "  " + TEXT_RED + name + TEXT_RESET);
                if (error == 3) {
                    life1 = Graphics.blackHeart;
                System.out.println("Oups you just answer wrong ");}
                else if (error == 2) {
                    life2 = Graphics.blackHeart;
                    System.out.println("Be careful, you have only one mistake left ");}
                error--;
            }
        }
        while (error>0);
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
        } else if (nextStep.equals("e") || nextStep.equals("E")) {
            IrregularVerbs.Run.exit();
        } else {
            System.out.println("Looks like you entered the wrong characters. Let`s try again... ");
        }

    }

    public static int randomNumber(int Number) {
        boolean check = true;
        int resultRandom = 0;
//        int resultRandom1 = 0;
        while (check) {
//            System.out.println("кол-во примеров: " + Number);
            double x = Math.random();
//            resultRandom1 = randomNumber(Number);
            resultRandom = (int) Math.round(x * Number);
//            System.out.println("Рандомное число: " + x);
//            System.out.println("Округленное рандомное число: " + Math.round(x));
//            System.out.println("Инт результата" + resultRandom);
//            System.out.println((int)resultRandom);
//            if (resultRandom1 > 0) {
//                check = false;
//            }

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
