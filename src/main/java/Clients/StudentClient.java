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
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.Laboratory;
import models.Student;

public class StudentClient {

    public static Student getStudentById(String id) {
        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet getRequest = new HttpGet(
                    "http://localhost:8080/students/getStudentById?studentId="+id + 
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
            Student tabusca = new Student();
            output = br.readLine();
            tabusca = objMap.readValue(output, Student.class);
            
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

    public static void postStudentAsProff(String email) {

  	  try {

  		DefaultHttpClient httpClient = new DefaultHttpClient();
  		HttpPost postRequest = new HttpPost(
  			"http://localhost:8080/students/saveStudent");

  		StringEntity input = new StringEntity("{" + 
  				"  \"email\": \""+email+"\"," + 
  				"  \"fullname\": \"string\"," + 
  				"  \"grupa\": 0," + 
  				"  \"hobby\": \"string\"," + 
  				"  \"password\": \"string\"," + 
  				"  \"token\": \"string\"" + 
  				"}") ;
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
    
    public static void deleteStudentById(String id) {
        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpDelete deleteRequest = new HttpDelete(
                    "http://localhost:8080/students/deleteStudentById?studentId="+id + 
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
    
    public List<Student> getAllStudents() {
        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet getRequest = new HttpGet(
                    "http://localhost:8080/students/getAllStudents" + 
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
            
            JSONArray jsonArray= new JSONArray(file);
            List<Student> list = new ArrayList<Student>();
            
            
            for(int i=0; i<jsonArray.length(); i++) {
            	Student p = new Student(); 
        		p.setStudentId(jsonArray.getJSONObject(i).getLong("studentId"));
        		p.setEmail(jsonArray.getJSONObject(i).getString("email"));
        		p.setPassword(jsonArray.getJSONObject(i).getString("password"));
        		p.setFullname(jsonArray.getJSONObject(i).getString("fullname"));
        		p.setGrupa(jsonArray.getJSONObject(i).getLong("grupa"));
        		p.setHobby(jsonArray.getJSONObject(i).getString("hobby"));
        		p.setToken(jsonArray.getJSONObject(i).getString("token"));
        		p.setAssigmentStudent(null);
        		p.setAttendances(null);
        		p.setStudentUid(null);
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
    
    public Student getStudentByEmailAndPassword(String email, String password) {
        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet getRequest = new HttpGet(
                    "http://localhost:8080/students/login?email="+email+"&password="+password + 
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
            Student tabusca = new Student();
            output = br.readLine();
            tabusca = objMap.readValue(output, Student.class);
            
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
    
    public Student getStudentByEmailAndToken(String email, String token) {
        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet getRequest = new HttpGet(
                    "http://localhost:8080/students/register?email="+email+"&token="+token + 
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
            Student tabusca = new Student();
            output = br.readLine();
            tabusca = objMap.readValue(output, Student.class);
            
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
    
    public static void putStudent(String id, String fullname, Long grupa, String hobby, String password) {

    	  try {

    		DefaultHttpClient httpClient = new DefaultHttpClient();
    		HttpPut postRequest = new HttpPut(
    			"http://localhost:8080/students/updateStudent?studentId="+id+"");

    		StringEntity input = new StringEntity("{ " + 
    				"   \"email\": \"string\", " + 
    				"   \"fullname\": \""+fullname+"\", " + 
    				"   \"grupa\": "+grupa+", " + 
    				"   \"hobby\": \""+hobby+"\", " + 
    				"   \"password\": \""+password+"\", " + 
    				"   \"token\": \"string\" " + 
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
            
            JSONArray jsonArray= new JSONArray(file);
            List<Laboratory> list = new ArrayList<Laboratory>();
            
            
            for(int i=0; i<jsonArray.length(); i++) {
            	Laboratory p = new Laboratory(); 
            	
            	p.setLaboratoryUid(jsonArray.getJSONObject(i).getLong("laboratoryUid"));
            	p.setCurricula(jsonArray.getJSONObject(i).getString("curricula"));
            	p.setDate(jsonArray.getJSONObject(i).getString("date"));
            	p.setDescription(jsonArray.getJSONObject(i).getString("description"));
            	p.setTitle(jsonArray.getJSONObject(i).getString("title"));
            	p.setNumber(jsonArray.getJSONObject(i).getLong("number"));
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
    
    public static Student getStudentByEmail(String email) {
        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet getRequest = new HttpGet(
                    "http://localhost:8080/students/getTokenByEmail?email="+email + 
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
            Student tabusca = new Student();
            output = br.readLine();
            tabusca = objMap.readValue(output, Student.class);
            
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