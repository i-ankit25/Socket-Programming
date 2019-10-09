package socketp1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class c1
{
	public static void main(String args[])
	{
		try
		{
		Socket s=new Socket("localhost",4999);
		DataInputStream in=new DataInputStream(s.getInputStream());
		DataOutputStream out=new DataOutputStream(s.getOutputStream());
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{   System.out.print("->");
		     String se=bf.readLine();
		     out.writeUTF(se);
		     if(se.equalsIgnoreCase("bye"))
					break;
			String re=in.readUTF();
			System.out.println("server:"+re);
		}
		s.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}  
}
