/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI_Connexion;

import java.rmi.*;
        
public interface Information extends Remote {
    
    public String getAuthentification(String pseudo, String mdp) throws RemoteException;
    public String getInscription(String pseudo, String mdp, String type) throws RemoteException;
    
}


