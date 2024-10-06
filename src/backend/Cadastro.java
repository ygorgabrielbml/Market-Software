package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.ConexaoDB;

public class Cadastro {
	private String nome;
	private String cpf;
	private int vendas;
	private double valorGerado;
	private String senha;
	private String senha2;
	private boolean genero;
	
	public Cadastro() {
	}
	
	public Cadastro(String nome, String cpf, boolean genero, String senha, String senha2) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.genero = genero;
		this.senha = senha;
		this.senha2 = senha2;
	}

	

	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public String getSenha() {
		return senha;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}



	public String getSenha2() {
		return senha2;
	}



	public void setSenha2(String senha2) {
		this.senha2 = senha2;
	}



	public boolean isGenero() {
		return genero;
	}



	public void setGenero(boolean genero) {
		this.genero = genero;
	}



	public static void registro(int id, String nome, String cpf, String senha) {
		Connection con = null;
		try {
			con = ConexaoDB.getInstance().getConnection();
			String querySelect = "SELECT nome, cpf, senha FROM usuários WHERE nome = ? OR cpf = ? OR senha = ?";
			PreparedStatement pstmtS = con.prepareStatement(querySelect);

			pstmtS.setString(1, nome);
			pstmtS.setString(2, cpf);
			pstmtS.setString(3, senha);
			ResultSet resultado = pstmtS.executeQuery();
			
			String n = resultado.getString("nome");

			if (n != null) {
				System.out.println("esse usuário já existe");

			}
			else {
				String queryInsert = "INSERT INTO usuários (id, nome, cpf, senha) VALUES (?, ?, ?, ?)";
				PreparedStatement pstmtI = con.prepareStatement(queryInsert);
				
				pstmtI.setInt(1, id);
				pstmtI.setString(2, nome);
				pstmtI.setString(3, cpf);
				pstmtI.setString(4, senha);
				
				pstmtI.executeUpdate();
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

		finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
	}
}
