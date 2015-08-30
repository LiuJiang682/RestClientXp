package demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;

import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestCalendarControllerIT {

	@Test
	public void testGetDateString() {
		Calendar c = Calendar.getInstance();
		String urlString = "http://localhost:8080/cld?date=" + c;
		
		try {
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("User-Agent", "Mozilla/5.0");

			int responseCode = conn.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);
			
			BufferedReader err = new BufferedReader(
			        new InputStreamReader(conn.getErrorStream()));
			String inputLineErr;
			StringBuffer responseErr = new StringBuffer();

			while ((inputLineErr = err.readLine()) != null) {
				responseErr.append(inputLineErr);
			}
			err.close();
			System.err.println(responseErr);
			
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			//print result
			System.out.println(response.toString());

		}
		catch (Throwable t) {
			t.printStackTrace();
		}
	}
	
	@Test
	public void testGetDateStringLong() {
		Calendar c = Calendar.getInstance();
		String urlString = "http://localhost:8080/cl?date=" + c.getTimeInMillis();
		
		try {
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("User-Agent", "Mozilla/5.0");

			int responseCode = conn.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);
			
//			BufferedReader err = new BufferedReader(
//			        new InputStreamReader(conn.getErrorStream()));
//			String inputLineErr;
//			StringBuffer responseErr = new StringBuffer();
//
//			while ((inputLineErr = err.readLine()) != null) {
//				responseErr.append(inputLineErr);
//			}
//			err.close();
//			System.err.println(responseErr);
			
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			//print result
			System.out.println(response.toString());

		}
		catch (Throwable t) {
			t.printStackTrace();
		}
	}
	
	@Test
	public void testClient() {
		try {

			Client client = Client.create();

			WebResource webResource = client
			   .resource("http://localhost:8080/cld");

			ClientResponse response = webResource.type("application/json")
	                   .post(ClientResponse.class, Calendar.getInstance());

			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}

			String output = response.getEntity(String.class);

			System.out.println("Output from Server .... \n");
			System.out.println(output);

		  } catch (Exception e) {

			e.printStackTrace();

		  }

		}
	
	@Test
	public void testClientObject() {
		try {

			MyCalander c = new MyCalander();
			c.setCalender(Calendar.getInstance());
			
			Client client = Client.create();

			WebResource webResource = client
			   .resource("http://localhost:8080/co");

			ClientResponse response = webResource.type("application/json")
	                   .post(ClientResponse.class, c);

			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}

			String output = response.getEntity(String.class);

			System.out.println("Output from Server .... \n");
			System.out.println(output);

		  } catch (Exception e) {

			e.printStackTrace();

		  }

		}
	
}
