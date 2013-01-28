package com.bueno.component.usuario.model;

public class UsuarioWrapper {
	private final boolean isLogged;
	private final String email;
	private final String id;
	
	public static UsuarioWrapper create(Usuario usuario, boolean isLogged){
		return new UsuarioWrapper(isLogged, usuario.getEmail(), usuario.getIdUsuario());
	}
	
	private UsuarioWrapper(boolean isLogged, String email, String id) {
		super();
		this.isLogged = isLogged;
		this.email = email;
		this.id = id;
	}

	public boolean isLogged() {
		return isLogged;
	}

	public String getEmail() {
		return email;
	}

	public String getId() {
		return id;
	}
}
