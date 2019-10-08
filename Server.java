// The skeleton program for Server
import java.net.*;
import java.io.*;

public class Server
{
	//input stream defined
	private Socket socket = null;
	private ServerSocket server = null;
	private DataInputStream in = null; //to receive messages

	public Server(int port)
	{
		try 
		{
			server = new ServerSocket(port);
			System.out.println("Server Started");

			System.out.println("Waiting for a client to connect...");

			socket = server.accept();
			System.out.println("Client connection accepted");

			//to accept messages from client
			in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			String line = "";

			While(!line.equals("Done"))
			{
				try 
				{
					line = in.readUTF();
					System.out.println(line);
				}
				catch(IOException i)
				{
					System.out.println(i);
				}
			}
			socket.close();
			in.clode();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}

	}
}

    public static void main(String args[])
    {
        Server server = new Server(5000);
    }
