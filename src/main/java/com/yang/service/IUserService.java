package com.yang.service;

import com.yang.vo.TestUser;

/**
 * Created by Adminitster on 2016/11/22.
 */
public interface IUserService {
    public TestUser login(TestUser user);
    public boolean addUser(TestUser user);
}
