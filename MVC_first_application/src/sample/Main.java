/*This file is responsible for creating all the necessary objects and running the program
* Author: Serdiuk Andrii
***/

package sample;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(view, model);
        controller.readGrettings();
    }
}
