package backend;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import database.ConexaoDB;

public class InfoPlus extends Usuario {
	private int vendasRealizadas;
	private double valorGerado;
	private int idUser;

	public InfoPlus(String nome, String cpf, boolean genero, String senha, String data, int vendasRealizadas,
			double valorGerado, int idUser) {
		super(nome, cpf, genero, senha, data);
		this.vendasRealizadas = vendasRealizadas;
		this.valorGerado = valorGerado;
		this.idUser = idUser;
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

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public ArrayList<Object> mostrarVendas() throws SQLException {
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

			pstmtI.setInt(1, 0);
			pstmtI.setDouble(2, valor);
			pstmtI.setInt(3, this.idUser);

			pstmtI.executeUpdate();
		} else {
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

	public void inserirImagem(File selectedFile) {
		try {
			Connection con = ConexaoDB.getInstance().getConnection();
			PreparedStatement pstmtS = con
					.prepareStatement("SELECT imagem FROM 'informações adicionais' WHERE idUser = ?");
			pstmtS.setInt(1, this.idUser);
			ResultSet resultado = pstmtS.executeQuery();
			byte[] im = resultado.getBytes("imagem");
			if (im != null) {
				PreparedStatement pstmt = con
						.prepareStatement("UPDATE 'informações adicionais' SET imagem = ? WHERE idUser = ?");

				// Lendo a imagem do arquivo
				FileInputStream fis = new FileInputStream(selectedFile);
				pstmt.setInt(2, this.idUser);
				pstmt.setBinaryStream(1, fis, (int) selectedFile.length());
				pstmt.executeUpdate();
				fis.close();
			} else {
				String queryInsert = "INSERT INTO 'informações adicionais' (imagem, idUser) VALUES (?, ?)";
				PreparedStatement pstmtI = con.prepareStatement(queryInsert);
				FileInputStream fis = new FileInputStream(selectedFile);
				pstmtI.setBinaryStream(1, fis, (int) selectedFile.length());
				pstmtI.setInt(2, this.idUser);

				pstmtI.executeUpdate();
			}
		} catch (SQLException | IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public byte[] recuperarImagem() {

		Connection con = ConexaoDB.getInstance().getConnection();
		PreparedStatement pstmt;
		byte[] imagem = null;
		try {
			pstmt = con.prepareStatement("SELECT imagem FROM 'informações adicionais' WHERE idUser = ?");
			pstmt.setInt(1, this.idUser);
			ResultSet rs = pstmt.executeQuery();

			imagem = rs.getBytes("imagem");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return imagem;
	}

	public static Image converterBytesParaImage(byte[] imagemBytes) {
		Image image = null;

		try (ByteArrayInputStream bais = new ByteArrayInputStream(imagemBytes)) {
			// Lê a imagem do ByteArrayInputStream e cria um BufferedImage
			BufferedImage bufferedImage = ImageIO.read(bais);
			image = bufferedImage; // Atribui o BufferedImage a um objeto Image
		} catch (IOException e) {
			System.out.println("Erro ao converter byte[] em Image: " + e.getMessage());
		}

		return image; // Retorna a imagem criada
	}

}
