package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.ConexaoDB;

public class Produto {
	private String nome;
	private String codigoBarras;
	private double valor;
	private Integer id;
	private int quantidade;

	// Construtores da classe
	public Produto() {
	}
	public Produto(int id, String n, String cb, double v, int q) {
		this.id = id;
		this.nome = n;
		this.codigoBarras = cb;
		this.valor = v;
		this.quantidade = q;
	}
	
	@Override
	// Reescrição do metodo toString para conseguir mostrar corretamente a lista de produtos no aplicativo
    public String toString() {
        return "Produto { " +
                "ID: " + id +
                ", Nome: '" + nome + '\'' +
                ", Código de Barras: '" + codigoBarras + '\'' +
                ", Valor: " + valor +
                ", Quantidade: " + quantidade +
                " }";
    }

	// Getters e Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	// Método para adicionar um novo produto ao estoque
	public static void addProduto(String nome, String cb, double valor, int quantidade) {
		Connection con = null;
		try {
			con = ConexaoDB.getInstance().getConnection(); // conexão com o banco de dados
			String query = "INSERT INTO produtos (nome, CB, valor, quantidade) VALUES (?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setString(1, nome);
			pstmt.setString(2, cb);
			pstmt.setDouble(3, valor);
			pstmt.setInt(4, quantidade);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

		finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// Falhou também para fechar o arquivo
				System.err.println(e.getMessage());
			}
		}
	}

	public static void remProduto(String cb) {
		Connection con = null;
		try {
			con = ConexaoDB.getInstance().getConnection();
			String query = "DELETE FROM produtos WHERE cb = ?";
			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setString(1, cb);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

		finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// Falhou também para fechar o arquivo
				System.err.println(e.getMessage());
			}
		}
	}

	public static ArrayList<Produto> verificarEstoque() {
		Connection con = null;
		ResultSet resultado = null;
		ArrayList<Produto> estoque = new ArrayList<>();
		con = ConexaoDB.getInstance().getConnection();
		try {
			String query = "SELECT * FROM produtos ORDER BY id ASC";
			PreparedStatement pstmt = con.prepareStatement(query);
			resultado = pstmt.executeQuery();
			
			while(resultado.next()) {
				int id = resultado.getInt("id");
				String cb = resultado.getString("CB");
				String nome = resultado.getString("nome");
				double valor = resultado.getDouble("valor");
				int quantidade = resultado.getInt("quantidade");
				
				estoque.add(new Produto(id, nome, cb, valor, quantidade));
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
				// Falhou também para fechar o arquivo
				System.err.println(e.getMessage());
			}
		}
		return estoque;
	}
	
	
}
