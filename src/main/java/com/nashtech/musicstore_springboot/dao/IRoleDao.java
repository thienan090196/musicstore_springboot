package com.nashtech.musicstore_springboot.dao;

import com.nashtech.musicstore_springboot.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleDao extends JpaRepository<Role, Integer> {
}
