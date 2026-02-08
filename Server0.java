// IL SERVER 1
//Questo server si mette in ascolto sul ServerSocket 11111
//Quando arriva la conenssione su questa porta poi crea un Socket solo per quel client
//Il server invia un numero al client e si chiude

import java.io.*;
import java.net.*;
class Server1
{
	public static void main(String args[])
	{
		ServerSocket serverSock = null;
		Socket cs = null;
		
		int numero = 1; //inizializzazione del numero che verrá inviato al client

		System.out.print("Creazione ServerSocket...");
		try
		{	//Il server crea un ServerSocket e si mette in ascolto
			serverSock = new ServerSocket(11111);
		}
		catch (IOException e)
		{
			System.err.println(e.getMessage());
			System.exit(1);
		}
		
		System.out.print("Attesa connessione...");
		try {
				cs = serverSock.accept();//accetta la connessiene dal client e crea un socket
		}
		catch (IOException e)
		{
			System.err.println("Connessione fallita");
			System.exit(2);
		}
		System.out.println("Conness. da " + cs);
		
		try{	
				//crea uno stream di output con il quale scriverà verso il client
				PrintWriter os = new PrintWriter(cs.getOutputStream(), true);
				os.println("Nuovo numero: " + numero);//scrive il numero al client
				os.close();//chiude lo stream di output
				cs.close();//chiude il socket col client
				serverSock.close();//chiude la porta 11111 in ascolto
		}
		catch (Exception e)

		{
				System.out.println("Errore: " +e);
				System.exit(3);
		}
		
	}
}
