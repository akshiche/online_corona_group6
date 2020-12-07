package com.cg.onlinecorona.repository;



import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.onlinecorona.entities.Room;
import com.cg.onlinecorona.repository.RoomDao;


@RunWith(SpringRunner.class)
@DataJpaTest
class RoomDaoTest {
	@Autowired
	private RoomDao dao;
	  @Autowired
	    private TestEntityManager testEntityManager;

	    @Test
	     void testUpdateTicket(){

	        Room data= new Room();
	       data.setRoomId("1");
	       data.setRoomPrice(200);
	       data.setRoomType("single");
	        testEntityManager.persist(data);

	       Room getFromDb = dao.findById("1").get();
	        getFromDb.setRoomPrice(2000);
	        testEntityManager.persist(getFromDb);

	        assertThat(getFromDb.getRoomPrice()).isEqualTo(2000);
	    }
	   @Test
	     void testAvaliablity() throws Exception{
	        Room data = new Room();
	       data.setRoomId("2");
	       data.setRoomPrice(2);
	       data.setRoomType("single");

	        Room saveInDb = testEntityManager.persist(data);
	        Room getInDb = dao.findById(saveInDb.getRoomId()).get();

	        Assert.assertEquals(saveInDb.getRoomType(), getInDb.getRoomType());
	    }
}
