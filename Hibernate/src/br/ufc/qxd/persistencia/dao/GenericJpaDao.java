package br.ufc.qxd.persistencia.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;



public class GenericJpaDao<T> implements GenericDAO<T>{


	protected Class<T> persistenceClass;

	public GenericJpaDao(Class<T> persistenceClass) {
		this.persistenceClass = persistenceClass;
	}
	
	@Override
	public void save(T entity) {
		JPAUtil.getEntityManager().merge(entity);
		
	}

	@Override
	public void Delete(T entity) {
		JPAUtil.getEntityManager().remove(JPAUtil.getEntityManager().merge(entity));
		
	}

	@Override
	public T select(Object id) {
		return JPAUtil.getEntityManager().find(persistenceClass, id);
	}

	@Override
	public List<T> listar() {
		CriteriaQuery<T> cq = JPAUtil.getEntityManager().getCriteriaBuilder()
				.createQuery(persistenceClass);
		cq.from(persistenceClass);
		return JPAUtil.getEntityManager().createQuery(cq).getResultList();
	}

	@Override
	public void beginTransaction() {
		JPAUtil.beginTransaction();
		
	}

	@Override
	public void commit() {
		JPAUtil.commit();
		
	}

	@Override
	public void rollback() {
		JPAUtil.rollback();
		
	}

	@Override
	public void close() {
		JPAUtil.closeEntityManager();
	}

	
}
