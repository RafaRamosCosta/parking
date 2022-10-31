package fiap.view;
import javax.swing.JOptionPane;

import fiap.controller.*;

public class Teste {

	public static void main(String[] args) {
		CarroController carro = new CarroController();
		
		//testando inserir dados
		//JOptionPane.showMessageDialog(null, 
		//		carro.insereCarro("ABC1234", "Azul-Marinho", "Opala"));
		
		//testando atualizações
		//		JOptionPane.showMessageDialog(null, 
		//				carro.alteraCarro("ABC1234", "Rosa", "Opala"));
				
		//testando exclusão
		//JOptionPane.showMessageDialog(null, 
		//		carro.excluiCarro("ABC1234"));		

		//testando listar
		JOptionPane.showMessageDialog(null, 
				carro.listaUmCarro("ABC1234"));
	}

}




