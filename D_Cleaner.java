import java.lang.*;
import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
 
class Remove_Duplicate 
{
	Remove_Duplicate(String path)//parameterised constructor
	{
		TravelDirectory(path);
	}
	
	public void TravelDirectory(String path)//to travel whole directory
	{
		File directorypath=new File(path);
		String str;
	
		//hashtable to store file name and checksum
		Hashtable<String,String> ht=new Hashtable<String,String>();

		//get all file name from directory
		File arr[]=directorypath.listFiles();

		for(File filename:arr)
		{
	
			if(filename.getName().endsWith(".txt"))
			{
				
				str= CheckSum(filename.getAbsolutePath());

				ht.put(filename.getName(),str);
				
			}
		}
		
		Enumeration it=ht.keys();

		while(it.hasMoreElements())//to display hashtable elements
		{
			System.out.println(it.nextElement()+"");
		}
	}

	public String CheckSum(String d_name)//to reterive checksum
	{
		try
		{         		
 
        		MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
         
        		FileInputStream fileInput = new FileInputStream(d_name);
        		
			byte[] dataBytes = new byte[1024];
 			int bytesRead = 0;
 
        		while ((bytesRead = fileInput.read(dataBytes)) != -1) 
			{
            			messageDigest.update(dataBytes, 0, bytesRead);
        		}
         
 
        		byte[] digestBytes = messageDigest.digest();
 
        		StringBuffer sb = new StringBuffer("");
         
        		for (int i = 0; i < digestBytes.length; i++) 
			{
            			sb.append(Integer.toString((digestBytes[i] & 0xff) + 0x100, 16).substring(1));
        		}
 
         
        		fileInput.close();
			return(sb.toString());    		
		}
    		catch(Exception eobj)
   		{
			System.out.println(eobj);
			return eobj.toString();
   		}

	}
    
}

class Demo
{
	public static void main(String args[])
   	{
		Remove_Duplicate dobj=new Remove_Duplicate("Demo");
		
	}

}	


