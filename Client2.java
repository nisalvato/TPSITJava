// IL CLIENT 1
// Ipotesi: server port (fisso) = 11111

import java.io.*;
import java.net.*;
public class Client1
{
	 public static void main(String args[])
	 {
		 Socket s = null;
		 BufferedReader is = null;
		 PrintWriter out= null;
		 try
		 {
			s = new Socket("localhost", 11112);
			is = new BufferedReader(new InputStreamReader(s.getInputStream()));
			out = new PrintWriter(s.getOutputStream(), true);
		 }
		 catch (IOException e)
		 {
			System.out.println(e.getMessage());
			System.exit(1);
		 }
		 System.out.println("Socket creata: " + s);
		 
		 try
		 {
			out.println("Ciao come stai");
			String line=is.readLine();
			System.out.println("Ricevuto: " + line);
	
		
			is.close(); // chiusura stream input
			out.close(); //chiusura dello stream in output
			s.close(); // chiusura socket
		 }
		 catch (IOException e)
		 {
			System.out.println(e.getMessage());
		 }
	 }
}
