package Controller;

import Model.Model;
import View.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

import static Controller.RegularExpressions.*;
import static View.TextConstants.*;

public class Controller {

    private Model model;
    private View view;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private User user = new User();

    private static final Pattern UKRAINIAN_NAME_PATTERN = Pattern.compile(NAME_UKRAINIAN);
    private static final Pattern ENGLISH_NAME_PATTERN = Pattern.compile(NAME_ENGLISH);
    private static final Pattern LOGIN_PATTERN = Pattern.compile(LOGIN);

    public Controller(final Model model, final View view) {
        this.model = model;
        this.view = view;
    }


    public void processInput() {
        processUsername();
        processUserLogin();
    }

    private void processUserLogin() {
        view.printMessage(View.bundle.getString(LOGIN_DATA));
        user.setUsername(readCorrectInput(LOGIN_PATTERN));

    }

    private void processUsername() {
        view.printMessage(View.bundle.getString(FIRST_NAME));
        if ((String.valueOf(View.bundle.getLocale()).equals("ua")))
            user.setName(readCorrectInput(UKRAINIAN_NAME_PATTERN));
        else
            user.setName(readCorrectInput(ENGLISH_NAME_PATTERN));
    }

    private String readCorrectInput(final Pattern pattern) {
        while (true) {
            final String input;
            try {
                input = reader.readLine().trim();
            } catch (IOException ex) {
                view.printMessage(READ_INPUT_ERROR);
                continue;
            }
            if (pattern.matcher(input).matches())
                return input;
            view.printMessage(view.bundle.getString(WRONG_INPUT_DATA));
        }
    }
}
