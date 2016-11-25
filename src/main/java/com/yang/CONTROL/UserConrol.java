package com.yang.CONTROL;

import com.yang.service.IUserService;
import com.yang.service.UserServiceImpl;
import com.yang.vo.TestUser;
import org.omg.CORBA.Request;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Adminitster on 2016/11/23.
 */
@WebServlet(
        urlPatterns = {"/UserConrol"},
        initParams = {
                @WebInitParam(name="success",value = "success.jsp"),
                @WebInitParam(name="error",value = "index.jsp")
        })
public class UserConrol extends HttpServlet {
    private IUserService service=new UserServiceImpl();
    private Map<String,String> map=new HashMap<String, String>();
    @Override
    public void init(ServletConfig config) {
        map.put("success",config.getInitParameter("success"));
        map.put("error",config.getInitParameter("error"));
    }
    public UserConrol() throws SQLException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
        String action=req.getParameter("action");
        if (action.equals("login")){

                login(req, resp);

        }else if(action.equals("register")) {

        }

    }
    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TestUser user=new TestUser();
        user.setUser_no(req.getParameter("userno"));
        user.setPwd(req.getParameter("password"));
        TestUser user1=service.login(user);
        if(user1!=null) {
            req.getSession().setAttribute("user", user1);
            resp.sendRedirect(map.get("success"));
        }else{
            resp.setContentType("text/html");
            resp.setCharacterEncoding("utf-8");
            PrintWriter out=resp.getWriter();

            out.write("<script type='text/javascript'> "+
                    "alert('非法入侵'); "+
                    "window.location='"+map.get("error").toString()+"'; "+
                    "</script>");
            out.flush();
            out.close();
        }
    }
    private void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TestUser user=new TestUser();
        user.setUser_no(req.getParameter("userno"));
        user.setPwd(req.getParameter("password"));
        user.setDepart(req.getParameter("depart"));
        user.setSex(req.getParameter("sex"));
        user.setUser_name(req.getParameter("username"));
        TestUser user1=service.login(user);
        if(user1!=null){
            req.getSession().setAttribute("user",user1);

        }

    }
}
