package Clients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.Assignment;
import models.Student;

public class AssigClient {
	public static void postAssig(String deadline, String desc, Long labId, String name) {

	  	  try {

	  		DefaultHttpClient httpClient = new DefaultHttpClient();
	  		HttpPost postRequest = new HttpPost(
	  			"http://localhost:8080/assignments/saveAssignment");

	  		StringEntity input = new StringEntity("{ " + 
	  				"   \"deadline\": \""+deadline+"\", " + 
	  				"   \"description\": \""+desc+"\", " + 
	  				"   \"laboratoryId\": "+labId+", " + 
	  				"   \"name\": \""+name+"\" " + 
	  				" }") ;
	  		input.setContentType("application/json");
	  		postRequest.setEntity(input);

	  		HttpResponse response = httpClient.execute(postRequest);

	  		if (response.getStatusLine().getStatusCode() != 200) {
	  			throw new RuntimeException("Failed : HTTP error code : "
	  				+ response.getStatusLine().getStatusCode());
	  		}

	  		BufferedReader br = new BufferedReader(
	                          new InputStreamReader((response.getEntity().getContent())));

	  		String output;
	  		System.out.println("Output from Server .... \n");
	  		while ((output = br.readLine()) != null) {
	  			System.out.println(output);
	  		}

	  		httpClient.getConnectionManager().shutdown();

	  	  } catch (MalformedURLException e) {

	  		e.printStackTrace();
	  	
	  	  } catch (IOException e) {

	  		e.printStackTrace();

	  	  }

	  	}
	
	 public static void deleteAssById(String id) {
	        try {

	            DefaultHttpClient httpClient = new DefaultHttpClient();
	            HttpDelete deleteRequest = new HttpDelete(
	                    "http://localhost:8080/assignments/deleteAssignmentById?assignmentId="+id + 
	                    "");
	            deleteRequest.addHeader("accept", "application/json");

	            HttpResponse response = httpClient.execute(deleteRequest);

	            if (response.getStatusLine().getStatusCode() != 200) {
	                throw new RuntimeException("Failed : HTTP error code : "
	                        + response.getStatusLine().getStatusCode());
	            }

	            BufferedReader br = new BufferedReader(
	                    new InputStreamReader((response.getEntity().getContent())));

	            String output;
	            System.out.println("Output from Server .... \n");
	            
	            httpClient.getConnectionManager().shutdown();

	        } catch (ClientProtocolException e) {

	            e.printStackTrace();

	        } catch (IOException e) {

	            e.printStackTrace();
	        }

	    }
	 
	 public static Assignment getAssignmentById(String id) {
	        try {

	            DefaultHttpClient httpClient = new DefaultHttpClient();
	            HttpGet getRequest = new HttpGet(
	                    "http://localhost:8080/assignments/getAssignmentById?assignmentId="+id + 
	                    "");
	            getRequest.addHeader("accept", "application/json");

	            HttpResponse response = httpClient.execute(getRequest);

	            if (response.getStatusLine().getStatusCode() != 200) {
	                throw new RuntimeException("Failed : HTTP error code : "
	                        + response.getStatusLine().getStatusCode());
	            }

	            BufferedReader br = new BufferedReader(
	                    new InputStreamReader((response.getEntity().getContent())));

	            String output;
	            System.out.println("Output from Server .... \n");
	            
	            ObjectMapper objMap = new ObjectMapper();
	            Assignment tabusca = new Assignment();
	            output = br.readLine();
	            tabusca = objMap.readValue(output, Assignment.class);
	            
	            System.out.println(tabusca.toString());
	            
	            
	            httpClient.getConnectionManager().shutdown();
	            return tabusca;
	            
	        } catch (ClientProtocolException e) {

	            e.printStackTrace();

	        } catch (IOException e) {

	            e.printStackTrace();
	        }
	        return null;
	    }
}
