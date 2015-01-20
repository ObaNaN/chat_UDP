package chat;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class UDPServer implements Runnable {

	
	public void run ()
	{

          
		
	
			try
			{
				   DatagramSocket serverSocket = new DatagramSocket(65432);
		           byte[] receiveData = new byte[1024];
		           byte[] sendData = new byte[1024];
				
				while(true)
				{

	                  DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
	                  serverSocket.receive(receivePacket);
	                  String sentence = new String( receivePacket.getData(),receivePacket.getOffset(),receivePacket.getLength());
	                  System.out.println("RECEIVED by server : " + sentence);
	                  
	                  InetAddress IPAddress = receivePacket.getAddress();
	                  int port = receivePacket.getPort();
	                  
	                  String capitalizedSentence = sentence.toUpperCase(); // convertie le string en majuscuule..
	                  sendData = capitalizedSentence.getBytes();
	                  DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
	                  serverSocket.send(sendPacket);
				}
				
			} //try
			catch(Exception error)
			{
				error.printStackTrace();
			}

		
	}// run
	
}
