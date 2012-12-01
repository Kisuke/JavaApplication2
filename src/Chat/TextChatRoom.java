/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;
import java.util.ArrayList;
/**
 *
 * @author Kisuke
 */
public class TextChatRoom implements Chatroom {
    
    private ArrayList<TextChatter> liste_chatteurs;
    
    public TextChatRoom()
    {
        liste_chatteurs = new ArrayList<TextChatter>();
    }
    
    public void post(String msg, Chatter c)
    {
        //Renvoit à tout les chatteurs le message
    }
    public void quit(Chatter c)
    {
        //Envoit à tous les chatteurs le départ
        //Supprime c de la liste_chatteur
    }
    public void join(Chatter c)
    {
        //Envoit à tous les chatteurs l'arrivée
        //Ajoute c à la liste
    }
    public String getTopic(Chatter c)
    {
        return topic;
    }
    
}
