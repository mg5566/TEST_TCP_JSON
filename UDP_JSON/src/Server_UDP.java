import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Server_UDP {

	public static void main(String[] args) {
		
		int port = 12345;
		
		JSONObject jsonObject = null;
		JSONParser jsonParser = new JSONParser();
		
		try {
			DatagramSocket socket = new DatagramSocket();
			
			while(true) {
				byte buf[] = new byte[512];
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				
				System.out.println("ready");
				
				socket.receive(packet);
				String str = new String(packet.getData());
				
				jsonObject = (JSONObject)jsonParser.parse(str);
				
				System.out.println(jsonObject.toString());
				
				socket.close();
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
