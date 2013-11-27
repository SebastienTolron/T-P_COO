package com.tosviel.coo.tpent.ihm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import com.tosviel.coo.tpent.metiers.Groupe;
import com.tosviel.coo.tpent.metiers.Portail;
import com.tosviel.coo.tpent.metiers.Utilisateur;

import javax.swing.JDialog;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.WindowConstants;

public class FenetreEnt extends JFrame {

	private JPanel contentPane;
	private JTable table;


	/**
	 * Create the frame.
	 */
	public FenetreEnt(final Portail p1) {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JLabel lblBienvenue = new JLabel("Bienvenue "+p1.getUserConnected().getPrenom()+" "+p1.getUserConnected().getNom());
		lblBienvenue.setBounds(129, 32, 278, 14);
		contentPane.add(lblBienvenue);
		
		JLabel lblListDeMes = new JLabel("List de mes groupes ");
		lblListDeMes.setBounds(37, 99, 128, 14);
		contentPane.add(lblListDeMes);
	 
    	
    	
    	Object[][] donnees = new Object[p1.getUserConnected().ListGroup.size()][8] ;
        for (int i = 0; i < p1.getUserConnected().ListGroup.size(); i++) {
            for (int j = 0; j < 1; j++) {
            	donnees[i][j] =  p1.getUserConnected().ListGroup.get(i).getNom();
            	donnees[i][j+1] =  "Modifier";
            }
        }
    	
        String[] entetes = {"Groupe", "Modifier",};
 
        JTable tableau = new JTable(donnees, entetes);  
        

		JButton btnCreerUnGroupe = new JButton("Creer un groupe ");
		btnCreerUnGroupe.setBounds(27, 380, 170, 23);
		contentPane.add(btnCreerUnGroupe);
		
		JButton btnDeconnection = new JButton("Deconnection");
		btnDeconnection.setBounds(321, 380, 128, 23);
		contentPane.add(btnDeconnection);
		
		JPanel panel = new JPanel();
		panel.setBounds(35, 124, 257, 225);
		contentPane.add(panel);
		
		table = tableau;
		panel.add(table);
		
		btnCreerUnGroupe.addActionListener(new ActionListener(){
		      
				public void actionPerformed(ActionEvent e){
		        	
					FenetreCreationGroupe fcg = new FenetreCreationGroupe(p1);
					fcg.setVisible(true);
					setVisible(false);
					
		     
		        }
		 });
		 
		
		 btnDeconnection.addActionListener(new ActionListener(){
		      
				public void actionPerformed(ActionEvent e){
		        	
					dispose();
					setVisible(false);
		        	p1.deconnection();
		        	p1.SeConnecter(p1);
		        }
		 });

	}
}
