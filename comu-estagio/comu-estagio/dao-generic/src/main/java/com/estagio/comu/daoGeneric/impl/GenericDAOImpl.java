package com.estagio.comu.daoGeneric.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import com.estagio.comu.daoGeneric.GenericDAO;

public abstract class GenericDAOImpl<T> implements GenericDAO<T> {

	/**
	 * Injeção do EntityManager para persistencia.
	 */
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Classe utilizada no DAO.
	 */
	private Class<T> clazz;

	/**
	 * Construtor.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public GenericDAOImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		clazz = ((Class) pt.getActualTypeArguments()[0]);
	}

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	protected void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
	 * Remove o objeto do banco.
	 * 
	 * @param id Integer
	 */
	@Override
	public void delete(final Integer id) {
		entityManager.remove(entityManager.getReference(clazz, id));
	}

	/**
	 * Efetua uma pesquisa completa no banco para o objeto do DAO.
	 * 
	 * @return Lista de Objetos pesquisada.
	 */
	@Override
	public List<T> findAll() {
		CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> query = criteria.createQuery(clazz);
		TypedQuery<T> typedQuery = entityManager.createQuery(query);
		return typedQuery.getResultList();
	}

	/**
	 * Persiste o objeto no banco.
	 * 
	 * @param t Objeto a ser persistido.
	 * @return Objeto persistido no banco.
	 */
	@Override
	public T save(final T t) {
		entityManager.persist(t);
		return t;
	}

	/**
	 * Efetua a pesquisa de acordo com o id informado.
	 * 
	 * @param id Integer
	 * @return Objeto consultado através da chave informada.
	 */
	@Override
	public T search(final Integer id) {
		return (T) this.entityManager.find(clazz, id);
	}

	/**
	 * Atualiza o objeto no banco.
	 * 
	 * @param t Objeto a ser persistido.
	 * @return Objeto persistido no banco.
	 */
	@Override
	public T update(final T t) {
		entityManager.merge(t);
		return t;
	}
}