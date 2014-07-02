package com.estagio.comu.core.usuario.view;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.estagio.comu.core.usuario.controller.UsuarioController;
import com.estagio.comu.orm.entidades.Usuario;

/**
 * Classe que controla o comportamento da tela de cadastro do usuario
 * 
 * @author lucasabreu - lucasigual14@gmail.com	
 * 
 */
@ViewScoped
@ManagedBean(name = "cadastroView")
public class CadastroView implements
		Serializable {

	/**
	 * UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Objeto que representa a entidade Usuairo.
	 */
	private Usuario usuario;

	/**
	 * Lista de Usuairo.
	 */
	public List<Usuario> listarEquipamento;

	/**
	 * Controlador de Usuario.
	 */
	@Inject
	private UsuarioController usuarioController;

	/**
	 * Construtor
	 */
	public CadastroView() {

	}

	public void inicializar() {

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getListarEquipamento() {
		return listarEquipamento;
	}

	public void setListarEquipamento(List<Usuario> listarEquipamento) {
		this.listarEquipamento = listarEquipamento;
	}

	public UsuarioController getUsuarioController() {
		return usuarioController;
	}

	public void setUsuarioController(UsuarioController usuarioController) {
		this.usuarioController = usuarioController;
	}
	
	public void salvar() {
		try {
			getUsuarioController().persist(usuario);
			//direcionar para fullpage		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
