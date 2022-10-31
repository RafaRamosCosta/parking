package fiap.view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import fiap.controller.*;

@SuppressWarnings("serial")
public class GUICarro extends JPanel {

	private JLabel lbPlaca, lbCor, lbDescricao;
	private JTextField tfPlaca, tfCor, tfDescricao;
	private JButton btPesquisa, btNovo, btAtualiza, btApaga, btCancelar;
	
	public GUICarro() {
		inicializarComponentes();
		definirEventos();
	}
	
	private void inicializarComponentes() {
		setLayout(null);
		setBackground(Color.orange);
		lbPlaca = new JLabel("Placa:", JLabel.RIGHT);
		lbCor = new JLabel("Cor:", JLabel.RIGHT);
		lbDescricao = new JLabel("Descricao:", JLabel.RIGHT);
		tfPlaca = new JTextField();
		tfCor = new JTextField();
		tfDescricao = new JTextField();
		btPesquisa = new JButton(new ImageIcon(getClass().getResource("img/search_icon.png")));
		btNovo = new JButton(new ImageIcon(getClass().getResource("img/new_icon.png")));
		btAtualiza = new JButton(new ImageIcon(getClass().getResource("img/update_icon.png")));
		btApaga = new JButton(new ImageIcon(getClass().getResource("img/delete_icon.png")));
		btCancelar = new JButton(new ImageIcon(getClass().getResource("img/exit_icon.png")));
		
		lbPlaca.setBounds(10, 30, 80, 25);
		tfPlaca.setBounds(100, 30, 120, 25);
		lbCor.setBounds(10, 75, 80, 25);
		tfCor.setBounds(100, 75, 120, 25);
		lbDescricao.setBounds(10, 120, 80, 25);
		tfDescricao.setBounds(100, 120, 200, 25);
		btPesquisa.setBounds(50, 250, 60, 40);
		btNovo.setBounds(120, 250, 60, 40);
		btAtualiza.setBounds(190, 250, 60, 40);
		btApaga.setBounds(260, 250, 60, 40);
		btCancelar.setBounds(330, 250, 60, 40);
		
		add(lbPlaca);
		add(tfPlaca);
		add(lbCor);
		add(tfCor);
		add(lbDescricao);
		add(tfDescricao);
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
				CarroController carro = new CarroController();
				if (tfPlaca.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha a placa");
					tfPlaca.requestFocus();
				} else {
					JOptionPane.showMessageDialog(null, carro.excluiCarro(tfPlaca.getText()));
					tfPlaca.setText("");
					tfCor.setText("");
					tfDescricao.setText("");
				}
			}
		});
		
		
		btAtualiza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarroController carro = new CarroController();
				if (tfPlaca.getText().equals("") || tfCor.getText().equals("") 
						|| tfDescricao.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					JOptionPane.showMessageDialog(null, carro.alteraCarro(
							tfPlaca.getText(), tfCor.getText(), tfDescricao.getText()));
					tfPlaca.setText("");
					tfCor.setText("");
					tfDescricao.setText("");
				}
			}
		});
		
		btNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarroController carro = new CarroController();
				if (tfPlaca.getText().equals("") || tfCor.getText().equals("") 
						|| tfDescricao.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					JOptionPane.showMessageDialog(null, carro.insereCarro(
							tfPlaca.getText(), tfCor.getText(), tfDescricao.getText()));
					tfPlaca.setText("");
					tfCor.setText("");
					tfDescricao.setText("");
				}
			}
		});
		
		btPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarroController carro = new CarroController();
				ArrayList<String> dados = new ArrayList<String>();
				if (tfPlaca.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha a placa");
					tfPlaca.requestFocus();
				} else {
					dados = carro.listaUmCarro(tfPlaca.getText());
					if (dados != null) {
						tfCor.setText(dados.get(1));
						tfDescricao.setText(dados.get(2));
					} else {
						JOptionPane.showMessageDialog(null, "Registro inexistente");
					}
				}
			}
		});
		
	}
}























