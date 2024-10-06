package backend;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.ConexaoDB;

public class InfoPlus extends Usuario {
	private int vendasRealizadas;
	private double valorGerado;

	public InfoPlus(String nome, String cpf, boolean genero, String senha, String data, int vendasRealizadas,
			double valorGerado) {
		super(nome, cpf, genero, senha, data);
		this.vendasRealizadas = vendasRealizadas;
		this.valorGerado = valorGerado;
	}

	@Override
	public String toString() {
		return "InfoPlus [vendasRealizadas=" + vendasRealizadas + ", valorGerado=" + valorGerado + "]";
	}

	public int getVendasRealizadas() {
		return vendasRealizadas;
	}

	public void setVendasRealizadas(int vendasRealizadas) {
		this.vendasRealizadas = vendasRealizadas;
	}

	public double getValorGerado() {
		return valorGerado;
	}

	public void setValorGerado(double valorGerado) {
		this.valorGerado = valorGerado;
	}

	public ArrayList<Object> mostrarVendas() throws SQLException{
		Connection con = null;
		con = ConexaoDB.getInstance().getConnection(); // Conexão é feita com o banco de dados
		
		String querySelect = "SELECT vendas, valorGerado FROM 'informações adicionais' WHERE idUser = ?";
		PreparedStatement pstmtS = con.prepareStatement(querySelect);
		
		pstmtS.setInt(1, this.idUser);
		ResultSet resultado = pstmtS.executeQuery();
		ArrayList<Object> lista = new ArrayList<Object>();
		while (resultado.next()) {
	        // Acessa os dados das colunas "vendas" e "valorGerado"
	        int vendas = resultado.getInt("vendas");
	        double valorGerado = resultado.getDouble("valorGerado");

	        lista.add(vendas);
	        lista.add(valorGerado);
	    }
		return lista;
	}
	
	public void registrarVenda(double valor) throws SQLException {
		Connection con = null;
		con = ConexaoDB.getInstance().getConnection(); // Conexão é feita com o banco de dados
		
		ArrayList<Object> resultado = mostrarVendas();
		
		if (resultado.isEmpty()) {
			String queryInsert = "INSERT INTO 'informações adicionais' (vendas, valorGerado, idUser) VALUES (?, ?, ?)";
			PreparedStatement pstmtI = con.prepareStatement(queryInsert);
			
			pstmtI.setInt(1, 1);
			pstmtI.setDouble(2, valor);
			pstmtI.setInt(3, this.idUser);
			
			pstmtI.executeUpdate();
		}else {
			Integer vendas = (Integer) resultado.get(0);
			double valorGerado = (Double) resultado.get(1);
			valorGerado += valor;
			String queryUpdate = "UPDATE 'informações adicionais' SET vendas = ?, valorGerado = ? WHERE idUser = ?";
			PreparedStatement pstmtU = con.prepareStatement(queryUpdate);
			
			pstmtU.setInt(1, vendas + 1);
			pstmtU.setDouble(2, valorGerado);
			pstmtU.setInt(3, this.idUser);
			
			pstmtU.executeUpdate();
		}

	}
}
