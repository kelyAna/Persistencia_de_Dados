package br.ufc.qxd.exec;

import java.util.Scanner;

import br.ufc.qx.persis.controler.ControlerDepartamento;
import br.ufc.qx.persis.controler.ControlerDependente;
import br.ufc.qx.persis.controler.ControlerFuncionarioLimpeza;
import br.ufc.qx.persis.controler.ControlerPesqProj;
import br.ufc.qx.persis.controler.ControlerPesquisador;
import br.ufc.qx.persis.controler.ControlerProjeto;
import br.ufc.qx.persis.controler.ControlerSecretario;

public class Principal {
	public static Scanner ler = new Scanner(System.in);
	
	public static void main(String[] args) {
		int op;
		do {
			System.out.println("\n1- Departamento:");
			System.out.println("2- Projeto:");
			System.out.println("3- Pesquisador:");
			System.out.println("4- Secretario:");
			System.out.println("5- Funcionario de Linpeza:");
			System.out.println("6- Dependente:");
			System.out.println("7- Pesquisador Projeto:");
			System.out.println("8- Sair :");

			
			op = ler.nextInt();
			
			if(op == 1) {
				departamento(); 
			}
			else if(op == 2) {
				projeto();
			}
			else if(op == 3) {
				pesquisador();
			}
			else if(op == 4) {
				secretario();
			}
			else if(op == 5) {
				funcLimpeza();
			}
			else if(op == 6) {
				dependente();
			}
			else if(op == 7) {
				pesquiProjeto();
			}
			else if(op != 8) {
				System.out.println("Opção invalida! \n\nTente novamente:");
			}

		}while(op != 8);
	}
	
	
	
	//Funções Departamento
	public static void departamento() {
		ControlerDepartamento d = new ControlerDepartamento();
		int opc;
		do {
			System.out.println("\n\n\n\n1- Cadastrar: ");
			System.out.println("2- Deletar por Id: ");
			System.out.println("3- Listar: ");
			System.out.println("4- Pesquisar por Id: ");
			System.out.println("5- Sair: ");
			
			opc = ler.nextInt();
			
			if(opc == 1) {
				 d.cadastrar();
			}
			else if(opc == 2) {
				d.deletar();
			}
			else if(opc == 3) {
				d.listar();
			}
			else if(opc == 4) {
				d.pesquisar();
			}
			else if(opc != 5) {
				System.out.println("Opção invalida! \n\nTente novamente:");
			}
			
			
			
		}while(opc != 5);
	}
	
	//Funções Projeto
	public static void projeto() {
		ControlerProjeto p = new ControlerProjeto();
		int opc;
		do {
			System.out.println("\n\n\n\n1- Cadastrar: ");
			System.out.println("2- Deletar por Id: ");
			System.out.println("3- Listar: ");
			System.out.println("4- Pesquisar por Id: ");
			System.out.println("5- Sair: ");
			
			opc = ler.nextInt();
			
			if(opc == 1) {
				 p.cadastrar();
			}
			else if(opc == 2) {
				p.deletar();
			}
			else if(opc == 3) {
				p.listar();
			}
			else if(opc == 4) {
				p.pesquisar();
			}
			else if(opc != 5) {
				System.out.println("Opção invalida! \n\nTente novamente:");
			}
			
			
			
		}while(opc != 5);
	}
	
	
	//Funções Pesquisador
	public static void pesquisador() {
		ControlerPesquisador p = new ControlerPesquisador();
		int opc;
		do {
			System.out.println("\n\n\n\n1- Cadastrar: ");
			System.out.println("2- Deletar por Id: ");
			System.out.println("3- Listar: ");
			System.out.println("4- Pesquisar por Id: ");
			System.out.println("5- Sair: ");
			
			opc = ler.nextInt();
			
			if(opc == 1) {
				 p.cadastrar();
			}
			else if(opc == 2) {
				p.deletar();
			}
			else if(opc == 3) {
				p.listar();
			}
			else if(opc == 4) {
				p.pesquisar();
			}
			else if(opc != 5) {
				System.out.println("Opção invalida! \n\nTente novamente:");
			}
			
			
			
		}while(opc != 5);
	}
	
	
	//Funções secretario
	public static void secretario() {
		ControlerSecretario s = new ControlerSecretario();
		int opc;
		do {
			System.out.println("\n\n\n\n1- Cadastrar: ");
			System.out.println("2- Deletar por Id: ");
			System.out.println("3- Listar: ");
			System.out.println("4- Pesquisar por Id: ");
			System.out.println("5- Sair: ");
			
			opc = ler.nextInt();
			
			if(opc == 1) {
				s.cadastrar(); 
			}
			else if(opc == 2) {
				s.deletar();
			}
			else if(opc == 3) {
				s.listar();
			}
			else if(opc == 4) {
				s.pesquisar();
			}
			else if(opc != 5) {
				System.out.println("Opção invalida! \n\nTente novamente:");
			}
			
			
			
		}while(opc != 5);
	}
	
	
	//Funções funcLimpeza
	public static void funcLimpeza() {
		ControlerFuncionarioLimpeza f = new ControlerFuncionarioLimpeza();
		int opc;
		do {
			System.out.println("\n\n\n\n1- Cadastrar: ");
			System.out.println("2- Deletar por Id: ");
			System.out.println("3- Listar: ");
			System.out.println("4- Pesquisar por Id: ");
			System.out.println("5- Sair: ");
			
			opc = ler.nextInt();
			
			if(opc == 1) {
				 f.cadastrar();
			}
			else if(opc == 2) {
				f.deletar();
			}
			else if(opc == 3) {
				f.listar();
			}
			else if(opc == 4) {
				f.pesquisar();
			}
			else if(opc != 5) {
				System.out.println("Opção invalida! \n\nTente novamente:");
			}
			
			
			
		}while(opc != 5);
	}
	
	
	//Funções dependente
	public static void dependente() {
		ControlerDependente d = new ControlerDependente();
		int opc;
		do {
			System.out.println("\n\n\n\n1- Cadastrar: ");
			System.out.println("2- Deletar por Id: ");
			System.out.println("3- Listar: ");
			System.out.println("4- Pesquisar por Id: ");
			System.out.println("5- Sair: ");
			
			opc = ler.nextInt();
			
			if(opc == 1) {
				 d.cadastrar();
			}
			else if(opc == 2) {
				d.deletar();
			}
			else if(opc == 3) {
				d.listar();
			}
			else if(opc == 4) {
				d.pesquisar();
			}
			else if(opc != 5) {
				System.out.println("Opção invalida! \n\nTente novamente:");
			}
			
			
			
		}while(opc != 5);	
	}
	
	//Funções Pesquisador Projeto
		public static void pesquiProjeto() {
			ControlerPesqProj pp = new ControlerPesqProj();
			int opc;
			do {
				System.out.println("\n\n\n\n1- Cadastrar: ");
				System.out.println("2- Deletar por Id: ");
				System.out.println("3- Listar: ");
				System.out.println("4- Pesquisar por Id: ");
				System.out.println("5- Sair: ");
				
				opc = ler.nextInt();
				
				if(opc == 1) {
					 pp.cadastrar();
				}
				else if(opc == 2) {
					pp.deletar();
				}
				else if(opc == 3) {
					pp.listar();
				}
				else if(opc == 4) {
					pp.pesquisar();
				}
				else if(opc != 5) {
					System.out.println("Opção invalida! \n\nTente novamente:");
				}
				
				
				
			}while(opc != 5);	
		}
	
}


