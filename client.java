import java.net.*;
import java.io.*;

public class client
{
	public static void main(String[] args)throws Exception
	{	
	   Socket s=new Socket("localhost",4999);  
		DataInputStream in=new DataInputStream(s.getInputStream());
	    DataOutputStream out=new DataOutputStream(s.getOutputStream());
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        
        while(true)
        {
		 System.out.print("-> : ");
         String inp=bf.readLine();
		 out.writeUTF(inp);
         
		 if (inp.equalsIgnoreCase("bye"))
			  break;
		 String str=in.readUTF();
		 System.out.println("Server: "+str);
		 
        }
        System.out.println("Connection closed");
	    s.close();
	   }
}
