package com.yang.DB;

/**
 * Created by Adminitster on 2016/11/14.
 */
public class test {
    public static void main(String[] args) {
        try {
            System.out.println(db.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
