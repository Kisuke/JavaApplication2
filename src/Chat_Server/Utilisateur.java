/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat_Server;
import User.user_class; //Importation de la partie user de notre bibliothèque

/**
 *
 * @author Kisuke
 */
public class Utilisateur extends user_class{
    String Alias_reserve; //L'alias que personne d'autre ne peut prendre
    
    public Utilisateur(String pseudo, String mdp, String type)
    {
        super(pseudo, mdp, type);
        
    }
    
    
    public String typeUser() {
        return type;
    }
    
}
