/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Authentification.Authentification_class;

import Chat_Server.Utilisateur;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Hashtable;

import Chat_Server.Base_de_donnees;

/**
 *
 * @author Kisuke
 */
public class Authentification_RMI implements Authentification.Authentification_interface.AuthentificationManager, Serializable, runnable{
 public Socket s;
	boolean identifie;
	public Thread operation;
	public Hashtable bdd;
        public Utilisateur user = null;
	
	public Authentification_RMI()
	{
		bdd = Chat_Server.Base_de_donnees.bdd;
	}
	
	//Possibilit� 1 : connexion
	//Possibilit� 2 : inscription
	public synchronized String run(String type_run, String pseudo, String mdp, String type)
	{
		try
		{
				if(type_run.equals("connexion"))
				{
                                    boolean stop = false;
                                    
                                        
                                        ArrayList<User.user_class> search_user = (ArrayList<User.user_class>)bdd.get("Utilisateurs");
                                        System.out.println("connexion reçue : " + pseudo + mdp);
                                       
                                        for(int i = 0; i < search_user.size() && !stop;i++)
                                        {
                                            Utilisateur x = search_user.get(i);
                                            if(x.toString().equals(pseudo + "\n" + mdp))
                                            {
                                                stop = true;
                                                identifie = true;
                                                user = x;
                                                int Session_ID = Base_de_donnees.Create_Session(); //Se trouve dans base de donnees
                                                return ("connecté" + "\n" + String.valueOf(Session_ID) + "\n" + x.typeUser());
                                            }
                                        }
                                    
                                    if(!stop) {
                                        System.out.println("Mauvais login");
                                        return null;
                                        
                                    }
					//Verification, si correct -> identifie = true sinon retour = "non"
				}
				else if(type_run.equals("inscription"))
				{
                                        System.out.println("Inscription reçue : " + pseudo + type + " " + mdp);
					if(!inscription(pseudo, mdp, type)) //Si utilisateur déjà existant
                                        {
                                            return null;
                                        }
                                        else
                                        {
                                            Base_de_donnees.save();
                                            identifie = true;
                                            int Session_ID = Base_de_donnees.Create_Session(); //Se trouve dans base de donnees
                                            
                                            return ("connecte" + "\n" + String.valueOf(Session_ID));
                                 
                                        }
				}
		}
		catch (IOException e) {
			
			System.err.println("Erreur connexion 1");
		}
	}
	
	public boolean inscription(String pseudo, String mdp, String type_compte)
	{
            ArrayList<String> liste_typecompte = (ArrayList<String>) bdd.get("type_compte"));
            boolean okay = false;
                    
            for(int i=0; i<liste_typecompte.size();i++)
            {
                String type_courant = liste_typecompte.get(i);
                if(type_courant.equals(type_compte)) okay = true;                
            }
            if(okay)
            {
		ArrayList<User.user_class> temp = (ArrayList<User.user_class>)bdd.get("Utilisateurs");
		user = new Utilisateur(pseudo, mdp, type_compte);
                temp.add((Utilisateur)user);
                return true;
            }	
                        else return false;
	}   
}
