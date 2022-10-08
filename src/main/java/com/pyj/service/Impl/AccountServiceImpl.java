package com.pyj.service.Impl;


import com.pyj.dao.AccountDao;
import com.pyj.pojo.Account;
import com.pyj.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("AccountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> SelectAll() {
        return accountDao.SelectAll();
    }

    @Override
    public Account SelectById(int id) {
        return accountDao.SelectById(id);
    }

    @Override
    public int save(Account account) {
        return accountDao.save(account);
    }

    @Override
    public int updateAccount(Account account) {
        return accountDao.updateAccount(account);
    }

    @Override
    public int deleteAccount(int id) {
        return accountDao.deleteAccount(id);
    }
}
