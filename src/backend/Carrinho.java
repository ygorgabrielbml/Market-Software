package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.ConexaoDB;

public class Carrinho {
	private String nome;
	private String codigoBarras;
	private double valor;

	public Carrinho(String n, String cb, double v) {
		this.nome = n;
		this.codigoBarras = cb;
		this.valor = v;
	}
	
	@Override
    public String toString() {
        return "Produto { " +
                ", Nome: '" + nome + '\'' +
                ", Código de Barras: '" + codigoBarras + '\'' +
                ", Valor: " + valor +
                " }";
    }

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

	public static ArrayList<Carrinho> pesquisar(String nome) {

		Connection con = null;
		ResultSet resultado = null;
		ArrayList<Carrinho> item = new ArrayList<>();
		try {
			con = ConexaoDB.getInstance().getConnection();
			String query = "SELECT nome, CB, valor FROM produtos WHERE nome = ? OR CB = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, nome);
			pstmt.setString(2, nome);
			resultado = pstmt.executeQuery();
			while (resultado.next()) {
				String cb2 = resultado.getString("CB");
				String nome2 = resultado.getString("nome");
				double valor = resultado.getDouble("valor");
	
				item.add(new Carrinho(nome2, cb2, valor));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

		finally {
			try {
				if (resultado != null) {
					resultado.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
		return item;
	}
	

}
