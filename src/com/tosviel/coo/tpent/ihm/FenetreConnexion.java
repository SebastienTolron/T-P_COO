package com.tosviel.coo.tpent.ihm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;

import com.tosviel.coo.tpent.metiers.Portail;
import com.tosviel.coo.tpent.metiers.Utilisateur;

public class FenetreConnexion extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passField;




	/**
	 * Create the frame.
	 * @param listUsers 
	 */
	public FenetreConnexion(final Portail p1) {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 401, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(143, 103, 183, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passField = new JPasswordField();
		passField.setColumns(10);
		passField.setBounds(143, 156, 183, 20);
		contentPane.add(passField);
		
		JLabel lblLogin = new JLabel("Login :");
		lblLogin.setBounds(45, 106, 54, 14);
		contentPane.add(lblLogin);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe ");
		lblMotDePasse.setBounds(45, 159, 75, 14);
		contentPane.add(lblMotDePasse);
		
		JLabel lblVeuillezVousConnecter = new JLabel("Veuillez vous connecter");
		lblVeuillezVousConnecter.setFont(new Font("Calibri", Font.BOLD, 14));
		lblVeuillezVousConnecter.setBounds(117, 36, 209, 14);
		contentPane.add(lblVeuillezVousConnecter);
		
		JButton btnConnection = new JButton("Connection");
		btnConnection.setBounds(143, 244, 101, 29);
		contentPane.add(btnConnection);
		
		final JLabel lblLoginOuMot = new JLabel("Login ou mot de passe incorrect");
		lblLoginOuMot.setVisible(false);
		lblLoginOuMot.setBounds(96, 205, 209, 14);
		contentPane.add(lblLoginOuMot);
		
		// Action du boutton connection
		
		 btnConnection.addActionListener(new ActionListener(){
		        @SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e){

		            if ( textField.getText().equals("") || passField.getText().equals(""))
		            {
		            	lblLoginOuMot.setVisible(true);
		            }
		            else 
		            {
		            	Iterator<Utilisateur> it = p1.ListUsers.iterator();
		            	 
		            	while (it.hasNext()) {
		            		
		            			
		            	       Utilisateur u = it.next();
		            	       if ( u.getLogin().equals(textField.getText()))
		            	    		   {
		            	    	   		if (u.getPass().equals(passField.getText()))
		            	    	   		{
		            		            	setVisible(false);
		            		            	p1.userConnected(u);
		            		            	p1.AfficheEnt(p1);
		            		            	
		            	    	   		}
		            	    	   		else
		            	    	   			lblLoginOuMot.setVisible(true);
		            	    		   }
		            	 
		            	 
		            	}
		            	
		            	
		            	
		            }
		            
		            

		        }

			
		    });
		 
		 
	}


	
}
