package DesafioMV.DesafioMV;

import java.util.List;
import java.util.Scanner;

import dao.FuncioanrioDAOImpl;
import dao.FuncionarioDAO;
import entidade.Funcionario;
import entidade.ItensCafe;

public class App {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		FuncionarioDAO funcDAO = new FuncioanrioDAOImpl();
		Scanner scan = new Scanner(System.in);

		int i = 0;
		List<ItensCafe> cont = funcDAO.listarTodosItens();
		for (ItensCafe item : cont) {
			if (item.getItem_id_pk() > i) {
				i = item.getItem_id_pk()+1;
			}
		}

		while (i > 0) {

			System.err.println("\n\nSelecione uma opção: \n\n[1] INSERIR FUNCIONARIO\n[2] REMOVER FUNCIONARIO\n"
					+ "[3] INSERIR CAFÉ DA MANHÃ\n[4] REMOVER CAFÉ DA MANHÃ\n[5] LISTAR FUNCIONARIOS\n[6] LISTAR CAFÉ DA MANHÃ ");
			int opcao = scan.nextInt();

			Funcionario funcionario = new Funcionario();
			ItensCafe itenscafe = new ItensCafe();

			switch (opcao) {

			case 1: // INSERIR FUNCIONARIO

				System.err.println("\n\nDigite o CPF do Funcionario: ");
				funcionario.setCpf(scan.nextLine());
				funcionario.setCpf(scan.nextLine());

				System.err.println("\nDigite o Nome do Funcionario: ");
				funcionario.setNome(scan.nextLine());

				funcDAO.inserir(funcionario);

				System.out.println("==== INSERIDO COM SUCESSO!!! ===");

				break;

			case 2: // REMOVER FUNCIONARIO

				System.err.println("\nDigite o CPF do Funcionario que será removido: ");
				funcionario.setCpf(scan.nextLine());
				funcionario.setCpf(scan.nextLine());

				funcDAO.remover(funcionario.getCpf());
				System.out.println("==== REMOVIDO COM SUCESSO!!! ===");
				break;

			case 3: // INSERIR CAFE DA MANHA

				System.err.println("\n\nDigite o item que será adicionado ao CAFÉ DA MANHÃ: ");
				itenscafe.setItem_cafe(scan.nextLine());
				itenscafe.setItem_cafe(scan.nextLine());

				System.err.println("\nDigite o CPF do responsável pelo item: ");
				funcionario.setCpf(scan.nextLine());

				funcDAO.inserirCafe(i, itenscafe.getItem_cafe(), funcionario.getCpf());

				System.out.println("==== INSERIDO COM SUCESSO!!! ===");

				break;

			case 4: // REMOVER CAFE DA MANHA

				System.err.println("\nDigite o ITEM do cafe da manhã que será removido: ");
				itenscafe.setItem_cafe(scan.nextLine());
				itenscafe.setItem_cafe(scan.nextLine());

				funcDAO.removerCafe(itenscafe.getItem_cafe());
				System.out.println("==== REMOVIDO COM SUCESSO!!! ===");
				break;

			case 5: // LISTAR FUNCIONARIO

				List<Funcionario> listaFuncionarios = funcDAO.listarTodos();
				for (Funcionario func : listaFuncionarios) {
					System.out.println(" CPF: " + func.getCpf() + " NOME: " + func.getNome());

//					for (ItensCafe item : func.getListItensCafe()) {
//						System.out.println(" ITEM: " + item.getItem_cafe());
//					}

				}

				break;

			case 6: // LISTAR CAFE DA MANHA

				List<ItensCafe> listaCafe = funcDAO.listarTodosItens();

				for (ItensCafe item : listaCafe) {
					System.out.println(
							" ITEM / RESPONSÁVEL: " + item.getItem_cafe() + " / " + item.getFuncionario().getNome());

				}

				break;

			default:
				break;
			}
			i++;
		}

	}

}
