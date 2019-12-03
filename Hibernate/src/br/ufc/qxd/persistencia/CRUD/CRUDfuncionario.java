package br.ufc.qxd.persistencia.CRUD;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import br.ufc.qxd.persistencia.dao.FuncionarioDAO;
import br.ufc.qxd.persistencia.dao.PesquisadorDAO;
import br.ufc.qxd.persistencia.jpa.FuncionarioJPADAO;
import br.ufc.qxd.persistencia.jpa.PesquisadorJPADAO;
import br.ufc.qxd.persistencia.model.Endereco;
import br.ufc.qxd.persistencia.model.Funcionario;
import br.ufc.qxd.persistencia.model.FuncionarioLimpeza;
import br.ufc.qxd.persistencia.model.Pesquisador;
import br.ufc.qxd.persistencia.model.Secretario;

public class CRUDfuncionario {
	CRUDdepartamento cr = new CRUDdepartamento();
	
	public void cadastrarPesquisador(String nomeFuncionario, String ruaFuncionario,
			int numeroCasaFuncionario, String cidadeFuncionario, String bairroFuncionario,
			String estadoFuncionario,String sexoFuncionario, String dataAniversarioFuncionario,
			float salarioFuncionario,
			int Id_Departamento,
			String areaAtuacaoPesquisador,
			String horasTrabalhadasPesquisador) {		

		Endereco e = new Endereco(ruaFuncionario, bairroFuncionario, cidadeFuncionario);

		
		Funcionario funcionario = new Funcionario(nomeFuncionario, sexoFuncionario, dataAniversarioFuncionario, salarioFuncionario);
		funcionario.setDepartamento(cr.Select(Id_Departamento));
		EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(funcionario);
		tx.commit();
		
		
		int id = funcionario.getId();
		Funcionario Ef = new Funcionario(id);
		Pesquisador P = new Pesquisador(areaAtuacaoPesquisador);
		
		
		try {
		tx.begin();
		em.persist(e);
		em.persist(P);
		tx.commit();
		} catch(IllegalStateException | PersistenceException ex) {
		tx.rollback();
		ex.printStackTrace();
		} finally {
		em.close();
		}

	}

	
	public void cadastrarSecretario(String nomeFuncionario, String ruaFuncionario,
			int numeroCasaFuncionario, String cidadeFuncionario, String bairroFuncionario,
			String estadoFuncionario,String sexoFuncionario, String dataAniversarioFuncionario,
			float salarioFuncionario,
			int Id_Departamento,
			String grauEscolaridade,
			String horasTrabalhadasPesquisador) {		

		Endereco e = new Endereco(ruaFuncionario, bairroFuncionario, cidadeFuncionario);

		
		Funcionario funcionario = new Funcionario(nomeFuncionario, sexoFuncionario, dataAniversarioFuncionario, salarioFuncionario);
		funcionario.setDepartamento(cr.Select(Id_Departamento));
		EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(funcionario);
		tx.commit();
		
		
		
		Secretario s = new Secretario(grauEscolaridade);
		
		
		try {
		tx.begin();
		em.persist(e);
		em.persist(s);
		tx.commit();
		} catch(IllegalStateException | PersistenceException ex) {
		tx.rollback();
		ex.printStackTrace();
		} finally {
		em.close();
		}

	}
	
	public void cadastrarFuncionarioLimpeza(String nomeFuncionario, String ruaFuncionario,
			int numeroCasaFuncionario, String cidadeFuncionario, String bairroFuncionario,
			String estadoFuncionario,String sexoFuncionario, String dataAniversarioFuncionario,
			float salarioFuncionario,
			int Id_Departamento,
			String cargo, Integer jornadaTrabalho,
			String horasTrabalhadasPesquisador) {		

		Endereco e = new Endereco(ruaFuncionario, bairroFuncionario, cidadeFuncionario);

		
		Funcionario funcionario = new Funcionario(nomeFuncionario, sexoFuncionario, dataAniversarioFuncionario, salarioFuncionario);
		funcionario.setDepartamento(cr.Select(Id_Departamento));
		EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(funcionario);
		tx.commit();
		
		
		
		
		FuncionarioLimpeza f = new FuncionarioLimpeza(jornadaTrabalho, cargo);
		
		
		try {
		tx.begin();
		em.persist(e);
		em.persist(f);
		tx.commit();
		} catch(IllegalStateException | PersistenceException ex) {
		tx.rollback();
		ex.printStackTrace();
		} finally {
		em.close();
		}

	}
	
	public void Delete(int id) {
		FuncionarioDAO funcionarioDAO = new FuncionarioJPADAO();
		
		try {
			funcionarioDAO.beginTransaction();
			funcionarioDAO.Delete(funcionarioDAO.select(id));
			funcionarioDAO.commit();
		} catch (IllegalStateException | PersistenceException e) {
				funcionarioDAO.rollback();
				e.printStackTrace();
		}finally {
			try {
				funcionarioDAO.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public List<Funcionario> listar(){
		FuncionarioDAO funcionarioDAO = new FuncionarioJPADAO();
		return funcionarioDAO.listar();
	}
	public Funcionario buscarPesquisadorPorId(int id){
		PesquisadorDAO pesq = new PesquisadorJPADAO();
		return pesq.select(id);
	}
	
	public Funcionario buscarFuncionariosPorId(int id){
		FuncionarioDAO funcionarioDAO = new FuncionarioJPADAO();
		return funcionarioDAO.select(id);
	}
}
