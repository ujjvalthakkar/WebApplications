package com.neu.ujjval;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.ujjval.pojo.Movie;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MovieController extends MyController {

	@RequestMapping(value = "home.htm", method = RequestMethod.GET)
	public ModelAndView showHomePage(HttpServletRequest request) {
		return new ModelAndView("home");
	}

	@RequestMapping(value = "movie.htm", method = RequestMethod.POST)
	public ModelAndView showMovieFormPage(HttpServletRequest request) {
		// Create the Hibernate Objects
		System.out.print("Entered 1");
		HttpSession session = request.getSession();
		if (request.getParameter("path").equals("moviesServlet")) {
			String path = "";
			if (request.getParameter("moviesOption").equals("Browse Movies")) {
				path = "1";
			} else {
				path = "2";
			}
			request.setAttribute("path", path);
		}
		return new ModelAndView("movies");
	}

	@RequestMapping(value = "movie1.htm", method = RequestMethod.POST)
	public ModelAndView showFormPage(HttpServletRequest request) {
		// Create the Hibernate Objects
		System.out.println("Entered 2");
		if (request.getParameter("formName").equals("searchMovieForm")) {
			String queryColumn = "";
			if (request.getParameter("searchBy").equals("Search by Title")) {
				queryColumn = "title";
			} else if (request.getParameter("searchBy").equals("Search by Actor")) {
				queryColumn = "actor";
			} else if (request.getParameter("searchBy").equals("Search by Actress")) {
				queryColumn = "actress";
			}
			Session hibernatesession = getSession();
			String query="from Movie where "+queryColumn+" like :queryColumn";
			//String query="from Movie where "+queryColumn+"= :queryColumn";
			Query q = hibernatesession.createQuery(query);
			//String columnString=request.getParameter("keyword");
			String columnString="%"+request.getParameter("keyword")+"%";
			q.setParameter("queryColumn", columnString);
			//("title", columnString);
			List<Movie> movieList= q.list();
			System.out.println("Entered>>>>>" + q+">>>>>"+q.list());
			request.setAttribute("keyword",request.getParameter("keyword"));
			request.setAttribute("criteria",queryColumn);
			request.setAttribute("movieList", movieList);
			return new ModelAndView("movieBrowse");
		}
		if (request.getParameter("formName").equals("addMovieForm")) {
			Session hibernatesession = getSession();
			Movie movie = new Movie(request.getParameter("movieTitle"), request.getParameter("leadActor"),
					request.getParameter("leadActress"), request.getParameter("movieGenre"),
					Integer.parseInt(request.getParameter("movieYear")));
			try {
				hibernatesession.beginTransaction();
				hibernatesession.save(movie);
				hibernatesession.getTransaction().commit();
				System.out.println("Movie created!" + request.getParameter("movieTitle"));
			} catch (HibernateException e) {
				System.out.println("Cannot create category! " + e);
				hibernatesession.getTransaction().rollback();
			} finally {
				System.out.println("Entered finally>>>>>" + hibernatesession);
				hibernatesession.close();
				System.out.println("Leaving finally>>>>>" + hibernatesession);

			}
			return new ModelAndView("movieAdded");
		}
		return new ModelAndView("movies");

	}
}