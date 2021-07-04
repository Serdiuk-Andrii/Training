import java.util.Random;

public class Model {

    private int generatedNumber;

    private final Random random = new Random();
    private int currentMin;
    private int currentMax;

    public void setupRules(final int minValue, final int maxValue) {
        this.currentMin = minValue;
        this.currentMax = maxValue;
    }

    public void generateTheNumber() {
        generatedNumber = random.nextInt(Constants.MAX_VALUE + 1 - Constants.MIN_VALUE)
                + Constants.MIN_VALUE;
    }

    public boolean processTheNumber(final int number) {
        if (number == generatedNumber)
            return true;
        if (generatedNumber > number)
            currentMin = number + 1;
        else
            currentMax = number - 1;
        return false;
    }

    public boolean guessIsUseless(final int number) {
        return number < currentMin || number > currentMax;
    }

    public int getGeneratedNumber() {
        return generatedNumber;
    }

    public int getCurrentMin() {
        return currentMin;
    }

    public int getCurrentMax() {
        return currentMax;
    }
}
