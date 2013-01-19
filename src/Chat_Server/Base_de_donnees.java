/*
 * Ici nous gérons le chargement et l'enregistrement de notre bdd via
 * sérialization.
 */
package Chat_Server;

import Chat.TextChatRoom;
import Chat.TextChatter;
import User.User_Session;
import User.user_class;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;


public class Base_de_donnees {
    
    static public Hashtable<String,Object> bdd; //Notre répertoire de données
    static public ArrayList<TextChatter> Session_list;
    
    static public int Create_Session(user_class utilisateur)
    {
        boolean retry = true;
        int session = 0;
        while(retry)
        {
            retry = false;
            session = (int)(Math.random() * 10000);
            for(int i = 0; i<Session_list.size();i++)
            {
                if(Session_list.get(i).Session_ID == session) retry = true;
            }
        }
        Session_list.add(new TextChatter(session, (Utilisateur)utilisateur));
        return session;
    }
    
    static public user_class Check_Session(int Session_id)
    {
        for(int i=0; i<Session_list.size();i++)
        {
            if(Session_list.get(i).Session_ID == Session_id)
            {
                return Session_list.get(i).getUtilisateur();
            }
           
        }
         return null; //Pas de session enregistrée
    }

    static public TextChatRoom Chat_Session(int Session_id)
    {
        for(int i=0; i<Session_list.size();i++)
        {
            if(Session_list.get(i).Session_ID == Session_id)
            {
                return Session_list.get(i).chat_courant;
            }
           
        }
         return null; //Pas de session enregistrée
    }
    
    
    static public void save()
    {
        sauvegarde("base_de_donnees.txt");
    }
    
    static public void sauvegarde(String nom_fichier)
        {
            ObjectOutputStream oos;
            try {
        	oos = new ObjectOutputStream(
        				new BufferedOutputStream(
        						new FileOutputStream(
        								new File(nom_fichier))));
                oos.writeObject(bdd);
                oos.flush();
                oos.close();
            }
            catch (IOException e) {
            e.printStackTrace();
            }
        }
            
    public void chargement(String nom_fichier)
    {
        try {
                    try
                    {
                        ObjectInputStream ois;
                        ois = new ObjectInputStream(
    				new BufferedInputStream(
    						new FileInputStream(
    								new File(nom_fichier))));
                        bdd = (Hashtable<String,Object>)ois.readObject();
                       ois.close();
                    }catch (FileNotFoundException e) { //Si le fichier n'existe pas, on crée la base manuellement
			bdd.put("utilisateurs", new ArrayList<Chat_Server.Utilisateur>());
                        bdd.put("chatrooms", new ArrayList<Chat.TextChatRoom>());
                        bdd.put("privileges", new Hashtable<String, Integer>());
                        //(bdd.get("privileges")).put("Default",0);
                        
                        
                        
                        /*Ecole.put("eleves", new ArrayList<Eleve>());
			Ecole.put("cours", new ArrayList<Cours>());
			Ecole.put("majeures", new ArrayList<Majeure>());
			Ecole.put("profs", new ArrayList<Professeur>());
                        Ecole.put("admin", new ArrayList<Administrateur>());*/
                        e.printStackTrace();
                    }catch(ClassNotFoundException e){e.printStackTrace();}
            } catch (Exception e) {
			e.printStackTrace();
		}
    }
}