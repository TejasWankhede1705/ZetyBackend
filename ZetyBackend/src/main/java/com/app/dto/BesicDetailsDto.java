package com.app.dto;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.app.custum_exception.RersourseNotFoundException;
import com.app.dao.BesicDetailsDao;
import com.app.entity.BesicDetails;

@Repository
@Transactional
public class BesicDetailsDto implements BesicDetailsDao{

	@Autowired
    private SessionFactory sessionFactory;
	boolean flag;

    @Override
    public boolean addBasicDetails(BesicDetails basicDetails) {
    	try {
            System.out.println("Adding BasicDetails: " + basicDetails);
            Session session = sessionFactory.getCurrentSession();
            session.save(basicDetails);
            flag=true;
    	}
    	catch(RersourseNotFoundException e) {
    		e.printStackTrace();
    		flag=false;
    	}
        return flag;
    }

   

    @Override
    public List<BesicDetails> getAllBasicDetails() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from BesicDetails", BesicDetails.class).list();
    }
    @Override
    public BesicDetails getBasicDetailsById(Long id) {
        return sessionFactory.getCurrentSession().get(BesicDetails.class, id);
    }
}