package br.ufc.qxd.persistencia.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.ufc.qxd.persistencia.dao.DepartamentoDAO;
import br.ufc.qxd.persistencia.dao.FuncionarioDAO;
import br.ufc.qxd.persistencia.dao.Pesquisador_ProjetoDAO;
import br.ufc.qxd.persistencia.dao.PesquisadorDAO;
import br.ufc.qxd.persistencia.jpa.DepartamentoJPADAO;
import br.ufc.qxd.persistencia.jpa.FuncionarioJPADAO;
import br.ufc.qxd.persistencia.jpa.PesquisadorJPADAO;
import br.ufc.qxd.persistencia.jpa.Pesquisador_ProjetoJPADAO;
import br.ufc.qxd.persistencia.model.Departamento;
import br.ufc.qxd.persistencia.model.Funcionario;
import br.ufc.qxd.persistencia.model.Pesquisador;
import br.ufc.qxd.persistencia.model.Pesquisador_Projeto;
import br.ufc.qxd.persistencia.model.Projeto;

public class CRUDpesquisador_Projeto {
	
	public static void Cadastro(int horas, int id_Projeto,int id_Pesquisador) {
		CRUDpesquisador_Projeto pe = new CRUDpesquisador_Projeto();
		CRUDprojeto pr = new CRUDprojeto();
		CRUDfuncionario f = new CRUDfuncionario();
		
		if(pr.select(id_Projeto)!= null & f.buscarPesquisadorPorId(id_Pesquisador)!= null) {
		
		Pesquisador_Projeto pepr= new Pesquisador_Projeto(horas, id_Projeto, id_Pesquisador);
		
		
		
		EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
	
		
		try {
			tx.begin();
			em.persist(pepr);
			tx.commit();
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
		}else System.out.println("Parametros errados");


		}
	
	public static void Delete(int id) {
		Pesquisador_ProjetoDAO departamentoDAO = new Pesquisador_ProjetoJPADAO();
		
		try {
			departamentoDAO.beginTransaction();
			
			departamentoDAO.Delete(departamentoDAO.select(id));
			
			departamentoDAO.commit();
			
		} catch (Exception e) {
			departamentoDAO.rollback();
			
			e.printStackTrace();
		}finally {
			try {
				departamentoDAO.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public Pesquisador_Projeto Select(int id) {
		Pesquisador_ProjetoDAO departamentoDAO = new Pesquisador_ProjetoJPADAO();
		
		return departamentoDAO.select(id);
	}

	public List<Pesquisador_Projeto> listar() {
		Pesquisador_ProjetoDAO departamentoDAO = new Pesquisador_ProjetoJPADAO();
		
		return departamentoDAO.listar();
	}
	
	
}
