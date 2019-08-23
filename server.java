package socketp1;
import java.net.*;
import java.util.Scanner;
import java.io.*;

public class server 
{
	public static void main(String[] args)throws Exception
	{
		ServerSocket ss=new ServerSocket(4999);
		Socket s=ss.accept();
		System.out.println("client connected"); 
		DataInputStream in=new DataInputStream(s.getInputStream());
	    DataOutputStream out=new DataOutputStream(s.getOutputStream());
	    BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
      while(true)
      {
		String str=in.readUTF();
		System.out.println("Client: "+str);
		if (str.equalsIgnoreCase("bye"))
			   break;   
		System.out.print("-> : ");
		String inp=bf.readLine();
		out.writeUTF(inp);
	   }
      System.out.println("Connection closed");
      s.close();
      ss.close();
	}
	
}


