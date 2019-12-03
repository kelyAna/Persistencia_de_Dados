package br.ufc.qxd.exec;

import java.util.List;
import java.util.Scanner;

import br.ufc.qxd.persistencia.CRUD.CRUDdepartamento;
import br.ufc.qxd.persistencia.CRUD.CRUDdependente;
import br.ufc.qxd.persistencia.CRUD.CRUDfuncionario;
import br.ufc.qxd.persistencia.CRUD.CRUDpesquisador_Projeto;
import br.ufc.qxd.persistencia.CRUD.CRUDprojeto;
import br.ufc.qxd.persistencia.model.Departamento;
import br.ufc.qxd.persistencia.model.Dependente;
import br.ufc.qxd.persistencia.model.Funcionario;
import br.ufc.qxd.persistencia.model.Pesquisador_Projeto;
import br.ufc.qxd.persistencia.model.Projeto;


public class PrincpalMenu {
public static Scanner ler = new Scanner(System.in);
	
	public static void main(String[] args) {
		int op;
		do {
			System.out.println("\n1- Departamento:");
			System.out.println("2- Projeto:");
			System.out.println("3- Funcionario:");
			System.out.println("4- Dependente: ");
			System.out.println("5- Pesquisador Projteo: ");
			System.out.println("6- Sair :");

			
			op = ler.nextInt();
			
			if(op == 1) {
				departamento(); 
			}
			else if(op == 2) {
				projeto();
			}
			else if(op == 3) {
				funcionario();
			}
			else if(op == 4) {
				dependente();
			}
			else if(op == 5) {
				pesq_pro();
			}
			else if(op != 6) {
				System.out.println("Opção invalida! \n\nTente novamente:");
			}

		}while(op != 6);
	}
	
	//Funções Departamento
	public static void departamento() {
		CRUDdepartamento dep = new CRUDdepartamento();
		int opc;
		do {
			System.out.println("\n\n\n\n1- Cadastrar: ");
			System.out.println("2- Deletar por Id: ");
			System.out.println("3- Listar: ");
			System.out.println("4- Pesquisar por Id: ");
			System.out.println("5- Sair: ");
			
			opc = ler.nextInt();
			
			if(opc == 1) {
				System.out.println("Digite o nome do Deprtamento: ");
				ler.nextLine();
				String nome = ler.nextLine();
				 dep.Cadastro(nome);
			}
			else if(opc == 2) {
				System.out.println("Digite o ID do Departamento: ");
				int id = ler.nextInt();
				dep.Delete(id);
			}
			else if(opc == 3) {
				List<Departamento> departamentos = dep.listar();
				
				for(Departamento d : departamentos) {
					System.out.println(d);
					//dep.listar();
				}
			}
			else if(opc == 4) {
				System.out.println("Digite o ID do Departamento: ");
				int id = ler.nextInt();
				Departamento d = dep.Select(id);
				System.out.println(d);
			}
			
			else if(opc != 5) {
				System.out.println("Opção invalida! \n\nTente novamente:");
			}
			
			
			
		}while(opc != 5);
	}
	
	//Funções Projeto
	public static void projeto() {
		CRUDprojeto p = new CRUDprojeto();
		int opc;
		do {
			System.out.println("\n\n\n\n1- Cadastrar: ");
			System.out.println("2- Deletar por Id: ");
			System.out.println("3- Listar: ");
			System.out.println("4- Pesquisar por Id: ");
			System.out.println("5- Sair: ");
			
			opc = ler.nextInt();
			
			if(opc == 1) {
				System.out.println("Digite o nome: ");
				ler.nextLine();
				String nome = ler.nextLine();
				
				System.out.println("Digite o periodo: ");
				String periodo = ler.nextLine();
				
				System.out.println("Digite o ID: ");
				int Id = ler.nextInt();
				
				p.Cadastro(nome, periodo, Id);
			}
			else if(opc == 2) {
				System.out.println("Digite o ID: ");
				int id = ler.nextInt();
				p.Delete(id);
			}
			else if(opc == 3) {
				List<Projeto> projetos = p.listar();
				
				for(Projeto pr: projetos) {
					System.out.print(pr);
				}
			}
			else if(opc == 4) {
				System.out.println("Digite o ID do Projeto: ");
				int id = ler.nextInt();
				Projeto d = p.select(id);
				System.out.println(d);
			}
			
			else if(opc != 5) {
				System.out.println("Opção invalida! \n\nTente novamente:");
			}
			
			
			
		}while(opc != 5);
	}
	
	//Funções Funcionario
	public static void funcionario() {
		CRUDfuncionario fun = new CRUDfuncionario();
		int op;
		
		do {
			System.out.println("1- Cadastrar Pesquisador:");
			System.out.println("2- Cadastrar Secretario:");
			System.out.println("3- Cadastrar Funcionario de Limpeza:");
			System.out.println("4- Listar Funcionarios: ");
			System.out.println("5- Buscar por ID: ");
			System.out.println("6- Deletar: ");
			System.out.println("7- Sair");
			op = ler.nextInt();
			
			if(op == 1) {
				pesquisador();
			}
			else if(op == 2) {
				secretario();
			}
			else if(op == 3) {
				funcLimpeza();
			}
			else if(op == 4) {
				fun.listar();
				List<Funcionario> func = fun.listar();
				
				for(Funcionario d : func) {
					System.out.println(d);
					//dep.listar();
				}
			}
			else if(op == 5) {
				System.out.println("Digite o ID: ");
				int id = ler.nextInt();
				System.out.print(fun.buscarFuncionariosPorId(id));
			}
			else if(op == 6) {
				System.out.println("Digite o ID: ");
				int id = ler.nextInt();
				fun.Delete(id);
			}
		}while(op != 7);
	}
	
	//Funções Pesquisador
	public static void pesquisador() {
		CRUDfuncionario fun = new CRUDfuncionario();
		System.out.println("Digite o nome: ");
		ler.nextLine();
		String nomeFuncionario = ler.nextLine();
		
		System.out.println("Rua: ");
		String ruaFuncionario = ler.nextLine();
		
		System.out.println("Numero da casa: ");
		int numeroCasaFuncionario = ler.nextInt();
		
		System.out.println("Cidade: ");
		ler.nextLine();
		String cidadeFuncionario = ler.nextLine();
		
		System.out.println("Bairro: ");
		String bairroFuncionario = ler.nextLine();
		ler.nextLine();
		System.out.println("Estado: ");
		String estadoFuncionario = ler.nextLine();
		
		System.out.println("Sexo: ");
		String sexoFuncionario = ler.nextLine();
		
		System.out.println();
		String dataAniversarioFuncionario = ler.nextLine();
		
		System.out.println("Salario: ");
		float salarioFuncionario = ler.nextFloat();
		
		System.out.println("ID Departamento: ");
		int Id_Departamento = ler.nextInt();
		
		System.out.println("Area de atuação: ");
		ler.nextLine();
		String areaAtuacaoPesquisador = ler.nextLine();
		
		System.out.println("Horas trabalhadas: ");
		String horasTrabalhadasPesquisador = ler.nextLine();
		
		
		fun.cadastrarPesquisador(nomeFuncionario, ruaFuncionario, numeroCasaFuncionario, cidadeFuncionario, bairroFuncionario, estadoFuncionario, sexoFuncionario, dataAniversarioFuncionario, salarioFuncionario, Id_Departamento, areaAtuacaoPesquisador, horasTrabalhadasPesquisador);
	}
	
	
	//Funções secretario
	public static void secretario() {
		CRUDfuncionario fun = new CRUDfuncionario();
		System.out.println("Digite o nome: ");
		ler.nextLine();
		String nomeFuncionario = ler.nextLine();
		
		System.out.println("Rua: ");
		String ruaFuncionario = ler.nextLine();
		
		System.out.println("Numero da casa: ");
		int numeroCasaFuncionario = ler.nextInt();
		
		System.out.println("Cidade: ");
		ler.nextLine();
		String cidadeFuncionario = ler.nextLine();
		
		System.out.println("Bairro: ");
		String bairroFuncionario = ler.nextLine();
		
		System.out.println("Estado: ");
		String estadoFuncionario = ler.nextLine();
		
		System.out.println("Sexo: ");
		String sexoFuncionario = ler.nextLine();
		
		System.out.println("Data de Aniversario: ");
		String dataAniversarioFuncionario = ler.nextLine();
		
		System.out.println("Salario: ");
		float salarioFuncionario = ler.nextFloat();
		
		System.out.println("ID Departamento: ");
		int Id_Departamento = ler.nextInt();
		
		System.out.println("Grau de escolaridade: ");
		String grauEscolaridade = ler.nextLine();
		
		System.out.println("Horas trabalhadas: ");
		String horasTrabalhadasPesquisador = ler.nextLine();
		
		
		fun.cadastrarSecretario(nomeFuncionario, ruaFuncionario, numeroCasaFuncionario, cidadeFuncionario, bairroFuncionario, estadoFuncionario, sexoFuncionario, dataAniversarioFuncionario, salarioFuncionario, Id_Departamento, grauEscolaridade, horasTrabalhadasPesquisador);
	}
	
	
	//Funções funcLimpeza
	public static void funcLimpeza() {
		CRUDfuncionario fun = new CRUDfuncionario();
		System.out.println("Digite o nome: ");
		ler.nextLine();
		String nomeFuncionario = ler.nextLine();
		
		System.out.println("Rua: ");
		String ruaFuncionario = ler.nextLine();
		
		System.out.println("Numero da casa: ");
		int numeroCasaFuncionario = ler.nextInt();
		
		System.out.println("Cidade: ");
		ler.nextLine();
		String cidadeFuncionario = ler.nextLine();
		
		System.out.println("Bairro: ");
		String bairroFuncionario = ler.nextLine();
		
		System.out.println("Estado: ");
		String estadoFuncionario = ler.nextLine();
		
		System.out.println("Sexo: ");
		String sexoFuncionario = ler.nextLine();
		
		System.out.println("Data de Aniversario: ");
		String dataAniversarioFuncionario = ler.nextLine();
		
		System.out.println("Salario: ");
		float salarioFuncionario = ler.nextFloat();
		
		System.out.println("ID Departamento: ");
		int Id_Departamento = ler.nextInt();
		
		System.out.println("Cargo: ");
		ler.nextLine();
		String cargo = ler.nextLine();
		
		System.out.println("(int)Jornada de trabalho: ");
		int jornadaTrabalho = ler.nextInt();
		
		System.out.println("Horas trabalhadas: ");
		ler.nextLine();
		String horasTrabalhadasPesquisador = ler.nextLine();
		
		
		fun.cadastrarFuncionarioLimpeza(nomeFuncionario, ruaFuncionario, numeroCasaFuncionario, cidadeFuncionario, bairroFuncionario, estadoFuncionario, sexoFuncionario, dataAniversarioFuncionario, salarioFuncionario, Id_Departamento, cargo, jornadaTrabalho, horasTrabalhadasPesquisador);
	}
	
	
	//Funções dependente
	public static void dependente() {

		CRUDdependente dep = new CRUDdependente();
		int opc;
		do {
			System.out.println("\n\n\n\n1- Cadastrar: ");
			System.out.println("2- Deletar por Id: ");
			System.out.println("3- Listar: ");
			System.out.println("4- Pesquisar por Id: ");
			System.out.println("5- Sair: ");
			
			opc = ler.nextInt();
			
			if(opc == 1) {
				System.out.println("Digite o nome: ");
				ler.nextLine();
				String nome = ler.nextLine();
				
				System.out.println("Digite a data de aniversario: ");
				String dataAniver = ler.nextLine();
				
				System.out.println("Digite o grau de parentesco: ");
				String grauParentesco = ler.nextLine();
				
				System.out.println("Digite o ID do funcionario: ");
				int id_fun = ler.nextInt();
				
				dep.Cadastro(nome, dataAniver, grauParentesco, id_fun);
			}
			else if(opc == 2) {
				System.out.println("Digite o ID do Dependente: ");
				int id = ler.nextInt();
				dep.Delete(id);
			}
			else if(opc == 3) {
				List<Dependente> dependentes = dep.listar();
				
				for(Dependente d : dependentes) {
					System.out.println(d);
					//dep.listar();
				}
			}
			else if(opc == 4) {
				System.out.println("Digite o ID do Dependente: ");
				int id = ler.nextInt();
				System.out.println(dep.Select(id));
			}
			
			else if(opc != 5) {
				System.out.println("Opção invalida! \n\nTente novamente:");
			}
			
			
			
		}while(opc != 5);
	}
	//Pesquisador_Projeto
	public static void pesq_pro() {
		CRUDpesquisador_Projeto dep = new CRUDpesquisador_Projeto();
		int opc;
		do {
			System.out.println("\n\n\n\n1- Cadastrar: ");
			System.out.println("2- Deletar por Id: ");
			System.out.println("3- Listar: ");
			System.out.println("4- Pesquisar por Id: ");
			System.out.println("5- Sair: ");
			
			opc = ler.nextInt();
			
			if(opc == 1) {
				System.out.println("Digite as horas do projeto: ");
				ler.nextLine();
				int horas = ler.nextInt();
				
				System.out.println("Digite o id do projeto: ");
				int id_Projeto = ler.nextInt();
				
				
				System.out.println("Digite o ID do Pesquisador: ");
				int id_Pesquisador = ler.nextInt();
				
				dep.Cadastro(horas, id_Projeto, id_Pesquisador);
			}
			else if(opc == 2) {
				System.out.println("Digite o ID do Pesquisador_Projeto: ");
				int id = ler.nextInt();
				dep.Delete(id);
			}
			else if(opc == 3) {
				List<Pesquisador_Projeto> dependentes = dep.listar();
				
				for(Pesquisador_Projeto d : dependentes) {
					System.out.println(d);
					//dep.listar();
				}
			}
			else if(opc == 4) {
				System.out.println("Digite o ID do Dependente: ");
				int id = ler.nextInt();
				System.out.println(dep.Select(id));
			}
			
			else if(opc != 5) {
				System.out.println("Opção invalida! \n\nTente novamente:");
			}
			
			
			
		}while(opc != 5);
	}
}
