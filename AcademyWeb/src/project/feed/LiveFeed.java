package project.feed;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import project.entity.Stock;
import project.strategies.Strategy;

public class LiveFeed {
	
	public static String[] runLiveFeed(String stock) {
		String[] fields = new String[7];
		try {
			StringBuilder url = 
		            new StringBuilder("http://finance.yahoo.com/d/quotes.csv?s=");
			url.append(stock);
	        url.append("&f=sbahgop&e=.csv");
	        
	        String theUrl = url.toString();
	        URL obj = new URL(theUrl);
	        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	        // This is a GET request
	        con.setRequestMethod("GET");
	        con.setRequestProperty("User-Agent", "Mozilla/5.0");
	        int responseCode = con.getResponseCode();
	        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	        String inputLine;
	        
			if((inputLine = in.readLine()) != null) {
				fields = inputLine.split(",");
			}
		}
		catch(Exception ex) {
			System.out.println("Problem with Yahoo feed connection");
		}
		
		return fields;
	}
}