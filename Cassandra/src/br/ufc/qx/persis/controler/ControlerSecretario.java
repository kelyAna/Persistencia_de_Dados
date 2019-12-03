package br.ufc.qx.persis.controler;

import java.util.List;
import java.util.Scanner;

import br.ufc.qxd.persistencia.dao.cassandra.SecretarioDAO;
import br.ufc.qxd.persistencia.model.PesquisadorProjeto;
import br.ufc.qxd.persistencia.model.Secretario;

public class ControlerSecretario implements GenericControler{

	public static Scanner ler = new Scanner(System.in);
	
	SecretarioDAO s = new SecretarioDAO();
	
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
		System.out.println("\nDigite o Grau de Escolaridade: ");
		String grauEscolaridade = ler.nextLine();

		Secretario se = new Secretario(id, nome, sexo, dataAniversario, salario, endereco, grauEscolaridade);
		s.insert(se);
		
	}

	@Override
	public void deletar() {
		System.out.println("\nDigite o ID: ");
		int id = ler.nextInt();
		s.delete(id);
	}

	@Override
	public void listar() {
		List<Secretario> pp = s.findAll();
		for(Secretario pproj : pp) {
			System.out.print(pproj);
		}
		
	}

	@Override
	public void pesquisar() {
		System.out.println("\nDigite o ID: ");
		int id = ler.nextInt();
		
		Secretario pp = s.find(id);
		System.out.print(pp);
		
	}
}
