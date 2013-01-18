/*
 * Cette classe permet d'associer un numéro de session à un utilisateur
 * 
 */
package User;

import java.util.Hashtable;


public class User_Session {
    
    public int Session_ID;
    public user_class user;
    
    public User_Session(int id, user_class utilisateur)
    {
        Session_ID = id;
        user = utilisateur;
    }
    
    public int get_privilege()
    {
        Hashtable<String, Integer> temp = (Hashtable<String, Integer>) Chat_Server.Base_de_donnees.bdd.get("privileges");
        return temp.get(user.type);
    }
    
}
