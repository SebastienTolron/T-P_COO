package com.tosviel.coo.tpent.ihm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.tosviel.coo.tpent.metiers.Dossier;
import com.tosviel.coo.tpent.metiers.Groupe;
import com.tosviel.coo.tpent.metiers.Portail;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class FenetreDossier extends JFrame {

	private JPanel contentPane;
	private JTextField textField;


	/**
	 * Create the frame.
	 */
	public FenetreDossier(Portail p1, final Dossier folderModif,final Groupe gp) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 372, 218);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNom = new JLabel("Nom : ");
		lblNom.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNom.setBounds(22, 86, 77, 14);
		contentPane.add(lblNom);
		
		textField = new JTextField();
		textField.setBounds(73, 84, 97, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblModificationDossier = new JLabel("Modification Dossier");
		lblModificationDossier.setFont(new Font("Calibri", Font.PLAIN, 29));
		lblModificationDossier.setBounds(43, 11, 273, 36);
		contentPane.add(lblModificationDossier);
		
		JButton btnV = new JButton("V");
		btnV.setBounds(100, 146, 39, 23);
		contentPane.add(btnV);
		
		JButton btnX = new JButton("X");
		btnX.setBounds(149, 146, 39, 23);
		contentPane.add(btnX);
		
		btnV.addActionListener(new ActionListener(){
		      
			public void actionPerformed(ActionEvent e){
	        	
					gp.updateDossier(gp.getDossierById(folderModif.id),textField);
					setVisible(false);
			
				
	        }
	 });
	}
}
