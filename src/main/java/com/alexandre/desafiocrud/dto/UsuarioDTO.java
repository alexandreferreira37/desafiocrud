package com.alexandre.desafiocrud.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

import com.alexandre.desafiocrud.domain.Usuario;

public class UsuarioDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotEmpty(message="Preenchimento obrigatório")
	private String name;
	@NotEmpty
	private String login;
	@NotEmpty
	private String pass;

	
	public UsuarioDTO() {
		
	}

	public UsuarioDTO(Usuario obj) {
		id = obj.getId();
 	    name = obj.getName();
 	    login = obj.getLogin();
 	    pass = obj.getPass();
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}	
	
}
