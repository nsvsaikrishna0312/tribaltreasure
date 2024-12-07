package com.klef.jfsd.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.klef.jfsd.project.model.Artisan;
import com.klef.jfsd.project.repository.ArtisanRepository;


@Service
public class ArtisanServiceImpl implements ArtisanService{
	
	@Autowired
	private ArtisanRepository artisanRepository;
	
	
	@Override
	public ResponseEntity<String> artisanregistration(Artisan aa) {
		artisanRepository.save(aa);
		return ResponseEntity.ok("registered successfully");
	}

	@Override
	public Artisan checkartisanlogin(String aausername,String aapassword) {
		return artisanRepository.checkartisanlogin(aausername, aapassword);
	}

}
