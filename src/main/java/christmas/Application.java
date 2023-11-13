package christmas;

import christmas.Controller.ChristmasController;
import christmas.factory.ComponentFactory;

public class Application {
    public static void main(String[] args) {
        ComponentFactory.getInstance().christmasController().execute();
    }
}
