/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

import Chat_Server.Base_de_donnees;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author Kisuke
 */
public class TextGestTopics implements TopicsManager {
    
    ArrayList<TextChatRoom> Liste_topics;
    
    public TextGestTopics()
    {
        Liste_topics = (ArrayList<TextChatRoom>) Base_de_donnees.bdd.get("chatrooms");
    }
    
    public ArrayList<String> listTopics()
    {
        ArrayList<String> nom_topics;
        for(int i=0; i<Liste_topics.size();i++)
        {
            Liste_topics.get(i).getTopicName();
        }
        return liste;
    }
    public Chatroom joinTopic(String topic)
    {
        
    }
    public String createTopic()
    {
        return topic;
    }
}
