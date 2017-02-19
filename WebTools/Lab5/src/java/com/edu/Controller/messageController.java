/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.Controller;

import com.edu.Beans.UsersBean;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
/**
 *
 * @author ujjva
 */
public class messageController extends AbstractController {

    public messageController() {
    }

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        //throw new UnsupportedOperationException("Not yet implemented");
        ModelAndView mv = new ModelAndView();
        HttpSession session = (HttpSession) request.getSession();
        String sender = (String) session.getAttribute("userName");
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("reply")) {
            String receiver = request.getParameter("to");
            DataSource ds = (DataSource) this.getApplicationContext().getBean("myDataSource");
            QueryRunner run = new QueryRunner(ds);
            ResultSetHandler<UsersBean> userBean = new BeanHandler<UsersBean>(UsersBean.class);
            UsersBean ub = run.query("select * from userstable1 where userName=?", userBean, receiver);

            if (ub != null) {
                mv.addObject("toEmail", ub.getUserEmail());
                mv.addObject("to", receiver);
                mv.setViewName("reply");
            } else {
                // Send to error
            }
        } else if (action.equalsIgnoreCase("sent")) {
            //insert into db
            String receiver =request.getParameter("to");
            String receiverEmail=request.getParameter("toEmail");
            DataSource ds = (DataSource) this.getApplicationContext().getBean("myDataSource");
            QueryRunner run = new QueryRunner(ds);
            ResultSetHandler<UsersBean> userBean = new BeanHandler<UsersBean>(UsersBean.class);
            UsersBean ub = run.query("select * from userstable1 where userName=?", userBean, sender);
            if(ub!=null){
                String senderEmail=ub.getUserEmail();
                Object[] params=new Object[4];
                params[0]=sender;
                params[1]=request.getParameter("message");
                Date d=new Date();
                SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
                String messageDate=format.format(d);
                params[2]=messageDate;
                params[3]=receiver;
                int inserts=run.update("insert into messages(fromUser,message,messageDate,userName) value(?,?,?,?)",params);
                try{
                    Email email=new SimpleEmail();
                    email.setHostName("smtp.googlemail.com");
                    email.setSmtpPort(465);
                    email.setAuthenticator(new DefaultAuthenticator("contactapplication2017@gmail.com", "springmvc"));
                    email.setSSLOnConnect(true);
                    email.setFrom(senderEmail);
                    email.setSubject("Test Email");
                    email.setMsg(request.getParameter("message"));
                    email.addTo(receiverEmail);
                    email.send();
                } catch(Exception e){
                    System.err.println("Email Exception"+e.getMessage());
                }
                mv.setViewName("messageSent");
            }

        } else {
            // Send to error
            mv.addObject("error",true);
            mv.setViewName("index");
        }
        return mv;
    }

}
