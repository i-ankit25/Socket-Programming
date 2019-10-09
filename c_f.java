package socketp1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class c_f 
{
	public static void main(String[] args)throws Exception
		{
			Socket s=new Socket("localhost",4998);
			try
			{
			byte[] ba=new byte[1024];
			  BufferedInputStream bf=new BufferedInputStream(s.getInputStream());
			  FileOutputStream fos=new   FileOutputStream("/home/ankit/Desktop/IMG1.jpg");
			  BufferedOutputStream bo=new BufferedOutputStream(fos);
			  int c=bf.read(ba,0,ba.length);
			  while(c!=-1)
			  {
				  bo.write(ba,0,c);
				  c=bf.read(ba,0,ba.length);
		}
			  System.out.println("Transfer Complete");
	}
			catch(Exception e)
			{
				System.out.println(e);
			}
			}
		}

