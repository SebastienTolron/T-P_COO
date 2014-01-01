/**
 * 
 */
package com.tosviel.coo.tpent.metiers;

import java.util.ArrayList;

/**
 * @author Seb
 *
 */
public class Utilisateur {
	
	public Utilisateur(int id, String prenom, String nom, String role,
			String login, String pass) {
		
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.role = role;
		this.login = login;
		this.pass = pass;
	}
	public Utilisateur() {
		
	}
	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", prenom=" + prenom + ", nom=" + nom
				+ ", role=" + role + ", login=" + login + ", pass=" + pass
				+ "]";
	}
	private int id ;
	private String prenom;
	private String nom;
	private String role;
	private String login;
	private String pass;
	public ArrayList<Groupe> ListGroup = new ArrayList<Groupe>();
	
	public synchronized int getId() {
		return id;
	}
	public  void setId(int id) {
		this.id = id;
	}
	public String getPrenom() {
		return prenom;
	}
	public  void setPrenom(String Prenom) {
		prenom = Prenom;
	}
	public String getNom() {
		return nom;
	}
	public   void setNom(String Nom) {
		nom = Nom;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public  String getRole() {
		return role;
	}
	public  void setRole(String Role) {
		role = Role;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void addGroup(Groupe group) {
		this.ListGroup.add(group);
		
	}
	public void removeGroup(Groupe groupRemove) {
		
		this.ListGroup.remove(groupRemove);
		
	}

}
