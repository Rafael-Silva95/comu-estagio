package com.estagio.comu.daoGeneric;

import java.util.List;

public interface GenericDAO<T> {

	/**
	 * Remove o objeto do banco.
	 * 
	 * @param id Chave primária do objeto
	 */
	void delete(Integer id);

	/**
	 * Efetua uma pesquisa completa no banco para o objeto do DAO.
	 * 
	 * @return Lista de Objetos pesquisada.
	 */
	List<T> findAll();

	/**
	 * Persiste o objeto no banco.
	 * 
	 * @param t Objeto a ser persistido.
	 * @return Objeto persistido no banco.
	 */
	T save(T t);

	/**
	 * Efetua a pesquisa de acordo com o id informado.
	 * 
	 * @param id Chave primaria do objeto
	 * @return Objeto consultado através da chave informada.
	 */
	T search(Integer id);

	/**
	 * Atualiza o objeto no banco.
	 * 
	 * @param t Objeto a ser persistido.
	 * @return Objeto persistido no banco.
	 */
	T update(T t);

}
