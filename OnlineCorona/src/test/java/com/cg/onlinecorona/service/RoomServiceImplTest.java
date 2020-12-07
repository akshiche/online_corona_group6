package com.cg.onlinecorona.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.onlinecorona.entities.Room;
import com.cg.onlinecorona.repository.RoomDao;

@RunWith(SpringRunner.class)
@SpringBootTest
class RoomServiceImplTest {

	  @MockBean
	    private RoomDao Dao;

	    @Autowired
	    private RoomService Service;
	   
	    @Test
	     void testCreateRoom(){
	    	 Room data= new Room();
		        data.setRoomId("1");
		        data.setRoomPrice(200);
		        data.setRoomType("single");

	        Mockito.when(Dao.save(data)).thenReturn(data);
	        assertThat(Service.save(data)).isEqualTo(data);
	    }
	    @Test
	     void testCheckAvali()
	    {
	    	List<Room> vk=new ArrayList<Room>();
	    	Room data =new Room();
	    	data.setRoomId("1");
	        data.setRoomPrice(200);
	        data.setRoomType("single");
vk.add(Dao.save(data));
Room data1 =new Room();
data1.setRoomId("2");
data1.setRoomPrice(200);
data1.setRoomType("single");
vk.add(Dao.save(data1));
//List<Room> v=Dao.findAll();
System.out.println(vk.size());

Mockito.when(Dao.findByRoomType("single")).thenReturn(vk);
assertEquals(2,vk.size());
	    }
	    @Test
	     void testUpdateTicket() throws Exception{

	    	 Room data= new Room();
		        data.setRoomId("2");
		        data.setRoomPrice(25);
		        data.setRoomType("double");
	      //  Mockito.when(Dao.findById("2").get()).thenReturn(data);
	        Mockito.when(Dao.findById("2"))
	         .thenReturn(Optional.ofNullable(data));
	        data.setRoomPrice(25);
	        Mockito.when(Dao.save(data)).thenReturn(data);
	        System.out.println(data.getRoomPrice());
	      //  assertThat(Service.save(data)).isEqualTo(data);
	        assertThat(Service.update("2", data)).isEqualTo(data);
	    }
}
