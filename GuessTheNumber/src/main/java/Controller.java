import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {


    private final Model model;
    private final View view;
    private BufferedReader reader;
    private final StringBuilder attempts = new StringBuilder();
    private boolean firstAttempt = true;

    private boolean userHasWon;
    private final Pattern pattern = Pattern.compile("-?\\d+");

    public Controller(final Model model, final View view) {
        this.model = model;
        this.view = view;
    }

    public void startTheGame() {
        view.printMessage(Constants.GREETING_MESSAGE);
        reader = new BufferedReader(new InputStreamReader(System.in));
        model.setupRules(Constants.MIN_VALUE, Constants.MAX_VALUE);
        model.generateTheNumber();
        System.out.println(model.getGeneratedNumber());
        while (!userHasWon)
            processUserInput();
        attempts.append("]");
        view.printMessage(Constants.CONGRATULATIONS_MESSAGE + model.getGeneratedNumber());
        view.printMessage(Constants.ATTEMPTS_MESSAGE + attempts);
    }

    private boolean outOfBounds(int number) {
       return number < Constants.MIN_VALUE || number > Constants.MAX_VALUE;
    }

    public boolean testOutOfBounds(int number) {
        return outOfBounds(number);
    }

    private void processUserInput() {
        final String input;
        try {
            input = reader.readLine().strip();
        } catch (IOException e) {
            view.printMessage(Constants.READING_ERROR);
            return;
        }
        final Matcher matcher = pattern.matcher(input);
        if (!matcher.matches())
            view.printMessage(Constants.NOT_A_NUMBER_ERROR);
        else {
            final int number = Integer.parseInt(input);
            if (outOfBounds(number)) {
                view.printMessage(Constants.OUT_OF_BOUNDS_ERROR);
                return;
            }
            if (model.guessIsUseless(number)) {
                view.printMessage(Constants.CHECK_IS_USELESS_MESSAGE);
                view.printCurrentRange(model.getCurrentMin(),model.getCurrentMax());
                return;
            }
            userHasWon = model.processTheNumber(number);
            if (firstAttempt) {
                firstAttempt = false;
                attempts.append("[").append(number);
            } else
                attempts.append(", ").append(number);
            if (!userHasWon)
                view.printCurrentRange(model.getCurrentMin(),model.getCurrentMax());
        }
    }


}
