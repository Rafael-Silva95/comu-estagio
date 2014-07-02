package com.estagio.comu.core.usuario.dao;

import com.estagio.comu.daoGeneric.GenericDAO;
import com.estagio.comu.orm.entidades.Usuario;


/**
 * Interface DAO para a entidade Usuario.
 * 
 * @author Alisson Belinki <alisson.belinki@consisanet.com>
 * @since 17/03/2014
 * @version 1.0
 */
public interface UsuarioDAO extends GenericDAO<Usuario> {

	/**
	 * Método que realiza pesquisa as descricoess do Login.
	 * 
	 * @param dsLogin Descricao do Login.
	 * 
	 * @return retorna a descricao do login se nao retorna null.
	 */
	Usuario findUsuarioByDsLogin(String dsLogin);
}
