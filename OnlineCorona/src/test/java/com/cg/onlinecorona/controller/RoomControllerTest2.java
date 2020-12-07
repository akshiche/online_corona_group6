package com.cg.onlinecorona.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
import com.cg.onlinecorona.entities.Room;
import com.cg.onlinecorona.repository.RoomDao;
import com.cg.onlinecorona.service.RoomService;
import com.cg.onlinecorona.service.RoomServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value=RoomController.class)

class RoomControllerTest{
	  @Autowired
	   private MockMvc mockMvc;
	 @MockBean
	  private RoomService Serviceimpl;
	 
        @MockBean
        private RoomDao dao;
	   
	@Test
     void CheckAvali() throws Exception
	{
        String URI = "/api/v2/data1";
       // Room data = new Room();
        Room data =new Room();
    	data.setRoomId("1");
        data.setRoomPrice(500);
        data.setRoomType("single");

        Room data1 =new Room();
    	data1.setRoomId("4");
        data1.setRoomPrice(200);
        data1.setRoomType("single");

        List<Room> ticketList = new ArrayList<>();
        ticketList.add(data);
        ticketList.add(data1);
        String jsonInput = this.converttoJson(ticketList);
        assertNotNull(jsonInput);

//        Mockito.when(dao.findAll()).thenReturn(ticketList);
//        
//        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andReturn();
//        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
//        String jsonOutput = mockHttpServletResponse.getContentAsString();
//        System.out.println(jsonOutput);
//        int count=0;
//        for(Room l:ticketList)
//        {
//        	if(l.getRoomType().equals("single"))
//        	{
//        		count++;
//        	}
//        }
//
//assertNull(jsonInput);
       // assertThat(jsonInput).isEqualTo(jsonOutput);
    }

	   private String converttoJson(Object ticket) throws JsonProcessingException {
	        ObjectMapper objectMapper = new ObjectMapper();
	        return objectMapper.writeValueAsString(ticket);
	    }
	   
	   @Test
	    void testUpdateStock() throws Exception
	   {
		   String URI="/api/v2/data/{roomId}";
		   Room r=new Room();
		   r.setRoomId("2");
		   r.setRoomPrice(200);
		   r.setRoomType("single");
		   String jsonInput=this.converttoJson(r);
		   Mockito.when(Serviceimpl.findById("2")).thenReturn(r);
		   System.out.println(r);
		   MvcResult mvcresult=this.mockMvc.perform(MockMvcRequestBuilders.put(URI,"2").content(jsonInput).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andReturn();
		   System.out.println("thslkl"+mvcresult);
	   MockHttpServletResponse mockHttpServletresponse=mvcresult.getResponse();
	   System.out.println(mockHttpServletresponse);
	   String jsonoutput=mockHttpServletresponse.getContentAsString();
	   System.out.println(jsonoutput);
	   assertEquals(HttpStatus.OK.value(), mockHttpServletresponse.getStatus());
	   //assertThat(jsonInput).isEqualTo(jsonoutput);
	   }
	   
}