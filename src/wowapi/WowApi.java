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
public class WowApi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
		HttpURLConnectionExample http = new HttpURLConnectionExample();

		System.out.println("Testing 1 - Send Http GET request");
		http.sendGet();

		System.out.println("\nTesting 2 - Send Http POST request");
		http.sendPost();

    }
    
}
