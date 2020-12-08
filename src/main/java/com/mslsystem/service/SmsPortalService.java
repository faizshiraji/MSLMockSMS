package com.mslsystem.service;

import com.mslsystem.entity.SmsPortal;

public interface SmsPortalService {

	void save(SmsPortal smsPortal);

	SmsPortal findBySmsPortal(String msisdn);

}
