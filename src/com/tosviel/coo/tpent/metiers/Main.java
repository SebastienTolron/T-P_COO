package com.tosviel.coo.tpent.metiers;

import com.tosviel.coo.tpent.ihm.FenetreConnexion;

public class Main {
	
	public static void main(String[] args) {

		// Initialisation des utilisateurs
		
		Portail p1 = new Portail();
		
		
		p1.addUser(new Utilisateur(1,"Admin","Admin","SuperAdmin","admin","admin"));
		p1.addUser(new Utilisateur(2,"Sebastien","Tolron","user","stolr","pass"));
		p1.addUser(new Utilisateur(3, "Thomas", "Bosviel", "admin", "tbosviel", "pass"));
		
		p1.addGroup(new Groupe(1,"Groupe enseigant - Annecy",p1.getUser(1)));
		p1.addGroup(new Groupe(2,"Groupe de enseignant - Chambéry",p1.getUser(1)));
		p1.addGroup(new Groupe(3,"Groupe de M2-ISC - Chambéry",p1.getUser(1)));
		
		/* Cest lutilisateur qui ajoute le groupe à la liste de groupe 
		/* puis evidemment le groupe insere l'utilisateur dans sa liste
		 * 
		 */
		p1.getUser(2).addGroup(p1.getGroup(2));
		p1.getUser(2).addGroup(p1.getGroup(3));
		
		p1.getGroup(2).addUser(p1.getUser(2));
		p1.getGroup(3).addUser(p1.getUser(2));
		
	
		
		p1.SeConnecter(p1);			
			
		//	p1.AfficheEnt();
		
			
		
			
		
	}
	
	

}
