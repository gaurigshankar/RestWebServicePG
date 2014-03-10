package com.gauri.rest.poc;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gauri.rest.poc.data.InputData;
import com.gauri.rest.poc.data.Payload;

//import com.google.gson.Gson;

@Path("/flag")
public class ModifyMigratedFlag {
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public String resetMigratedFlag(InputData inputData){
	 String response = null;
        try{
        	if(inputData!=null){
        	System.out.println(inputData.getPayload().getPerson().getAccounts()[0].getIsMigrated());
        	}
        	
        	
        	
      } catch (Exception e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
      }
       // Gson gson = new Gson();
  
        return "{ \"json\":\"value\"}";
    }
}
