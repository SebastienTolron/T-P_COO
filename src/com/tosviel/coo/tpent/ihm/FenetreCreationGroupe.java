package com.tosviel.coo.tpent.ihm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.WindowConstants;

import com.tosviel.coo.tpent.metiers.Portail;

public class FenetreCreationGroupe extends JDialog {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTable table_1;



	/**
	 * Create the frame.
	 */
	public FenetreCreationGroupe() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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
		
	
		Object[][] donneesListUtilisateur = new Object[Portail.ListGroups.size()][8] ;
        for (int i = 0; i < Portail.ListGroups.size(); i++) {
            for (int j = 0; j < 1; j++) {
            	donneesListUtilisateur[i][j] =  Portail.ListGroups.get(i).getNom();
            	donneesListUtilisateur[i][j+1] =  "Modifier";
            }
        }
    	
        String[] entetes = {"Groupe", "Modifier",};
 
        JTable tableau = new JTable(donneesListUtilisateur, entetes);  
        
        
		
		table = new JTable();
		table.setBounds(34, 149, 140, 174);
		contentPane.add(table);
		
		table_1 = new JTable();
		table_1.setBounds(290, 149, 134, 174);
		contentPane.add(table_1);
		
		JButton btnNewButton = new JButton("->");
		btnNewButton.setBounds(199, 177, 46, 23);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("<-");
		button.setBounds(199, 242, 46, 23);
		contentPane.add(button);
		
		JButton btnNewButton_1 = new JButton("Enregistrer");
		btnNewButton_1.setBounds(34, 415, 140, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(242, 415, 140, 23);
		contentPane.add(btnAnnuler);
		
		JButton button_1 = new JButton("+");
		button_1.setBounds(34, 346, 56, 23);
		contentPane.add(button_1);
		
		JLabel lblListeDesUtilisateurs = new JLabel("Liste des utilisateurs");
		lblListeDesUtilisateurs.setBounds(34, 124, 125, 14);
		contentPane.add(lblListeDesUtilisateurs);
		
		JLabel lblUtilisateursDansLe = new JLabel("Utilisateurs dans le groupe");
		lblUtilisateursDansLe.setBounds(292, 124, 161, 14);
		contentPane.add(lblUtilisateursDansLe);
	}
}
