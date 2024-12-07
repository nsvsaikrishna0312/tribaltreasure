package com.klef.jfsd.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.project.model.Artisan;

@Repository
public interface ArtisanRepository extends JpaRepository<Artisan,Integer>{
	
	@Query("select aa from Artisan aa where aa.aausername=?1 and aa.aapassword=?2")
	public Artisan checkartisanlogin(String aausername,String aapassword);

}
