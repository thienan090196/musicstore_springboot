package com.nashtech.musicstore_springboot.service;

import com.nashtech.musicstore_springboot.model.Order;
import java.util.List;

public interface IOrderService {
    void save(Order order);
    List<Order> getAll();
    Order findById(Integer orderId);
    void update(Order order);
    void deleteById(Integer orderId);
}
