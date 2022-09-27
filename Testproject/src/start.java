public class start {
    public final double pi = 3.14; //publick constatna (final) for all clases

    public static void main(String[] args) {
        byte num = 127; //8 bit  -128 to 127
        short num1 = 32767; //16 bit -32768 to 32767
        int num2 = 2147483647; //32 bit -2147483648 to 2147483647
        long num3 = 214748364788l; //64 bit

        float num10 = 10.34f; //32 bit 1.123456 (6-7 numbers after point)
        double num11 = -546.156784936524; //64 bit (15 numbers after point)

        char symb = '\u2600'; //16 bit secial symbols (e.g. Unicode)

        boolean isTrue = false; //1 bit (true or false)
        char s = '\u24C8';
        char t = '\u24C9';
        char o = '\u24C4';
        char p = '\u24C5';
        char w = '\u24CC';
        char a = '\u24B6';
        char r = '\u24C7';


        System.out.println("Hello \n world !");
        System.out.println(num);
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
        System.out.println(num10);
        System.out.println(num11);
        System.out.println(symb);
        System.out.print(s);
        System.out.print(t);
        System.out.print(o);
        System.out.println(p);
        System.out.println(isTrue);

        double d = 1.0;
        double g = 1.0;
        System.out.println(d);
        System.out.println(g);
        System.out.println(d + g);
        if (d == g) {
            System.out.println("!");
        } else {
            System.out.print("?");
        }
    }
}