package com.cg.onlinecorona.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.onlinecorona.entities.Room;
/**
 * Desc : RoomDao interface is created which extends JpaRepository
 * @author AKSHITHA
 *
 */
@Repository
public interface RoomDao extends JpaRepository<Room,String>{
//	@Query("select t from rooms t where t.type=(:type)")
	@Query(value="select t from rooms t where t.type=:type",nativeQuery=true)
	List<Room> findByRoomType(@Param("type") String type);



}
