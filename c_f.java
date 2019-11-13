package socketp1;

import java.io.*;
import java.net.*;

public class c_f 
{
	public static void main(String[] args)throws Exception
		{
			Socket s=new Socket("localhost",4998);
			try
			{   int c;
				FileOutputStream fos=new   FileOutputStream("/home/ankit/Desktop/cpy1.jpg");
				DataInputStream bf=new DataInputStream(s.getInputStream());
				//DataOutputStream bo=new DataOutputStream(fos);
				while((c=bf.read())!=-1)
				{
				  fos.write(c);
				}
				System.out.println("Transfer Complete");
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			}
		}

