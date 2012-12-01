package Chat;

public interface Chatter {
    public void receiveAMessage(String msg, Chatter c);
    public void getAlias(String alias);
}
