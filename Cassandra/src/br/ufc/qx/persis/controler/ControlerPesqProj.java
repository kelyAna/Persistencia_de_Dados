package br.ufc.qx.persis.controler;

import java.util.List;
import java.util.Scanner;

import br.ufc.qxd.persistencia.dao.cassandra.PesquisadorProjetoDAO;
import br.ufc.qxd.persistencia.model.PesquisadorProjeto;


public class ControlerPesqProj implements GenericControler{
	public static Scanner ler = new Scanner(System.in);
	
	PesquisadorProjetoDAO pro = new PesquisadorProjetoDAO();
	
	@Override
	public void cadastrar() {
		System.out.println("\nDigite o ID: ");
		int id = ler.nextInt();
		System.out.println("\nDigite as Horas: ");
		ler.nextLine();
		String horasTrabalhadas = ler.nextLine();
		System.out.println("\nDigite o ID do Projeto: ");
		int idProjeto = ler.nextInt();
		System.out.println("\nDigite o ID do Pesquisador: ");
		int idPesquisador = ler.nextInt();
		
		PesquisadorProjeto pp = new PesquisadorProjeto(id, horasTrabalhadas, idProjeto, idPesquisador);
		pro.insert(pp);
		
	}

	@Override
	public void deletar() {
		System.out.println("\nDigite o ID: ");
		int id = ler.nextInt();
		pro.delete(id);
	}

	@Override
	public void listar() {
		List<PesquisadorProjeto> pp = pro.findAll();
		for(PesquisadorProjeto pproj : pp) {
			System.out.print(pproj);
		}
		
	}

	@Override
	public void pesquisar() {
		System.out.println("\nDigite o ID: ");
		int id = ler.nextInt();
		
		PesquisadorProjeto pp = pro.find(id);
		System.out.print(pp);
		
	}
}
