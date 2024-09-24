package org.example.app;

import org.example.app.coffee.order.CoffeeOrderBoard;

public class App {

    public static void main(String[] args) {

        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();

        coffeeOrderBoard.deliver();
        coffeeOrderBoard.deliver(1);

        coffeeOrderBoard.add("Yuliia");
        coffeeOrderBoard.add("Evgene");
        coffeeOrderBoard.add("Serhii");
        coffeeOrderBoard.add("Serhii");

        coffeeOrderBoard.draw();

        coffeeOrderBoard.deliver();
        coffeeOrderBoard.deliver(1);
        coffeeOrderBoard.deliver(3);

        coffeeOrderBoard.add("Helen");
        coffeeOrderBoard.draw();

        coffeeOrderBoard.deliver(33);
        coffeeOrderBoard.draw();

    }
}
