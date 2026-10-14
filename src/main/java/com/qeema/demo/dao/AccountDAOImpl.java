package com.qeema.demo.dao;

import org.springframework.stereotype.Repository;

import com.qeema.demo.entity.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {
    private String name;
    private Integer serviceCode;

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT WITH DATA: " + account
                + " and VIP flag: " + vipFlag);
        
    }

    @Override
    public String getName() {
        System.out.println(getClass() + ": in getName()");
        return name;
    }
    
    @Override
    public void setName(String name) {
        System.out.println(getClass() + ": in setName()");
        this.name = name;
    }
    
    @Override
    public Integer getServiceCode() {
        System.out.println(getClass() + ": in getServiceCode()");
        return serviceCode;
    }
    
    @Override
    public void setServiceCode(Integer serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
