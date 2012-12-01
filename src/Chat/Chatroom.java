package Chat;


public interface Chatroom {
    
    public void post(String msg, Chatter c);
    public void quit(Chatter c);
    public void join(Chatter c);
    public String getTopic(Chatter c);
}
