package com.app.dto;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
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



	@Override
	public List<BesicDetails> findAll() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<BesicDetails> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<BesicDetails> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public <S extends BesicDetails> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public <S extends BesicDetails> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public <S extends BesicDetails> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void deleteAllInBatch(Iterable<BesicDetails> entities) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public BesicDetails getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public BesicDetails getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public BesicDetails getReferenceById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public <S extends BesicDetails> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public <S extends BesicDetails> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Page<BesicDetails> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public <S extends BesicDetails> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Optional<BesicDetails> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}



	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void delete(BesicDetails entity) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void deleteAll(Iterable<? extends BesicDetails> entities) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public <S extends BesicDetails> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}



	@Override
	public <S extends BesicDetails> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public <S extends BesicDetails> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public <S extends BesicDetails> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public <S extends BesicDetails, R> R findBy(Example<S> example,
			Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}
}