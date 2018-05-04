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
            	
            	p.setLabId(jsonArray.getJSONObject(i).getLong("laboratoryUid"));
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