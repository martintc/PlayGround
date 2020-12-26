import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Client {

	private Socket s;
	private DataInputStream in;
	private DataOutputStream out;
	private Scanner scan;

	public static void main (String[] args) {
		Client c = new Client();
		c.run();
	}

	public void run () {
		try {
			s = new Socket("localhost", 8000);
			out = new DataOutputStream(s.getOutputStream());
			scan = new Scanner(System.in);
			while (true) {
				String message = scan.nextLine();
				out.writeUTF(message);
			}
		} catch (IOException e) {
			System.out.println("Issue with connect");
			System.exit(1);
		}
	}
}
