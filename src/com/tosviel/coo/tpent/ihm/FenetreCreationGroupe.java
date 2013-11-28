package com.tosviel.coo.tpent.ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;

import com.tosviel.coo.tpent.metiers.Dossier;
import com.tosviel.coo.tpent.metiers.DynamicTree;
import com.tosviel.coo.tpent.metiers.Fichier;
import com.tosviel.coo.tpent.metiers.Groupe;
import com.tosviel.coo.tpent.metiers.Portail;
import com.tosviel.coo.tpent.metiers.Utilisateur;

import javax.swing.JTree;

import java.awt.Color;

public class FenetreCreationGroupe extends JFrame  {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTable table_1;
	public String temp ="" ;
	private JTable table_2;
	private	JTree treePanel;
    private int newNodeSuffix = 1;


	/**
	 * Create the frame.
	 */
	public FenetreCreationGroupe(final Portail p1) {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCreationDeGroupe = new JLabel("Creation de groupe");
		lblCreationDeGroupe.setBounds(147, 29, 125, 14);
		contentPane.add(lblCreationDeGroupe);
		
		textField = new JTextField();
		textField.setBounds(90, 71, 134, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(22, 74, 46, 14);
		contentPane.add(lblNom);
		
		
		// remplissage des utilisateurs 
	
		Object[][] donneesListUtilisateur = new Object[p1.ListUsers.size()][8] ;
        for (int i = 0; i < p1.ListUsers.size(); i++) {
            for (int j = 0; j < 1; j++) {
            	donneesListUtilisateur[i][j] =  p1.ListUsers.get(i).getNom();
            	
            }
        }
    	
        String[] entetes = {"Users"};
 
       
        JTable tableau = new JTable(donneesListUtilisateur, entetes);  
        
		table = tableau;		
		JPanel panel = new JPanel();
		panel.setBounds(34, 149, 140, 174);
		contentPane.add(panel);		
		panel.add(table);
		

		final DefaultListModel listModel = new DefaultListModel();
		final JList list = new JList(listModel);
		
		
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(290, 149, 134, 174);
		contentPane.add(panel2);
		panel2.add(list);
	

		
		
		
		JButton btnAjout = new JButton("->");
		btnAjout.setBounds(199, 177, 46, 23);
		contentPane.add(btnAjout);
		
		JButton btnRemove = new JButton("<-");
		btnRemove.setBounds(199, 242, 46, 23);
		contentPane.add(btnRemove);
		
		JButton btnSave = new JButton("Enregistrer");
		btnSave.setForeground(Color.BLACK);
		btnSave.setBounds(34, 532, 140, 23);
		contentPane.add(btnSave);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(225, 532, 140, 23);
		contentPane.add(btnAnnuler);
		
		
		JLabel lblListeDesUtilisateurs = new JLabel("Liste des utilisateurs");
		lblListeDesUtilisateurs.setBounds(34, 124, 125, 14);
		contentPane.add(lblListeDesUtilisateurs);
		
		JLabel lblUtilisateursDansLe = new JLabel("Utilisateurs dans le groupe");
		lblUtilisateursDansLe.setBounds(292, 124, 161, 14);
		contentPane.add(lblUtilisateursDansLe);
		
		// Tables des documents
		// Faire une JList pour ajouter les documents car le groupe n'est pas encore creer
		
		// faire un modele pour les documents 
		
		final DefaultListModel listModelDoc = new DefaultListModel();
		
		
			// construction de l'arbre
				
			//create the root node
	        DefaultMutableTreeNode root = new DefaultMutableTreeNode(new Dossier("Racine"));
	        root.add(new DefaultMutableTreeNode("FichierExemple"));

     
        	//create the tree by passing in the root node   
        	
    		treePanel = new JTree(root);
    		treePanel.setEditable(true);
			
      

		
			treePanel.setBounds(35, 347, 353, 127);
			contentPane.add(treePanel);
			
			JButton btnAjouterFichier = new JButton("Ajouter Fichier");
			btnAjouterFichier.setBounds(34, 477, 103, 23);
			contentPane.add(btnAjouterFichier);
			
			JButton btnAjouterDossier = new JButton("Ajouter Dossier");
			btnAjouterDossier.setBounds(147, 477, 107, 23);
			contentPane.add(btnAjouterDossier);
			
			JButton btnSupprimer = new JButton("Supprimer");
			btnSupprimer.setBounds(264, 477, 89, 23);
			contentPane.add(btnSupprimer);
			
		
		
		
		btnAjout.addActionListener(new ActionListener(){
		      
			public void actionPerformed(ActionEvent e){
	        	
				
				int j = table.getSelectedRow();
				int i = table.getSelectedColumn();
				
				if ( i != -1 && j!= -1)
				{
					Object Nom = table.getValueAt(j, i);
					if (!temp.contains(Nom.toString()))
					{
						temp = temp + Nom.toString()+";;";				
						listModel.addElement(Nom);
					}
			
				
				}
				else
					JOptionPane.showMessageDialog(contentPane, "Veuillez Selectionner un utilisateur");
				
	            }
	 });
		
		btnRemove.addActionListener(new ActionListener(){
		      
			public void actionPerformed(ActionEvent e){
	        	
				
				try {
				
					int i = list.getSelectedIndex();
					temp = temp.replace(list.getSelectedValue().toString()," ");
					listModel.remove(i);
				
				
				}
				catch (Exception err)
				{
					JOptionPane.showMessageDialog(contentPane, "Veuillez Selectionner un utilisateur a supprimer du groupe");
				
	            }
			}
	 });
		
		
		
		
		
		
		
		btnSave.addActionListener(new ActionListener(){
		      
			public void actionPerformed(ActionEvent e){
				
				
	        	int idGroup = p1.ListGroups.size();
				Groupe groupe = new Groupe(idGroup,textField.getText(), p1.getUserConnected());
				// on Lie l'administrateur au groupe 
				p1.addGroup(groupe);			
				p1.getUserConnected().addGroup(groupe);
				
				// on lie tous les utilisateurs selectionnées au groupe 			
				for ( int i =0 ; i < listModel.getSize() ; i++ )
				{
					if ( !listModel.get(i).toString().equals(p1.getUserConnected().getNom()))
					{
			
					p1.getGroup(idGroup).addUser(p1.getUserByName(listModel.get(i).toString()));
					p1.getUserByName(listModel.get(i).toString()).addGroup(p1.getGroup(idGroup));
					}
				}
				
				
				
				
				setVisible(false);
				p1.AfficheEnt(p1);
				
				
	     
	        }
	 });
		
		
		btnAnnuler.addActionListener(new ActionListener(){
		      
			public void actionPerformed(ActionEvent e){
	        	
				setVisible(false);
				p1.AfficheEnt(p1);
				
	     
	        }
	 });
		
		
		btnSupprimer.addActionListener(new ActionListener(){
		      
			public void actionPerformed(ActionEvent e){
	        	
				
				
	     
	        }
	 });
		
		
		btnAjouterFichier.addActionListener(new ActionListener(){
		      
			public void actionPerformed(ActionEvent e){
	        	
				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) treePanel.getLastSelectedPathComponent();			
				if ((selectedNode.getUserObject() instanceof Dossier))
				{
					
					selectedNode.add(new DefaultMutableTreeNode(new Fichier("Fichier")));
					treePanel.updateUI();
				
				}
			
			}
	 });
		

		btnAjouterDossier.addActionListener(new ActionListener(){
		      
			public void actionPerformed(ActionEvent e){
	        	
				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) treePanel.getLastSelectedPathComponent();			
				if ((selectedNode.getUserObject() instanceof Dossier))
				{
					
					selectedNode.add(new DefaultMutableTreeNode(new Dossier("Fichier")));
					
					treePanel.updateUI();
				
				}
			
				
	        }
	 });
		
		
		
		
		
		
		

		
		
	}
	
	public void buildTree()
	{
		
	}
}
