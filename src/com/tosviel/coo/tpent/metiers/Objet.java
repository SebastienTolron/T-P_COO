/**
 * 
 */
package com.tosviel.coo.tpent.metiers;

import java.util.ArrayList;

/**
 * @author Seb
 * 
 */
public class Objet {

	public int id;
	public String nom;
	public String type;

	public ArrayList<Relation> listrelation = new ArrayList<Relation>();

	public void addRelation(String pLibele, Object pObjet) {
		Relation relation = new Relation(pLibele, pObjet);
		listrelation.add(relation);
	}

	@Override
	public String toString() {
		return this.nom;
	}
}