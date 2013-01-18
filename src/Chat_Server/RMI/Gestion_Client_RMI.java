/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat_Server.RMI;

import Chat_Server.Base_de_donnees;
import Chat_Server.Utilisateur;
import java.util.ArrayList;

/**
 *
 * @author Kisuke
 */
public class Gestion_Client_RMI {
    public Utilisateur user = null;
    
    public Gestion_Client_RMI(int Session)
    {
        user = (Utilisateur)Base_de_donnees.Check_Session(Session);
    }
    
    public ArrayList<String> Liste_Salons()
    {
        if(user == null) return null;
        ArrayList<Chat.TextChatRoom> chatrooms = (ArrayList<Chat.TextChatRoom>)Base_de_donnees.bdd.get("chatrooms"); 
        ArrayList<String> Nom_salons = new ArrayList<String>();
        
        for(int i = 0; i < chatrooms.size();i++)
        {
           Nom_salons.add(chatrooms.get(i).Name_ChatRoom);
        }
        return Nom_salons;
    }
    
    public
    
}
