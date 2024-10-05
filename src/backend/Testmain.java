package backend;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Testmain {
	public static void main(String[] args) throws SQLException {
		Scanner input = new Scanner(System.in);
		System.out.print("escolha: ");
		int escolha = input.nextInt();
		if (escolha == 1) {
			Produto.addProduto("arroz", "1234567891011", 12.50, 200);
			System.out.println("produto adicionado");
		}
		else if (escolha == 2) {
			ArrayList<Produto> busca = Produto.verificarEstoque();
			for (Produto p : busca) {
				System.out.println(p);
			}
			
		}
		else if (escolha == 3) {
			ArrayList<Carrinho> busca = Carrinho.pesquisar("arroz");
			System.out.println(busca);
		}
		else if(escolha == 4) {
			Cadastro.registro(2, "joao", "12345678911", "123");
		}
	}}
