import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Server {

	public static void main(String[] args) {
		Socket socket = null;                //Client Socket
        ServerSocket server_socket = null;  // Server Socket 
        
        // objectStream
        ObjectInputStream objectInputStream = null;
        
        // JSONObject
        JSONObject jsonObject = null;
        JSONParser jsonParser = new JSONParser();
        
        try{
            server_socket = new ServerSocket(12345);
            System.out.println("Server Start");
            
        }catch(IOException e)
        {
            System.out.println("already use port");
        }
        try {
            
            System.out.println("before socket connect");
            socket = server_socket.accept();    //서버 생성 , Client 접속 대기
            System.out.println("after socket connect");
            
            // 내가 만듬
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            
            // check JSON
            
			try {
				
				jsonObject = (JSONObject)jsonParser.parse(objectInputStream.readObject().toString());
			
				System.out.println(jsonObject.toString());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
            
            
            System.out.println("complete communication");
            
            objectInputStream.close();
            socket.close();
            
            
            
        }catch(IOException e){
        	e.printStackTrace();
        }
    }
}
