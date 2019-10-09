package socketp1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
public class data_client {
	public static void main(String agrs[])
	{ 
		try
	    {
		while(true)
		{
			System.out.print("->");
			BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
			String s=bf.readLine();
			byte[] ba=s.getBytes();
			InetAddress i=InetAddress.getLocalHost();
			DatagramPacket dp=new DatagramPacket(ba,ba.length,i,5000);
			DatagramSocket ds=new DatagramSocket();
			ds.send(dp);
			if(s.equalsIgnoreCase("BYE"))
				break;
			
			byte[] bar=new byte[1024];
			DatagramPacket dpr=new DatagramPacket(bar,bar.length);
			ds.receive(dpr);
			String st=new String(dpr.getData(),0,dpr.getLength());
			System.out.println("Server : "+st);
			ds.close();
		}
	    }
		catch(Exception e)
		{
		System.out.println("e");
		}
	  }	
	}

