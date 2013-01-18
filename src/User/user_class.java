/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

/**
 *
 * @author Kisuke
 */
public class user_class {
    protected String pseudo;
    protected String mdp; //Censé être hashé
    protected String type = null;
    
    public user_class(String pseudonyme, String mdpass, String type_compte)
    {
        pseudo = pseudonyme;
        mdp = mdpass;
        type = type_compte;
    }
    
}
