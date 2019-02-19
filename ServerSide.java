
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ServerSide {

	public static void main(String[] args) {
	ServerSocket listener = null;
	Socket client = null;
	String line;
	List<String> textLines = new ArrayList<String>();
	Random rand = new Random();
		try {
			listener = new ServerSocket(8765);
			client = listener.accept();
			System.out.println("Client has arrived!");
			
			OutputStreamWriter os = new OutputStreamWriter(client.getOutputStream());
			
			BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\user\\eclipse-workspace\\AP_Lab3\\quotes.txt"));
			
			while((line = in.readLine()) != null) {
				textLines.add(line);				
			}
			int n = rand.nextInt(textLines.size());
			os.write(textLines.get(n));
			os.flush();
			in.close();
			client.close();
			listener.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}