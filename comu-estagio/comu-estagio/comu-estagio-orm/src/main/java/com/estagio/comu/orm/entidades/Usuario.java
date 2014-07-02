package com.estagio.comu.orm.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Mapeamento ORM - Entidade Usuario.
 * 
  * @author Lucas Henrique de Abreu <lucasigual14@gmail.com>
 * @since 23/04/2014
 * @version 1.00
 */
@Entity
@Table(name = Usuario.NOME_TABELA)
public class Usuario implements Serializable {

	/**
	 * SerialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Nome da tabela no banco de dados.
	 */
	protected static final String NOME_TABELA = "usuario";

	/**
	 * Chave primaria.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Integer idUsuario;

	/**
	 * Nome do usuario.
	 */
	@NotNull
	@Size(min = 3, max = 60)
	@Column(name = "nm_usuario")
	private String nmUsuario;

	/**
	 * Descrição email.
	 */
	@NotNull
	@Pattern(regexp = ".+@.+\\.[a-z]+")
	@Size(min = 3, max = 60)
	@Column(name = "ds_email")
	private String dsEmail;
	
	/**
	 * senha.
	 */
	@NotNull
	@Pattern(regexp = ".+@.+\\.[a-z]+")
	@Size(min = 3, max = 60)
	@Column(name = "senha")
	private String senha;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNmUsuario() {
		return nmUsuario;
	}

	public void setNmUsuario(String nmUsuario) {
		this.nmUsuario = nmUsuario;
	}

	public String getDsEmail() {
		return dsEmail;
	}

	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}
}