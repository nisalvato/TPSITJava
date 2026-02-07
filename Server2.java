// IL SERVER 1
import java.io.*;
import java.net.*;
class Server1
{
	public static void main(String args[])
	{
		ServerSocket serverSock = null;
		Socket cs = null;

		System.out.print("Creazione ServerSocket...");
		try
		{
			serverSock = new ServerSocket(11112);
		}
		catch (IOException e)
		{
			System.err.println(e.getMessage());
			System.exit(1);
		}

			System.out.print("Attesa connessione...");
			try {
				cs = serverSock.accept();
			}
			catch (IOException e)
			{
				System.err.println("Connessione fallita");
				System.exit(2);
			}
			System.out.println("Conness. da " + cs);
			
			
			try
			{
				BufferedReader is = null;is = new BufferedReader(new InputStreamReader(cs.getInputStream()));
				String line=is.readLine();
				System.out.println("Ricevuto: " + line);
		
				PrintWriter os = new PrintWriter(cs.getOutputStream(), true);
				os.println("Stop");
				os.close();
				cs.close();
			}
			catch (Exception e)

			{
				System.out.println("Errore: " +e);
				System.exit(3);
			}
		
	}
}
