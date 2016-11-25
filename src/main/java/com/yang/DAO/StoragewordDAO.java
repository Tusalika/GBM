package com.yang.DAO;

import com.yang.vo.Word;
import com.yang.DB.db;

import java.sql.*;
import java.util.List;

/**
 * Created by Adminitster on 2016/11/14.
 */
public class StoragewordDAO {

    public static boolean addWord(List<Word> wordslist){
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        boolean flag=false;
        try {
            conn= db.getConnection();
            for(int i=0;i<wordslist.size();i++){
                String sql="insert into words(id,word,A,B,C,D,answer) values(?,?,?,?,?,?,?)";
                pstmt=conn.prepareStatement(sql);
                pstmt.setString(1,wordslist.get(i).getId());
                pstmt.setString(2,wordslist.get(i).getWord());
                pstmt.setString(3,wordslist.get(i).getA());
                pstmt.setString(4,wordslist.get(i).getB());
                pstmt.setString(5,wordslist.get(i).getC());
                pstmt.setString(6,wordslist.get(i).getD());
                pstmt.setString(7,wordslist.get(i).getAnswer());
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
