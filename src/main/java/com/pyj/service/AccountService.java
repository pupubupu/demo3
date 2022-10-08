package com.pyj.service;

import com.pyj.pojo.Account;

import java.util.List;

public interface AccountService {

    public List<Account> SelectAll();

    public Account SelectById(int id);


    public int save(Account account);


    public int updateAccount(Account account);


    public int deleteAccount(int id);


}
