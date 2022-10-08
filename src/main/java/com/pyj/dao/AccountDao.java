package com.pyj.dao;

import com.pyj.pojo.Account;
import org.apache.ibatis.annotations.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AccountDao {

    @Select("select * from account")
    public List<Account> SelectAll();

    @Select("select * from account where id = #{id}")
    public Account SelectById(int id);

    @Insert("insert into account(username,balance) values(#{username},#{balance})")
    public int save(Account account);

    @Update("update account set balance = #{balance} where id = #{id}")
    public int updateAccount(Account account);

    @Delete("delete from account where id = #{id}")
    public int deleteAccount(int id);
}
