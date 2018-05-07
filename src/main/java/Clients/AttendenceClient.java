package Clients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.Attendence;
import models.Student;

public class AttendenceClient {
	public static void postAttendence(String labId) {

	  	  try {

	  		DefaultHttpClient httpClient = new DefaultHttpClient();
	  		HttpPost postRequest = new HttpPost(
	  			"http://localhost:8080/attendences/saveAttendance");

	  		StringEntity input = new StringEntity("{ " + 
	  				"   \"laboratoryId\": "+labId+" " + 
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
	
	public static void deleteAttendenceById(String id) {
        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpDelete deleteRequest = new HttpDelete(
                    "http://localhost:8080/attendences/deleteAttendanceById?attendenceId="+id + 
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
	
	 public static Attendence getAttendencetById(String id) {
	        try {

	            DefaultHttpClient httpClient = new DefaultHttpClient();
	            HttpGet getRequest = new HttpGet(
	                    "http://localhost:8080/attendences/getAttendanceById?attendenceId="+id + 
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
	            Attendence tabusca = new Attendence();
	            output = br.readLine();
	            tabusca = objMap.readValue(output, Attendence.class);
	            
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
	 
	 public List<Attendence> getAllAttendences() {
	        try {

	            DefaultHttpClient httpClient = new DefaultHttpClient();
	            HttpGet getRequest = new HttpGet(
	                    "http://localhost:8080/attendences/getAllAttendences" + 
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
	            
//	            ObjectMapper objMap = new ObjectMapper();
//	            Student tabusca = new Student();
//	            output = br.readLine();
//	            tabusca = objMap.readValue(output, Student.class);
//	            
//	            System.out.println(tabusca.toString());
	            String file = "";
	            while ((output = br.readLine()) != null) {
	            	file += output;
	    			//System.out.println(output);
	    		}
	            
	            if(file.startsWith("[") == false)
	            	file = " ["+file+"]";
	            
	            //System.out.println(file);
	            
	            JSONArray jsonArray= new JSONArray(file);
	            List<Attendence> list = new ArrayList<Attendence>();
	            
	            
	            for(int i=0; i<jsonArray.length(); i++) {
	            	Attendence p = new Attendence(); 
	            	
	            	p.setAttendenceId(jsonArray.getJSONObject(i).getLong("attendenceUid"));
	            	p.setLaboratoryId(jsonArray.getJSONObject(i).getLong("laboratoryId"));
	        		list.add(p);
	           }
	            
	            
	            
	            
	            httpClient.getConnectionManager().shutdown();
	            return list;
	            
	        } catch (ClientProtocolException e) {

	            e.printStackTrace();

	        } catch (IOException e) {

	            e.printStackTrace();
	        }
	        return null;
	    }

}

