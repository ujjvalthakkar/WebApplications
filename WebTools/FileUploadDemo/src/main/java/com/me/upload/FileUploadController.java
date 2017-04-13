package com.me.upload;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.me.pojo.User;
import com.me.dao.UserDAO;
import com.me.exception.UserException;
import com.me.validator.UserValidator;

@Controller
public class FileUploadController {

	@Autowired
	@Qualifier("userDao")
	UserDAO userDao;

	@Autowired
	@Qualifier("userValidator")
	UserValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@Autowired
	ServletContext servletContext;

	@RequestMapping(value = "/upload.htm", method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		User user = new User(); // should be AutoWired

		// command object
		model.addAttribute("user", user);

		// return form view
		return "user-form";

	}

	@RequestMapping(value = "/upload.htm", method = RequestMethod.POST)
	public String handleUpload(@ModelAttribute("user") User user) {
		try {
			if (user.getFilename().trim() != "" || user.getFilename() != null) {
				File directory;
				String check = File.separator; // Checking if system is linux
												// based or windows based by
												// checking seprator used.
				String path = null;
				if (check.equalsIgnoreCase("\\")) {
					path = servletContext.getRealPath("").replace("build\\", ""); // gives real path as Lab9/build/web/
																				  // so we need to replace build in the path
																						}

				if (check.equalsIgnoreCase("/")) {
					path = servletContext.getRealPath("").replace("build/", "");
					path += "/"; // Adding trailing slash for Mac systems.
				}
				directory = new File(path + "\\" + user.getFilename());
				boolean temp = directory.exists();
				if (!temp) {
					temp = directory.mkdir();
				}
				if (temp) {
					// We need to transfer to a file
					CommonsMultipartFile photoInMemory = user.getPhoto();

					String fileName = photoInMemory.getOriginalFilename();
					// could generate file names as well

					File localFile = new File(directory.getPath(), fileName);

					// move the file from memory to the file

					photoInMemory.transferTo(localFile);
					user.setFilename(localFile.getPath());
					System.out.println("File is stored at" + localFile.getPath());
					System.out.print("registerNewUser");
					User u = userDao.register(user);

				} else {
					System.out.println("Failed to create directory!");
				}
			}

		} catch (IllegalStateException e) {
			System.out.println("*** IllegalStateException: " + e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("*** IOException: " + e.getMessage());
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "user-success";
	}

	@RequestMapping(value = "/search.htm", method = RequestMethod.GET)
	public String giveSearchForm(ModelMap model) {
		User user = new User(); // should be AutoWired

		// command object
		model.addAttribute("user", user);

		// return form view
		return "search-user";

	}

	@RequestMapping(value = "/search.htm", method = RequestMethod.POST)
	public ModelAndView seacrhUser(HttpServletRequest request) {
		String key=request.getParameter("inputtext");
        String searchKey=request.getParameter("searchkey");
        List<User> userList = null;
		try {
			userList = userDao.get(key,searchKey);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return new ModelAndView("search-result", "userList", userList);
	}
}
