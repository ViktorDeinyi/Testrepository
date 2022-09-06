package IrregularVerbs;


import java.io.*;

public class NewFile {
    public static void newFile() throws IOException {
        System.out.println("Write file name:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        OutputStream outputStream = new FileOutputStream(reader.readLine());


        while (true) {
            System.out.println("Write your name:");
            String data = reader.readLine();
            if (data == ("0")) {
                outputStream.write((data + "\r\n").getBytes());
            } else {
                outputStream.write(data.getBytes());
                break;
            }
        }
//        outputStream.close();
//        reader.close();
    }
}
