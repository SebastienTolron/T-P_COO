package com.tosviel.coo.tpent.ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

import com.tosviel.coo.tpent.metiers.Groupe;
import com.tosviel.coo.tpent.metiers.Portail;

public class FenetreCreationGroupe extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTable table_1;
	public String temp ="" ;


	/**
	 * Create the frame.
	 */
	public FenetreCreationGroupe(final Portail p1) {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 501);
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
        
        
        System.out.println(tableau.toString());
		
		table = tableau;		
		JPanel panel = new JPanel();
		panel.setBounds(34, 149, 140, 174);
		contentPane.add(panel);		
		panel.add(table);
		
		
		
		// Remplissage de rien 
		

	

	
		
			
		
		final DefaultListModel listModel = new DefaultListModel();


		final JList list = new JList(listModel);
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(250, 80));	
		
		
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
		btnSave.setBounds(34, 415, 140, 23);
		contentPane.add(btnSave);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(242, 415, 140, 23);
		contentPane.add(btnAnnuler);
		
		
		JLabel lblListeDesUtilisateurs = new JLabel("Liste des utilisateurs");
		lblListeDesUtilisateurs.setBounds(34, 124, 125, 14);
		contentPane.add(lblListeDesUtilisateurs);
		
		JLabel lblUtilisateursDansLe = new JLabel("Utilisateurs dans le groupe");
		lblUtilisateursDansLe.setBounds(292, 124, 161, 14);
		contentPane.add(lblUtilisateursDansLe);
		
		
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
	        	
				Groupe groupe = new Groupe(4,textField.getText(), p1.getUserConnected());
				// on Lie l'administrateur au groupe 
				p1.addGroup(groupe);			
				p1.getUserConnected().addGroup(groupe);
				
				// on lie tous les utilisateurs selectionnées au groupe 			
				for ( int i =0 ; i < listModel.getSize() ; i++ )
				{
					if ( !listModel.get(i).toString().equals(p1.getUserConnected().getNom()))
					{
					System.out.println("dans le FOR");
					p1.getGroup(4).addUser(p1.getUserByName(listModel.get(i).toString()));
					p1.getUserByName(listModel.get(i).toString()).addGroup(p1.getGroup(4));
					}
				}
				
				System.out.println(p1.getGroup(1).toString());
				
				
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
		
		
		
		
		
		
		
	}
}
