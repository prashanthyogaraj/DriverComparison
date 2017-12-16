package com.java.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.java.driver.FunctionMain;

//****************Discrepency Controller will be collecting all the input from GUI and Pass it to Fuction Main Class in com.java.driver********
@Controller
public class Discrepancy_controller {

	@RequestMapping(value="/home")
	public ModelAndView disc(){
		
		ModelAndView model = new ModelAndView("FrontPage1");
		return model;
	}
	@RequestMapping (value="/result", method = RequestMethod.POST)
	public ModelAndView getValue(@RequestParam(value = "url1") String url1,@RequestParam(value = "url2") String url2,@RequestParam(value = "dropdown") String dropdown,@RequestParam(value="cecid") String cec) throws InterruptedException, IOException{
		FunctionMain main = new FunctionMain();
		ModelAndView model = new ModelAndView("FrontPage1");
		main.getResult(dropdown, url1, url2, cec);
		return model.addObject("Success", "") ;
		

	}
	@RequestMapping (value="/result1", method = RequestMethod.POST)
	public ModelAndView getSingleOs(@RequestParam(value = "url1") String url1,@RequestParam(value = "url2") String url2,@RequestParam(value = "dropdown") String dropdown,@RequestParam(value="cecid") String cec,@RequestParam(value="newsel") String newsel,@RequestParam(value="newtext") String newtext) throws InterruptedException, IOException{
		FunctionMain main = new FunctionMain();
		ModelAndView model = new ModelAndView("FrontPage1");
	main.getIndosResult(dropdown, url1, url2, newsel, newtext,cec);
		return model.addObject("Success", "") ;
	}
	@RequestMapping (value="/singleos", method = RequestMethod.POST)
	public ModelAndView geteachos(@RequestParam(value = "url1") String url1,@RequestParam(value = "dropdown") String dropdown,@RequestParam(value="cecid") String cec,@RequestParam(value="newsel") String newsel,@RequestParam(value="newtext") String newtext) throws InterruptedException, IOException{
		System.out.println("inside os controller");
		FunctionMain main = new FunctionMain();
		ModelAndView model = new ModelAndView("FrontPage1");
		System.out.println("drop is"+dropdown+"url1 is"+url1+"newsel is"+newsel+"text is"+newtext+"cec is"+cec);
		main.getindos(dropdown, url1, newsel, newtext, cec);
		
		return model.addObject("Success", "") ;
	}
	@RequestMapping (value="/clear", method = RequestMethod.POST)
	public ModelAndView cleartextFile(@RequestParam(value = "dropdown") String dropdown,@RequestParam(value="cecid") String cec) throws InterruptedException, IOException{
		FunctionMain main = new FunctionMain();
		ModelAndView model = new ModelAndView("clear");
		main.clearText(dropdown, cec);
		return model.addObject("Success", "Text Files Cleared Successfully") ;
	}
	@RequestMapping (value="/adapter", method = RequestMethod.POST)
	public ModelAndView indAdapter(@RequestParam(value = "url1") String url1,@RequestParam(value = "url2") String url2,@RequestParam(value ="textvendor") String textvendor,@RequestParam(value="cecid")String cec) throws InterruptedException, IOException{
		FunctionMain main = new FunctionMain();
		ModelAndView model = new ModelAndView("Adapter");
		System.out.println("input is"+textvendor);
		main.getIndAdapterdetail(url1,url2,textvendor, cec);
		return model.addObject("Success", "");
		
	}
}
