package com.yang.service;

import com.yang.DAO.IUserdao;
import com.yang.DAO.UserdaoImpl;
import com.yang.vo.TestUser;

import java.sql.SQLException;

/**
 * Created by Adminitster on 2016/11/22.
 */
public class UserServiceImpl implements IUserService {
    private IUserdao dao=new UserdaoImpl();
    public UserServiceImpl() throws SQLException {
    }

    public TestUser login(TestUser user) {
        // TODO Auto-generated method stub
        return dao.login(user);
    }

    public boolean addUser(TestUser user) {
        return dao.addUser(user);
    }

}
