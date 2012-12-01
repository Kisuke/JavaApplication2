package Authentification.Authentification_interface;

import java.io.IOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Kisuke
 */
public interface AuthentificationManager {
    void addUser(String login, String password) throws UserExitsException;
    void removeUser(String login) throws UserUnknownException;
    void authentify(String login, String password) throws UserExitsException, WrongPasswordException;
    //static AuthentificationManager load(String path) throws IOException;
    void save(String path) throws IOException;
}
