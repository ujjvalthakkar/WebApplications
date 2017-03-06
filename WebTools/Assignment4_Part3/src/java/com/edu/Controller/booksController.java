/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.Controller;

import com.edu.Beans.Book;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author ujjva
 */
public class booksController extends AbstractController {

    public booksController() {
    }

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        DataSource ds = (DataSource) this.getApplicationContext().getBean("myDataSource");
        QueryRunner run = new QueryRunner(ds);
        String path = "";
        if (request.getParameter("path").equals("booksServlet")) {
            if (request.getParameter("booksOption").equals("Browse Books")) {
                path = "1";
                ResultSetHandler<List<Book>> books = new BeanListHandler<Book>(Book.class);
                List<Book> bookList = run.query("select * from books", books);
                request.setAttribute("bookList", bookList);
                request.setAttribute("path", path);
                mv.setViewName("books");
            } else {
                path = "2";
                request.setAttribute("path", path);
                mv.setViewName("books");
            }
        }
        if (request.getParameter("path").equals("books.jsp")) {
            if (request.getParameter("formName").equals("addBookForm")) {
                path = "3";
                request.setAttribute("path", path);
                request.setAttribute("numberOfBooks", request.getParameter("number"));
                mv.setViewName("books");
            }
            if (request.getParameter("formName").equals("addBooksForm")) {
                int n = Integer.parseInt(request.getParameter("numberOfBooks"));
                int result = 0;
                for (int i = 1; i <= n; i++) {
                    Object[] params = new Object[4];
                    params[0] = request.getParameter("isbn" + i);
                    params[1] = request.getParameter("title" + i);
                    params[2] = request.getParameter("author" + i);
                    params[3] = request.getParameter("price" + i);
                    result = run.update("INSERT INTO books(isbn,title,authors,price) VALUES(?,?,?,?)", params);
                }
                if (result > 0) {
                    path = "4";
                    request.setAttribute("path", path);
                    request.setAttribute("number", n);
                    mv.setViewName("books");
                }
            }
        }
        return mv;
    }

}
