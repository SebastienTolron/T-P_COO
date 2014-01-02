package com.tosviel.coo.tpent.metiers;

public class Fichier extends Objet {

	public String relationFichier;
	
	public Fichier()
	{
		super();
		this.type="Fichier";
		this.relationFichier= "";
		
	}

	public Fichier(int id,String string) {
		this.nom=string;
		this.id=id;
		this.type = "Fichier";
		this.relationFichier= "";
	}

	public String getRelationFichier() {
		return relationFichier;
	}

	public void setRelationFichier(String relationFichier) {
		this.relationFichier = relationFichier;
	}

	
	
}
