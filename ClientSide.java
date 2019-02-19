import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientSide {
	
	public static void main(String[] args) {
		Socket s = null;
		Scanner sc = new Scanner(System.in);

		try {
			s = new Socket("127.0.0.1",8765);	
			System.out.println("If you want to get motivated\n"
					+ "just type motivateme.\n"
					+ "Or else type quit.");
			String userInput = sc.nextLine();
			
			if (userInput.equals("motivateme")) {
				Scanner reader = new Scanner(s.getInputStream());
				while(reader.hasNextLine()) {
					System.out.println(reader.nextLine());
				}
			} else if (userInput.equals("quit")) {
				s.close();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally{
			try {
				s.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
}// End of class
