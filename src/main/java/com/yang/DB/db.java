package com.yang.DB;

/**
 * Created by Adminitster on 2016/11/13.
 */
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class db {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        Connection con=null;
        Map<String, String> map=null;
        try {
            map = readXML();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        con= DriverManager.
                getConnection(map.get("url"), map.get("username"), map.get("password"));
        return con;
    }
    private static Map<String,String> readXML() throws FileNotFoundException, IOException,DocumentException {

        String configPath = new db().getClass().getClassLoader().getResource("dbconfig.xml").getFile();
        try {
            configPath = java.net.URLDecoder.decode(configPath,"utf-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        BufferedReader reader=new BufferedReader(new FileReader(configPath));
        String tempStr;
        String configXml="";
        while((tempStr=reader.readLine())!=null) {
            configXml=configXml+tempStr;
        }
        Element root = null;
        root = DocumentHelper.parseText(configXml).getRootElement();

        Element server=root.element("Server");//取得服务器子节
        Element database=root.element("Database");//取得数据库子节
        Element username=root.element("Username");//取得用户名子节
        Element password=root.element("Password");
        Element characterencoding=root.element("CharacterEncoding");
        Element useunicode=root.element("UseUnicode");

        String url="jdbc:mysql://"+server.getTextTrim()+"/"+
                database.getTextTrim()+"?useUnicode="+useunicode.getTextTrim()+
                "&characterEncoding="+characterencoding.getTextTrim();


        Map<String ,String> map=new HashMap<String,String>();
        map.put("url", url);
        map.put("username", username.getTextTrim());
        map.put("password", password.getTextTrim());
        return map;
    }
    public static void main(String[] args) {
        try {
            System.out.println(readXML());
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
