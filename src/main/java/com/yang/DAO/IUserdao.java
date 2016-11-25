package com.yang.DAO;

import com.yang.vo.TestUser;

/**
 * Created by Adminitster on 2016/11/22.
 */
public interface IUserdao {
    public TestUser login(TestUser user);
    public boolean addUser(TestUser user);
}
