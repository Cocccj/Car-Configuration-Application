package driver;

import java.io.IOException;
import java.net.ServerSocket;

import server.DefaultSocketClient;


/**
 * Main driver for the server in car configuration application unit4.
 * @author Jiaqi Zhang
 *
 */
public class Driver {

	/**
	 * Main driver
	 * @param args no argument
	 */
	public static void main(String [] args) {
		ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(7799);
        } catch (IOException e) {
            System.out.println("Cannot listen on the port.");
        }
        try {
        	System.out.println("Server running...");
	        while(true) {
	        	// listen to connections
	        	try {
		            DefaultSocketClient client = new DefaultSocketClient(
		            									serverSocket.accept());
		            client.start();
	        	} catch (IOException e) {
	        		System.err.println("Accept failed.");
	        		System.exit(1);
				}
	        }
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
        	System.out.println("Stop.");
        	if (serverSocket != null) {
	            try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        }
	}
}
