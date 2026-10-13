package com.qeema.demo.dao;

import org.springframework.stereotype.Repository;

import com.qeema.demo.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT WITH DATA: " + account
                + " and VIP flag: " + vipFlag);
    }
}
