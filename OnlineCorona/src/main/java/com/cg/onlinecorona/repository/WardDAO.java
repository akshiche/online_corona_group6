package com.cg.onlinecorona.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.onlinecorona.entities.Ward;
/**
 * Desc : WardDao interface is created which extends JpaRepository
 * @author AKSHITHA
 *
 */
@Repository
public interface WardDAO extends JpaRepository<Ward,String>{
//	@Query("select t from wards t where t.type=(:type)")
	@Query(value="select t from wards t where t.type=:type",nativeQuery=true)
	List<Ward> findByWardType(@Param("type") String type);



}
