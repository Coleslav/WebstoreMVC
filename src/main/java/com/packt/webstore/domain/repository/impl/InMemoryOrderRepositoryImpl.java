package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.Order;
import com.packt.webstore.domain.repository.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryOrderRepositoryImpl implements OrderRepository{
    private Map<Long, Order> listofOrders;
    private long nextOrderId;

    public InMemoryOrderRepositoryImpl(){
        listofOrders = new HashMap<Long, Order>();
        nextOrderId = 1000;
    }

    @Override
    public Long saveOrder(Order order) {
        order.setOrderId(getNextOrderId());
        listofOrders.put(order.getOrderId(), order);
        return order.getOrderId();
    }

    private synchronized long getNextOrderId(){
        return nextOrderId++;
    }
}
