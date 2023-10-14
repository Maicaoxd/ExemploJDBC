package view;

import javax.swing.JOptionPane;

import model.DAO.ConexaoDAO;
import model.DAO.PessoaDAO;

public class Teste {

	public static void main(String[] args) {
		ConexaoDAO dao = new ConexaoDAO();
		PessoaDAO dao2 = new PessoaDAO();

		try {
			System.out.println("Conectado ao Banco de Dados: " + dao.getConnection());
			System.out.println("Gestão de Pessoas");

			while (true) {
				char opcao = JOptionPane.showInputDialog("(I)nserir pessoa\r\n" + "(R)emover pessoa\r\n"
						+ "(A)tualizar pessoa\r\n" + "(L)istar pessoa\r\n" + "(S)air").toUpperCase().charAt(0);
				if (opcao == 'I') {
					dao2.inserir();
					;
				} else if (opcao == 'A') {
					dao2.atualizar();
				} else if (opcao == 'R') {
					dao2.remover();
				} else if (opcao == 'L') {
					dao2.listar();
				} else if (opcao == 'S') {
					System.out.println("Ate breve...!!!!");
					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
