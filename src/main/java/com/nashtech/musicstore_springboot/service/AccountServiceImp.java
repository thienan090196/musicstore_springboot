package com.nashtech.musicstore_springboot.service;

import com.nashtech.musicstore_springboot.dao.IAccountDao;
import com.nashtech.musicstore_springboot.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImp implements IAccountService {

    @Autowired
    IAccountDao accountDao;

    @Override
    public void save(Account account) {
        accountDao.save(account);
    }

    @Override
    public List<Account> getAll() {
        return accountDao.findAll(new Sort(Sort.Direction.DESC, "modifiedAt", "createdAt"));
    }

    @Override
    public Account findById(Integer accountId) {
        return accountDao.findOne(accountId);
    }

    @Override
    public Account findByEmail(String email) {
        return accountDao.findByEmail(email);
    }

    @Override
    public void update(Account account) {
        accountDao.save(account);
    }

    @Override
    public void deleteById(Integer accountId) {
        accountDao.delete(accountId);
    }
}
