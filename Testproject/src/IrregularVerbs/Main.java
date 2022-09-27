package IrregularVerbs;

import javax.mail.MessagingException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, MessagingException {
        Graphics.title();
        Menus.askAboutRegistration();
        Menus.learningType();
    }
}
