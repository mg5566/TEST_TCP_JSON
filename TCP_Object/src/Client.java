import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Client {
	public static void main(String[] args) {

		Socket socket = null;            //Server와 통신하기 위한 Socket
        
        // ObjectStream
        ObjectOutputStream objectOutputStream = null;
        
        // JSON 만들기
        JSONObject jobj = new JSONObject();
        jobj.put("name", "Kang");
        jobj.put("Age", new Integer(100));
        
        JSONArray list = new JSONArray();
        list.add("msg1");
        list.add("msg2");
        list.add("msg3");
        
        jobj.put("message", list);
        
        try {
            String ip = "";  // IP
            socket = new Socket(ip, 7777);
            
            // ObjectStream 내가만듬
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(jobj.toJSONString());
            
            
        }catch(IOException e) {}
        
        try {
        	objectOutputStream.flush();
        	objectOutputStream.close();
            socket.close();
            
        }catch(IOException e) {}

    }

}
