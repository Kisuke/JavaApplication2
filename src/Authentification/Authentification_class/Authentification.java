/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Authentification.Authentification_class;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Hashtable;

import Chat_Server.Base_de_donnees; 
/**
 *
 * @author Kisuke
 */
public class Authentification implements Authentification.Authentification_interface.AuthentificationManager, Serializable{
 public Socket s;
	boolean identifie;
	private PrintWriter out = null;
	private BufferedReader in = null;
	public Thread operation;
        public Utilisateur user = null;
	
	public Authentification()
	{
		s = sock;
		identifie = false;
	}
	
	//Possibilit� 1 : connexion
	//Possibilit� 2 : inscription
	public synchronized void run()
	{
		try
		{
			//Réception du choix connexion/inscription
			while(!identifie)
			{
                            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                            PrintWriter out = new PrintWriter(s.getOutputStream());
                            String verif;
                            //values = " connexion " ou " inscription "
                                verif = in.readLine();
				String pseudo = in.readLine();
				String mdp = in.readLine();
				if(verif.equals("connexion"))
				{
                                    boolean stop = false;
                                    
                                        
                                        ArrayList<User.user_class> search_user = (ArrayList<User.user_class>)bdd.get("Utilisateurs");
                                        System.out.println("connexion reçue : " + Prenom + Nom + mdp);
                                       
                                        for(int i = 0; i < search_user.size() && !stop;i++)
                                        {
                                            Eleve x = search_user.get(i);
                                            if(x.toString().equals(pseudo + "\n" + mdp))
                                            {
                                                stop = true;
                                                int Session_ID = Create_Session(); //Se trouve dans base de donnees
                                                out.println("connecte\n" + String.valueOf(Session_ID) + "\n" + x.typeUser());
                                                out.flush();
                                                identifie = true;
                                                user = x;
                                            }
                                        }
                                    
                                    if(!stop) {
                                        System.out.println("Mauvais login");
                                        out.println("wrong");
                                        out.flush();
                                        
                                    }
					//Verification, si correct -> identifie = true sinon retour = "non"
				}
				else if(verif.equals("inscription"))
				{
					//Inscription -> identifie = true
					String compte = in.readLine(); //pseudo+type de compte
                                        System.out.println("Inscription reçue : " + pseudo + compte + " " + mdp);
					while(!inscription(Prenom, Nom, mdp, compte)) //Si utilisateur déjà existant
                                        {
                                            out.println("wrong");
                                            out.flush();
                                            compte = in.readLine(); //pseudo+type de compte
                                            System.out.println("Inscription reçue : " + pseudo + compte + " " + mdp);
                                        }
                                        Classe_Serveur.sauvegarde(ecole);
                                        //Génération d'une session
                                        int Session_ID = Create_Session(); //Se trouve dans base de donnees
                                        out.println("connecte\n" + String.valueOf(Session_ID));
                                        out.flush();
                                        identifie = true;
                       
				}
			}
                       
			//operation = new Thread(new Traitement(s, ecole, user));
			//operation.start();
		}
		catch (IOException e) {
			
			System.err.println("Erreur connexion 1");
		}
	}
	
	public void inscription(String prenom, String nom, String mdp, String type_compte)
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
		user = new User.user_class(pseudo, mdp, type_compte);
                temp.add((User.user_class)user);
            }	
                        else System.err.println("Type de compte non valide.");
	}   
}
