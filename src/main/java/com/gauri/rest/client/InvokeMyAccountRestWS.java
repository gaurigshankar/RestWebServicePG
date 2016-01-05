package com.gauri.rest.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpClientConnection;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.gauri.rest.utils.JsonUtils;

public class InvokeMyAccountRestWS {

	public static void main(String[] args) {
		URL url;
		try {
			url = new URL("url value");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			HttpClient httpClient = HttpClientBuilder.create().build();

			HttpGet get = new HttpGet(url.toString());
			
			get.addHeader("headerName", "headerValue");
			
			HttpResponse response = httpClient.execute(get);
			int responseCode = response.getStatusLine().getStatusCode();
			
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);
		 
			BufferedReader rd = new BufferedReader(
		                new InputStreamReader(response.getEntity().getContent()));
		 
			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			
			
			//System.out.println(result);
			
			Map<String,Object> customerInfo = (Map<String, Object>) JsonUtils.deserialize(result.toString());
            String status = (String)customerInfo.get("status");
            Map<String,Object> personObject = ((Map)((Map)customerInfo.get("payload")).get("person"));
            List accounts = (List)personObject.get("accounts");
            Map<String,Object> account = (Map<String, Object>) accounts.get(0);
           Boolean isMigrated = (Boolean) account.get("isMigrated");
			System.out.println(isMigrated);
		
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
 
	}
}
