package driver;

import client.DefaultSocketClient;


/**
 * Main driver for client in the car configuration application unit4.
 * @author Jiaqi Zhang
 *
 */
public class Driver {

	/**
	 * Main driver
	 * @param args no argument
	 */
	public static void main(String [] args) {
		String strHost = "localhost";
        int port = 7799;
        DefaultSocketClient clientSocket = new DefaultSocketClient(strHost, port);
        clientSocket.start();
	}
}
