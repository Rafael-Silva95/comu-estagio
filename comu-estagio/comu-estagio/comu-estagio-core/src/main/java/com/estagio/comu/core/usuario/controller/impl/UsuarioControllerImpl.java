package com.estagio.comu.core.usuario.controller.impl;

import java.util.List;

import javax.ejb.EJB;

import com.estagio.comu.core.usuario.controller.UsuarioController;
import com.estagio.comu.core.usuario.dao.UsuarioDAO;
import com.estagio.comu.orm.entidades.Usuario;



/**
 * Implementação do Controller da entidade Usuário.
 * 
 * @author Alisson Belinki <alisson.belinki@consisanet.com>
 * @since 26/03/2014
 * @version 1.0.0
 */
public class UsuarioControllerImpl implements UsuarioController {
	/**
	 * DAO.
	 */
	@EJB
	private UsuarioDAO usuarioDAO;

	private UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	@Override
	public void merge(Usuario usuario) {
		this.getUsuarioDAO().update(usuario);
	}

	@Override
	public void remove(Usuario usuario) {
		this.getUsuarioDAO().delete(usuario.getIdUsuario());
	}

	@Override
	public void persist(Usuario usuario) {
		this.getUsuarioDAO().save(usuario);
	}

	@Override
	public Usuario findById(Integer id) {
		return this.getUsuarioDAO().search(id);
	}

	@Override
	public List<Usuario> findAll() {
		return (List<Usuario>) this.getUsuarioDAO().findAll();
	}

	@Override
	public Usuario findUsuarioByDsLogin(String dsLogin) {
		return this.usuarioDAO.findUsuarioByDsLogin(dsLogin);
	}

	
}