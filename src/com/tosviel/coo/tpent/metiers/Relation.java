package com.tosviel.coo.tpent.metiers;

public class Relation {

	private Libele libele;
	private Object objet;

	public Relation(String pLibele, Object pObjet) {
		this.setLibele(Libele.valueOf(pLibele));
		this.setObjet(pObjet);
		// TODO Auto-generated constructor stub
	}

	public Libele getLibele() {
		return libele;
	}

	public void setLibele(Libele libele) {
		this.libele = libele;
	}

	public Object getObjet() {
		return objet;
	}

	public void setObjet(Object objet) {
		this.objet = objet;
	}

}
