/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.Controller;

import com.edu.Beans.MessageBean;
import com.edu.Beans.UsersBean;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author ujjva
 */
public class loginController extends AbstractController {

    public loginController() {
    }

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        DataSource ds = (DataSource) this.getApplicationContext().getBean("myDataSource");
        QueryRunner run = new QueryRunner(ds);
        if (action.equals("logout")) {
            session.invalidate();
            mv.setViewName("index");
        } else if (action.equals("login")) {
            String userName = request.getParameter("user");
            String userPassword = request.getParameter("password");
            try {
                ResultSetHandler<UsersBean> userBean = new BeanHandler<UsersBean>(UsersBean.class);
                Object[] params = new Object[2];
                params[0] = userName;
                params[1] = userPassword;
                UsersBean ub = run.query("select * from userstable1 where userName=? and userPassword=?", userBean, params);

                if (ub != null) {
                    ResultSetHandler<List<MessageBean>> messages = new BeanListHandler<MessageBean>(MessageBean.class);
                    List<MessageBean> msg = run.query("select * from messages where userName=?", messages, userName);
                    session.setAttribute("userName", userName);
                    session.setAttribute("messageList", msg);
                    mv.setViewName("userHome");
                } else {
                    mv.addObject("error", true);
                    mv.setViewName("index");
                }
            } catch (Exception e) {
                System.err.println("Exception:" + e.getMessage());
            }
        } else if (action.equals("signUp")) {
            mv.setViewName("signup");
        } else if (action.equals("signin")) {
            String userName = request.getParameter("name");
            String userPassword = request.getParameter("pwd");
            String userEmail = request.getParameter("email");
            try {
                ResultSetHandler<UsersBean> userBean = new BeanHandler<UsersBean>(UsersBean.class);
                Object[] params = new Object[3];
                params[0] = userName;
                params[1] = userPassword;
                params[2] = userEmail;
                int inserts = run.update("insert into userstable1(UserName,UserPassword,UserEmail) value(?,?,?)", params);
                mv.setViewName("userHome");
            } catch (Exception e) {
                System.err.println("Exception:" + e.getMessage());
            }

        } else if (action.equals("inbox")) {
            String userName = (String) session.getAttribute("userName");
            System.out.println("com.edu.Controller.loginController.handleRequestInternal()"+userName);
            try {
                ResultSetHandler<List<MessageBean>> messages = new BeanListHandler<MessageBean>(MessageBean.class);
                List<MessageBean> msg = run.query("select * from messages where userName=?", messages, userName);
                session.setAttribute("userName", userName);
                session.setAttribute("messageList", msg);
                mv.setViewName("userHome");
            } catch (Exception e) {
                System.err.println("Exception:" + e.getMessage());
            }
        }
            return mv;
        }
    }
