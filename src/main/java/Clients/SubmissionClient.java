package Clients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class SubmissionClient {

	public static void postSubmission(String assId, String date, String studId) {

	  	  try {

	  		DefaultHttpClient httpClient = new DefaultHttpClient();
	  		HttpPost postRequest = new HttpPost(
	  			"http://localhost:8080/submission/saveSubmission");

	  		StringEntity input = new StringEntity("{ " + 
	  				"   \"assignment\": "+assId+", " + 
	  				"   \"date\": \""+date+"\", " + 
	  				"   \"grade\": 0, " + 
	  				"   \"student\": "+studId+" " + 
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
}
