/*This class defines the view in the MVC approach.
 * Author: Serdiuk Andrii
 ***/

package sample;

public class View {

    public void notifyAboutUnexpectedInput(final String expected, final String found) {
        System.out.println("Waiting for string " + expected + ", but found " + found);
    }

    public void printMessage(final String string) {
        System.out.println(string);
    }

}
