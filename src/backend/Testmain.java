package backend;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Testmain {
	public static void main(String[] args) throws SQLException {

		InfoPlus venda = new InfoPlus("a", "111.111.111-11", true, "Aa123456", "06/10/2024", 1, 1);
		venda.registrarVenda(25.50);

	}
}
