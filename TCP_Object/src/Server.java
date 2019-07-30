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
		Socket socket = null;                //Client�� ����ϱ� ���� Socket
        ServerSocket server_socket = null;  //���� ������ ���� ServerSocket 
        BufferedReader in = null;            //Client�κ��� �����͸� �о���̱� ���� �Է½�Ʈ��
        PrintWriter out = null;                //Client�� �����͸� �������� ���� ��� ��Ʈ��
        
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
            socket = server_socket.accept();    //���� ���� , Client ���� ���
            System.out.println("after socket connect");
            
            // ���� ����
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            
//            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));    //�Է½�Ʈ�� ����
//            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))); //��½�Ʈ�� ����
//            
//            String str = null;
//            str = in.readLine();                //Client�κ��� �����͸� �о��
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