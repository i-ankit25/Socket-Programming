package socketp1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.ServerSocket;
import java.net.Socket;

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
		FileInputStream f=new FileInputStream("/home/ankit/Downloads/study/IMG_20140915_014043.jpg");
		byte[] ba=new byte[1024];
		  BufferedInputStream bf=new BufferedInputStream(f);
		  BufferedOutputStream bo=new BufferedOutputStream(s.getOutputStream());
		  int c=bf.read(ba,0,ba.length);
		  while(c!=-1)
		  {
			  bo.write(ba,0,c);
			  c=bf.read(ba,0,ba.length);
	}
}
		catch(Exception e)
		{
			System.out.println(e);
		}
		}
	}
