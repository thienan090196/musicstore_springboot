package com.nashtech.musicstore_springboot.service;

import com.nashtech.musicstore_springboot.dao.IOrderDetailDao;
import com.nashtech.musicstore_springboot.model.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("orderDetailService")
public class OrderDetailServiceImp implements IOrderDetailService {

    @Autowired
    IOrderDetailDao orderDetailDao;

    @Override
    public void save(OrderDetail orderDetail) {
        orderDetailDao.save(orderDetail);
    }

    @Override
    public List<OrderDetail> getAll() {
        return orderDetailDao.findAll(new Sort(Sort.Direction.DESC, "modifiedAt", "createdAt"));
    }

    @Override
    public OrderDetail findById(Integer orderDetailId) {
        return orderDetailDao.findOne(orderDetailId);
    }

    @Override
    public void update(OrderDetail orderDetail) {
        orderDetailDao.save(orderDetail);
    }

    @Override
    public void deleteById(Integer orderDetailId) {
        orderDetailDao.delete(orderDetailId);
    }
}
