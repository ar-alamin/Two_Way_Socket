package two_way_socket;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientTwoWay {

	public static void main(String args[])throws IOException {
		// Create client socket
		Socket socket = new Socket("localhost", 4000);

		DataOutputStream output = new DataOutputStream(socket.getOutputStream());
		
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		
		String str, str1;

		while (!(str = read.readLine()).equals("stop")) {

			// send to the server
			output.writeBytes(str + "\n");

			// receive from the server
			str1 = br.readLine();

			System.out.println(str1);
		}socket.close();
	}
}
