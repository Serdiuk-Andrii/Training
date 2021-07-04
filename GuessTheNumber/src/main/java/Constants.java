public interface Constants {

    int MIN_VALUE = 0;
    int MAX_VALUE = 100;

    String READING_ERROR = "An error occurred while reading your input, try again";
    String NOT_A_NUMBER_ERROR = "The input you`ve provided is not a integer";
    String OUT_OF_BOUNDS_ERROR = "The given number is out of the range [" + MIN_VALUE + ", " + MAX_VALUE + ']';
    String CHECK_IS_USELESS_MESSAGE = "You already know that the secret number is not in this range";
    String CONGRATULATIONS_MESSAGE = "You`ve won! The secret number was indeed ";
    String ATTEMPTS_MESSAGE = "The history of your attempts:\n";
    String GREETING_MESSAGE = "The game has started!";
    String CURRENT_RANGE_MESSAGE = "The secret number is in range ";

}
