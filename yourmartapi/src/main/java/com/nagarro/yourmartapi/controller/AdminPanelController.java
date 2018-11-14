/**
 * 
 */
package com.nagarro.yourmartapi.controller;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.yourmartapi.entity.AdminUserDetails;
import com.nagarro.yourmartapi.entity.CategoryDetails;
import com.nagarro.yourmartapi.entity.ProductDetails;
import com.nagarro.yourmartapi.entity.SellerDetails;
import com.nagarro.yourmartapi.repository.AdminUserRepository;
import com.nagarro.yourmartapi.service.AdminPanelService;
import com.nagarro.yourmartapi.util.OffsetLimitRequest;
import com.nagarro.yourmartapi.util.ProductPredicatesBuilder;
import com.nagarro.yourmartapi.util.VerifyRecaptcha;
import com.querydsl.core.types.dsl.BooleanExpression;

/**
 * @author ishaanvashishth
 *
 */
@Controller
public class AdminPanelController {
	
	@Autowired
	AdminUserRepository userRepo;
	
	@Autowired
	AdminPanelService service;

	Logger logger = LoggerFactory.getLogger(AdminPanelController.class);
	
	
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
			@ModelAttribute("adminUser") AdminUserDetails adminUser) throws IOException {
		ModelAndView mav = null;
		HttpSession session = req.getSession();
		boolean result = false;
		String gRecaptchaResponse = req
				.getParameter("g-recaptcha-response");

		boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);
		AdminUserDetails adminUserFromDB = new AdminUserDetails();
		result = service.authenticateAdminUser(adminUser);
		if(result && verify) {
			adminUserFromDB = userRepo.findByYourmartId(adminUser.getYourmartId());
			mav = new ModelAndView("redirect:/home");
			session.setAttribute("user", adminUserFromDB);
		} else {
			mav = new ModelAndView("login");
			mav.addObject("message", "Username or password is wrong!!");
		}
		return mav;
	}
	
	/**
	 * @param session
	 * @return login screen.
	 * removes admin from the session.
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "login";

	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView showHomePage(@RequestParam(name = "sort", required = false) String sortStr,
			@RequestParam(name = "sortDirection", required = false) String sortDirection,
			@RequestParam(name = "page", required = false) Integer pageNo,
			@RequestParam(name = "filter", required = false) String filterStr,
			@RequestParam(name = "search", required = false) String search, HttpServletRequest req,
			HttpServletResponse res, HttpSession session) {
		if (session.getAttribute("user") == null) { // admin is not logged in.
			return new ModelAndView("redirect:/");
		}
		ModelAndView mav = new ModelAndView();
		BooleanExpression exp = null;
		Page<SellerDetails> sellers = null;
		ProductPredicatesBuilder builder = new ProductPredicatesBuilder();
		if (search != null) {
			Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
			Matcher matcher = pattern.matcher(search + ",");
			while (matcher.find()) {
				builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
			}
			exp = builder.build();
		}
		pageNo = (pageNo == null) ? 1 : pageNo; 
		if(sortStr==null) {
			sortStr="status";
		}
		if(sortDirection==null) {
			sortDirection="ASC";
		}
		
		OffsetLimitRequest pageable = new OffsetLimitRequest(4*(pageNo - 1), 4 , new Sort(Sort.Direction.fromString(sortDirection), sortStr)); 
		if (exp == null) {
			sellers = service.getAllSellersPageable(pageable);
		} else {
			sellers = service.getAllSellersPageableAndFiltered(pageable, exp);
		}
		mav.addObject("sellers", sellers.getContent());
		mav.addObject("noPages", sellers.getTotalPages());
		mav.setViewName("home");
		return mav;
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView showProductsList(@RequestParam(name = "sort", required = false) String sortStr,
			@RequestParam(name = "sortDirection", required = false) String sortDirection,
			@RequestParam(name = "page", required = false) Integer pageNo,
			@RequestParam(name = "filter", required = false) String filterStr,
			@RequestParam(name = "search", required = false) String search, HttpServletRequest req,
			HttpServletResponse res, HttpSession session) {
		if (session.getAttribute("user") == null) { // admin is not logged in.
			return new ModelAndView("redirect:/");
		}
		ModelAndView mav = new ModelAndView();
		BooleanExpression exp = null;
		Page<ProductDetails> products = null;
		ProductPredicatesBuilder builder = new ProductPredicatesBuilder();
		if (search != null) {
			Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
			Matcher matcher = pattern.matcher(search + ",");
			while (matcher.find()) {
				builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
			}
			exp = builder.build();
		}
		pageNo = (pageNo == null) ? 1 : pageNo; 
		if(sortStr==null) {
			sortStr="status";
		}
		if(sortDirection==null) {
			sortDirection="ASC";
		}
		
		OffsetLimitRequest pageable = new OffsetLimitRequest(4*(pageNo - 1), 4, new Sort(Sort.Direction.fromString(sortDirection), sortStr)); 
		if (exp == null) {
			products = service.getAllProductsPageable(pageable);
		} else {
			products = service.getAllProductsPageableAndFiltered(pageable, exp);
		}
		mav.addObject("products", products.getContent());
		mav.addObject("noPages", products.getTotalPages());
		mav.setViewName("products");
		return mav;
	}
	
	/**
	 * @param model
	 * @param id
	 * @param session
	 * @return seller's details page.
	 * 
	 */
	@RequestMapping(value = "/seller/{id}", method = RequestMethod.GET)
	public ModelAndView sellerPage(ModelAndView model, @PathVariable String id, HttpSession session) {
		if (session.getAttribute("user") == null) {
			return new ModelAndView("redirect:/");
		}
		SellerDetails seller = service.getSellerById(Integer.parseInt(id));
		
		model.addObject("seller", seller);
		model.setViewName("sellerPage");
		return model;

	}

	/**
	 * @param action
	 * @param selectedSeller
	 * @param model
	 * @param session
	 * @return products page
	 */
	@RequestMapping(value = "/actions", method = RequestMethod.POST)
	public ModelAndView actions(@RequestParam("action") String action,
			@RequestParam("selectedSeller") String[] selectedSeller, ModelMap model, HttpSession session) {
		if (session.getAttribute("user") == null) { //admin is not logged in.
			return new ModelAndView("redirect:/");
		}
		if (action.equals("approve")) { //approve the selected sellers.
			service.approve(selectedSeller);
		}
		else {
			service.reject(selectedSeller); //rejected the selected sellers.
		}
		return new ModelAndView("redirect:/home");
	}

	
	
	/**
	 * @param model
	 * @param id
	 * @param session
	 * @return product page 
	 * with details about the product.
	 */
	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	public ModelAndView productDetails(ModelAndView model, @PathVariable String id, HttpSession session) {
		
		if (session.getAttribute("user") == null) {
			return new ModelAndView("redirect:/");
		}
		ProductDetails product = service.getProductById(Integer.parseInt(id));
		List<CategoryDetails> categories = product.getCategories();
		model.addObject("categories", categories);
		model.addObject("product", product);
		model.setViewName("productDetail");
		return model;
	}
	
	@RequestMapping(value = "/category/add", method = RequestMethod.POST)
	public String addCategory(@RequestParam("category") String category, HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "redirect:/";
		}
		CategoryDetails categoryObj = new CategoryDetails();
		categoryObj.setCategoryName(category);
		service.addCategory(categoryObj);
		return "redirect:/category";
	}

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public String getCategoryPage(ModelMap model, HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "redirect:/";
		}
		List<CategoryDetails> categories = service.getCategories();
		model.addAttribute("categories", categories);
		return "category";
	}

	@RequestMapping(value = "/category/delete", method = RequestMethod.POST)
	public String deleteCategroy(@RequestParam("id") int categoryId, HttpSession session, ModelMap model) {
		if (session.getAttribute("user") == null) {
			return "redirect:/";
		}
		if (service.deleteCategory(categoryId)) {
			return "redirect:/category";
		} else {
			model.addAttribute("error", "Category contains products, can't delete it");
			return getCategoryPage(model, session);
		}
	}

	@RequestMapping(value = "/category/edit", method = RequestMethod.POST)
	public String editCategory(@RequestParam("id") int categoryId, @RequestParam("categoryName") String newName,
			HttpSession session, ModelMap model) {
		if (session.getAttribute("user") == null) {
			return "redirect:/";
		}
		service.editCategory(categoryId, newName);
		return "redirect:/category";
	}
}
