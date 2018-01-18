package com.nashtech.musicstore_springboot.service;

import com.nashtech.musicstore_springboot.model.Account;
import java.util.List;

public interface IAccountService {
    void save(Account account);
    List<Account> getAll();
    Account findById(Integer accountId);
    Account findByEmail(String email);
    void update(Account account);
    void deleteById(Integer accountId);
}
