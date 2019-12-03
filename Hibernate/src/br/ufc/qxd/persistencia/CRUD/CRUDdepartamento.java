package br.ufc.qxd.persistencia.CRUD;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.ufc.qxd.persistencia.dao.DepartamentoDAO;
import br.ufc.qxd.persistencia.jpa.DepartamentoJPADAO;
import br.ufc.qxd.persistencia.model.Departamento;



public class CRUDdepartamento {
	DepartamentoDAO departamentoDAO = new DepartamentoJPADAO();
	
	 public static void Cadastro(String nome) {
			
			Departamento dep = new Departamento(nome);
			
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
	
	
	public static void Delete(int id) {
		DepartamentoDAO departamentoDAO = new DepartamentoJPADAO();
		
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
	
	public Departamento Select(int id) {
		DepartamentoDAO departamentoDAO = new DepartamentoJPADAO();

		
		return departamentoDAO.select(id);
	}


	public List<Departamento> listar() {
		DepartamentoDAO departamentoDAO = new DepartamentoJPADAO();

		
		return departamentoDAO.listar();
	}
}