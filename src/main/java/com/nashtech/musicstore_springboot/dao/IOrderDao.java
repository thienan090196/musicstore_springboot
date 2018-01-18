package com.nashtech.musicstore_springboot.dao;

import com.nashtech.musicstore_springboot.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderDao extends JpaRepository<Order, Integer> {
}
