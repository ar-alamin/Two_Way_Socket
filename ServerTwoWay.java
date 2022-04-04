package two_way_socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTwoWay {

	public static void main(String args[])throws IOException{
		// Create server Socket
		ServerSocket ss = new ServerSocket(4000);

		// connect it to client socket
		Socket socket = ss.accept();
		System.out.println("Connection established");

		PrintStream send = new PrintStream(socket.getOutputStream());

		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

		// server executes continuously
		while (true) {
			String str, str1;

			while ((str = br.readLine()) != null) {
				System.out.println(str);
				str1 = read.readLine();

				// send to client
				send.println(str1);
			}ss.close();
			socket.close();

			// terminate application
			System.exit(0);
		} 
	}
}
