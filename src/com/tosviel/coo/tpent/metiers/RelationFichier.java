package com.tosviel.coo.tpent.metiers;

public class RelationFichier {

	
		public int id;
		private Fichier fichier1;
		private Fichier fichier2;
		private Relation rel ;
		
		
		
		public RelationFichier(int cpt, Fichier fileModif, Fichier f1, Relation rel) {
			
			this.id = cpt ;
			this.fichier1 = fileModif;
			this.fichier2 = f1;
			this.rel = rel;
		
	}



		public RelationFichier() {
			// TODO Auto-generated constructor stub
		}



		public int getId() {
			return id;
		}



		public void setId(int id) {
			this.id = id;
		}



		public Fichier getFichier1() {
			return fichier1;
		}



		public void setFichier1(Fichier fichier1) {
			this.fichier1 = fichier1;
		}



		public Fichier getFichier2() {
			return fichier2;
		}



		public void setFichier2(Fichier fichier2) {
			this.fichier2 = fichier2;
		}



		public Relation getRel() {
			return rel;
		}



		public void setRel(Relation rel) {
			this.rel = rel;
		}
		
}
