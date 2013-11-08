/**
 * 
 */
package com.tosviel.coo.tpent.metiers;

/**
 * @author Seb
 *
 */
public class Objet {
	
	private int id;
	private String nom;
	private String type;

	private synchronized int getId() {
		return id;
	}
	private synchronized void setId(int id) {
		this.id = id;
	}
	private synchronized String getNom() {
		return nom;
	}
	private synchronized void setNom(String nom) {
		this.nom = nom;
	}
	private synchronized String getType() {
		return type;
	}
	private synchronized void setType(String type) {
		this.type = type;
	}
	

}