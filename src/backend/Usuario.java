package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.ConexaoDB;

public class Usuario {
	private String nome;
	private String cpf;
	private String senha;
	private boolean genero;
	private String login;
	private int idUser;

	
	// Contrutores da classe
	
	public Usuario() {
		
	}
	
	public Usuario(String nome, String cpf, boolean genero, String senha) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.genero = genero;
		this.senha = senha;
	}

	// Getters e Setters
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

	public boolean isGenero() {
		return genero;
	}

	public void setGenero(boolean genero) {
		this.genero = genero;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	public int getIdUser() {
		return idUser;
	}

	// Método para registrar novo usuário.
	public String registro() {
		Connection con = null;
		String mensagem = null;
		try {
			con = ConexaoDB.getInstance().getConnection(); // Conexão é feita com o banco de dados
			String querySelect = "SELECT nome, cpf, senha FROM usuários WHERE nome = ? OR cpf = ?";
			PreparedStatement pstmtS = con.prepareStatement(querySelect);

			pstmtS.setString(1, this.nome);
			pstmtS.setString(2, this.cpf);
			ResultSet resultado = pstmtS.executeQuery();

			String n = resultado.getString("nome");

			// Caso a busca no banco de dados tenha resultado, significa que o usuário não pode ser cadastrado.
			// Caso a busca seja igual a null(não tenha resultado), o novo usuário pode ser cadastrado no banco de dados.
			if (n != null) {
				mensagem = "esse usuário ja existe";

			} else {
				String queryInsert = "INSERT INTO usuários (nome, cpf, senha, genero) VALUES (?, ?, ?, ?)";
				PreparedStatement pstmtI = con.prepareStatement(queryInsert);

				pstmtI.setString(1, this.nome);
				pstmtI.setString(2, this.cpf);
				pstmtI.setString(3, this.senha);
				pstmtI.setBoolean(4, this.genero);

				pstmtI.executeUpdate();
				mensagem = "Usuário cadastrado com sucesso";
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

		finally {
			try {
				if (con != null) {						// tratamentos de excessões
					con.close();
				}
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
		// a função retorna uma mensagem que vai ser mostrada na tela do aplicativo conforme o resultado
		return mensagem;
	}

	// Método para realizar o login do funcionário.
	public String login() {
		Connection con = null;
		String mensagem = null;
		try {
			con = ConexaoDB.getInstance().getConnection(); // Conexão com o banco de dados
			String querySelect = "SELECT nome, cpf, senha, id FROM usuários WHERE nome = ? OR cpf = ?";
			PreparedStatement pstmtS = con.prepareStatement(querySelect);

			pstmtS.setString(1, this.login);
			pstmtS.setString(2, this.login);
			ResultSet resultado = pstmtS.executeQuery();

			String n = resultado.getString("nome");
			String c = resultado.getString("cpf");
			String s = resultado.getString("senha");
			int i = resultado.getInt("id");

			// A variável login vem do input na interface de login, ela é utilizada para buscar tanto pelo nome do usuário, quanto pelo cpf.
			// caso ele identifique que o nome buscado é igual ao nome que veio na busca do banco de dados e a senha ou que o cpf buscado é o mesmo
			// do cpf que veio na busca e a senha, o login é efetuado e seta o id do usuário buscado como uma identificação que vai ser
			// usada em outros pontos do aplicativo.
			if ((this.login == n && this.senha == s) || (this.login == c && this.senha == s)) {
				mensagem = "Login efetuado com sucesso";
				setIdUser(i);

			} else {
				mensagem = "Houve um erro ao realizar o login, verifique os dados de login";
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

		finally {
			try {
				if (con != null) {						// tratamentos de excessões
					con.close();
				}
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
		// a função retorna uma mensagem que vai ser mostrada na tela do aplicativo conforme o resultado
		return mensagem;
	}
}
