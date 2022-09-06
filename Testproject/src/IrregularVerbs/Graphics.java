package IrregularVerbs;

public class Graphics {
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_PURPLE = "\u001B[35m";

    public static void title() {

        String l = String.valueOf('\u066D');
        String l15 = l + l + l + l + l + l + l + l + l + l + l + l + l + l + l;
        System.out.println(TEXT_PURPLE + l15 + l15 + l15 + l15);
        System.out.print(l15);
        System.out.print("  STUDY SOME IRREGULAR VERBS  ");
        System.out.println(l15);
        System.out.println(l15 + l15 + l15 + l15 + TEXT_RESET + "\n\n");
    }

    public static void frameW6(String x) {
        String luc = String.valueOf('\u250C');
        String ruc = String.valueOf('\u2510');
        String ldc = String.valueOf('\u2514');
        String rdc = String.valueOf('\u2518');
        String vs = String.valueOf('\u2502');
        String hs = String.valueOf('\u2500');
        System.out.println(luc + hs + hs + hs + hs + hs + hs + hs + hs + ruc);
        System.out.println(vs + " " + x + " " + vs);
        System.out.println(ldc + hs + hs + hs + hs + hs + hs + hs + hs + rdc);
    }

    public static void frameW7(String x) {
        String luc = String.valueOf('\u250C');
        String ruc = String.valueOf('\u2510');
        String ldc = String.valueOf('\u2514');
        String rdc = String.valueOf('\u2518');
        String vs = String.valueOf('\u2502');
        String hs = String.valueOf('\u2500');
        System.out.println(luc + hs + hs + hs + hs + hs + hs + hs + hs + hs + ruc);
        System.out.println(vs + " " + x + " " + vs);
        System.out.println(ldc + hs + hs + hs + hs + hs + hs + hs + hs + hs + rdc);
    }

    public static void frameW8(String x) {
        String luc = String.valueOf('\u250C');
        String ruc = String.valueOf('\u2510');
        String ldc = String.valueOf('\u2514');
        String rdc = String.valueOf('\u2518');
        String vs = String.valueOf('\u2502');
        String hs = String.valueOf('\u2500');
        System.out.println(luc + hs + hs + hs + hs + hs + hs + hs + hs + hs + hs + ruc);
        System.out.println(vs + " " + x + " " + vs);
        System.out.println(ldc + hs + hs + hs + hs + hs + hs + hs + hs + hs + hs + rdc);
    }

    public static void frameLearningType(String x, String y, String z) {
        String luc = String.valueOf('\u250C');
        String ruc = String.valueOf('\u2510');
        String ldc = String.valueOf('\u2514');
        String rdc = String.valueOf('\u2518');
        String vs = String.valueOf('\u2502');
        String hs = String.valueOf('\u2500');
        String hs14 = hs + hs + hs + hs + hs + hs + hs + hs + hs + hs + hs + hs + hs + hs;
        System.out.println(luc + hs14 + ruc + "\t" + luc + hs14 + ruc + "\t" + luc + hs14 + ruc);
        System.out.println(vs + " " + x + " " + vs + "\t" + vs + " " + y + " " + vs + "\t" + vs + " " + z + " " + vs + "\t\t\t\t\t\t\t\t" + "[RETURN (0)]" + "\t" + "[EXIT (E)]");
        System.out.println(ldc + hs14 + rdc + "\t" + ldc + hs14 + rdc + "\t" + ldc + hs14 + rdc);
    }

    public static void frameExamType(String x, String y, String z, String q) {
        String luc = String.valueOf('\u250C');
        String ruc = String.valueOf('\u2510');
        String ldc = String.valueOf('\u2514');
        String rdc = String.valueOf('\u2518');
        String vs = String.valueOf('\u2502');
        String hs = String.valueOf('\u2500');
        String hs14 = hs + hs + hs + hs + hs + hs + hs + hs + hs + hs + hs + hs + hs + hs;
        System.out.println(luc + hs14 + ruc + "\t" + luc + hs14 + ruc + "\t" + luc + hs14 + ruc + "\t" + luc + hs14 + ruc);
        System.out.println(vs + " " + x + " " + vs + "\t" + vs + " " + y + " " + vs + "\t" + vs + " " + z + " " + vs + "\t" + vs + " " + q + " " + vs + "\t\t\t" + "[RETURN (0)]" + "\t" + "[EXIT (E)]");
        System.out.println(ldc + hs14 + rdc + "\t" + ldc + hs14 + rdc + "\t" + ldc + hs14 + rdc + "\t" + ldc + hs14 + rdc);
    }
}