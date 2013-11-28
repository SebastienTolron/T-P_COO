package com.tosviel.coo.tpent.ihm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;





public class FenetreAjoutObjet extends JFrame  {

	private JPanel contentPane;
	private JTextField textField;

	
	public FenetreAjoutObjet()  {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAjouterUnObjet = new JLabel("Ajouter un objet");
		lblAjouterUnObjet.setBounds(147, 26, 115, 14);
		contentPane.add(lblAjouterUnObjet);
		
		JLabel lblNom = new JLabel("Nom : ");
		lblNom.setBounds(10, 91, 75, 14);
		contentPane.add(lblNom);
		
		textField = new JTextField();
		textField.setBounds(76, 88, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(10, 135, 55, 14);
		contentPane.add(lblType);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(76, 132, 86, 20);
		contentPane.add(comboBox);
		comboBox.addItem("Dossier");
		comboBox.addItem("Fichier");
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(159, 228, 89, 23);
		contentPane.add(btnValider);
		
		btnValider.addActionListener(new ActionListener(){
		      
			public void actionPerformed(ActionEvent e){
	        	
				System.out.println("youhou");
				setVisible(false);
				
	            }
	 });
		
		
	}
}
