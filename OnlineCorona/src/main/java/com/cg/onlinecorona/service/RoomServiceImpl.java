package com.cg.onlinecorona.service;


import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.onlinecorona.entities.Room;
import com.cg.onlinecorona.exception.ResourceNotFoundException;
import com.cg.onlinecorona.repository.RoomDao;
/**
 * Desc : RoomServiceImpl implements RoomService interface
 * @author AKSHITHA
 *
 */
@Service
@Transactional
public class RoomServiceImpl implements RoomService{
	
	
@Autowired
private RoomDao dao;

/**
 * Desc : checkAvailability method
 */
	@Override
	public List<Room> checkAvail(String type) {
		
		return dao.findAll();
	}
	
public Room findById(String data)
{
	return dao.findById(data).get();
}
public Room save(Room data)
{
	return dao.save(data);
}
/**
 * Desc : update method
 */
@Override
public Room update(String v, Room data) throws ResourceNotFoundException {

	Logger logger=Logger.getLogger(RoomServiceImpl.class);
	logger.debug("Running");
	Room d=dao.findById(v)
			.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " +v));

			
d.setRoomPrice(data.getRoomPrice());
d.setRoomType(data.getRoomType());
//d.setRoomId(data.getRoomId());
dao.save(d);
System.out.println(d.toString());
return d;
}
public List<Room> findAll()
{
	return dao.findAll();}
}
