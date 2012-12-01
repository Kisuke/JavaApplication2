/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI_Connexion;

import Authentification.Authentification_class.Authentification;
import java.net.*;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.rmi.server.*;
 
 
public class Implementation extends UnicastRemoteObject implements Information
{
    private static final long serialVersionUID;
    public Thread authentification;
    
       public Implementation() throws RemoteException //Constructeur avec exception propagée
       {
           super();
       } 
 
       public String getCoucou() throws RemoteException
       {
                   
             System.out.println("getCoucou a été appelée dans le serveur\n");
             return "Coucou distant";
       }
       public static void main(String[] args)
       {
             if(System.getSecurityManager() == null)
                    System.setSecurityManager(new RMISecurityManager());
 
             try
             {
                           Implementation cs = new Implementation();
                           Naming.rebind("//lune/MonServeurRMI", cs);
                           System.out.println("Objet MonServeur lié");
             }
             catch(Exception e)
             {
                    System.out.println("\nProblème !!\n\n " + e.toString());
                    e.printStackTrace();
             }
       }

    @Override
    public String getAuthentification(String pseudo, String mdp) throws RemoteException {
       authentification = new Thread(new Authentification_RMI());
       
    }

    @Override
    public String getInscription(String pseudo, String mdp, String type) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}