package com.estagio.comu.core.usuario.controller;


import java.util.List;

import com.estagio.comu.orm.entidades.Usuario;

/**
 * Contrato que irá definir a implementação do controller para a entidade Usuario.
 * 
 * @author Lucas Henrique de Abreu <lucasigual14@gmail.com>
 * @since 23/04/2014
 * @version 1.0.0
 */
public interface UsuarioController {

	/**
	 * Método responsável atualizar o objeto.
	 * 
	 * @param usuario Objeto a ser atualizado.
	 */
	void merge(Usuario usuario);

	/**
	 * Método responsável por remover o objeto.
	 * 
	 * @param usuario Objeto a ser removido.
	 */
	void remove(Usuario usuario);

	/**
	 * Método responsável por persistir o objeto.
	 * 
	 * @param usuario Objeto a ser persitido.
	 */
	void persist(Usuario usuario);

	/**
	 * Método que irá buscar o objeto a partir do seu Id.
	 * 
	 * @param Id do objeto usuário.
	 * 
	 * @return Objeto do usuário ou retorna null caso nao encontre no banco.
	 */
	Usuario findById(Integer id);

	/**
	 * Método que irá listar os objetos.
	 * 
	 * @return lista de Usuários.
	 */
	List<Usuario> findAll();

	/**
	 * Método responsável por fazer a busca dos Logins salvos no banco para um usuário.
	 * 
	 * @param dsLogin login do usuário para fazer a pesquisa.
	 * 
	 * @return Usuarios.
	 */
	Usuario findUsuarioByDsLogin(String dsLogin);


}
