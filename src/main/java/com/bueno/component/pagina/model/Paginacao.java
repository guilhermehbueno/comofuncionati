package com.bueno.component.pagina.model;

import java.util.ArrayList;
import java.util.List;

public class Paginacao {
	
	public Paginacao(String identificador, String estado, String label) {
		super();
		this.identificador = identificador;
		this.estado = estado;
		this.label = label;
	}
	
	public Paginacao() {
		super();
	}

	private String identificador;
	private String estado;
	private String label;
	
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public static List<Paginacao> factory(Pagina paginaInicial, List<Pagina> paginas){
		List<Paginacao> paginacao = new ArrayList<Paginacao>();
		paginacao.add(factory(paginaInicial));
		for (Pagina pagina : paginas) {
			paginacao.add(factory(pagina));
		}
		return paginacao;
	}
	
	public static Paginacao factory(Pagina pagina){
		return new Paginacao(pagina.getTituloResumido(), "inative", null);
	}
}
