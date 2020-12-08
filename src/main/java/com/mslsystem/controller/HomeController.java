package com.mslsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mslsystem.entity.SmsPortal;
import com.mslsystem.service.SmsPortalService;
import com.mslsystem.service.serviceimpl.SnowFlacks;

@Controller
public class HomeController {

	@Autowired
	private SmsPortalService smsPortalService;
	
	@Autowired
	private SnowFlacks snowFlacks;
	
	@RequestMapping("")
	public String Home() {
		
		return "redirect:/index";
	}
	
	@RequestMapping("/index")
	public String Index() {
		
		return "index";
	}
	
	@RequestMapping(value = "/smssend", method = RequestMethod.POST)
	public String smsPost(@ModelAttribute("smsportal") SmsPortal smsPortal, Model model) {

		
		if (smsPortal != null) {
			long nextId = snowFlacks.nextId();
			
			long checkTranId = smsPortal.getTranId();
			if (nextId != checkTranId) {
				smsPortal.setTranId(nextId);
			}
			
			smsPortalService.save(smsPortal);
			model.addAttribute("msg", "Your Message Successfully Submitted.");
		} else {
			model.addAttribute("msg", "Your Message Is Blank.");
		}

			return "redirect:/";
		
	}
	
	@RequestMapping("/snowtest")
	public String snowTest() {
		long nextId = snowFlacks.nextId();
		System.out.println(nextId);

		return "index";
		
	}
}
