package com.cg.onlinecorona.service;


import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.onlinecorona.entities.Ward;
import com.cg.onlinecorona.exception.ResourceNotFoundException;
import com.cg.onlinecorona.repository.WardDAO;
/**
 * Desc : WardServiceImpl implements WardService interface
 * @author AKSHITHA
 *
 */
@Service
@Transactional
public class WardServiceImpl implements WardService{
	
	
@Autowired
private WardDAO repositoryLayer;

	@Override
	public List<Ward> checkAvail(String type) {
		
		return repositoryLayer.findAll();
	}
	@Override
public Ward findById(String data)
{
	return repositoryLayer.findById(data).get();
}
	@Override
public Ward save(Ward data)
{
	return repositoryLayer.save(data);
}
@Override
public Ward update(String v, Ward data) throws ResourceNotFoundException {

	Logger logger=Logger.getLogger(RoomServiceImpl.class);
	logger.debug("Running");
	Ward d=repositoryLayer.findById(v)
			.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " +v));

			
d.setWardPrice(data.getWardPrice());
//d.setWardtype(data.getWardtype());
//d.setWardId(data.getWardId());
repositoryLayer.save(d);
System.out.println(d.toString());
return d;
}
public List<Ward> findAll()
{
	return repositoryLayer.findAll();}
}
