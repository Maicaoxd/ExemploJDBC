package model.entity;

public class Pessoa {
	private String nome;
	private String email;
	private String cpf;
	private String telefone;
	private Long id;

	@Override
	public String toString() {
		return "id= " + id + ", nome= " + nome + ", email= " + email + ", cpf= " + cpf + ", telefone= " + telefone;
	}

	public Long getId() {
		return id;
	}

	public void setId(String id) {
		this.id = Long.parseLong(id);
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
