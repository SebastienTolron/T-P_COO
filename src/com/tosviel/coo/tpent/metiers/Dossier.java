package com.tosviel.coo.tpent.metiers;

import java.util.ArrayList;

public class Dossier extends Objet {

	public ArrayList<Objet> ListObjet;
	
	public Dossier()
	{
		super();
		this.type="Fichier";
		this.ListObjet = new ArrayList<Objet>();
	}

	public Dossier(int cptTree , String Nom) {

		this.id=cptTree ; 
		this.nom = Nom;
		this.type = "Dossier";
	}
	
}
