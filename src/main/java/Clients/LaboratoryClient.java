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

import models.Laboratory;
import models.Student;

public class LaboratoryClient {

	public void postLab(String curricula, String date, String description, Long number, String title) {

	  	  try {

	  		DefaultHttpClient httpClient = new DefaultHttpClient();
	  		HttpPost postRequest = new HttpPost(
	  			"http://localhost:8080/laboratories/saveLaboratory");

	  		StringEntity input = new StringEntity("{" + 
	  				"   \"curricula\": \""+curricula+"\",  " + 
	  				"   \"date\": \""+date+"\", " + 
	  				"   \"description\": \""+description+"\", " + 
	  				"   \"number\": "+number+", " + 
	  				"   \"title\": \""+title+"\" " + 
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
	
	public List<Laboratory> getAllLaboratories() {
        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet getRequest = new HttpGet(
                    "http://localhost:8080/laboratories/getAllLaboratories" + 
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
            
//            ObjectMapper objMap = new ObjectMapper();
//            Student tabusca = new Student();
//            output = br.readLine();
//            tabusca = objMap.readValue(output, Student.class);
//            
//            System.out.println(tabusca.toString());
            String file = "";
            while ((output = br.readLine()) != null) {
            	file += output;
    			//System.out.println(output);
    		}
            
            //System.out.println(file);
            if(file.startsWith("[") == false)
            	file = " ["+file+"]";
            
            JSONArray jsonArray= new JSONArray(file);
            List<Laboratory> list = new ArrayList<Laboratory>();
            
            
            for(int i=0; i<jsonArray.length(); i++) {
            	Laboratory p = new Laboratory(); 
            	
            	p.setLaboratoryUid(jsonArray.getJSONObject(i).getLong("laboratoryUid"));
            	p.setCurricula(jsonArray.getJSONObject(i).getString("curricula"));
            	p.setDate(jsonArray.getJSONObject(i).getString("date"));
            	p.setDescription(jsonArray.getJSONObject(i).getString("description"));
            	p.setNumber(jsonArray.getJSONObject(i).getLong("number"));
            	p.setTitle(jsonArray.getJSONObject(i).getString("title"));
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
	
	public void deleteLaboratoryById(String id) {
        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpDelete deleteRequest = new HttpDelete(
                    "http://localhost:8080/laboratories/deleteLaboratoryById?laboratoryId="+id + 
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
	
	 public static Laboratory getLabById(String id) {
	        try {

	            DefaultHttpClient httpClient = new DefaultHttpClient();
	            HttpGet getRequest = new HttpGet(
	                    "http://localhost:8080/laboratories/getLaboratoryById?laboratoryId="+id + 
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
	            Laboratory tabusca = new Laboratory();
	            output = br.readLine();
	            tabusca = objMap.readValue(output, Laboratory.class);
	            
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
