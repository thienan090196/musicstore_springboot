package com.nashtech.musicstore_springboot.dao;

import com.nashtech.musicstore_springboot.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderDetailDao extends JpaRepository<OrderDetail, Integer> {
}
