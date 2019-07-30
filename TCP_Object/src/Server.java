import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		Socket socket = null;                //Client와 통신하기 위한 Socket
        ServerSocket server_socket = null;  //서버 생성을 위한 ServerSocket 
        BufferedReader in = null;            //Client로부터 데이터를 읽어들이기 위한 입력스트림
        PrintWriter out = null;                //Client로 데이터를 내보내기 위한 출력 스트림
        
        // objectStream
        ObjectInputStream objectInputStream = null;
        
        try{
            server_socket = new ServerSocket(7777);
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
            
//            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));    //입력스트림 생성
//            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))); //출력스트림 생성
//            
//            String str = null;
//            str = in.readLine();                //Client로부터 데이터를 읽어옴
//
//            System.out.println("Message(be sended to Client) : " + str);
//            
//            out.write(str);
//            out.flush();
            socket.close();
            
        }catch(IOException e){
        	e.printStackTrace();
        }
    }
}
