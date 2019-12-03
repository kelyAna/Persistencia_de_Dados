package br.ufc.qxd.persistencia.CRUD;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.ufc.qxd.persistencia.dao.DepartamentoDAO;
import br.ufc.qxd.persistencia.dao.ProjetoDAO;
import br.ufc.qxd.persistencia.jpa.DepartamentoJPADAO;
import br.ufc.qxd.persistencia.jpa.ProjetoJPADAO;
import br.ufc.qxd.persistencia.model.Departamento;
import br.ufc.qxd.persistencia.model.Projeto;

public class CRUDprojeto {
	
		
	
	public static void Cadastro(String nome, String periodo, int Id_Departamento) {
		CRUDdepartamento cr = new CRUDdepartamento();
		
		Projeto dept = new Projeto(nome, periodo);
		
		dept.setDepartamento(cr.Select(Id_Departamento));
		EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
	
		
		try {
			tx.begin();
			em.persist(dept);
			tx.commit();
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
		
		

		}
	
	public static void Delete(int id) {
		ProjetoDAO projetoDAO = new ProjetoJPADAO();
		
		try {
			projetoDAO.beginTransaction();
			
			projetoDAO.Delete(projetoDAO.select(id));
			
			projetoDAO.commit();
			
		} catch (Exception e) {
			projetoDAO.rollback();
			
			e.printStackTrace();
		}finally {
			try {
				projetoDAO.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public Projeto select(int id) {
		//DepartamentoDAO departamentoDAO = new DepartamentoJPADAO();
		
		ProjetoDAO proDAO = new ProjetoJPADAO();
		
		//return departamentoDAO.find(id);
		return proDAO.select(id);
	}


	public List<Projeto> listar() {
		ProjetoDAO proDAO = new ProjetoJPADAO();
		
		return proDAO.listar();
	}
}
