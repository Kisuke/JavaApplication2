/*
 * Ici nous gérons le chargement et l'enregistrement de notre bdd via
 * sérialization.
 */
package Chat_Server;

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;


public class Base_de_donnees {
    
    static public Hashtable<String,Object> bdd; //Notre répertoire de données
    static public ArrayList Session_list;
    
    static public int Create_Session()
    {
        boolean retry = true;
        int session = 0;
        while(retry)
        {
            retry = false;
            session = (int)(Math.random() * 10000);
            if(Session_list.contains(session)) retry = true;
        }
        Session_list.add(session);
        return session;
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