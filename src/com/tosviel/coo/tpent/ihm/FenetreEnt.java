package com.tosviel.coo.tpent.ihm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

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

public class FenetreEnt extends JDialog {

	private JPanel contentPane;
	private JTable table;

	

	/**
	 * Create the frame.
	 */
	public FenetreEnt(Utilisateur e) {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 490, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblBienvenue = new JLabel("Bienvenue "+e.getPrenom()+" "+e.getNom());
		lblBienvenue.setBounds(129, 32, 278, 14);
		contentPane.add(lblBienvenue);
		
		JLabel lblListDeMes = new JLabel("List de mes groupes ");
		lblListDeMes.setBounds(37, 99, 128, 14);
		contentPane.add(lblListDeMes);
		/* DEBUG
		 * 
		 */
		

		
		Iterator<Groupe> it = e.ListGroup.iterator();
		Groupe gMatch = new Groupe();
    	while (it.hasNext()) {
    		
    			
    		   Groupe u = it.next();	
    	       System.out.println(u.toString());
    	}
    
    	
	
		
		JButton btnCreerUnGroupe = new JButton("Creer un groupe ");
		btnCreerUnGroupe.setBounds(27, 380, 170, 23);
		contentPane.add(btnCreerUnGroupe);
		
		table = new JTable();
		table.setBounds(37, 143, 237, 216);
		contentPane.add(table);
		
		JButton btnDeconnection = new JButton("Deconnection");
		btnDeconnection.setBounds(321, 380, 128, 23);
		contentPane.add(btnDeconnection);
		
		
		
		 btnDeconnection.addActionListener(new ActionListener(){
		      
				public void actionPerformed(ActionEvent e){
		        	
					dispose();
					setVisible(false);
		        	Portail.deconnection();
		        }
		 });

	}
}
