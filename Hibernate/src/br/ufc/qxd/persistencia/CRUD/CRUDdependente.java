package br.ufc.qxd.persistencia.CRUD;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.ufc.qxd.persistencia.dao.DepartamentoDAO;
import br.ufc.qxd.persistencia.dao.DependenteDAO;
import br.ufc.qxd.persistencia.jpa.DependenteJPADAO;
import br.ufc.qxd.persistencia.model.Dependente;
import br.ufc.qxd.persistencia.model.Projeto;



public class CRUDdependente {

	public static void Cadastro(String nome, String dataAniver,
	String grauParentesco, int id_fun) {
			
		CRUDfuncionario f = new CRUDfuncionario();
		
		Dependente dep = new Dependente(nome, dataAniver, grauParentesco);
		
		//dep.setDepartamento(cr.Select(Id_Departamento));
		dep.setFuncionario(f.buscarFuncionariosPorId(id_fun));
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
	

	}
	
	public static void Delete(int id) {
		DependenteDAO dependeteDAO = new DependenteJPADAO();
	
		
		try {
			dependeteDAO.beginTransaction();
			
			dependeteDAO.Delete(dependeteDAO.select(id));
			
			dependeteDAO.commit();
			
		} catch (Exception e) {
			dependeteDAO.rollback();
			
			e.printStackTrace();
		}finally {
			try {
				dependeteDAO.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public Dependente Select(int id) {
		DependenteDAO dependenteDAO = new DependenteJPADAO();
	
		
		return dependenteDAO.select(id);
	}


	public List<Dependente> listar() {
		DependenteDAO dependenteDAO = new DependenteJPADAO();
		
		
		return dependenteDAO.listar();
	}
}
