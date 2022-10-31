package fiap.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import fiap.controller.*;

@SuppressWarnings("serial")
public class GUIPesquisaCliente extends JPanel {

	private JTable table;
	private JButton btPesquisa;
	private JScrollPane scrollPane;

	public GUIPesquisaCliente() {
		inicializarComponentes();
		definirEventos();
	}

	private void inicializarComponentes() {
		setLayout(null);
		setBackground(Color.lightGray);

		btPesquisa = new JButton(new ImageIcon(getClass().getResource("img/search_icon.png")));
		scrollPane = new JScrollPane();
		
		btPesquisa.setBounds(10, 10, 60, 40);
		scrollPane.setBounds(10, 60, 500, 250);
		
		add(btPesquisa);
		add(scrollPane);
	}
	
	private void definirEventos() {
		btPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteController cliente = new ClienteController();
				DefaultTableModel tableModel = new DefaultTableModel();
				tableModel = cliente.listaTudo();
				table = new JTable(tableModel);
				scrollPane.setViewportView(table);
			}
		});
	}
}
