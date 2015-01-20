package chat;


import java.io.*;
import java.net.*;
import java.util.concurrent.*;
public class UDPClient implements Runnable {

	   public void run()
	   {
		   

	    	 try
	    	 {
	    		 
	    		 byte[] sendData = new byte[1024];
	    	     byte[] receiveData = new byte[1024];
	   		   
	    		 while(true)
	    	     {
	    		  BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
	    	      DatagramSocket clientSocket = new DatagramSocket();
	    	      InetAddress IPAddress = InetAddress.getByName("10.113.31.51");
	    	      
	    	      String sentence = null;
	    	      sentence = inFromUser.readLine();
	    	      sendData = sentence.getBytes();
	    	      
	    	      //création d'un packet (data, longueur, IP + port)
	    	      DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 65432);
	    	      clientSocket.send(sendPacket);
	    	      
	    	      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
	    	      clientSocket.receive(receivePacket);
	    	      
	    	      String modifiedSentence = new String(receivePacket.getData(),receivePacket.getOffset(),receivePacket.getLength());
	    	      System.out.println("FROM SERVER :" + modifiedSentence);
	    	      
	    	      
	    	      
	    	      
	    	     }// while
	    	 }
	    	 catch (Exception error)
	    	 {
	    		 error.printStackTrace();
	    	 }
	    	 
	    	 
	     
		   
		
	   }// run


}
