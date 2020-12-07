package com.cg.onlinecorona.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.cg.onlinecorona.entities.Room;
import com.cg.onlinecorona.exception.ResourceNotFoundException;
/**
 * 
 * @author AKSHITHA
 *
 */
@Service
public interface RoomService {
	
public List<Room> checkAvail(String type);
public Room findById(String data);
public Room save(Room data);
public List<Room> findAll();
public Room update(String v,Room data) throws ResourceNotFoundException;
}
