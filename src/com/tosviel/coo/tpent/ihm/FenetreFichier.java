package com.tosviel.coo.tpent.ihm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.tosviel.coo.tpent.metiers.Fichier;
import com.tosviel.coo.tpent.metiers.Groupe;
import com.tosviel.coo.tpent.metiers.Objet;
import com.tosviel.coo.tpent.metiers.Portail;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class FenetreFichier extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 * @param fileModif 
	 * @param p1 
	 * @param gp 
	 */
	public FenetreFichier(final Portail p1, final Fichier fileModif, final Groupe gp) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 379, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFichier = new JLabel(fileModif.nom);
		lblFichier.setFont(new Font("Calibri", Font.BOLD, 25));
		lblFichier.setBounds(120, 11, 175, 35);
		contentPane.add(lblFichier);
		
		JLabel lblNom = new JLabel("Nom : ");
		lblNom.setBounds(25, 86, 46, 14);
		contentPane.add(lblNom);
		
		textField = new JTextField(fileModif.nom);
		textField.setBounds(81, 83, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox(gp.getListFichier().toArray());
		comboBox.setBounds(204, 160, 120, 20);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("V");
		btnNewButton.setBounds(131, 228, 50, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("X");
		btnNewButton_1.setBounds(191, 228, 46, 23);
		contentPane.add(btnNewButton_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(55, 160, 112, 20);
		contentPane.add(comboBox_1);
		
		JLabel lblRelation = new JLabel("Relation");
		lblRelation.setBounds(81, 135, 62, 14);
		contentPane.add(lblRelation);
		
		JLabel lblFichier_1 = new JLabel("Fichier");
		lblFichier_1.setBounds(224, 135, 46, 14);
		contentPane.add(lblFichier_1);
		
		
		btnNewButton.addActionListener(new ActionListener(){
		      
			public void actionPerformed(ActionEvent e){
	        	
					gp.updateFichier(gp.getFichierById(fileModif.id),textField);
					setVisible(false);
			
				
	        }
	 });
		
		btnNewButton_1.addActionListener(new ActionListener(){
		      
			public void actionPerformed(ActionEvent e){
	        	
					setVisible(false);
					//p1.AfficheEnt(p1);
			
				
	        }
	 });
		
	}
}
