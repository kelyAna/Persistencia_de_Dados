package br.ufc.qx.persis.controler;

import java.util.List;
import java.util.Scanner;

import br.ufc.qxd.persistencia.dao.cassandra.FuncionarioLimpezDAO;
import br.ufc.qxd.persistencia.model.FuncionarioLimpeza;

public class ControlerFuncionarioLimpeza implements GenericControler{
	public static Scanner ler = new Scanner(System.in);
	
	 FuncionarioLimpezDAO fl = new FuncionarioLimpezDAO();
	 
	 
	@Override
	public void cadastrar() {
		System.out.println("\nDigite o ID: ");
		int id = ler.nextInt();
		System.out.println("\nDigite o nome:");
		ler.nextLine();
		String nome = ler.nextLine();
		System.out.println("\nDigite o sexo: ");
		String sexo = ler.nextLine();
		System.out.println("\nDigite a data de aniversario: ");
		String dataAniversario = ler.nextLine();
		System.out.println("\nDigite o salario: ");
		String salario = ler.nextLine();
		System.out.println("\nDigite o endereco: ");
		String endereco = ler.nextLine();
		System.out.println("\nDigite o Cargo: ");
		String cargo = ler.nextLine();
		System.out.println("\nDigite a Jornada de Trabalho: ");
		int jornadaTrabalho = ler.nextInt();
		System.out.println("\nDigite o codigo do Gerente: ");
		int codGerente = ler.nextInt();
		
		FuncionarioLimpeza f = new FuncionarioLimpeza(id, nome, sexo, dataAniversario, salario, endereco,
				jornadaTrabalho, cargo, codGerente);  
		
		fl.insert(f);
	}

	@Override
	public void deletar() {
		System.out.println("\nDigite o ID: ");
		int id = ler.nextInt();
		fl.delete(id);
	}

	@Override
	public void listar() {
		List<FuncionarioLimpeza> pp = fl.findAll();
		for(FuncionarioLimpeza pproj : pp) {
			System.out.print(pproj);
		}
		
	}

	@Override
	public void pesquisar() {
		System.out.println("\nDigite o ID: ");
		int id = ler.nextInt();
		
		FuncionarioLimpeza pp = fl.find(id);
		System.out.print(pp);
		
	}
	
}
