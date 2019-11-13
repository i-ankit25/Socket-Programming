package socketp1;

import java.io.*;
import java.net.*;

public class s_f 
{
	public static void main(String[] args)throws Exception
	{
		ServerSocket ss=new ServerSocket(4998);
		Socket s=ss.accept();
		file_transfer(s);
		s.close();
	}
	static void file_transfer(Socket s)
	{
		try
		{
		FileInputStream f=new FileInputStream("/home/ankit/Desktop/extras/ph.jpg");
		//DataInputStream bf=new DataInputStream(f);
		DataOutputStream bo=new DataOutputStream(s.getOutputStream());
		  int c;
		  while((c=f.read())!=-1)
		  {
			  bo.write(c);
		  }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		}
	}
