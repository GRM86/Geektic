package com.mg;

import java.sql.SQLException;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
@RequestMapping("/test")
public class Controller {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView indexJSp() throws SQLException{
	
		ModelAndView mav = new ModelAndView("test.jsp");
		mav.addObject("interets", Service.getUser("1"));
		return mav;
	}
	
}