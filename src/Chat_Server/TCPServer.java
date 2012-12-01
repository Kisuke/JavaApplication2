/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat_Server;

import Authentification.Authentification_class.Authentification;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;

/**
 *
 * @author Kisuke
 */
abstract class TCPServer implements Runnable, Cloneable{
    
    private int port_comm;
    Socket commSocket;
    ServerSocket waitSock;
    public Thread authentification;
    
    
    void startServer(int port, Hashtable save) throws IOException
    {
        port_comm = port;
        waitSock = new ServerSocket( port_comm );	// ouverture du port 6788, creation du serveur
        System.out.println( "serveur : attente connection" );	
	commSocket = waitSock.accept();
        authentification = new Thread(new Authentification(commSocket, save));
        authentification.start();
    }
    
    void stopServer()
    {
        
    }
    
    int getPort()
    {
       return port_comm; 
    }
    
        @Override
    public void run()
    {
        
    }
        
    abstract void gereClient(Socket comm);
}
