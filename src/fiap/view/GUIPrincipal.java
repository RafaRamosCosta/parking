package fiap.view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class GUIPrincipal extends JFrame {

	private Container contentPane;
	private JMenuBar mnBarra;
	private JMenu mnArquivo, mnCadastro, mnPesquisa;
	private JMenuItem miSair, miCarro, miCliente, miPesquisaCarro, miPesquisaCliente;
	
	public GUIPrincipal() {
		inicializarComponentes();
		definirEventos();
	}
	
	private void inicializarComponentes() {
		setTitle("Janela Principal");
		setBounds(0, 0, 600, 400);
		contentPane = getContentPane();
		
		mnBarra = new JMenuBar();
		mnArquivo = new JMenu("Arquivo");
		mnArquivo.setMnemonic('A');
		mnCadastro = new JMenu("Cadastro");
		mnCadastro.setMnemonic('C');
		
		mnPesquisa = new JMenu("Pesquisa");
		mnPesquisa.setMnemonic('P');
		
		miSair = new JMenuItem("Sair", new ImageIcon(
				getClass().getResource("img/exit_icon.png")));
		miCarro = new JMenuItem("Carro");
		miCliente = new JMenuItem("Cliente");
		
		miPesquisaCarro = new JMenuItem("Carro");
		miPesquisaCliente = new JMenuItem("Cliente");
		
		setJMenuBar(mnBarra);
		mnBarra.add(mnArquivo);
		mnBarra.add(mnCadastro);
		
		mnBarra.add(mnPesquisa);
		
		mnArquivo.add(miSair);
		mnCadastro.add(miCarro);
		mnCadastro.add(miCliente);
		
		mnPesquisa.add(miPesquisaCarro);
		mnPesquisa.add(miPesquisaCliente);
	}
	
	private void definirEventos() {
		miSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resultado = JOptionPane.showConfirmDialog(null, 
					"Deseja realmente sair do sistema?", "Saindo...",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (resultado == 0) {
					System.exit(0);
				}			
			}
		});
		
		miCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUICarro carro = new GUICarro();
				contentPane.removeAll();
				contentPane.add(carro);
				contentPane.validate();
			}
		});
		
		miCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUICliente cliente = new GUICliente();
				contentPane.removeAll();
				contentPane.add(cliente);
				contentPane.validate();
			}
		});
		
		miPesquisaCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIPesquisaCarro carro = new GUIPesquisaCarro();
				contentPane.removeAll();
				contentPane.add(carro);
				contentPane.validate();
			}
		});
		miPesquisaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIPesquisaCliente cliente = new GUIPesquisaCliente();
				contentPane.removeAll();
				contentPane.add(cliente);
				contentPane.validate();
			}
		});
		
	}
	
	public static void main(String[] args) {
		GUIPrincipal frame = new GUIPrincipal();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((tela.width - frame.getSize().width) / 2,
				(tela.height - frame.getSize().height) / 2);
		frame.setVisible(true);
	}
}











