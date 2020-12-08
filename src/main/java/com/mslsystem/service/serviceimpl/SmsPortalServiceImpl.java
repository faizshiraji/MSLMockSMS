package com.mslsystem.service.serviceimpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mslsystem.dao.SmsPortalDao;
import com.mslsystem.entity.SmsPortal;
import com.mslsystem.service.SmsPortalService;

@Service
@Transactional
public class SmsPortalServiceImpl implements SmsPortalService {

	@Autowired
	private SmsPortalDao smsPortalDao;
	
	@Override
	public SmsPortal findBySmsPortal(String msisdn) {
		return (SmsPortal) smsPortalDao.findByMsisdn(msisdn);
	}

	
	
	@Override
	public void save(SmsPortal smsPortal) {
		smsPortalDao.save(smsPortal);
	}


}
