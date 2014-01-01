package com.tosviel.coo.tpent.metiers;

public class Fichier extends Objet {

	public Fichier()
	{
		super();
		this.type="Fichier";
		
	}

	public Fichier(int id,String string) {
		this.nom=string;
		this.id=id;
		this.type = "Fichier";
	}


	
}
