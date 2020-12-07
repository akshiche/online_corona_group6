package com.cg.onlinecorona.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.onlinecorona.entities.Ward;
import com.cg.onlinecorona.repository.WardDAO;
import com.cg.onlinecorona.service.WardService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value=WardController.class)

class WardControllerTest{
	  @Autowired
	   private MockMvc mockMvc;
	 @MockBean
	  private WardService Serviceimpl;
	 
        @MockBean
        private WardDAO dao;
	   
	@Test
     void CheckAvali() throws Exception
	{
        String URI = "/api/v2/data1";
       // Ward data = new Ward();
        Ward data =new Ward();
    	data.setWardId("1");
        data.setWardPrice(500);
        data.setWardtype("ICU");

        Ward data1 =new Ward();
    	data1.setWardId("2");
        data1.setWardPrice(500);
        data1.setWardtype("ICU");

        List<Ward> ticketList = new ArrayList<>();
        ticketList.add(data);
        ticketList.add(data1);
        String jsonInput = this.converttoJson(ticketList);

        Mockito.when(dao.findAll()).thenReturn(ticketList);
        
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        int count=0;
        for(Ward l:ticketList)
        {
        	if(l.getWardtype().equals("ICU"))
        	{
        		count++;
        	}
        }
assertEquals(2,count);

       // assertThat(jsonInput).isEqualTo(jsonOutput);
    }

	   private String converttoJson(Object ticket) throws JsonProcessingException {
	        ObjectMapper objectMapper = new ObjectMapper();
	        return objectMapper.writeValueAsString(ticket);
	    }
	   
	   @Test
	    void testUpdateStock() throws Exception
	   {
		   String URI="/api/v2/data/{wardId}";
		   Ward r=new Ward();
		   r.setWardId("1");
		   r.setWardPrice(550);
		   r.setWardtype("ICU");
		   String jsonInput=this.converttoJson(r);
		   Mockito.when(Serviceimpl.findById("1")).thenReturn(r);
		   System.out.println(r);
		   MvcResult mvcresult=this.mockMvc.perform(MockMvcRequestBuilders.put(URI,"1").content(jsonInput).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andReturn();
		   System.out.println("thslkl"+mvcresult);
	   MockHttpServletResponse mockHttpServletresponse=mvcresult.getResponse();
	   System.out.println(mockHttpServletresponse);
	   String jsonoutput=mockHttpServletresponse.getContentAsString();
	   System.out.println(jsonoutput);
	   assertEquals(HttpStatus.NOT_FOUND.value(), mockHttpServletresponse.getStatus());
	  // assertThat(jsonInput).isEqualTo(jsonoutput);
	   }
	  
}