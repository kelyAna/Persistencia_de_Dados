package br.ufc.qx.persis.controler;

import java.util.List;
import java.util.Scanner;

import br.ufc.qxd.persistencia.dao.cassandra.PesquisadorDAO;
import br.ufc.qxd.persistencia.model.Pesquisador;
import br.ufc.qxd.persistencia.model.Secretario;

public class ControlerPesquisador implements GenericControler{

	public static Scanner ler = new Scanner(System.in);
	
	PesquisadorDAO p = new PesquisadorDAO();
	
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
		System.out.println("Digite a area de atuacao: ");
		String areaAtuacao = ler.nextLine();

		Pesquisador pe = new Pesquisador(id, nome, sexo, dataAniversario, salario, endereco, areaAtuacao);
		p.insert(pe);
		
	}

	@Override
	public void deletar() {
		System.out.println("\nDigite o ID: ");
		int id = ler.nextInt();
		p.delete(id);
	}

	@Override
	public void listar() {
		List<Pesquisador> pp = p.findAll();
		for(Pesquisador pproj : pp) {
			System.out.print(pproj);
		}
		
	}

	@Override
	public void pesquisar() {
		System.out.println("\nDigite o ID: ");
		int id = ler.nextInt();
		
		Pesquisador pp = p.find(id);
		System.out.print(pp);
		
	}

}
