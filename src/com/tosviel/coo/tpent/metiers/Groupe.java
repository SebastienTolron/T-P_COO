/**
 * 
 */
package com.tosviel.coo.tpent.metiers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.TreeNode;

/**
 * @author Seb
 * 
 */
public class Groupe {

	private int id;
	public int cpt;
	private String nom;
	private Utilisateur adminGroup;
	private ArrayList<Utilisateur> listUtilisateurs;
	private ArrayList<Objet> listObjets;
	private ArrayList<Fichier> listFichier;
	private ArrayList<Dossier> listDossier = new ArrayList<Dossier>();
	private JTree treeObjet;
	private ArrayList<RelationFichier> listRelation;

	public Groupe(int i, String string, Utilisateur j, JTree arbre) {

		this.id = i;
		this.nom = string;
		this.adminGroup = j;
		this.treeObjet = arbre;
		this.listObjets = new ArrayList<Objet>();
		this.listUtilisateurs = new ArrayList<Utilisateur>();
		this.listUtilisateurs.add(j);
		this.listFichier = new ArrayList<Fichier>();
		this.listRelation = new ArrayList<RelationFichier>();
	}

	public Groupe(int id, String nom, Utilisateur adminGroup) {
		super();
		this.id = id;
		this.nom = nom;
		this.adminGroup = adminGroup;
		this.listObjets = new ArrayList<Objet>();
		this.listUtilisateurs = new ArrayList<Utilisateur>();
		this.listUtilisateurs.add(adminGroup);
		this.listFichier = new ArrayList<Fichier>();
		this.listRelation =  new ArrayList<RelationFichier>();
	}

	public Groupe() {

	}

	public ArrayList<Fichier> getListFichier() {
		return listFichier;
	}

	public void setListFichier(ArrayList<Fichier> listFichier) {
		this.listFichier = listFichier;
	}

	public ArrayList<Dossier> getListDossier() {
		return listDossier;
	}

	public void setListDossier(ArrayList<Dossier> listDossier) {
		this.listDossier = listDossier;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Utilisateur getAdminGroup() {
		return adminGroup;
	}

	public void setAdminGroup(Utilisateur adminGroup) {
		this.adminGroup = adminGroup;
	}

	public void addUser(Utilisateur user) {
		this.listUtilisateurs.add(user);

	}

	public JTree getTreeObjet() {
		return treeObjet;
	}

	public void setTreeObjet(JTree treeObjet) {
		this.treeObjet = treeObjet;
	}

	@Override
	public String toString() {
		return "Groupe [id=" + id + ", nom=" + nom + ", adminGroup="
				+ adminGroup + ", listUtilisateurs=" + listUtilisateurs
				+ ", listObjets=" + listObjets + ", listFichier=" + listFichier
				+ ", listDossier=" + listDossier + ", treeObjet=" + treeObjet
				+ "]";
	}

	public ArrayList<Utilisateur> getListUtilisateurs() {
		return listUtilisateurs;
	}

	public void setListUtilisateurs(ArrayList<Utilisateur> listUtilisateurs) {
		this.listUtilisateurs = listUtilisateurs;
	}

	public ArrayList<Objet> getListObjets() {
		return listObjets;
	}

	public void setListObjets(ArrayList<Objet> listObjets) {
		this.listObjets = listObjets;
	}

	public void removeUser(Utilisateur userByName) {
		this.listUtilisateurs.remove(userByName);

	}

	public Objet getObjet(Fichier fileModif) {

		Fichier returnF = new Fichier();
		for (int i = 0; i < listObjets.size(); i++) {
			if (listObjets.get(i) == fileModif) {
				returnF = (Fichier) listObjets.get(i);
			}
		}

		return returnF;
	}

	public Fichier getFichierById(int id2) {

		for (int i = 0; i < listFichier.size(); i++) {
			if (listFichier.get(i).id == id2)
				return listFichier.get(i);
		}
		return null;
	}

	public void updateFichier(Fichier file, JTextField textField) {

		int indexTemp = this.getIndexByFile(file);
		this.listFichier.get(indexTemp).nom = textField.getText();

	}

	public int getIndexByFile(Fichier file) {

		int index = 0;
		for (int i = 0; i < listFichier.size(); i++) {
			if (listFichier.get(i).id == file.id) {
				index = i;
			}
		}
		return index;
	}

	private int getIndexByFolder(Dossier dossier) {
		int index = 0;
		for (int i = 0; i < listDossier.size(); i++) {
			if (listDossier.get(i).id == dossier.id) {
				index = i;
			}
		}
		return index;
	}

	public Dossier getDossierById(int id2) {
		for (int i = 0; i < listDossier.size(); i++) {
			if (listDossier.get(i).id == id2)
				return listDossier.get(i);
		}
		return null;
	}

	public void updateDossier(Dossier dossier, JTextField textField) {

		int indexTemp = this.getIndexByFolder(dossier);
		this.listDossier.get(indexTemp).nom = textField.getText();

	}

	public void addRelation(Fichier fileModif, Fichier f2,
			Relation rel2) {

	
		RelationFichier rel = new RelationFichier(cpt,fileModif,f2,rel2);
		this.listRelation.add(rel);
		cpt++;
		
		
	}

	public RelationFichier getRelation(Fichier fileModif) {
	
		
		for ( int i = 0 ; i< listFichier.size() ; i++)
		{
		
			Fichier f2 = this.listFichier.get(i);
			int index = isRelation(fileModif,f2);
			if ( index != -1)
			{				
				return this.listRelation.get(index);
			
			}
		
			
		
		}
		
		return null;
	}

	private int isRelation(Fichier fileModif, Fichier f2) {

		int index = -1 ;
		for ( int j = 0 ; j < listRelation.size() ; j++)
		{
			RelationFichier temp = this.listRelation.get(j);
			if (temp.getFichier1() == fileModif && temp.getFichier2() == f2)
			{
				index = j;
			}
		}
		return index;
	}

}
