/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

import Chat_Server.Utilisateur;

/**
 *
 * @author Kisuke
 */
public class TextChatter extends User.User_Session implements Chatter {
    
    Utilisateur user;
    TextChatRoom chat_courant = null;
    String Alias_chat;
   
    public TextChatter(int id, Utilisateur util)
    {
        super(id, util);
    }
    
    public void receiveAMessage(String msg, Chatter c)
    {
        
    }
    public void setAlias(String alias)
    {
        Alias_chat = alias;
    }
    public Utilisateur getUtilisateur()
    {
        return user;
    }
    
  
}
