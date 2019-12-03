package br.ufc.qx.persis.controler;

import java.util.List;
import java.util.Scanner;

import br.ufc.qxd.persistencia.dao.cassandra.ProjetoDAO;
import br.ufc.qxd.persistencia.model.Projeto;

public class ControlerProjeto implements GenericControler{

	public static Scanner ler = new Scanner(System.in);
	
	ProjetoDAO p = new ProjetoDAO();
	
	@Override
	public void cadastrar() {
		System.out.println("\nDigite o ID: ");
		int id = ler.nextInt();
		System.out.println("\nDigite o nome:");
		ler.nextLine();
		String nome = ler.nextLine();
		System.out.println("Digite o periodo: ");
		String periodo = ler.nextLine();
		System.out.println("\nDigite o ID do Departamento: ");
		int idDepartamento = ler.nextInt();

		Projeto pr = new Projeto(id, nome, periodo, idDepartamento);
				//Projeto(id, nome, periodo, idDepartamento);
		p.insert(pr);
	}

	@Override
	public void deletar() {
		System.out.println("\nDigite o ID: ");
		int id = ler.nextInt();
		p.delete(id);
	}

	@Override
	public void listar() {
		List<Projeto> pp = p.findAll();
		for(Projeto pproj : pp) {
			System.out.print(pproj);
		}
		
	}

	@Override
	public void pesquisar() {
		System.out.println("\nDigite o ID: ");
		int id = ler.nextInt();
		
		Projeto pp = p.find(id);
		System.out.print(pp);
		
	}

}
