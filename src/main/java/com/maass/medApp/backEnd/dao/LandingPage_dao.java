package com.maass.medApp.backEnd.dao;

import java.util.List;

import com.maass.medApp.backEnd.Beans.OurDoctorsBean;

public interface LandingPage_dao {
	public List<OurDoctorsBean> getDoctorReccomendations();
}
