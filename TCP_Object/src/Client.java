import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Client {
	public static void main(String[] args) {

		Socket socket = null;            //Server�� ����ϱ� ���� Socket
        BufferedReader in = null;        //Server�κ��� �����͸� �о���̱� ���� �Է½�Ʈ��
        BufferedReader in2 = null;        //Ű����κ��� �о���̱� ���� �Է½�Ʈ��
        PrintWriter out = null;            //������ �������� ���� ��� ��Ʈ��
        InetAddress ia = null;
        
        // ObjectStream
        ObjectOutputStream objectOutputStream = null;
        
        // JSON �����
        JSONObject jobj = new JSONObject();
        jobj.put("name", "Kang");
        jobj.put("Age", new Integer(100));
        
        JSONArray list = new JSONArray();
        list.add("msg1");
        list.add("msg2");
        list.add("msg3");
        
        jobj.put("message", list);
        
        try {
            ia = InetAddress.getByName("���� �ּ� �Է�");    //������ ����
            socket = new Socket(ia, 7777);
            
            // ObjectStream ��������
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(jobj);
            
//            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            in2 = new BufferedReader(new InputStreamReader(System.in));
//            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
//            
//            System.out.println(socket.toString());
            
        }catch(IOException e) {}
        
        try {
//            System.out.print("������ ���� �޼��� : ");
//            String data = in2.readLine();            //Ű����κ��� �Է�
//            out.println(data);                        //������ ������ ����
//            out.flush();
//
//            String str2 = in.readLine();            //�����κ��� �ǵ��ƿ��� ������ �о����
//            System.out.println("�����κ��� �ǵ��ƿ� �޼��� : " + str2);
        	objectOutputStream.flush();
            socket.close();
            
        }catch(IOException e) {}

    }

}