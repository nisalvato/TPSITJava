// IL SERVER 1
//Questo server si mette in ascolto sul ServerSocket 11111
//Quando arriva la connessione su questa porta poi crea un Socket solo per quel client
//Il server invia un numero sempre crescente per poi chiduersi quando questo numero arriva a cinque
//Attenzione NON E' multicast e  accontenta solo un client alla volta fino a un massimo di cinque

import java.io.*;
import java.net.*;
class Server1
{
	public static void main(String args[])
	{
		ServerSocket serverSock = null;
		Socket cs = null;
		
		int numero = 1; //inizializzazione del numero che verrá inviato al client
		final int MAXCONNESSIONI = 6;//numero massimo di connessioni client prima di chiudersi

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
		
		//Controlla quanti client ha accontentato finora
		while (numero<MAXCONNESSIONI) // condizione arbitraria
		{
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
			
			
			//Adesso inviamo i dati al client
			try
			{	
				//crea uno stream di output con il quale scriverà verso il client
				PrintWriter os = new PrintWriter(cs.getOutputStream(), true);
				os.println("Nuovo numero: " + numero);//scrive il numero al client
				
				numero++; //incrementa il numero di client accontentati
				os.close();//chiude lo stream di output
				cs.close();//chiude il socket col client
			}
			catch (Exception e)

			{
				System.out.println("Errore: " +e);
				System.exit(3);
			}
		}
		
		try
		{	
			serverSock.close();//esce dal while chiude la porta 11111 in ascolto
		}
		catch (Exception e)
		{
				System.out.println("Errore: " +e);
				System.exit(3);
		}
	}
}
