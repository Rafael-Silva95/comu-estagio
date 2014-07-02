package com.estagio.comu.core.usuario.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.estagio.comu.core.usuario.dao.UsuarioDAO;
import com.estagio.comu.daoGeneric.impl.GenericDAOImpl;
import com.estagio.comu.orm.entidades.Usuario;
import com.estagio.comu.orm.entidades.Usuario_;

/**
 * Implementação da interface DAO para a entidade Usuario.
 * 
 * @author Alisson Belinki <alisson.belinki@consisanet.com>
 * @since 17/03/2014
 * @version 1.0
 */
@Stateless(name = "usuarioDAO")
public class JPAUsuarioDAOImpl extends GenericDAOImpl<Usuario> implements
		UsuarioDAO {

	@Override
	public Usuario findUsuarioByDsLogin(String dsLogin) {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Usuario> criteria = cb.createQuery(Usuario.class);
		Root<Usuario> from = criteria.from(Usuario.class);
		criteria.where(cb.equal(from.get(Usuario_.dsLogin), dsLogin));

		try {

			Usuario usuario = getEntityManager().createQuery(criteria).getSingleResult();
			return usuario;

		} catch (Exception e) {

			return null;

		}

	}
}