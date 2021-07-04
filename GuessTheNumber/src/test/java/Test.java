import org.junit.Assert;

import java.util.Random;

public class Test {


    @org.junit.Test
    public void testGenerateNumber() {
        Model model = new Model();
        for (int i = Constants.MIN_VALUE; i <= Constants.MAX_VALUE; i++) {
            boolean hasBeenGenerated = false;
            for (int j = 0; j < 10000000 && !hasBeenGenerated; j++) {
                model.generateTheNumber();
                if (i == model.getGeneratedNumber())
                    hasBeenGenerated = true;
            }
            Assert.assertTrue(hasBeenGenerated);
        }
    }

    @org.junit.Test
    public void testModelCheck() {
        Model model = new Model();
        model.generateTheNumber();
        int answer = model.getGeneratedNumber();
        Assert.assertTrue(model.processTheNumber(answer));
    }

    @org.junit.Test
    public void testOutOfBounds() {
        Random random = new Random();
        Controller controller = new Controller(new Model(), new View());
        for (int i = 0; i < 10000000; i++)
            Assert.assertTrue(controller.testOutOfBounds(random.nextInt() + Constants.MAX_VALUE + 1));
        for (int i = 0; i < 10000000; i++)
            Assert.assertTrue(controller.testOutOfBounds(-random.nextInt() + Constants.MIN_VALUE - 1));
    }

}
