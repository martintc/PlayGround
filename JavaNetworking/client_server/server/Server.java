import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class Server {

	private ServerSocket server;
	private Socket client;

	public static void main (String[] args) {
		Server s = new Server();
		s.run();
	}

	public void run () {
		try {
			server = new ServerSocket(8000);
			// server.bind();
			ClientHandler c = new ClientHandler(server.accept());

			while (true) {
				c.recv();
			}
		} catch (IOException e) {
			System.out.println("Error occured");
			System.exit(1);
		}
		
	}
	
}
