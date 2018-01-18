package com.nashtech.musicstore_springboot.dao;

import com.nashtech.musicstore_springboot.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountDao extends JpaRepository<Account, Integer> {
    Account findByEmail(String email);
}
