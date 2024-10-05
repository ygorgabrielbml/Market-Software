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
	private int idUser;

	public Cadastro(String nome, String cpf, String senha, int idUser, String genero) {
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.idUser = idUser;
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

	public int getVendas() {
		return vendas;
	}

	public void setVendas(int vendas) {
		this.vendas = vendas;
	}

	public double getValorGerado() {
		return valorGerado;
	}

	public void setValorGerado(double valorGerado) {
		this.valorGerado = valorGerado;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
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
