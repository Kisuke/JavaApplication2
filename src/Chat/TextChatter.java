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
public class TextChatter implements Chatter {
    
    Utilisateur user;
    TextChatRoom chat_courant = null;
    String Alias_chat;
    int Session_ID;
    
    public TextChatter(int id, Utilisateur util)
    {
        Session_ID = id;
        user = util;
    }
    
    public void receiveAMessage(String msg, Chatter c)
    {
        
    }
    public void getAlias(String alias)
    {
        Alias_chat = alias;
    }
    
  
}
