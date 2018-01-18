package com.nashtech.musicstore_springboot.service;

import com.nashtech.musicstore_springboot.model.OrderDetail;
import java.util.List;

public interface IOrderDetailService {
    void save(OrderDetail orderDetail);
    List<OrderDetail> getAll();
    OrderDetail findById(Integer orderDetailId);
    void update(OrderDetail orderDetail);
    void deleteById(Integer orderDetailId);
}
