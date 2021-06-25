/*This class defines the controller in the MVC approach.
 * Author: Serdiuk Andrii
 ***/

package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {

    private static final String FIRST_STRING = "Hello";
    private static final String SECOND_STRING = "world!";

    private View view;
    private Model model;
    private final BufferedReader reader;

    public Controller(final View view, final Model model) {
        this.view = view;
        this.model = model;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void readGrettings() throws IOException {
        readFirstString();
        readSecondString();
        view.printMessage(model.getResponse());
    }

    private void readFirstString() throws IOException {
        while(true) {
            String input  = reader.readLine();
            if (input.equals(FIRST_STRING)) {
                model.setFirstInput(input);
                view.printMessage("Received string " + input);
                break;
            } else view.notifyAboutUnexpectedInput(FIRST_STRING, input);
        }
    }

    private void readSecondString() throws IOException {
        while(true) {
            String input  = reader.readLine();
            if (input.equals(SECOND_STRING)) {
                model.setSecondInput(input);
                view.printMessage("Received string " + input);
                break;
            } else view.notifyAboutUnexpectedInput(SECOND_STRING, input);
        }
    }

}
