/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI_Connexion;

import java.rmi.*;
import java.rmi.Naming;
import java.rmi.registry.*;
 
 
public class MonClientRMI
{
       public static void main(String[] args)
       {
             System.setSecurityManager(new RMISecurityManager());
             try
             {
                    CoucouDistant cd = (CoucouDistant)Naming.lookup("//lune/MonServeurRMI");
                    System.out.println("Client connecté");
                    System.out.println("******\n"+cd.getCoucou()+"\n******\n");
                    System.exit(0);
             }
             catch(Exception e)
             {
                    System.out.println(e.toString());
                    e.printStackTrace();
             }
       }