package com.cg.onlinecorona.repository;



import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;


import com.cg.onlinecorona.entities.Ward;
import com.cg.onlinecorona.repository.WardDAO;




@RunWith(SpringRunner.class)
@DataJpaTest
class WardDaoTest {
	@Autowired
	private WardDAO dao;
	  @Autowired
	    private TestEntityManager testEntityManager;

	    @Test
	     void testUpdateTicket(){

	        Ward data= new Ward();
	       data.setWardId("1");
	       data.setWardPrice(200);
	       data.setWardtype("ICU");
	        testEntityManager.persist(data);

	        Ward getFromDb = dao.findById("1").get();
	        getFromDb.setWardPrice(2000);
	        testEntityManager.persist(getFromDb);

	        assertThat(getFromDb.getWardPrice()).isEqualTo(2000);
	    }
	   @Test
	     void testAvaliablity() throws Exception{
	        Ward data = new Ward();
	       data.setWardId("2");
	       data.setWardPrice(2);
	       data.setWardtype("ICU");

	       Ward saveInDb = testEntityManager.persist(data);
	       Ward getInDb = dao.findById(saveInDb.getWardId()).get();

	        Assert.assertEquals(saveInDb.getWardtype(), getInDb.getWardtype());
	    }
}
