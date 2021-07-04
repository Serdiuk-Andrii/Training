public class View {

    public void printMessage(final String string) {
        System.out.println(string);
    }

    public void printCurrentRange(int currentMin, int currentMax) {
        System.out.println(Constants.CURRENT_RANGE_MESSAGE + '[' + currentMin + ", " + currentMax + ']');
    }

}
