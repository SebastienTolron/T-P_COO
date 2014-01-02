package com.tosviel.coo.tpent.metiers;

public enum Relation {

	// Objets directement construits
	TdDe("Est le TD de "),
	TpDe("Est le TP de "),
	CorrectionDe("Est la correction de");

	private String name = "";

	// Constructeur
	Relation(String name){
	   this.name = name;
	  }

	public String toString() {
		return name;
	}

}
