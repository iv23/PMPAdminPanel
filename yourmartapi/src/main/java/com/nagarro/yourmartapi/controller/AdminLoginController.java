/**
 * 
 */
package com.nagarro.yourmartapi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.yourmartapi.entity.AdminUserDetails;
import com.nagarro.yourmartapi.repository.AdminUserRepository;
import com.nagarro.yourmartapi.service.AdminPanelService;

/**
 * @author ishaanvashishth
 *
 */
@Controller
public class AdminLoginController {
	
	@Autowired
	AdminUserRepository userRepo;
	
	AdminPanelService service = new AdminPanelService();
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model) {
        return "welcome";
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLoginPage(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("adminUser", new AdminUserDetails());
		mav.setViewName("login");
		return mav;
	}
	@RequestMapping(value = "/processLogin", method = RequestMethod.POST)
	public ModelAndView processLoginForm(HttpServletRequest req, HttpServletResponse res,
			@ModelAttribute("adminUser") AdminUserDetails adminUser) {
		ModelAndView mav = null;
		HttpSession session = req.getSession();
		boolean result = false;
		AdminUserDetails adminUserFromDB = new AdminUserDetails();
		result = service.authenticateAdminUser(adminUser);
		if(result) {
			adminUserFromDB = userRepo.findByYourmartId(adminUser.getYourmartId());
			mav = new ModelAndView("redirect:/welcome");
			session.setAttribute("user", adminUserFromDB);
		} else {
			mav = new ModelAndView("login");
			mav.addObject("message", "Username or password is wrong!!");
		}
		return mav;
	}
}
