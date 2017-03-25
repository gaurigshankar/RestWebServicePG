package com.gauri.rest.poc;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.gauri.indexer.Indexer;
import com.gauri.rest.poc.data.InputData;
import com.gauri.rest.poc.data.Payload;

//import com.google.gson.Gson;

@Path("/accountServices")
public class ModifyMigratedFlag {

	private static int staticCounter = 0;

	@Path("/customer/{cId}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public String resetMigratedFlag(@PathParam("cId") String customerId, InputData inputData) {
		String response = null;
		try {
			System.out.println("customerID:: " + customerId);
			if (inputData != null) {
				System.out.println(inputData.getPayload().getPerson().getAccounts()[0].getIsMigrated());
				if (!inputData.getPayload().getPerson().getAccounts()[0].getIsMigrated()) {
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

	@Path("/suresh")
	@GET
	@Produces("application/json")
	public String sureshMethod(@Context UriInfo info) {
		//String tracking = info.getQueryParameters().getFirst("tracking");
		int counter = ModifyMigratedFlag.staticCounter;
		//if (tracking.equalsIgnoreCase("true")) {
			counter = ModifyMigratedFlag.incrementCounter();
		//}
		

		return "hello word" + counter;
	}

	public static int incrementCounter() {
		// ModifyMigratedFlag.staticCounter ++;
		return ModifyMigratedFlag.staticCounter++;
	}
	
	 

}
