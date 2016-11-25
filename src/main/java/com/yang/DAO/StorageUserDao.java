package com.yang.DAO;

import com.yang.vo.TestUser;
import com.yang.vo.Word;
import com.yang.DB.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adminitster on 2016/11/15.
 */
public class StorageUserDao {
    public boolean query(){
        CallableStatement cs=null;
        Connection conn=null;
        ResultSet rs=null;
        ArrayList<Word> list=new ArrayList<Word>();
        String sql= "select * from words";
        try {
            conn.prepareStatement("sql");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    public static boolean addUser(List<TestUser> userlist){
        boolean flag=false;
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            conn= db.getConnection();
            for(int i=0;i<userlist.size();i++){
                String sql="insert into users(User_no,User_name,pwd,depart,sex) values(?,?,?,?,?)";
                pstmt=conn.prepareStatement(sql);
                pstmt.setString(1,userlist.get(i).getUser_no());
                pstmt.setString(2,userlist.get(i).getUser_name());
                pstmt.setString(3,userlist.get(i).getPwd());
                pstmt.setString(4,userlist.get(i).getDepart());
                pstmt.setString(5,userlist.get(i).getSex());

                if(pstmt.executeUpdate()>0){
                    flag=true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }
}
