// IL CLIENT 1
// Il client effettua una connessione col server
//Sulla porta 11111, dopodiché apre uno stream in lettura.

import java.io.*;
import java.net.*;
public class Client1
{
	 public static void main(String args[])
	 {
		 Socket s = null;
		 BufferedReader is = null;
		 try
		 {	
			//Apertura di un socket sull'indirizzo locale e sulla porta 11111
			s = new Socket("localhost", 11111);
			
			//Creo uno stream in input sul client.
			//Da questo leggero` i dati inviati dal server
			is = new BufferedReader(new InputStreamReader(s.getInputStream()));
		 }
		 catch (IOException e)
		 {
			System.out.println(e.getMessage());
			System.exit(1);
		 }
		 System.out.println("Socket creata: " + s);
		 
		 try
		 {
			//leggo i dati inviati dal Server sullo stream di input
			String line=is.readLine();
			System.out.println("Ricevuto: " + line);
		
			is.close(); // chiusura stream
			s.close(); // chiusura socket
		 }
		 catch (IOException e)
		 {
			System.out.println(e.getMessage());
		 }
	 }
}
