package com.tosviel.coo.tpent.metiers;

public enum Libele {

	Correction("correction de"), Illustre("Illustre");

	private String name = "";

	// Constructeur
	Libele(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}
