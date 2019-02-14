import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Client {
	public static void main(String[] args) {

		Socket socket = null;            // Socket communicate to Server
        
        // ObjectStream
        ObjectOutputStream objectOutputStream = null;
        // InputStreamBuffer
        OutputStream outputStream = null;
        
        // make JSON
        JSONObject jobj = new JSONObject();
        jobj.put("name", "Kang");
        jobj.put("Age", new Integer(100));
        
        JSONArray list = new JSONArray();
        list.add("msg1");
        list.add("msg2");
        list.add("msg3");
        
        jobj.put("message", list);
        
        // put JSON to String
        String str = new String();
        str = jobj.toJSONString();
        byte[] bt = str.getBytes();
        
        try {
            String ip = "192.168.0.192";  // IP
            socket = new Socket(ip, 12345);
            
            // ObjectStream 
//            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
//            outputStream = new OutputStreamWriter(socket.getOutputStream());
            outputStream = socket.getOutputStream();
//            objectOutputStream.writeObject(jobj.toJSONString());
            
//            objectOutputStream.writeChars(str);
//            objectOutputStream.writeUTF(str);

            outputStream.write(bt, 0, str.length());
            
            System.out.println(outputStream.toString().getBytes());
            System.out.println(str);
       
        }catch(IOException e) {}
        
        try {
//        	objectOutputStream.flush();
//        	objectOutputStream.close();
        	
        	outputStream.flush();
        	outputStream.close();
            socket.close();
            
        }catch(IOException e) {}

    }

}
