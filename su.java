package socketp1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class su 
{
	public static void main(String args[])
	{ 
		try
		{
			while(true)
			{
			DatagramSocket ds=new DatagramSocket(5000);
			byte[] bar=new byte[1024];
			DatagramPacket dpr=new DatagramPacket(bar,bar.length);
			ds.receive(dpr);
			String st=new String(dpr.getData(),0,dpr.getLength());
			System.out.println("Client : "+st);
			if(st.equalsIgnoreCase("BYE"))
				break;
			Thread t=new ClientHandler(ds,dpr);
			t.start();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		}
	static class ClientHandler extends Thread
	{
		DatagramSocket ds;
		DatagramPacket dpr;
		public ClientHandler(DatagramSocket dso,DatagramPacket dpo)
		{
			ds=dso;
			dpr=dpo;
		}
		public void run()
		{
			while(true)
			{
			try
			{
			System.out.print("->");
			BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
			String s=bf.readLine();
			byte[] ba=s.getBytes();
			InetAddress i=InetAddress.getLocalHost();
			int des_port=dpr.getPort();
			DatagramPacket dp=new DatagramPacket(ba,ba.length,i,des_port);
			ds.send(dp);
			ds.close();
				}
			catch(Exception e)
			{
				System.out.println(e);
			}
			}
	   }
}
}
