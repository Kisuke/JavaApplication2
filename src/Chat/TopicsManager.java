package Chat;

import java.util.ArrayList;

public interface TopicsManager {
    public ArrayList<String> listTopics();    
    public Chatroom joinTopic(String topic);
    public String createTopic();
}
