package com.gauri.rest.poc;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gauri.rest.poc.data.InputData;
import com.gauri.rest.poc.data.Payload;

//import com.google.gson.Gson;

@Path("/accountServices")
public class ModifyMigratedFlag {
	
	@Path("/customer/{cId}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public String resetMigratedFlag(@PathParam("cId") String customerId,InputData inputData){
	 String response = null;
        try{
        	System.out.println("customerID:: " +customerId);
        	if(inputData!=null){
        	System.out.println(inputData.getPayload().getPerson().getAccounts()[0].getIsMigrated());
        	if(!inputData.getPayload().getPerson().getAccounts()[0].getIsMigrated()){
        		return "{ \"flag\":\"false\"}";
        	}
        	}
        	
        	
        	
      } catch (Exception e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
      }
       // Gson gson = new Gson();
  
        return "{ \"flag\":\"true\"}";
    }
}
