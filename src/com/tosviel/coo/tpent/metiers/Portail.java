/**
 * 
 */
package com.tosviel.coo.tpent.metiers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

import javax.swing.WindowConstants;

import com.tosviel.coo.tpent.ihm.FenetreConnexion;
import com.tosviel.coo.tpent.ihm.FenetreEnt;

/**
 * @author Seb
 *
 */
public class Portail  {
	
	private Utilisateur UserConnected ;
	private static boolean isConnectedToPortal;
	public ArrayList<Utilisateur> ListUsers = new ArrayList();
	public static ArrayList<Groupe> ListGroups = new ArrayList();
	public ArrayList<Objet> ListObjet = new ArrayList();

	/**
	 * @param p1 
	 * @param args
	 * @return 
	 */
	
	
	public  void SeConnecter (Portail p1)
	{
		FenetreConnexion fc = new FenetreConnexion(p1);	
		fc.setVisible(true);
		
	
		
	}


	public void addUser(Utilisateur utilisateur) {
		
		this.ListUsers.add(utilisateur);
		
		
	}
	
 // Getter et setters
	public Utilisateur getUserConnected() {
		return UserConnected;
	}

	public void setUserConnected(Utilisateur userConnected) {
		UserConnected = userConnected;
	}


	public void AfficheEnt(Portail p1) {
		
		
		
		FenetreEnt fent = new FenetreEnt(this);	;
	
		fent.setVisible(true);
		
	}


	public boolean isConnectedToPortal() {
		return isConnectedToPortal;
	}
	
	


	public void setConnectedToPortal(boolean isConnectedToPortal) {
		this.isConnectedToPortal = isConnectedToPortal;
	}


	public void deconnection() {
		
		 isConnectedToPortal= false;
		 this.setUserConnected(null);
	}


	public Utilisateur getUser(int i) {

		boolean arret=true;
		Iterator<Utilisateur> it = this.ListUsers.iterator();
   	 	Utilisateur uMatch = new Utilisateur();
    	while (arret) {
    		
    			
    	       Utilisateur u = it.next();	
    	       if ( u.getId() == i)
    	       {
    	       uMatch = u;
    	       arret = false;
    	       }
    	}
    	return uMatch;
	}




	public void addGroup(Groupe groupe) {
		
		this.ListGroups.add(groupe);

		
	}


	public Groupe getGroup(int i) {

		boolean arret=true;
		Iterator<Groupe> it = this.ListGroups.iterator();
		Groupe gMatch = new Groupe();
    	while (arret) {
    		
    			
    		   Groupe g = it.next();	
    	       if ( g.getId() == i)
    	       {
    	       gMatch = g;
    	       arret = false;
    	       }
    	  }
    	return gMatch;
    	
	}


	public void userConnected(Utilisateur u) {
		this.UserConnected=u;
		
	}
	
	public Utilisateur getUserByName(String nom){
		
		
		for ( int i = 0 ; i< ListUsers.size();i++)
		{
			if ( ListUsers.get(i).getNom().equals(nom))
			{
				return ListUsers.get(i);
			}
		}
		return null;
		
		}
		
	
}