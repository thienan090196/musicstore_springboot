package com.nashtech.musicstore_springboot.service;

import com.nashtech.musicstore_springboot.dao.IOrderDao;
import com.nashtech.musicstore_springboot.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("orderService")
public class OrderServiceImp implements IOrderService {

    @Autowired
    IOrderDao orderDao;

    @Override
    public void save(Order order) {
        orderDao.save(order);
    }

    @Override
    public List<Order> getAll() {
        return orderDao.findAll(new Sort(Sort.Direction.DESC, "modifiedAt", "createdAt"));
    }

    @Override
    public Order findById(Integer orderId) {
        return orderDao.findOne(orderId);
    }

    @Override
    public void update(Order order) {
        orderDao.save(order);
    }

    @Override
    public void deleteById(Integer orderId) {
        orderDao.delete(orderId);
    }
}
