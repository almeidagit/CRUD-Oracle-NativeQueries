package dao;

import java.util.List;

import entidade.Funcionario;
import entidade.ItensCafe;


public interface FuncionarioDAO {
	
	void inserir(Funcionario funcionario);

	void remover(String cpf);
	
	List<Funcionario> listarTodos();

	void inserirCafe(int i, String itemcafe, String funcionario);

	void removerCafe(String cafe);

	List<ItensCafe> listarTodosItens();
}
