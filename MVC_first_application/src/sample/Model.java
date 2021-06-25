/*This class defines the model in the MVC approach.
 * Author: Serdiuk Andrii
 ***/

package sample;

public class Model {

    private String firstInput;
    private String secondInput;

    public void setFirstInput(final String input) {
        firstInput = input;
    }

    public void setSecondInput(final String input) {
        secondInput = input;
    }

    public String getResponse() {
        return firstInput + ", " + secondInput;
    }

}
