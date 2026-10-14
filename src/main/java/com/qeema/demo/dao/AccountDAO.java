package com.qeema.demo.dao;

import java.util.List;

import com.qeema.demo.entity.Account;

public interface AccountDAO {
    void addAccount(Account account, boolean vipFlag);

    String getName();

    void setName(String name);

    Integer getServiceCode();

    void setServiceCode(Integer serviceCode);

    List<Account> findAccounts();

    List<Account> findAccounts(boolean tripWire);
}
