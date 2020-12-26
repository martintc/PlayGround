import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ClientHandler {

	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;

	public ClientHandler (Socket s) {
		this.socket = s;
		try {
			this.in = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			System.out.println("error creating pipe");
			System.exit(1);
		}
	}

	public void recv () throws IOException {
		try {
			String message = in.readUTF();
			System.out.println("Message: " + message);
		} catch (IOException e) {
			throw e;
		}
	}
	
	
}
