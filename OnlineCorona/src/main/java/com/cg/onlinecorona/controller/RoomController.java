package com.cg.onlinecorona.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinecorona.entities.Room;
import com.cg.onlinecorona.exception.ResourceNotFoundException;
import com.cg.onlinecorona.repository.RoomDao;
import com.cg.onlinecorona.service.RoomService;
/**
 * Desc:controller for room entity is implemented
 * @author AKSHITHA
 *
 */
@RestController
@RequestMapping("/api/v2")
public class RoomController {
//static data
	@Autowired
	private RoomDao dao;
	@Autowired
	private RoomService service;
	/**
	 * this method is used for checking the availability of rooms based on type
	 * @param type
	 * @return available rooms
	 */
	@GetMapping("/Room1/{type}")
	public ResponseEntity<String> checkAvaliablity(@PathVariable(value = "type") String type)
	{
		
		List<Room> v= service.checkAvail(type);
		List<Room> s=new ArrayList<>();
		for(Room c:v)
		{
			if(c.getRoomType().equals(type) && (type.equals("single")|| type.equals("double")))
			{
				s.add(c);
				System.out.println(s);
				
				
			}
		}
		if(s.size()<10 && (type.equals("single") || type.equals("double")))
		{
			int x=s.size();
			System.out.println(x);
			return ResponseEntity.ok().body("the avalible "+(10-x)+"rooms");
		}
		else if (type.equals("single") || type.equals("double")) 
		{
			return ResponseEntity.ok().body("this "+type+"of rooms not availbe");
		}
		else
		{
			return ResponseEntity.ok().body("Invalid Room type");
		}

		
	}
/**
 * 	this method is used for displaying availability of rooms 
 * @return list of rooms
 */

	@GetMapping("/data1")
	public List<Room> view()
	{
	return service.findAll();
	}
	/**
	 * update the rooms based on the roomId
	 * @param roomId
	 * @param data
	 * @return updated details
	 * @throws ResourceNotFoundException
	 */
	
	@PutMapping("/data/{roomId}")
	public ResponseEntity<Room> updateRooms(@PathVariable(value = "roomId") String roomId,
			 @RequestBody Room data) throws ResourceNotFoundException {
		
		Room kk=service.update(roomId,data);
		return ResponseEntity.ok(kk);
	}
	
	
	
}
