import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Client_UDP {

	public static void main(String[] args) {
		 // ObjectStream
        ObjectOutputStream objectOutputStream = null;
        
        // JSON ¸¸µé±â
        JSONObject jobj = new JSONObject();
        jobj.put("name", "Kang");
        jobj.put("Age", new Integer(100));
        
        JSONArray list = new JSONArray();
        list.add("msg1");
        list.add("msg2");
        list.add("msg3");
        
        jobj.put("message", list);
        
        // IP
        String serverIP = "IP";
        // Port
        int port = 12345;
        
        try {
			InetAddress ip = InetAddress.getByName(serverIP);
			DatagramSocket socket = new DatagramSocket();		// create socket
			byte[] buf = jobj.toJSONString().getBytes();		// convert to String and convert to Bytes
			DatagramPacket packet = new DatagramPacket(buf, buf.length, ip, port);
			
			socket.send(packet);
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
