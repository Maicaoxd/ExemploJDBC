package model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.entity.Pessoa;

public class PessoaDAO extends ConexaoDAO {

	public Pessoa criarPessoa(Pessoa p) {
		p.setNome(JOptionPane.showInputDialog("Insira o nome da pessoa"));
		p.setEmail(JOptionPane.showInputDialog("Insira o email da pessoa"));
		p.setCpf(JOptionPane.showInputDialog("Insira o cpf da pessoa"));
		p.setTelefone(JOptionPane.showInputDialog("Insira o telefone da pessoa"));
		return p;
	}

	public void inserir() throws Exception {
		Pessoa p = criarPessoa(new Pessoa());
		conn = getConnection();
		String sql = "INSERT INTO PESSOA(NOME, EMAIL, CPF, TELEFONE) VALUES (?,?,?,?)";
		PreparedStatement ps;
		ps = conn.prepareStatement(sql);
		ps.setString(1, p.getNome());
		ps.setString(2, p.getEmail());
		ps.setString(3, p.getCpf());
		ps.setString(4, p.getTelefone());
		ps.execute();
		ps.close();
	}

	public void atualizar() throws Exception {
		Pessoa p = new Pessoa();
		p.setId(JOptionPane.showInputDialog("Insira o ID da pessoa a ser atualizada: "));
		p = criarPessoa(p);
		conn = getConnection();
		String sql = "UPDATE PESSOA SET NOME = (?), EMAIL = (?), CPF = (?), TELEFONE = (?) WHERE IDPESSOA = (?)";
		PreparedStatement ps;
		ps = conn.prepareStatement(sql);
		ps.setString(1, p.getNome());
		ps.setString(2, p.getEmail());
		ps.setString(3, p.getCpf());
		ps.setString(4, p.getTelefone());
		ps.setLong(5, p.getId());
		ps.executeUpdate();
		ps.close();
	}

	public void remover() throws Exception {
		Pessoa p = new Pessoa();
		p.setId(JOptionPane.showInputDialog("Insira o ID da pessoa a ser removida: "));
		conn = getConnection();
		String sql = "DELETE FROM PESSOA WHERE IDPESSOA = (?)";
		PreparedStatement ps;
		ps = conn.prepareStatement(sql);
		ps.setLong(1, p.getId());
		ps.execute();
		ps.close();
	}

	public void listar() throws Exception {
		conn = getConnection();
		String sql = "SELECT * FROM PESSOA";
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			Pessoa p = new Pessoa();
			p.setCpf(rs.getString("cpf"));
			p.setNome(rs.getString("nome"));
			p.setEmail(rs.getString("email"));
			p.setTelefone(rs.getString("telefone"));
			p.setId(rs.getLong("idpessoa"));
			pessoas.add(p);
		}
		for (Pessoa p : pessoas) {
			System.out.println(p.toString());
		}
		System.out.println("******************************************************************");
	}
}
