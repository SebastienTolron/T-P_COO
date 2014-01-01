package com.tosviel.coo.tpent.ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;

import com.tosviel.coo.tpent.metiers.Dossier;
import com.tosviel.coo.tpent.metiers.Fichier;
import com.tosviel.coo.tpent.metiers.Groupe;
import com.tosviel.coo.tpent.metiers.Portail;
import com.tosviel.coo.tpent.metiers.Utilisateur;

import java.awt.Font;

public class FenetreModifierGroupe extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTable table_1;
	public String listString = "";
	private JTable table_2;
	public JTree treePanel;
	private int newNodeSuffix = 1;
	public int cptNode = 0;
	private JPanel contentPaneUsers;
	private JPanel contentPaneDocuments;

	/**
	 * Create the frame.
	 */
	public FenetreModifierGroupe(final Portail p1, final Groupe gp) {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 637);
		contentPane = new JPanel();
		contentPaneDocuments = new JPanel();
		contentPaneUsers = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField(gp.getNom());
		textField.setBounds(90, 71, 134, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		System.out.println(gp);
		// remplissage des utilisateurs

		Object[][] donneesListUtilisateur = new Object[p1.ListUsers.size()][8];
		for (int i = 0; i < p1.ListUsers.size(); i++) {
			for (int j = 0; j < 1; j++) {
				donneesListUtilisateur[i][j] = p1.ListUsers.get(i).getNom();

			}
		}

		String[] entetes = { "Users" };
		contentPaneUsers.setLayout(null);

		JTable tableau = new JTable(donneesListUtilisateur, entetes);

		table = tableau;
		JPanel panel = new JPanel();
		panel.setBounds(10, 65, 204, 220);
		contentPaneUsers.add(panel);
		panel.add(table);

		final DefaultListModel listModel = new DefaultListModel();
		final JList list = new JList(listModel);
		ArrayList<Utilisateur> temp2 = gp.getListUtilisateurs();
		for (int i = 0; i < temp2.size(); i++) {

			listModel.addElement(temp2.get(i).getNom());
		}

		JPanel panel2 = new JPanel();
		panel2.setBounds(329, 65, 177, 220);
		contentPaneUsers.add(panel2);
		panel2.add(list);

		JButton btnRemove = new JButton("<-");
		btnRemove.setBounds(240, 147, 45, 23);
		contentPaneUsers.add(btnRemove);

		JButton btnSave = new JButton("Modifier");
		btnSave.setForeground(Color.BLACK);
		btnSave.setBounds(162, 525, 140, 23);
		contentPane.add(btnSave);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(367, 525, 140, 23);
		contentPane.add(btnAnnuler);

		JButton btnAjout = new JButton("->");
		btnAjout.setBounds(240, 87, 45, 23);
		contentPaneUsers.add(btnAjout);

		btnAjout.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int j = table.getSelectedRow();
				int i = table.getSelectedColumn();

				// On recupere l'arbre pour creer le groupe

				if (i != -1 && j != -1) {
					Object Nom = table.getValueAt(j, i);
					if (!listString.contains(Nom.toString())) {

						listString = listString + Nom.toString() + ";;";
						listModel.addElement(Nom);
					}

				} else
					JOptionPane.showMessageDialog(contentPane,
							"Veuillez Selectionner un utilisateur");

			}

		});

		JLabel lblListeDesUtilisateurs = new JLabel("Liste des utilisateurs");
		lblListeDesUtilisateurs.setBounds(43, 26, 97, 14);
		contentPaneUsers.add(lblListeDesUtilisateurs);

		JLabel lblUtilisateursDansLe = new JLabel("Utilisateurs dans le groupe");
		lblUtilisateursDansLe.setBounds(350, 26, 127, 14);
		contentPaneUsers.add(lblUtilisateursDansLe);

		// Tables des documents
		// Faire une JList pour ajouter les documents car le groupe n'est pas
		// encore creer

		// faire un modele pour les documents

		final DefaultListModel listModelDoc = new DefaultListModel();

		// construction de l'arbre

		// create the root node
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(new Dossier(
				cptNode, "Racine"));
		cptNode++;
		root.add(new DefaultMutableTreeNode("FichierExemple"));

		// create the tree by passing in the root node

		treePanel = gp.getTreeObjet();
		contentPaneDocuments.setLayout(null);

		JScrollPane scrollPane = new JScrollPane(treePanel);

		scrollPane.setBounds(10, 11, 325, 257);

		contentPaneDocuments.add(scrollPane);

		JButton btnAjouterDossier = new JButton("Ajouter Dossier");
		btnAjouterDossier.setBounds(345, 113, 139, 23);
		contentPaneDocuments.add(btnAjouterDossier);

		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(348, 181, 98, 23);
		contentPaneDocuments.add(btnSupprimer);

		JButton fichierBtn = new JButton("Modifier");
		fichierBtn.setBounds(355, 11, 63, 23);
		contentPaneDocuments.add(fichierBtn);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(32, 127, 550, 324);
		contentPane.add(tabbedPane);

		tabbedPane.addTab("Gestion Utilisateurs", contentPaneUsers);
		// In this case the custom component is responsible for rendering the
		// title of the tab.
		// tabbedPane.addTab(null, myComponent);
		tabbedPane.setTabComponentAt(0, new JLabel("Tab1"));
		tabbedPane.addTab("Gestion des document", contentPaneDocuments);

		JButton btnAjouterFichier = new JButton("Ajouter Fichier");
		btnAjouterFichier.setBounds(345, 147, 139, 23);
		contentPaneDocuments.add(btnAjouterFichier);

		btnAjouterFichier.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) treePanel
						.getLastSelectedPathComponent();
				if ((selectedNode.getUserObject() instanceof Dossier)) {

					selectedNode.add(new DefaultMutableTreeNode(new Fichier(
							cptNode, "Fichier")));
					cptNode++;
					treePanel.updateUI();

				}

			}
		});

		JLabel label_1 = new JLabel("Nom");
		label_1.setFont(new Font("Calibri", Font.PLAIN, 17));
		label_1.setBounds(32, 74, 46, 14);
		contentPane.add(label_1);

		JLabel label = new JLabel(gp.getNom());
		label.setFont(new Font("Calibri", Font.BOLD, 24));
		label.setBounds(199, 11, 192, 30);
		contentPane.add(label);
		// In this case the custom component is responsible for rendering the
		// title of the tab.
		// tabbedPane.addTab(null, myComponent);
		tabbedPane.setTabComponentAt(0, new JLabel("Tab2"));

		btnRemove.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {

					int i = list.getSelectedIndex();
					listString = listString.replace(list.getSelectedValue()
							.toString(), " ");
					p1.getUserByName(list.getSelectedValue().toString())
							.removeGroup(gp);
					gp.removeUser(p1.getUserByName(list.getSelectedValue()
							.toString()));
					listModel.remove(i);

					Portail ptemp = p1;
					System.out.println(ptemp);

				} catch (Exception err) {
					JOptionPane
							.showMessageDialog(contentPane,
									"Veuillez Selectionner un utilisateur a supprimer du groupe");

				}
			}
		});

		btnSave.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				p1.getGroup(gp.getId()).setNom(textField.getText());
				p1.getGroup(gp.getId()).setTreeObjet(treePanel);
				ArrayList<Utilisateur> ListUser = new ArrayList<Utilisateur>();

				ListUser.add(p1.getGroup(gp.getId()).getAdminGroup());
				if (!p1.getGroup(gp.getId()).getAdminGroup().ListGroup
						.contains(gp))
					p1.getGroup(gp.getId()).getAdminGroup().addGroup(gp);

				for (int i = 0; i < listModel.getSize(); i++) {
					if (!listModel
							.get(i)
							.toString()
							.equals(p1.getGroup(gp.getId()).getAdminGroup()
									.getNom())) {

						ListUser.add(p1.getUserByName(listModel.get(i)
								.toString()));
						p1.getUserByName(listModel.get(i).toString()).addGroup(
								p1.getGroup(gp.getId()));

					}
				}

				// for ( int i = 0 ; i<lis)
				p1.getGroup(gp.getId()).setListUtilisateurs(ListUser);
				/*
				 * 
				 * DEBUG ]
				 */
				ArrayList<Groupe> tempgpl = new ArrayList<Groupe>();
				tempgpl = p1.ListGroups;
				Portail tempoP = p1;

				/*
				 * 
				 */

				setVisible(false);
				p1.AfficheEnt(p1);

			}
		});

		btnAnnuler.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				// p1.AfficheEnt(p1);

			}
		});

		btnSupprimer.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}
		});

		btnAjouterDossier.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) treePanel
						.getLastSelectedPathComponent();
				if ((selectedNode.getUserObject() instanceof Dossier)) {

					DefaultMutableTreeNode tempNode = new DefaultMutableTreeNode(
							new Dossier(cptNode, "Dossier"));
					cptNode++;
					tempNode.add(new DefaultMutableTreeNode(new Fichier(
							cptNode, "FichierExemple")));
					cptNode++;
					selectedNode.add(tempNode);
					treePanel.updateUI();

				}

			}
		});

		fichierBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) treePanel
						.getLastSelectedPathComponent();
				if ((selectedNode.getUserObject() instanceof Fichier)) {

					Fichier fileModif = (Fichier) selectedNode.getUserObject();
					FenetreFichier fich = new FenetreFichier(p1, p1.getGroup(
							gp.getId()).getFichierById(fileModif.id),p1.getGroup(gp.getId()));
					fich.setVisible(true);

				}
				if ((selectedNode.getUserObject() instanceof Dossier)) {

					Fichier fileModif = (Fichier) selectedNode.getUserObject();
					FenetreFichier fich = new FenetreFichier(p1, p1.getGroup(
							gp.getId()).getFichierById(fileModif.id),p1.getGroup(gp.getId()));
					fich.setVisible(true);

				}

			}
		});

	}

	public void buildTree() {

	}
}
