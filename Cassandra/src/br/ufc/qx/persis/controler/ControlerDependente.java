package br.ufc.qx.persis.controler;

import java.util.List;
import java.util.Scanner;

import br.ufc.qxd.persistencia.dao.cassandra.DependenteDAO;
import br.ufc.qxd.persistencia.model.Dependente;
import br.ufc.qxd.persistencia.model.PesquisadorProjeto;

public class ControlerDependente implements GenericControler{
	public static Scanner ler = new Scanner(System.in);
	
	DependenteDAO de = new DependenteDAO();
	
	@Override
	public void cadastrar() {
		System.out.println("\nDigite o ID: ");
		int id = ler.nextInt();
		System.out.println("\nDigite a data de Aniversario: ");
		ler.nextLine();
		String dataAniver = ler.nextLine();
		System.out.println("\nDigite o Grau de parentesco: ");
		String grauParentesco = ler.nextLine();
		System.out.println("\nDigite o ID do Funcionario: ");
		int idFuncionario = ler.nextInt();
		System.out.println("\nDigite o nome: ");
		ler.nextLine();
		String nome = ler.nextLine();
		System.out.println("\nDigite o sexo: ");
		ler.nextLine();
		String sexo = ler.nextLine();
		
		Dependente dep = new Dependente(id, dataAniver, grauParentesco, idFuncionario, nome, sexo);
		de.insert(dep);
	}

	@Override
	public void deletar() {
		System.out.println("\nDigite o ID: ");
		int id = ler.nextInt();
		de.delete(id);
	}

	@Override
	public void listar() {
		List<Dependente> pp = de.findAll();
		for(Dependente pproj : pp) {
			System.out.print(pproj);
		}
		
	}

	@Override
	public void pesquisar() {
		System.out.println("\nDigite o ID: ");
		int id = ler.nextInt();
		Dependente pp = de.find(id);
		System.out.print(pp);
		
	}

}
