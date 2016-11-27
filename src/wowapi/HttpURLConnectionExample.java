/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wowapi;

/**
 *
 * @author Alex
 */

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HttpURLConnectionExample {

	private final String USER_AGENT = "Mozilla/5.0";

        
	// HTTP GET request
	void sendGet() throws Exception {

		String url = "https://us.api.battle.net/wow/item/18803?locale=en_US&apikey=znvu7s744nxkmbjx66rcywvjqrk8h7f8";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());

	}
        
        

	// HTTP POST request
	void sendPost() throws Exception {

		String url = "https://dev.battle.net/io-docs/call-api";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

                
		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
                con.setRequestProperty("Accept", "application/json, text/javascript, */*; q=0.01");
		con.setRequestProperty("Accept-Language", "fr-FR,en;q=0.5");
                con.setRequestProperty("x-api-key", "znvu7s744nxkmbjx66rcywvjqrk8h7f8");
                con.setRequestProperty("x-api-secret", "449ZmBG4vY9SYEPQzfb98VTzCMYuRUZz");

		String urlParameters = "";

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());

	}

}