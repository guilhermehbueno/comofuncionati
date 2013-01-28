package br.com.comofuncionati.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="cargo")
public final class Cargo {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@Column(name="id")
	private String id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="descricao")
	private String descricao;
	
	public Cargo() {
		super();
	}

	public Cargo(String nome, String conteudo) {
		super();
		this.nome = nome;
		this.descricao = conteudo;
	}

	public static CargoBuilder newCargo(){
		return new CargoBuilder();
	}
	
	public static class CargoBuilder{
		private String nomeBuilder;
		private String conteudoBuilder;	
		
		public CargoBuilder comConteudo(String conteudo){
			this.conteudoBuilder = conteudo;
			return this;
		}
		
		public CargoBuilder comNome(String nome){
			this.nomeBuilder = nome;
			return this;
		}
		
		public Cargo create(){
			return  new Cargo(this.nomeBuilder, this.conteudoBuilder);
		}
	}

	public String getNome() {
		return nome;
	}

	public String getConteudo() {
		return descricao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Cargo [id=" + id + ", nome=" + nome + ", descricao="
				+ descricao + "]";
	}
}

