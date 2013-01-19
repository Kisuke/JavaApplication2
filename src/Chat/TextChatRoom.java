/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;
import Chat_Server.Utilisateur;
import java.util.ArrayList;
/**
 *
 * @author Kisuke
 */
public class TextChatRoom implements Chatroom {
    
    public ArrayList<Utilisateur> liste_chatteurs;
    public String Name_ChatRoom;
    
    public TextChatRoom(String nom)
    {
        liste_chatteurs = new ArrayList<Utilisateur>();
        Name_ChatRoom = nom;
    }
    
    public void post(String msg, Chatter c)
    {
        //Renvoit à tout les chatteurs le message
    }
    public void quit(Utilisateur c)
    {
        liste_chatteurs.remove(c);
    }
    public void join(Utilisateur c)
    {
        liste_chatteurs.add(c);
    }
    public String getTopic(Chatter c)
    {
        return topic;
    }
    
    
}
