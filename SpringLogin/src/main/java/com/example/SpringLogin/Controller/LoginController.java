package com.example.SpringLogin.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String roomLogin(ModelMap model, HttpSession httpSession) {
		// System.out.println("user name is "+getLoggedInUserName());
		// model.put("name", getLoggedInUserName());
		httpSession.setAttribute("name", getLoggedInUserName());
		return "login";
	}

	private String getLoggedInUserName() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			System.out.println("User " + ((UserDetails) principal).getUsername());
			return ((UserDetails) principal).getUsername();

		}

		return principal.toString();
	}

	@RequestMapping(value = "/welcome")
	public String showWelcome(ModelMap model,HttpSession httpSession) {
		httpSession.setAttribute("name", getLoggedInUserName());
		return "login";
	}
}
