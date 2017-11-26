package com.maass.medApp.backEnd.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maass.medApp.backEnd.Beans.OurDoctorsBean;
import com.maass.medApp.backEnd.Collections.MedApp_client_ourDoctors;
import com.maass.medApp.backEnd.Repositories.MedApp_client_ourDoctors_Repository;
import com.maass.medApp.backEnd.dao.LandingPage_dao;

@Service
public class LandingPage_daoImpl implements LandingPage_dao {
	
	@Autowired
	private MedApp_client_ourDoctors_Repository medApp_client_ourDoctors_Repository;
	
	public List<OurDoctorsBean> getDoctorReccomendations(){
		List<OurDoctorsBean> doctorsBeans = null;
		List<MedApp_client_ourDoctors> ourDoctorsBeans = null;
		try{
			ourDoctorsBeans = medApp_client_ourDoctors_Repository.findAll();
			doctorsBeans = new ArrayList<OurDoctorsBean>();
			for(MedApp_client_ourDoctors doc: ourDoctorsBeans){
				OurDoctorsBean tempBean = new OurDoctorsBean();
				tempBean.setName(doc.name);
				tempBean.setQualification(doc.qualification);
				tempBean.setRecomendationQuote(doc.recomendationQuote);
				tempBean.setImageUrl(doc.imageUrl);
				doctorsBeans.add(tempBean);
			}
		}catch(Exception exp){
			exp.printStackTrace();
		}
		return doctorsBeans;
	}
	
}
