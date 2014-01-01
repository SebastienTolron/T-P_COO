package com.tosviel.coo.tpent.ihm;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
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
import com.tosviel.coo.tpent.metiers.Objet;
import com.tosviel.coo.tpent.metiers.Portail;
import com.tosviel.coo.tpent.metiers.Utilisateur;

import javax.swing.JTree;

import java.awt.Color;

import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import java.awt.Font;

public class FenetreCreationGroupe extends JFrame  {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTable table_1;
	public String temp ="" ;
	private JTable table_2;
	public JTree treePanel;
    private int newNodeSuffix = 1;
    public int cptTree = 0 ;
	private ArrayList<Fichier> listObjetFichier = new ArrayList<Fichier>();
	private ArrayList<Dossier> listObjetDossier = new ArrayList<Dossier>();
	private JPanel contentPaneUsers;
	private JPanel contentPaneDocuments;


	/**
	 * Create the frame.
	 */
	public FenetreCreationGroupe(final Portail p1) {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 637);
		contentPane = new JPanel();
		contentPaneUsers = new JPanel();
		contentPaneDocuments = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCreationDeGroupe = new JLabel("Creation de groupe");
		lblCreationDeGroupe.setFont(new Font("Calibri", Font.BOLD, 24));
		lblCreationDeGroupe.setBounds(236, 30, 192, 30);
		contentPane.add(lblCreationDeGroupe);
		
		textField = new JTextField();
		textField.setBounds(87, 82, 134, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Calibri", Font.PLAIN, 17));
		lblNom.setBounds(33, 85, 46, 14);
		contentPane.add(lblNom);
		
		
		// remplissage des utilisateurs 
	
		Object[][] donneesListUtilisateur = new Object[p1.ListUsers.size()][8] ;
        for (int i = 0; i < p1.ListUsers.size(); i++) {
            for (int j = 0; j < 1; j++) {
            	donneesListUtilisateur[i][j] =  p1.ListUsers.get(i).getNom();
            	
            }
        }
    	
        String[] entetes = {"Users"};
        contentPaneUsers.setLayout(null);
 
       
        JTable tableau = new JTable(donneesListUtilisateur, entetes);  
        
		table = tableau;		
		JPanel panel = new JPanel();
		panel.setBounds(26, 71, 181, 192);
		contentPaneUsers.add(panel);		
		panel.add(table);
		

		final DefaultListModel listModel = new DefaultListModel();
		final JList list = new JList(listModel);
		
		
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(323, 73, 181, 190);
		contentPaneUsers.add(panel2);
		panel2.add(list);
	

		
		
		
		JButton btnAjout = new JButton("->");
		btnAjout.setBounds(240, 111, 45, 23);
		contentPaneUsers.add(btnAjout);
		
		JButton btnSave = new JButton("Enregistrer");
		btnSave.setForeground(Color.BLACK);
		btnSave.setBounds(87, 476, 140, 23);
		contentPane.add(btnSave);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(259, 476, 140, 23);
		contentPane.add(btnAnnuler);
		
		
		JLabel lblListeDesUtilisateurs = new JLabel("Liste des utilisateurs");
		lblListeDesUtilisateurs.setFont(new Font("Calibri", Font.PLAIN, 19));
		lblListeDesUtilisateurs.setBounds(31, 19, 200, 35);
		contentPaneUsers.add(lblListeDesUtilisateurs);
		
		JButton btnRemove = new JButton("<-");
		btnRemove.setBounds(240, 157, 45, 23);
		contentPaneUsers.add(btnRemove);
		
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
		
		JLabel lblUtilisateursDansLe = new JLabel("Utilisateurs dans le groupe");
		lblUtilisateursDansLe.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblUtilisateursDansLe.setBounds(323, 19, 212, 35);
		contentPaneUsers.add(lblUtilisateursDansLe);
		
		// Tables des documents
		// Faire une JList pour ajouter les documents car le groupe n'est pas encore creer
		
		// faire un modele pour les documents 
		
		final DefaultListModel listModelDoc = new DefaultListModel();
		
		
			// construction de l'arbre
				
			//create the root node
	        DefaultMutableTreeNode root = new DefaultMutableTreeNode(new Dossier(cptTree,"Racine"));
	        cptTree++;
	        root.add(new DefaultMutableTreeNode(" ."));
    		contentPaneDocuments.setLayout(null);

     
        	//create the tree by passing in the root node   
        	
    		treePanel = new JTree(root);
    		//treePanel.setBounds(91, 5, , 200);
    		treePanel.setEditable(true);
    		
    		JScrollPane scrollPane = new JScrollPane(treePanel) ;
    	
    		scrollPane.setBounds(5, 5, 400, 280);
      
    		contentPaneDocuments.add(scrollPane);
			
			JButton btnAjouterDossier = new JButton("Ajouter Dossier");
			btnAjouterDossier.setBounds(428, 11, 107, 23);
			contentPaneDocuments.add(btnAjouterDossier);
			
				//contentPane.add(scrollPane);
				
				JButton btnAjouterFichier = new JButton("Ajouter Fichier");
				btnAjouterFichier.setBounds(432, 45, 103, 23);
				contentPaneDocuments.add(btnAjouterFichier);
				
				
				btnAjouterFichier.addActionListener(new ActionListener(){
				      
					public void actionPerformed(ActionEvent e){
	        	
						DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) treePanel.getLastSelectedPathComponent();			
						if ((selectedNode.getUserObject() instanceof Dossier))
						{
							
							selectedNode.add(new DefaultMutableTreeNode(new Fichier(cptTree,"Fichier")));
							cptTree++;
							
							treePanel.updateUI();
						
						}
					
					}
	 });
			
			JButton btnSupprimer = new JButton("Supprimer");
			btnSupprimer.setBounds(454, 79, 81, 23);
			contentPaneDocuments.add(btnSupprimer);
			
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBounds(32, 127, 550, 324);
			contentPane.add(tabbedPane);
			
			
			 tabbedPane.addTab("Gestion Utilisateurs", contentPaneUsers);
			 // In this case the custom component is responsible for rendering the
			 // title of the tab.
			// tabbedPane.addTab(null, myComponent);
			 tabbedPane.setTabComponentAt(0, new JLabel("Tab1"));
			 tabbedPane.addTab("Gestion des document", contentPaneDocuments);
			 // In this case the custom component is responsible for rendering the
			 // title of the tab.
			// tabbedPane.addTab(null, myComponent);
			 tabbedPane.setTabComponentAt(0, new JLabel("Gestion des Utilisateirs "));
			 
			 
			
		
		
		
		btnAjout.addActionListener(new ActionListener(){
		      
			public void actionPerformed(ActionEvent e){
	        	
				
				int j = table.getSelectedRow();
				int i = table.getSelectedColumn();
				
				// On recupere l'arbre pour creer le groupe
				
				
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
		
		
		
		
		
		
		
		btnSave.addActionListener(new ActionListener(){
		      
			public void actionPerformed(ActionEvent e){
				
				
	        	int idGroup = p1.ListGroups.size();
				Groupe groupe = new Groupe(idGroup,textField.getText(), p1.getUserConnected(),treePanel);
				DefaultMutableTreeNode root = (DefaultMutableTreeNode) treePanel.getModel().getRoot();	
				SaveTree(root, p1, idGroup);
				groupe.setListFichier(listObjetFichier);
				groupe.setListDossier(listObjetDossier);
				// on Lie l'administrateur au groupe 
				p1.addGroup(groupe);	
				
				System.out.println("Groupe = "+ p1.getGroup(idGroup));
				System.out.println(p1.ListGroups);
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
				
				
				System.out.println(p1.getUserConnected().toString());
				
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
		

		btnAjouterDossier.addActionListener(new ActionListener(){
		      
			public void actionPerformed(ActionEvent e){
	        	
				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) treePanel.getLastSelectedPathComponent();			
				if ((selectedNode.getUserObject() instanceof Dossier))
				{
					
					DefaultMutableTreeNode tempNode = new DefaultMutableTreeNode(new Dossier(cptTree,"Dossier"));
					cptTree++;;
					tempNode.add(new DefaultMutableTreeNode(new Fichier(cptTree,"FichierExemple")));					
					cptTree++;
					selectedNode.add(tempNode);					
					
					treePanel.updateUI();
				
				}
			
				
			}
	
		
			});
				
		}
		
		
	public void SaveTree(DefaultMutableTreeNode root,Portail p1,int groupId)
	{
		
	
		
		Enumeration enumerationOnTree = root.depthFirstEnumeration();
	
    	while(enumerationOnTree.hasMoreElements()) {
 
    		
    		DefaultMutableTreeNode element = (DefaultMutableTreeNode)enumerationOnTree.nextElement();
    		System.out.println("Next + "+element.getUserObject());
    	
    		if(element.getUserObject() instanceof Dossier ){
    			
    			listObjetDossier.add((Dossier)element.getUserObject());
    			//p1.getGroup(groupId).addDossier(doss);
 
    		}
    		if(element.getUserObject() instanceof Fichier  ){
    		
    		
    			listObjetFichier.add((Fichier)element.getUserObject());
    			//p1.getGroup(groupId).addFichier((Fichier)element.getUserObject());
    		
 
    		
    		}
    	
    	}
	
    
	}
	}