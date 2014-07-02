package com.estagio.comu.orm.entidades;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.estagio.comu.orm.enumeration.AtivoInativo;
import com.estagio.comu.orm.enumeration.TipoUsuario;

/**
 * Mapeamento ORM - Entidade Usuario Metamodelo.
 * 
 * @author Lucas Henrique de Abreu <lucasigual14@gmail.com>
 * @since 23/04/2014
 * @version 1.00
 */
@StaticMetamodel(Usuario.class)
public class Usuario_ {

	public static volatile SingularAttribute<Usuario, Integer> idUsuario;
	public static volatile SingularAttribute<Usuario, String> nmUsuario;
	public static volatile SingularAttribute<Usuario, String> dsEmail;
	public static volatile SingularAttribute<Usuario, TipoUsuario> tpUsuario;
	public static volatile SingularAttribute<Usuario, AtivoInativo> stUsuario;
	public static volatile SingularAttribute<Usuario, String> dsLogin;

}
