/**
 * 
 */
package com.tosviel.coo.tpent.metiers;

import java.util.ArrayList;

import javax.swing.JTree;

/**
 * @author Seb
 *
 */
public class Groupe {


	private int id;
	private String nom;
	private Utilisateur adminGroup;
	private ArrayList<Utilisateur> listUtilisateurs;
	private ArrayList<Objet> listObjets; 
	private JTree treeObjet ;
	
	public Groupe(int i, String string, Utilisateur j, JTree arbre) {

		this.id=i;
		this.nom=string;
		this.adminGroup=j;
		this.treeObjet = arbre;
		this.listObjets = new ArrayList<Objet>();
		this.listUtilisateurs=new ArrayList<Utilisateur>();
		this.listUtilisateurs.add(j);
	}

	public Groupe(int id, String nom, Utilisateur adminGroup) {
		super();
		this.id = id;
		this.nom = nom;
		this.adminGroup = adminGroup;
		this.listObjets = new ArrayList<Objet>();
		this.listUtilisateurs=new ArrayList<Utilisateur>();
		this.listUtilisateurs.add(adminGroup);
	}

	public Groupe() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Utilisateur getAdminGroup() {
		return adminGroup;
	}

	public void setAdminGroup(Utilisateur adminGroup) {
		this.adminGroup = adminGroup;
	}

	public void addUser(Utilisateur user) {
		this.listUtilisateurs.add(user);
		
	}


	public JTree getTreeObjet() {
		return treeObjet;
	}

	public void setTreeObjet(JTree treeObjet) {
		this.treeObjet = treeObjet;
	}

	@Override
	public String toString() {
		return "Groupe [id=" + id + ", nom=" + nom + ", adminGroup="
				+ adminGroup + ", listUtilisateurs=" + listUtilisateurs
				+ ", listObjets=" + listObjets + ", treeObjet=" + treeObjet
				+ "]";
	}

	public ArrayList<Utilisateur> getListUtilisateurs() {
		return listUtilisateurs;
	}

	public void setListUtilisateurs(ArrayList<Utilisateur> listUtilisateurs) {
		this.listUtilisateurs = listUtilisateurs;
	}

	public ArrayList<Objet> getListObjets() {
		return listObjets;
	}

	public void setListObjets(ArrayList<Objet> listObjets) {
		this.listObjets = listObjets;
	}

	public void removeUser(Utilisateur userByName) {
		this.listUtilisateurs.remove(userByName);
		
	}

	
	
	
}
