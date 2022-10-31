package fiap.controller;
import java.sql.*;
import java.util.*;

import javax.swing.table.DefaultTableModel;

import fiap.model.*;

public class ClienteController {

	public String insereCliente(int id, String nome, String placa) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		ClienteDAO cd = new ClienteDAO(con);
		Cliente cli = new Cliente();
		cli.setIdCliente(id);
		cli.setNomeCliente(nome);
		cli.setPlaca(placa);
		resultado = cd.inserir(cli);
		Conexao.fecharConexao(con);
		return resultado;
	}
	
	public String alteraCliente(int id, String nome, String placa) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		ClienteDAO cd = new ClienteDAO(con);
		Cliente cli = new Cliente();
		cli.setIdCliente(id);
		cli.setNomeCliente(nome);
		cli.setPlaca(placa);
		resultado = cd.alterar(cli);
		Conexao.fecharConexao(con);
		return resultado;
	}
	
	public String excluiCliente(int id) {
		String resultado;
		Connection con = Conexao.abrirConexao();
		ClienteDAO cd = new ClienteDAO(con);
		Cliente cli = new Cliente();
		cli.setIdCliente(id);
		resultado = cd.excluir(cli);
		Conexao.fecharConexao(con);
		return resultado;
	}
	
	public ArrayList<String> listaUmCliente(String id) {
		ArrayList<String> resultado = new ArrayList<String>();
		Connection con = Conexao.abrirConexao();
		ClienteDAO cd = new ClienteDAO(con);
		resultado = cd.listarUm(id);
		Conexao.fecharConexao(con);
		if (resultado != null) {
			return resultado;
		} else {
			return null;
		}
	}
	
	public DefaultTableModel listaTudo() {
		Connection con = Conexao.abrirConexao();
		ClienteDAO cd = new ClienteDAO(con);
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel = cd.listarTudo();
		Conexao.fecharConexao(con);
		if (tableModel != null) {
			return tableModel;
		} else {
			return null;
		}
	}
}





