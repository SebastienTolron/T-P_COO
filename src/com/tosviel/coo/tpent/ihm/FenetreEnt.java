package com.tosviel.coo.tpent.ihm;

import java.awt.BorderLayout;
import java.awt.Component;
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
import javax.swing.JTabbedPane;
import java.awt.Font;
import javax.swing.JTextField;

public class FenetreEnt extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JPanel contentPaneGroups;
	private JPanel contentPaneProfil;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the frame.
	 */
	public FenetreEnt(final Portail p1) {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 467);
		contentPane = new JPanel();
		contentPaneGroups = new JPanel();
		contentPaneProfil = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBienvenue = new JLabel("Bienvenue "
				+ p1.getUserConnected().getPrenom() + " "
				+ p1.getUserConnected().getNom());
		lblBienvenue.setFont(new Font("Calibri", Font.PLAIN, 27));
		lblBienvenue.setBounds(66, 11, 451, 49);
		contentPane.add(lblBienvenue);

		final Object[][] donnees = new Object[p1.getUserConnected().ListGroup
				.size()][8];
		for (int i = 0; i < p1.getUserConnected().ListGroup.size(); i++) {
			for (int j = 0; j < 1; j++) {
				donnees[i][j] = p1.getUserConnected().ListGroup.get(i).getId();
				donnees[i][j + 1] = p1.getUserConnected().ListGroup.get(i)
						.getNom();
				donnees[i][j + 2] = new JButton("Modif");
			}
		}

		String[] entetes = { "Groupe", "Modifier", };

		final JTable tableau = new JTable(donnees, entetes);

		JButton btnDeconnection = new JButton("Deconnection");
		btnDeconnection.setBounds(238, 395, 128, 23);
		contentPane.add(btnDeconnection);
		contentPaneGroups.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 331, 158);
		contentPaneGroups.add(panel);

		table = tableau;
		panel.add(table);

		JButton btnCreerUnGroupe = new JButton("Creer un groupe ");
		btnCreerUnGroupe.setBounds(366, 11, 115, 23);
		contentPaneGroups.add(btnCreerUnGroupe);

		btnCreerUnGroupe.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				FenetreCreationGroupe fcg = new FenetreCreationGroupe(p1);
				fcg.setVisible(true);
				setVisible(false);

			}
		});

		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(395, 46, 71, 23);
		contentPaneGroups.add(btnModifier);

		JButton button = new JButton("?");
		button.setBounds(562, 27, 37, 23);
		contentPane.add(button);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 86, 507, 222);
		contentPane.add(tabbedPane);

		 tabbedPane.addTab("Liste de mes Groupes", contentPaneGroups);
		 // In this case the custom component is responsible for rendering the
		 // title of the tab.
		// tabbedPane.addTab(null, myComponent);
		 tabbedPane.setTabComponentAt(0, new JLabel("Tab1"));
		 tabbedPane.addTab("Mon Profil", contentPaneProfil);
		 // In this case the custom component is responsible for rendering the
		 // title of the tab.
		// tabbedPane.addTab(null, myComponent);
		 tabbedPane.setTabComponentAt(0, new JLabel("Tab2"));
		 
		
		contentPaneProfil.setLayout(null);

		JLabel lblNom = new JLabel("Nom : ");
		lblNom.setBounds(23, 26, 46, 14);
		contentPaneProfil.add(lblNom);

		JLabel lblPrenom = new JLabel("Prenom : ");
		lblPrenom.setBounds(23, 69, 60, 14);
		contentPaneProfil.add(lblPrenom);

		JLabel lblNombreDeGroupes = new JLabel("Nombre de groupes :");
		lblNombreDeGroupes.setBounds(23, 129, 121, 14);
		contentPaneProfil.add(lblNombreDeGroupes);

		JLabel lblnb = new JLabel(Integer.toString(p1.getUserConnected().ListGroup.size()));
		lblnb.setBounds(153, 129, 46, 14);
		contentPaneProfil.add(lblnb);

		JButton btnModifier_1 = new JButton("Modifier");
		btnModifier_1.setBounds(403, 22, 89, 23);
		contentPaneProfil.add(btnModifier_1);

		JButton btnRetablir = new JButton("Retablir");
		btnRetablir.setBounds(403, 65, 89, 23);
		contentPaneProfil.add(btnRetablir);

		JLabel lblpseudo = new JLabel(p1.getUserConnected().getLogin());
		lblpseudo.setBounds(213, 54, 114, 14);
		contentPaneProfil.add(lblpseudo);

		textField = new JTextField(p1.getUserConnected().getPrenom());
		textField.setBounds(74, 66, 89, 20);
		contentPaneProfil.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField(p1.getUserConnected().getNom());
		textField_1.setBounds(58, 23, 86, 20);
		contentPaneProfil.add(textField_1);
		textField_1.setColumns(10);
		tabbedPane.setTabComponentAt(0, new JLabel("Mon Profil"));

		btnDeconnection.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				dispose();
				setVisible(false);
				p1.deconnection();
				p1.SeConnecter(p1);
			}
		});

		btnModifier.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int id = (Integer) donnees[tableau.getSelectedRow()][0];
				System.out.println("id = " + id);
				System.out.println(id);
				setVisible(false);
				FenetreModifierGroupe fmo = new FenetreModifierGroupe(p1, p1
						.getGroup(id));
				fmo.setVisible(true);

			}
		});

	}
}
