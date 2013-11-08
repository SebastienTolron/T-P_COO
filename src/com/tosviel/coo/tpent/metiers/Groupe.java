/**
 * 
 */
package com.tosviel.coo.tpent.metiers;

import java.util.ArrayList;

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
	
	public Groupe(int i, String string, Utilisateur j) {

		this.id=i;
		this.nom=string;
		this.adminGroup=j;
		this.listObjets = new ArrayList<Objet>();
		this.listUtilisateurs=new ArrayList<Utilisateur>();
		this.listUtilisateurs.add(j);
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

	@Override
	public String toString() {
		return "Groupe [id=" + id + ", nom=" + nom + ", adminGroup="
				+ adminGroup + ", listUtilisateurs=" + listUtilisateurs
				+ ", listObjets=" + listObjets + "]";
	}

	
	
	
}
