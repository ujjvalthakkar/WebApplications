package com.neu.ujjval;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.neu.ujjval.pojo.Book;
import java.util.List;

@Controller
public class BookController extends MyController {

	@RequestMapping(value = "home.htm", method = RequestMethod.GET)
	public ModelAndView showHomePage(HttpServletRequest request) {
		return new ModelAndView("home");
	}

	@RequestMapping(value = "book.htm", method = RequestMethod.POST)
	public ModelAndView showMovieFormPage(HttpServletRequest request) {
		String path = "";
		if (request.getParameter("path").equals("booksServlet")) {
			if (request.getParameter("booksOption").equals("Browse Books")) {
				path = "1";
				Session hibernatesession = getSession();
				Query hqlquery = hibernatesession.createQuery("from Book");
				List<Book> bookList = hqlquery.list();
				request.setAttribute("bookList", bookList);
				request.setAttribute("path", path);
			} else {
				path = "2";
				request.setAttribute("path", path);

			}
		}
		if (request.getParameter("path").equals("books.jsp")) {
			if (request.getParameter("formName").equals("addBookForm")) {
				path = "3";
				request.setAttribute("path", path);
				request.setAttribute("numberOfBooks", request.getParameter("number"));
			}
			if (request.getParameter("formName").equals("addBooksForm")) {
				int n = Integer.parseInt(request.getParameter("numberOfBooks"));
				int result = 0;
				
				for (int i = 1; i <= n; i++) {
					Book book = new Book(request.getParameter("isbn" + i), request.getParameter("title" + i),
							request.getParameter("author" + i), Float.parseFloat(request.getParameter("price" + i)));
					Session hibernatesession = getSession();
					try {
						if(request.isUserInRole("canAdd")){
							hibernatesession.beginTransaction();
							hibernatesession.save(book);
							hibernatesession.getTransaction().commit();
							System.out.println("Book created!" + request.getParameter("title" + i));	
						}
						else{
							System.out.println("Book not created!" + request.getParameter("title" + i));
							return new ModelAndView("booksNotAdded");
						}
						
					} catch (HibernateException e) {
						System.out.println("Cannot create category! " + e);
						hibernatesession.getTransaction().rollback();
					} finally {
						hibernatesession.close();
					}
				}
				request.setAttribute("number", n);
				return new ModelAndView("booksAdded");
			}
		}
		return new ModelAndView("books");
	}

}
