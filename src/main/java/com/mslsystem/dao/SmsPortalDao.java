package com.mslsystem.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mslsystem.entity.SmsPortal;

@RepositoryRestResource
public interface SmsPortalDao extends CrudRepository<SmsPortal, Integer> {
	
	List<SmsPortal> findByMsisdn(String msisdn);
}
