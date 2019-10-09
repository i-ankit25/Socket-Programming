package socketp1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
public class data_server 
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
	   }
		catch(Exception e)
		{
			System.out.println(e);
		}
		}

}
