package com.tosviel.coo.tpent.metiers;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import com.tosviel.coo.tpent.ihm.FenetreConnexion;

public class Main {
	
	public static void main(String[] args) {

		// Initialisation des utilisateurs
		
		Portail p1 = new Portail();
		
		
		p1.addUser(new Utilisateur(1,"Admin","Admin","SuperAdmin","admin","admin"));
		p1.addUser(new Utilisateur(2,"Sebastien","Tolron","user","stolr","pass"));
		p1.addUser(new Utilisateur(3, "Thomas", "Bosviel", "admin", "tbosviel", "pass"));
		
		p1.addGroup(new Groupe(0,"Groupe enseigant - Annecy",p1.getUser(1)));
		p1.addGroup(new Groupe(1,"Groupe de enseignant - Chambéry",p1.getUser(1)));
		
		Groupe gp1 = new Groupe(2,"Groupe 1 M2-ISC - Chambéry",p1.getUser(1));
		Fichier f1 = new Fichier(0,"Exemple.pdf");
		gp1.getListFichier().add(f1);
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(new Dossier(1,"Racine"));
	    root.add(new DefaultMutableTreeNode(" ."));
	    root.add(new DefaultMutableTreeNode(f1));
	    JTree treeGroupe = new JTree(root);
	    gp1.setTreeObjet(treeGroupe);
		p1.addGroup(gp1);
		
		
		/* Cest lutilisateur qui ajoute le groupe à la liste de groupe 
		/* puis evidemment le groupe insere l'utilisateur dans sa liste
		 * 
		 */
		p1.getUser(2).addGroup(p1.getGroup(1));
		p1.getUser(2).addGroup(p1.getGroup(2));
		
		p1.getGroup(1).addUser(p1.getUser(2));
		p1.getGroup(2).addUser(p1.getUser(2));
		
	
		
		p1.SeConnecter(p1);			
			
	
			
		
			
		
	}
	
	

}
