package com.qeema.demo.dao;

import com.qeema.demo.Account;

public interface AccountDAO {
    void addAccount(Account account, boolean vipFlag);
}
