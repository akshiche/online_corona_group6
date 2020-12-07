package com.cg.onlinecorona.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.cg.onlinecorona.entities.Ward;
import com.cg.onlinecorona.exception.ResourceNotFoundException;
/**
 * 
 * @author AKSHITHA
 *
 */
@Service
public interface WardService {
public List<Ward> checkAvail(String type);
public Ward findById(String data);
public Ward save(Ward data);
public List<Ward> findAll();
public Ward update(String v,Ward data) throws ResourceNotFoundException;
}
