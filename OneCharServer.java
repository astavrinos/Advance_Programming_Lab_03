import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class OneCharServer {

	public void sendChar() {
	ServerSocket listener = null;
	Socket client = null;
		try {
			listener = new ServerSocket(8765);
			client = listener.accept();
			System.out.println("Client has arrived!");
			
			OutputStreamWriter os = new OutputStreamWriter(client.getOutputStream());
			
			os.write('x');
			os.flush();
			
			client.close();
			listener.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}