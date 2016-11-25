package com.yang.DAO;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;
import com.yang.DB.db;
import com.yang.vo.TestUser;

import javax.jws.soap.SOAPBinding;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Adminitster on 2016/11/22.
 */
public class UserdaoImpl implements IUserdao{
    private Connection conn;
    public UserdaoImpl() throws SQLException {
        conn= db.getConnection();
    }
    public TestUser login(TestUser user) {
        TestUser user1=null;
        String sql="select * from users where User_no=? and pwd=?";
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        boolean flag=false;
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, user.getUser_no());
            pstmt.setString(2, user.getPwd());
            rs=pstmt.executeQuery();
            if(rs.next()){
                user1=new TestUser();
                user1.setId(rs.getInt("id"));
                user1.setUser_no(rs.getString("User_no"));
                user1.setUser_name(rs.getString("User_name"));
            }
            flag=rs.next();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return user1;
    }

    public boolean addUser(TestUser user) {
        PreparedStatement pstmt = null;
        String sql = "insert into users(User_no,User_name,pwd,depart,sex) values(?,?,?,?,?)";
        boolean flag = false;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUser_no());
            pstmt.setString(2, user.getUser_name());
            pstmt.setString(3, user.getPwd());
            pstmt.setString(4, user.getDepart());
            pstmt.setString(5, user.getSex());

            flag = pstmt.executeUpdate() > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return flag;

        }
    }

    public static void main(String[] args) {
        TestUser user = new TestUser();
        user.setPwd("11");
        user.setUser_name("11");
        user.setUser_no("11");
        user.setDepart("as");
        user.setSex("n");

        try {
            new UserdaoImpl().addUser(user);
        } catch (SQLException e) {


        }
    }
}
