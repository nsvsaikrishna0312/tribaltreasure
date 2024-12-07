package com.klef.jfsd.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.klef.jfsd.project.model.CulturalConsultant;
import com.klef.jfsd.project.repository.CulturalConsultantRepository;


@Service
public class CulturalConsultantServiceImpl implements CulturalConsultantService{
	
	@Autowired
	private CulturalConsultantRepository culturalconsultantRepository;

	
	@Override
	public ResponseEntity<String> culturalconsultantregistration(CulturalConsultant cc) {
		culturalconsultantRepository.save(cc);
		return ResponseEntity.ok("registered successfully");
	}

	@Override
	public CulturalConsultant checkculturalconsultantlogin(String ccusername,String  ccpassword) {
		return culturalconsultantRepository.checkculturalconsultantlogin(ccusername, ccpassword);
	}

}
