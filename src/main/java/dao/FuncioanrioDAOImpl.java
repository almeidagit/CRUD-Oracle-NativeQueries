package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entidade.Funcionario;
import entidade.ItensCafe;
import util.JpaUtil;

public class FuncioanrioDAOImpl implements FuncionarioDAO {

	

	@Override
	public void inserir(Funcionario funcionario) {

		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();

		String nativeQueryInserir = "INSERT INTO FUNCIONARIO VALUES (:a, :b)";

		Query query = em.createNativeQuery(nativeQueryInserir, Funcionario.class);

		query.setParameter("a", funcionario.getCpf());
		query.setParameter("b", funcionario.getNome()).executeUpdate();

		tx.commit();
		em.close(); 
	}

	@Override
	public void remover(String cpf) {

		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();

		String nativeQueryRemoveItem = "DELETE ITENS_CAFE WHERE CPF_FUNC = ?";
		String nativeQueryRemoveFunc = "DELETE FUNCIONARIO WHERE CPF = ?";

		Query query = em.createNativeQuery(nativeQueryRemoveItem, Funcionario.class);
		Query query2 = em.createNativeQuery(nativeQueryRemoveFunc, Funcionario.class);

		query.setParameter(1, cpf).executeUpdate();
		query2.setParameter(1, cpf).executeUpdate();

		tx.commit();
		em.close(); 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Funcionario> listarTodos() {
		
		EntityManager em = JpaUtil.getEntityManager();
		
		String nativeQuery = "SELECT * from funcionario";
		Query query = em.createNativeQuery(nativeQuery, Funcionario.class);

		List<Funcionario> funcionarios = query.getResultList();

		em.close(); 
		return funcionarios;
	}

	@Override
	public void inserirCafe(int i, String itemcafe, String cpf) {
		
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();

		String nativeQueryInserir = "INSERT INTO ITENS_CAFE (ID_ITEM, ITEM_CAFE, CPF_FUNC) VALUES (:a, :b, :c)";

		Query query = em.createNativeQuery(nativeQueryInserir, ItensCafe.class);
		query.setParameter("a", i);
		query.setParameter("b", itemcafe);
		query.setParameter("c", cpf).executeUpdate();

		tx.commit();
		em.close(); 

	}

	@Override
	public void removerCafe(String cafe) {

		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();

		String nativeQueryRemoveItem = "DELETE ITENS_CAFE WHERE ITEM_CAFE = ?";

		Query query = em.createNativeQuery(nativeQueryRemoveItem, ItensCafe.class);

		query.setParameter(1, cafe).executeUpdate();

		tx.commit();
		em.close(); 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItensCafe> listarTodosItens() {
		
		EntityManager em = JpaUtil.getEntityManager();

		String nativeQuery = "SELECT * from ITENS_CAFE order by cpf_func";

		Query query = em.createNativeQuery(nativeQuery, ItensCafe.class);

		List<ItensCafe> itenscafe = query.getResultList();

		em.close(); 
		return itenscafe;
	}

}
