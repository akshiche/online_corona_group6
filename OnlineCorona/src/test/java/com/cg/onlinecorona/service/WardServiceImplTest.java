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

import com.cg.onlinecorona.entities.Ward;
import com.cg.onlinecorona.repository.WardDAO;


@RunWith(SpringRunner.class)
@SpringBootTest
class WardServiceImplTest {

	  @MockBean
	    private WardDAO Dao;

	    @Autowired
	    private WardService Service;
	   
	    @Test
	    void testCreateTicket(){
	    	 Ward data= new Ward();
		        data.setWardId("1");
		        data.setWardPrice(300);
		        data.setWardtype("ICU");

	        Mockito.when(Dao.save(data)).thenReturn(data);
	        assertThat(Service.save(data)).isEqualTo(data);
	    }
	    @Test
	     void testCheckAvali()
	    {
	    	List<Ward> vk=new ArrayList<Ward>();
	    	Ward data =new Ward();
	    	data.setWardId("1");
	        data.setWardPrice(500);
	        data.setWardtype("ICU");
vk.add(Dao.save(data));
Ward data1 =new Ward();
data1.setWardId("2");
data1.setWardPrice(500);
data1.setWardtype("ICU");
vk.add(Dao.save(data1));
//List<Ward> v=Dao.findAll();
System.out.println(vk.size());

Mockito.when(Dao.findByWardType("ICU")).thenReturn(vk);
assertEquals(2,vk.size());
	    }
	    @Test
	    public void testUpdateTicket() throws Exception{

	    	 Ward data= new Ward();
		      data.setWardId("2");
		      data.setWardPrice(25);
		        data.setWardtype("ICU");
	      //  Mockito.when(Dao.findById("2")).thenReturn(data);
	       // Mockito.when(Dao.findById("2"))
	        // .thenReturn(Optional.ofNullable(data));
	        data.setWardPrice(500);
	    data.setWardId("2");
	    data.setWardtype("ICU");
	        Mockito.when(Dao.save(data)).thenReturn(data);
	        System.out.println(data.getWardPrice());
	        //assertThat(Service.save(data)).isEqualTo(data);
	        //assertThat(Service.update("2", data)).isEqualTo(data);
	    }
}
