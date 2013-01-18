/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI_Connexion;

import Authentification.Authentification_class.Authentification;
import Authentification.Authentification_class.Authentification_RMI;
import Chat_Server.RMI.Gestion_Client_RMI;
import java.net.*;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.util.ArrayList;
 
 
public class Implementation extends UnicastRemoteObject implements Information
{
    private static final long serialVersionUID;
    
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
       Authentification_RMI authentification = new Authentification_RMI("connexion", pseudo, mdp, null);
       return authentification.Authentifier();
    }

    @Override
    public String getInscription(String pseudo, String mdp, String type) throws RemoteException {
        Authentification_RMI authentification = new Authentification_RMI("inscription", pseudo, mdp, type);
       return authentification.Authentifier();
    }

    @Override
    public ArrayList<String> getListeChat(int Session) throws RemoteException {
        Gestion_Client_RMI gestion = new Gestion_Client_RMI(Session);
        return gestion.Liste_Salons();
    }

    @Override
    public String EnterChat(int Session, String NomSalon) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String CreateNewChat(int Session, String NomSalon) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}