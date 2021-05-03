package entidade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "FUNCIONARIO")
public class Funcionario {
	
	@Id
	@Column(name = "CPF", nullable = false)
	private String cpf;
	
	@Column(name = "NOME", nullable = false)
	private String nome;
	
	@OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
	private List<ItensCafe> listItensCafe;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ItensCafe> getListItensCafe() {
		return listItensCafe;
	}

	public void setListItensCafe(List<ItensCafe> listItensCafe) {
		this.listItensCafe = listItensCafe;
	}

}
