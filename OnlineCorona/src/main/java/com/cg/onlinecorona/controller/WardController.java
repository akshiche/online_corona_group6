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

import com.cg.onlinecorona.entities.Ward;
import com.cg.onlinecorona.exception.ResourceNotFoundException;
import com.cg.onlinecorona.repository.WardDAO;
import com.cg.onlinecorona.service.WardService;
/**
 * Desc : controller for ward entity is implemented
 * @author AKSHITHA
 *
 */
@RestController
@RequestMapping("/api/v1")
public class WardController {
 //static data
	@Autowired
	private WardDAO dao;
	@Autowired
	private WardService service;
	/**
	 * this method is used for checking the availability of wards based on type
	 * @param type
	 * @return available wards
	 */
	@GetMapping("/Ward1/{type}")
	public ResponseEntity<String> checkAvaliablity(@PathVariable(value = "type") String type)
	{
		
		List<Ward> v= service.checkAvail(type);
		List<Ward> s=new ArrayList<>();
		for(Ward c:v)
		{
			if((c.getWardtype().equals(type)))
			{
				s.add(c);
				
				
			}
		}
		if(s.size()<5 && type.equals("ICU"))
		{
			int x=s.size();
			return ResponseEntity.ok().body("the avalible "+(5-x)+"wards");
		}
		else if (type.equals("ICU") ) 
		{
			return ResponseEntity.ok().body("this "+type+"of wards not availbe");
		}
		else
		{
			return ResponseEntity.ok().body("Invalid Room type");
		}

		
	}
	/**
	 * this method is used for displaying availability of wards
	 * @return list of wards
	 */

	@GetMapping("/data1")
	public List<Ward> view()
	{
	return service.findAll();
	}
	/**
	 * update the wards based on the wardId
	 * @param wardId
	 * @param wardData
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@PutMapping("/data/{wardId}")
	public ResponseEntity<Ward> updateWards(@PathVariable(value = "wardId") String wardId,
			 @RequestBody Ward wardData) throws ResourceNotFoundException {
		Ward kk=service.update(wardId,wardData);
		return ResponseEntity.ok(kk);
	}
	
	
	
}
