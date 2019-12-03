package br.ufc.qxd.exec;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.ufc.qxd.persistencia.controller.CRUDdepartamento;
import br.ufc.qxd.persistencia.controller.CRUDdependente;
import br.ufc.qxd.persistencia.controller.CRUDfuncionario;
import br.ufc.qxd.persistencia.controller.CRUDpesquisador_Projeto;
import br.ufc.qxd.persistencia.controller.CRUDprojeto;
import br.ufc.qxd.persistencia.model.Departamento;


public class Principal {
	public static Scanner ler = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		//ex1InserirDados();
		//ex5deletecomDAO();
		
		
		//Departamento dep = new Departamento();
		CRUDdepartamento cr = new CRUDdepartamento();
		CRUDfuncionario fun = new CRUDfuncionario();
		//fun.cadastrarPesquisador("ana", "jah", 1, "pb",
		//		"centro", "ce", "f", "ju7643", 2000, 
		//		cr.Select(3), "jja", "af");
	//	fun.cadastrarSecretario("Bruno", "rr", 1, "cid", "bairroFuncionario", "estadoFuncionario", "sexoFuncionario", "dataAniversarioFuncionario", 200, 1, "grauEscolaridade", "horasTrabalhadasPesquisador");
		//	fun.cadastrarFuncionarioLimpeza("Junior", "Ponte", 24, "Qx", "Centro", "CE", "F", "24/24/24", 1, cr.Select(3), "ff", 30, "20");	
		CRUDprojeto pr = new CRUDprojeto();
	//	pr.select(6);
		//cr.Cadastro("maria");
		CRUDpesquisador_Projeto pp = new CRUDpesquisador_Projeto();
		CRUDdependente dep = new CRUDdependente();
		//dep.Cadastro("Kely", "dataAniver", "grauParentesco", 1 );
		//pp.Cadastro(1, 0, 12);
		
		CRUDfuncionario f = new CRUDfuncionario();
		f.listar();
		
		
	}
 public static void ex1InserirDados() {
	
		Departamento dep = new Departamento("rh");
		
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			em.persist(dep);
			tx.commit();
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
		
		System.out.println("=====================================");
		System.out.println(dep);
		System.out.println("FIM - JPA");

		}
	
}


