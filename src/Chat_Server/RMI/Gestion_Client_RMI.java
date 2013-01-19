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
    
    public String Entrer_Salon(int Session, String chat_name)
    {
        //Vérification que l'utilisateur n'est pas enregistré comme étant déjà dans une chatroom
        ArrayList<Chat.TextChatRoom> chatrooms = (ArrayList<Chat.TextChatRoom>)Base_de_donnees.bdd.get("chatrooms");
        int stop = 0;
        for(int i = 0; i < chatrooms.size() && stop == 0;i++)
        {
            if(chatrooms.get(i).liste_chatteurs.contains(user)) //Chatteur déjà enregistré dans un chat
            {
                if(chatrooms.get(i).Name_ChatRoom.equals(chat_name)) //Chatteur déjà enregistré dans la chatroom demandée
                {
                    if(Base_de_donnees.Chat_Session(Session).Name_ChatRoom.equals(chat_name)) stop = 1; //Sortie sans rien changer
                }
                else
                {
                    stop = 2; //Sortie avec mise à jour
                }
            }
        }
        if(stop != 1) //Mise à jour
        {
            for(int i = 0; i < chatrooms.size(); i++)
            {
                //On l'ajoute
                if(chatrooms.get(i).Name_ChatRoom.equals(chat_name))
                {
                    chatrooms.get(i).join(user);
                }
                if(stop == 2) //On le supprime des autres chats où il se trouve
                {
                    if(!chatrooms.get(i).Name_ChatRoom.equals(chat_name))
                    {
                        if(chatrooms.get(i).liste_chatteurs.contains(user)) chatrooms.get(i).liste_chatteurs.remove(user);
                    }
                }
            }
        }
        return null;
    }
    
}
