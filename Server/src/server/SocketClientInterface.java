package server;

/**
 * Socket Client interface.
 * @author Jiaqi Zhang
 *
 */
public interface SocketClientInterface
{
	/**
	 * Open connection.
	 * @return true if successfully open the connection, false otherwise.
	 */
    boolean openConnection();
    
    /**
     * Handle the session.
     */
    void handleSession();
    
    /**
     * Close the session.
     */
    void closeSession();
}
