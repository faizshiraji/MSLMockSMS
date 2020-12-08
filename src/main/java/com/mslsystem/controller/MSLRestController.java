package com.mslsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mslsystem.dao.SmsPortalDao;
import com.mslsystem.entity.SmsPortal;
import com.mslsystem.service.serviceimpl.SnowFlacks;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class MSLRestController {

	private SmsPortalDao smsPortalDao;
	
	@Autowired
	MSLRestController(SmsPortalDao smsPortalDao) {
		this.smsPortalDao = smsPortalDao;
	}

	@Autowired
	private SnowFlacks snowFlacks;

	@RequestMapping(value = "/messages/{id}", method = RequestMethod.GET)
	public SmsPortal getMSmsPortal(@PathVariable("id") int id) {
		return smsPortalDao.findById(id).get();
	}
	
	@RequestMapping(value = "/messages", method = RequestMethod.GET)
	public Iterable<SmsPortal> getSmsPortals() {
		return smsPortalDao.findAll();
	}
	
	@RequestMapping(value = "/smsupdate", method = RequestMethod.POST)
	public SmsPortal updateSmsPortal(@RequestBody SmsPortal smsUpdate) {
		SmsPortal smsPortal = smsPortalDao.findById(smsUpdate.getId()).get();
		
		smsPortal.setClientTranId(smsUpdate.getClientTranId());
		return smsPortalDao.save(smsPortal);
		
	}
}
