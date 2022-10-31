package fiap.model;
import java.sql.*;
import java.util.*;

import javax.swing.table.DefaultTableModel;

public class ClienteDAO implements IDAO{
	private Connection con;
	private Cliente cliente;
	
	public ClienteDAO(Connection con) {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public String inserir(Object obj) {
		cliente = (Cliente) obj;
		String sql = "insert into cliente(idcliente,nomecliente,placa) values(?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, cliente.getIdCliente());
			ps.setString(2, cliente.getNomeCliente());
			ps.setString(3, cliente.getPlaca());
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public String alterar(Object obj) {
		cliente = (Cliente) obj;
		String sql = "update cliente set nomecliente=?, placa=? where idcliente=?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, cliente.getNomeCliente());
			ps.setString(2, cliente.getPlaca());
			ps.setInt(3, cliente.getIdCliente());
			if (ps.executeUpdate() > 0) {
				return "Alterado com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public String excluir(Object obj) {
		cliente = (Cliente) obj;
		String sql = "delete from cliente where idcliente=?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, cliente.getIdCliente());
			if (ps.executeUpdate() > 0) {
				return "Excluido com sucesso";
			} else {
				return "Erro ao excluir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	
	public ArrayList<String> listarUm(String id) {
		String sql = "select * from cliente where idcliente=?";
		ArrayList<String> resul = new ArrayList<String>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				resul.add("" + rs.getInt(1));
				resul.add(rs.getString(2));
				resul.add(rs.getString(3));
				return resul;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}	
	public DefaultTableModel listarTudo(){
		String sql = "select * from cliente order by 1";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			DefaultTableModel table = new DefaultTableModel();
			int qtdeColunas = rs.getMetaData().getColumnCount();
			for (int i = 1; i <= qtdeColunas; i++) {
				table.addColumn(rs.getMetaData().getColumnName(i));
			}
			while(rs.next()) {
				String[] dados = new String[qtdeColunas];
				for (int i = 1; i <= qtdeColunas; i++) {
					dados[i-1] = rs.getString(i);
				}
				table.addRow(dados);
			}
			return table;
		}catch (SQLException e){
			return null;
		}
	}
}










