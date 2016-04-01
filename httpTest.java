package httpcommunication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class httpTest {
	
	 private static String readStream(InputStream in) {
		 //creates an empty stringbuilder
		 StringBuilder a = new StringBuilder();
		 //generates content for the string
		 try (BufferedReader read = new BufferedReader(new InputStreamReader(in));) {
			 String string = "";
		     while ((string = read.readLine()) != null) {
		       a.append(string);
		       }
		     } catch (IOException e) {
		    	 e.printStackTrace();
		    }
		    return a.toString();
		  }
	
  public static void main(String[] args) {
    try {
      //gets info from google.com
      URL web = new URL("http://www.google.com");
      HttpURLConnection connection = (HttpURLConnection) web.openConnection();
      //assigns values from the readStream function created earlier in the class
      String output = readStream(connection.getInputStream());
      //displays info from output
      System.out.println(output);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

 
} 