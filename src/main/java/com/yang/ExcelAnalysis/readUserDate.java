package com.yang.ExcelAnalysis;


import com.yang.vo.TestUser;

import com.yang.DAO.StorageUserDao;
import jxl.Sheet;
import jxl.Workbook;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Adminitster on 2016/11/15.
 */
public class readUserDate {
    public static List<TestUser> readXlsResourse(String path){
        Workbook readwb=null;
        List<TestUser> userlist=new LinkedList<TestUser>();
        try {
            //构建WrokBook对象，只读Workbook对象
            //直接从本地文件创建Workbook
            InputStream instream=new FileInputStream(path);
            readwb=Workbook.getWorkbook(instream);

            //sheet的下标是从0开始的
            //获取第一张Sheet表
            Sheet readsheet=readwb.getSheet(0);

            //获取Sheet表中所包含的总列数
            int rsColums=readsheet.getColumns();

            int rsRows=readsheet.getRows();
            System.out.println(rsRows);
            for(int i=0;i<rsRows;i++){
                TestUser user=new TestUser();
                System.out.println(readsheet.getCell(0,i).getContents());
                user.setUser_no(readsheet.getCell(0,i).getContents());
                user.setUser_name(readsheet.getCell(1,i).getContents());
                user.setPwd(readsheet.getCell(0,i).getContents());
                user.setDepart(readsheet.getCell(2,i).getContents());
                user.setSex(readsheet.getCell(3,i).getContents());

                userlist.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return userlist;
    }

    public static void main(String[] args) {
        List<TestUser> userlist=readXlsResourse("E:/TestUser.xls");
        for(int i=0;i<userlist.size();i++){
            System.out.print(userlist.get(i).getUser_name());
            System.out.print("--");
            System.out.println(userlist.get(i).getUser_no());
        }
        StorageUserDao.addUser(userlist);
    }
}

