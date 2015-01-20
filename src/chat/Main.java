package chat;



public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Thread serv = new Thread(new UDPServer());
		serv.start();
		
		Thread client = new Thread(new UDPClient());
		client.start();
		
		
	}

}
