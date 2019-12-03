package br.ufc.qx.persis.controler;

import java.util.List;
import java.util.Scanner;

import br.ufc.qxd.persistencia.dao.cassandra.DepartamentoDAO;
import br.ufc.qxd.persistencia.model.Departamento;
import br.ufc.qxd.persistencia.model.PesquisadorProjeto;



public class ControlerDepartamento implements GenericControler{
	
	public static Scanner ler = new Scanner(System.in);
	
	DepartamentoDAO dep = new DepartamentoDAO();
	
	@Override
	public void cadastrar() {
		System.out.println("\nDigite o ID: ");
		int id = ler.nextInt();
		System.out.println("\nDigite o Nome: ");
		ler.nextLine();
		String nome = ler.nextLine();
		Departamento de = new Departamento(id, nome);
		dep.insert(de);
		
	}

	@Override
	public void deletar() {
		System.out.println("\nDigite o ID: ");
		int id = ler.nextInt();
		dep.delete(id);
		
	}

	@Override
	public void listar() {
		List<Departamento> pp = dep.findAll();
		for(Departamento pproj : pp) {
			System.out.print(pproj.toString());
		}
		
	}

	@Override
	public void pesquisar() {
		System.out.println("\nDigite o ID: ");
		int id = ler.nextInt();
		
		Departamento pp = dep.find(id);
		System.out.print(pp);
		
	}

}
