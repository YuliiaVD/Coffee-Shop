package org.example.app.coffee.order;

import org.example.app.coffee.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CoffeeOrderBoard {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(CoffeeOrderBoard.class);
    private final List<Order> orders = new ArrayList<>();
    private int lastOrderId = 0;

    // Метод для додавання нового замовлення
    public void add(String customerName) {
        lastOrderId++;
        Order newOrder = new Order(lastOrderId, customerName);
        orders.add(newOrder);
        LOGGER.info(Constants.LOG_NEW_ORDER, newOrder);
    }

    // Метод для видачі найближчого до видачі замовлення
    public Order deliver() {
        if (orders.isEmpty()) {
            LOGGER.warn(Constants.LOG_WARN_EMPTY_QUEUE);
            return null;
        }
        Order orderToDeliver = orders.removeFirst();
        LOGGER.info(Constants.LOG_ORDER_RMVD, orderToDeliver);
        return orderToDeliver; // Видаємо і видаляємо перше замовлення
    }

    // Перевантажений метод для видачі замовлення за номером
    public Order deliver(int orderNumber) {
        for (Order order : orders) {
            if (order.getOrderId() == orderNumber) {
                orders.remove(order);
                LOGGER.info(Constants.LOG_ORDER_SHIPPED, order);
                return order;
            }
        }
        LOGGER.error(Constants.LOG_ERROR_ORDER, orderNumber);
        return null;
    }

    // Метод для виводу поточного стану черги замовлень
    public void draw() {
        System.out.println("Num | Name");
        for (Order order : orders) {
            System.out.println(order);
        }
        LOGGER.info(Constants.LOG_INFO_STATUS_ORDER, orders.size());
    }

}
