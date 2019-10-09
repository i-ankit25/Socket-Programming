package socketp1;
import java.io.*;
import java.net.*;
public class s1 
{
	public static void main(String args[]) throws IOException
	{
		ServerSocket ss=new ServerSocket(4999);
		while(true)
		{
		Socket s = null;
		try
		{
		s=ss.accept();
		DataInputStream in=new DataInputStream(s.getInputStream());
		DataOutputStream out=new DataOutputStream(s.getOutputStream());
		Thread t=new ClientHandler(s,in,out);
		t.start();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	  }
    }
  static class ClientHandler extends Thread
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
	     Socket s;
		 DataInputStream in;
		 DataOutputStream out;
		public ClientHandler(Socket so,DataInputStream din,DataOutputStream dout)
		{
			s=so;
			in=din;
			out=dout;
		}
		public void run()
		{
			try
			{
			while(true)
			{
				String re=in.readUTF();
				System.out.println("client:"+re);
				if(re.equalsIgnoreCase("bye"))
					{
					s.close();
					break;
					}
				System.out.print("->");
				String se=bf.readLine();
				out.writeUTF(se);
			}
		  }
			catch(Exception e)
			{
			System.out.println(e);
		   }
        }
	}
}
