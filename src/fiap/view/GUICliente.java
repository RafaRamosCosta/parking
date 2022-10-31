package fiap.view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import fiap.controller.*;

@SuppressWarnings("serial")
public class GUICliente extends JPanel {

	private JLabel lbId, lbNome, lbPlaca;
	private JTextField tfId, tfNome, tfPlaca;
	private JButton btPesquisa, btNovo, btAtualiza, btApaga, btCancelar;
	
	public GUICliente() {
		inicializarComponentes();
		definirEventos();
	}
	
	private void inicializarComponentes() {
		setLayout(null);
		setBackground(Color.cyan);
		
		lbId = new JLabel("ID:", JLabel.RIGHT);
		lbNome = new JLabel("Nome:", JLabel.RIGHT);
		lbPlaca = new JLabel("Placa:", JLabel.RIGHT);
		tfId = new JTextField();
		tfNome = new JTextField();
		tfPlaca = new JTextField();
		btPesquisa = new JButton(new ImageIcon(getClass().getResource("img/search_icon.png")));
		btNovo = new JButton(new ImageIcon(getClass().getResource("img/new_icon.png")));
		btAtualiza = new JButton(new ImageIcon(getClass().getResource("img/update_icon.png")));
		btApaga = new JButton(new ImageIcon(getClass().getResource("img/delete_icon.png")));
		btCancelar = new JButton(new ImageIcon(getClass().getResource("img/exit_icon.png")));
		
		lbId.setBounds(10, 30, 80, 25);
		tfId.setBounds(100, 30, 120, 25);
		lbNome.setBounds(10, 75, 80, 25);
		tfNome.setBounds(100, 75, 200, 25);
		lbPlaca.setBounds(10, 120, 80, 25);
		tfPlaca.setBounds(100, 120, 120, 25);
		btPesquisa.setBounds(50, 250, 60, 40);
		btNovo.setBounds(120, 250, 60, 40);
		btAtualiza.setBounds(190, 250, 60, 40);
		btApaga.setBounds(260, 250, 60, 40);
		btCancelar.setBounds(330, 250, 60, 40);
		
		add(lbId);
		add(tfId);
		add(lbNome);
		add(tfNome);
		add(lbPlaca);
		add(tfPlaca);
		add(btPesquisa);
		add(btNovo);
		add(btAtualiza);
		add(btApaga);
		add(btCancelar);
		
	}
	
	private void definirEventos() {
		
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btApaga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteController cliente = new ClienteController();
				if (tfId.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID");
					tfId.requestFocus();
				} else {
					JOptionPane.showMessageDialog(null, cliente.excluiCliente(
							Integer.parseInt(tfId.getText())));
					tfId.setText("");
					tfNome.setText("");
					tfPlaca.setText("");
				}
			}
		});
		
		btNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteController cliente = new ClienteController();
				if (tfId.getText().equals("") || tfNome.getText().equals("") || 
						tfPlaca.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					JOptionPane.showMessageDialog(null, cliente.insereCliente(
						Integer.parseInt(tfId.getText()), tfNome.getText(), tfPlaca.getText()));
					tfId.setText("");
					tfNome.setText("");
					tfPlaca.setText("");
				}
			}
		});
		
		btAtualiza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteController cliente = new ClienteController();
				if (tfId.getText().equals("") || tfNome.getText().equals("") || 
						tfPlaca.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					JOptionPane.showMessageDialog(null, cliente.alteraCliente(
						Integer.parseInt(tfId.getText()), tfNome.getText(), tfPlaca.getText()));
					tfId.setText("");
					tfNome.setText("");
					tfPlaca.setText("");
				}
			}
		});
		
		btPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteController cliente = new ClienteController();
				ArrayList<String> dados = new ArrayList<String>();
				if (tfId.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o ID");
					tfId.requestFocus();
				} else {
					dados = cliente.listaUmCliente(tfId.getText());
					if (dados != null) {
						tfNome.setText(dados.get(1));
						tfPlaca.setText(dados.get(2));
					} else {
						JOptionPane.showMessageDialog(null, "Registro inexistente");
					}
				}
			}
		});
		
	}
	
}












