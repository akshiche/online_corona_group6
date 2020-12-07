package com.cg.onlinecorona.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.cg.onlinecorona.entities.Room;

class RoomTest {

	@Test
	void datatest() {
		Room data=new Room();
		data.setRoomId("1");
		data.setRoomPrice(100);
		data.setRoomType("single");
		assertNotNull(data);
	}
 @Test
 void roomIdtest()
 {
	 Room data=new Room();
		data.setRoomId("1");
		assertNotNull(data.getRoomId());
 }
 @Test
 void roomTypeTest()
 {
	 Room data=new Room();
		data.setRoomType("single");
		assertNotNull(data.getRoomType());
 }
 @Test
 void roomPriceTest()
 {
	 Room data=new Room();
		data.setRoomPrice(100);
		assertEquals(100,data.getRoomPrice());
 }
 @Test
 void roomIdNulltest()
 {
	 Room data=new Room();
		data.setRoomId(null);
		assertNull(data.getRoomId());
 }
 @Test
 void roomTypeNullTest()
 {
	 Room data=new Room();
		data.setRoomType(null);
		assertNull(data.getRoomType());
 }
 @Test
 void roomNullTest()
 {
	 Room data=new Room();
		data.setRoomType(null);
		assertNull(data.getRoomType());
 }
 @Test
 void roomPriceNullTest()
 {
	 Room data=new Room();
		data.setRoomPrice(1);
		assertEquals(1,data.getRoomPrice());
 }
}
