package View;

import java.util.Locale;
import java.util.ResourceBundle;

public class View {

    public static final String MESSAGE_BUNDLE_NAME = "message";
    public static final ResourceBundle bundle = ResourceBundle.getBundle(MESSAGE_BUNDLE_NAME,
            new Locale("ua", "UA"));
            //new Locale("en"));


    /**
     * @param message The text to be printed
     * */
    public void printMessage(final String message) {
        System.out.println(message);
    }




}
