package Clients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.Laboratory;
import models.Student;
import models.Submission;

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
	
	public List<Submission> getAllSubmissions() {
        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet getRequest = new HttpGet(
                    "http://localhost:8080/submission/getAllSubmissions" + 
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
            
            System.out.println("Fisierul este \n" + file);
            if(file.startsWith("[") == false)
            	file = " ["+file+"]";
            
            JSONArray jsonArray= new JSONArray(file);
            List<Submission> list = new ArrayList<Submission>();
            
            
            System.out.println(jsonArray.length());
            for(int i=0; i<jsonArray.length(); i++) {
            	Submission p = new Submission(); 
            	
            	p.setAssignment(jsonArray.getJSONObject(i).getLong("assignment"));
            	p.setDate(jsonArray.getJSONObject(i).getString("date"));
            	p.setGrade(jsonArray.getJSONObject(i).getLong("grade"));
            	p.setStudent(jsonArray.getJSONObject(i).getLong("student"));
            	
        		list.add(p);
        		p = null;
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
	
	public void gradeSubmission(String id, String grade) {
        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPut getRequest = new HttpPut(
                    "http://localhost:8080/submission/gradeSubmission?submissionID="+id+"&newGrade="+grade + 
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
            
            Student tabusca = new Student();
            
            System.out.println(tabusca.toString());
            
            
            httpClient.getConnectionManager().shutdown();
            
        } catch (ClientProtocolException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
	
}
