package org.example.app.coffee.order;

import lombok.Data;

@Data
public class Order implements Comparable<Order> {

    private final int orderId;
    private final String customerName;


    @Override
    public String toString() {
        return orderId + " | " + customerName;
    }

    @Override
    public int compareTo(Order otherId) {
        return Integer.compare(orderId, ((Order) otherId).orderId);
    }
}
